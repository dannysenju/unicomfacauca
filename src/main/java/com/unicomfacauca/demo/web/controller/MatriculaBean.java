/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.web.controller;

import com.unicomfacauca.demo.domain.entities.Estudiante;
import com.unicomfacauca.demo.domain.entities.Horario;
import com.unicomfacauca.demo.domain.entities.Materia;
import com.unicomfacauca.demo.domain.entities.Usuario;
import com.unicomfacauca.demo.service.EstudianteEJB;
import com.unicomfacauca.demo.service.HorarioEJB;
import com.unicomfacauca.demo.service.MateriaEJB;
import com.unicomfacauca.demo.service.UserEJB;
import com.unicomfacauca.demo.service.utils.exception.BusinessAppException;
import com.unicomfacauca.demo.web.general.GeneralBean;
import com.unicomfacauca.demo.web.general.UtilsMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

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
    private List<Horario> schedule;
    private Materia materia;
    private Estudiante studentSelected;
    private int countScheduleSelected = 0;

    @EJB // pone a dispocision Servicio
    UserEJB userEJB;

    @Inject // pone a dispocision Servicio
    EstudianteEJB estudianteEJB;
    
    @Inject // pone a dispocision Servicio
    MateriaEJB materiaEJB;
    @Inject // pone a dispocision Servicio
    HorarioEJB horarioEJB;

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

    private List initListSchedule() {
        return horarioEJB.getAllAvailableSchedule();
    }
    
    public Materia getCourse(Integer id) {
        return materiaEJB.getCourseByID(id);
    }
    
    
    public void getCoursesForStudent(){
        
        listCourses = new ArrayList<>();
        listCourses = materiaEJB.getAllCourseByProgram(this.studentSelected.getIdprograma());
        if(listCourses.size()>0){
            RequestContext.getCurrentInstance().execute("PF('dlgMatricula').show();");
            
        } else {
            addErrorMessage(UtilsMessage.translate("notCourses", "matricula.matricula", new String[]{""}));
        }
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

    public List<Horario> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Horario> schedule) {
        this.schedule = schedule;
    }

    public int getCountScheduleSelected() {
        return countScheduleSelected;
    }

    public void setCountScheduleSelected(int countScheduleSelected) {
        this.countScheduleSelected = countScheduleSelected;
    }
}
