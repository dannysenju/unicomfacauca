/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.web.controller;

import com.unicomfacauca.demo.domain.entities.DetalleMatricula;
import com.unicomfacauca.demo.domain.entities.Estudiante;
import com.unicomfacauca.demo.domain.entities.Materia;
import com.unicomfacauca.demo.domain.entities.MateriaHorario;
import com.unicomfacauca.demo.domain.entities.Matricula;
import com.unicomfacauca.demo.domain.entities.Usuario;
import com.unicomfacauca.demo.domain.entities.dto.HorarioMatDTO;
import com.unicomfacauca.demo.service.EstudianteEJB;
import com.unicomfacauca.demo.service.HorarioEJB;
import com.unicomfacauca.demo.service.MateriaEJB;
import com.unicomfacauca.demo.service.MatriculaEJB;
import com.unicomfacauca.demo.service.UserEJB;
import com.unicomfacauca.demo.service.utils.exception.BusinessAppException;
import com.unicomfacauca.demo.web.general.GeneralBean;
import com.unicomfacauca.demo.web.general.UtilsMessage;
import com.unicomfacauca.demo.web.utils.emails.JsfUtilities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author danny
 */
@Named(value = "matriculaBean")
@ViewScoped
public class MatriculaBean extends GeneralBean implements Serializable {

    private Usuario newUser;
    private String pass;
    private String fullNameUser;
    private List<Estudiante> listStudents;
    private List<Materia> listCourses;
    private Materia materia;
    private Estudiante studentSelected;
    private int countCredits = 0;
    private DualListModel<HorarioMatDTO> scheduleList;
    private List<HorarioMatDTO> selectedCourses;
    private JsfUtilities jsfUtilities;
    private Matricula matricula;
    private boolean isBlockAdd = false;
    private List<Matricula> matriculas;
    private List<Matricula> filtroMatriculas;

    @EJB // pone a dispocision Servicio
    UserEJB userEJB;

    @Inject // pone a dispocision Servicio
    EstudianteEJB estudianteEJB;

    @Inject // pone a dispocision Servicio
    MateriaEJB materiaEJB;
    @Inject // pone a dispocision Servicio
    HorarioEJB horarioEJB;

    @Inject // pone a dispocision Servicio
    MatriculaEJB matriculaEJB;

    public MatriculaBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            setPermisos(context.getExternalContext().getSessionMap().get("rol").toString());
            String idString = context.getExternalContext().getSessionMap().get("userId").toString();
            newUser = new Usuario();
            fullNameUser = userEJB.getFullName(Integer.parseInt(idString));
            listStudents = estudianteEJB.getAllAvailableStudents();
            initListSchedule();
            this.selectedCourses = new ArrayList<>();
            matricula = new Matricula();
            jsfUtilities = JsfUtilities.getInstance();
            isBlockAdd = false;
            matriculas = matriculaEJB.getAllAvailableEnrollment();
        } catch (BusinessAppException ex) {
            addErrorMessage(UtilsMessage.translate("accessDenied", "general.general", new String[]{"administración, con código: " + ex.getCode() + " " + ex.getMsj()}));
            navigate("/views/error/not-access.xhtml");
        }
    }

    @Override
    public void setPermisos(String rol) throws BusinessAppException {
        if (!rol.equals("FUNC")) {
            throw new BusinessAppException("1002", "Acceso no permitido");
        }
    }

    private void initListSchedule() {
        scheduleList = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
    }

    public Materia getCourse(Integer id) {
        return materiaEJB.getCourseByID(id);
    }

    public void getCoursesForStudent() {

        listCourses = new ArrayList<>();
        listCourses = materiaEJB.getAllCourseByProgram(this.studentSelected.getIdprograma());
        if (listCourses.size() > 0) {
            RequestContext.getCurrentInstance().execute("PF('dlgMatricula').show();");
            initPickList(new ArrayList<>(), listCourses.get(0));

        } else {
            addErrorMessage(UtilsMessage.translate("notCourses", "matricula.matricula", new String[]{""}));
        }
    }

    private void initPickList(List<HorarioMatDTO> moduleTarget, Materia m) {

        List<HorarioMatDTO> listSource = new ArrayList<>();
        for (MateriaHorario mh : materiaEJB.getScheduleForCourse(m)) {
            HorarioMatDTO hmDto = new HorarioMatDTO();
            hmDto.setMateria(mh.getMateria());
            hmDto.setHorarioIni(mh.getHorario1());
            hmDto.setHorarioFin(mh.getHorario());
            listSource.add(hmDto);
        }
        listSource.removeAll(new HashSet(moduleTarget));
        scheduleList = new DualListModel<>(listSource, moduleTarget);
    }

    public void add() {

        if (this.scheduleList.getTarget().size() <= 1) {

            countCredits += this.materia.getNumeroCreditos();

            if (countCredits > 0 && countCredits < 12) {

                if (!(this.matricula.getIdmatricula() != null)) {
                    this.matricula = getSingleMatricula(matricula);
                }

                this.selectedCourses.add(this.scheduleList.getTarget().get(0));

                this.listCourses.remove(this.materia);
                initPickList(new ArrayList<>(), (listCourses.size() > 0) ? listCourses.get(0) : new Materia());
                isBlockAdd = this.listCourses.isEmpty();

            } else {
                addErrorMessage(UtilsMessage.translate("excededCredits", "matricula.matricula", new String[]{""}));
            }

        } else {
            addErrorMessage(UtilsMessage.translate("cannotAddMore", "matricula.matricula", new String[]{""}));
        }

    }

    private Matricula getSingleMatricula(Matricula m) {
        m.setNumeroMatricula(getCodeMatricula());
        m.setIdestudiante(this.studentSelected);
        return m;
    }

    public void changeMateSelection(ValueChangeEvent evt) {
        Materia m = (Materia) evt.getNewValue();
        initPickList(new ArrayList<>(), m);
    }

    public void save() {

        if (matriculaEJB.save(matricula, this.selectedCourses)) {
            addInfoMessage(UtilsMessage.translate("create", "general.general", new String[]{"Matrícula"}));
            listStudents = estudianteEJB.getAllAvailableStudents();
            matriculas = matriculaEJB.getAllAvailableEnrollment();
            this.matricula = new Matricula();
            isBlockAdd = false;
        } else {
            addErrorMessage(UtilsMessage.translate("error", "general.genral", new String[]{"Crear la Matrícula"}));
        }

    }

    private String getCodeMatricula() {
        return jsfUtilities.getCode();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public Usuario getNewUser() {
        return newUser;
    }

    public void setNewUser(Usuario newUser) {
        this.newUser = newUser;
    }

    public List<Estudiante> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Estudiante> listStudents) {
        this.listStudents = listStudents;
    }

    public Estudiante getStudentSelected() {
        return studentSelected;
    }

    public void setStudentSelected(Estudiante studentSelected) {
        this.studentSelected = studentSelected;
    }

    public List<Materia> getListCourses() {
        return listCourses;
    }

    public void setListCourses(List<Materia> listCourses) {
        this.listCourses = listCourses;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getCountCredits() {
        return countCredits;
    }

    public void setCountCredits(int countCredits) {
        this.countCredits = countCredits;
    }

    public DualListModel<HorarioMatDTO> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(DualListModel<HorarioMatDTO> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<HorarioMatDTO> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<HorarioMatDTO> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public boolean isIsBlockAdd() {
        return isBlockAdd;
    }

    public void setIsBlockAdd(boolean isBlockAdd) {
        this.isBlockAdd = isBlockAdd;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Matricula> getFiltroMatriculas() {
        return filtroMatriculas;
    }

    public void setFiltroMatriculas(List<Matricula> filtroMatriculas) {
        this.filtroMatriculas = filtroMatriculas;
    }
    
}
