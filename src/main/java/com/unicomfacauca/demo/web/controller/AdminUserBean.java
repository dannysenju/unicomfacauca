/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.web.controller;

import com.unicomfacauca.demo.domain.entities.Modulo;
import com.unicomfacauca.demo.domain.entities.Usuario;
import com.unicomfacauca.demo.service.ModuloEJB;
import com.unicomfacauca.demo.service.UserEJB;
import com.unicomfacauca.demo.service.utils.exception.BusinessAppException;
import com.unicomfacauca.demo.service.utils.security.utils.UtilsEncrypt;
import com.unicomfacauca.demo.web.general.GeneralBean;
import com.unicomfacauca.demo.web.general.UtilsMessage;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Hashtable;
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
@Named(value = "adminBean")
@ViewScoped
public class AdminUserBean extends GeneralBean implements Serializable {

    private Usuario newUser;
    private String pass;
    private String fullNameUser;
    private List<Modulo> availableModules;
    private DualListModel<Modulo> modules;
    private List<Usuario> listUsers;
    private Usuario userModule;
    private Usuario userToDelete;

    @EJB // pone a dispocision Servicio
    UserEJB userEJB;

    @Inject // pone a dispocision Servicio
    ModuloEJB moduloEJB;

    public AdminUserBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            setPermisos(context.getExternalContext().getSessionMap().get("rol").toString());
            String idString = context.getExternalContext().getSessionMap().get("userId").toString();
            newUser = new Usuario();
            fullNameUser = userEJB.getFullName(Integer.parseInt(idString));
            listUsers = initListUsers();
            userModule = listUsers.size() > 0 ? listUsers.get(0) : new Usuario();
            initPickList(userModule.getModuloList());

        } catch (BusinessAppException ex) {
            addErrorMessage(UtilsMessage.translate("accessDenied", "general.general", new String[]{"administración, con código: " + ex.getCode() + " " + ex.getMsj()}));
            navigate("/views/error/not-access.xhtml");
        }
    }

    private List initListUsers() {
        return userEJB.getAllUsers();
    }

    private void initPickList(List<Modulo> moduleTarget) {
        availableModules = moduloEJB.getAllAvailableModules();
        availableModules.removeAll(new HashSet(moduleTarget));
        modules = new DualListModel<>(availableModules, moduleTarget);
    }

    public void createUser() {
        this.newUser.setPassword(UtilsEncrypt.getInstance().encryptPassword(pass));
        try {
            userEJB.createUser(this.newUser);
            addInfoMessage(
                    UtilsMessage.translate("create", "general.general", new String[]{Usuario.class.getSimpleName() + ": " + this.newUser.getNombreCompleto()}));
            this.newUser = new Usuario();
        } catch (SQLException ex) {
            addErrorMessage(UtilsMessage.translate("error", "general.general", new String[]{"Crear"}));
        }
    }

    public void assignModules() {

        Hashtable assign = userEJB.assignModules(this.userModule, this.modules);

        if (((int) assign.get("deletes") == 0) && ((int) assign.get("inserts") > 0)) {
            addInfoMessage(UtilsMessage.translate("assignedModule", "general.general", new String[]{assign.get("inserts").toString(), assign.get("deletes").toString(), this.userModule.getNombreCompleto()}));
        } else if (((int) assign.get("deletes") > 0) && ((int) assign.get("inserts") > 0)) {
            addWarnMessage(UtilsMessage.translate("assignedModule", "general.general", new String[]{assign.get("inserts").toString(), assign.get("deletes").toString(), this.userModule.getNombreCompleto()}));
        } else if (((int) assign.get("deletes") > 0) && ((int) assign.get("inserts") == 0)) {
            addErrorMessage(UtilsMessage.translate("assignedModule", "general.general", new String[]{assign.get("inserts").toString(), assign.get("deletes").toString(), this.userModule.getNombreCompleto()}));
        }
        initPickList(userEJB.getUserById(this.userModule.getIdusuario()).getModuloList());

    }

    public void changeUserSelection(ValueChangeEvent evt) {
        Usuario u = (Usuario) evt.getNewValue();
        initPickList(u.getModuloList());
    }

    public void deleteUser(Usuario u) {
        String userInactive = u.getNombreCompleto();
        RequestContext.getCurrentInstance().execute("PF('dlgDelete').hide();");
        if (userEJB.deleteUser(u)) {
            addWarnMessage(UtilsMessage.translate("delete", "general.general", new String[]{userInactive}));
            listUsers = initListUsers();
        } else {
            addErrorMessage(UtilsMessage.translate("error", "general.general", new String[]{"Eliminar"}));
        }

    }

    public void activateUser(Usuario u) {
        String userInactive = u.getNombreCompleto();
        RequestContext.getCurrentInstance().execute("PF('dlgActivate').hide();");
        if (userEJB.activateUser(u)) {
            addInfoMessage(UtilsMessage.translate("activate", "general.general", new String[]{userInactive}));
            listUsers = initListUsers();
        } else {
            addErrorMessage(UtilsMessage.translate("error", "general.general", new String[]{"Activar"}));
        }
    }

    public Usuario getUser(Integer id) {
        return userEJB.getUserById(id);
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

    public List<Modulo> getAvailableModules() {
        return availableModules;
    }

    public void setAvailableModules(List<Modulo> availableModules) {
        this.availableModules = availableModules;
    }

    public DualListModel<Modulo> getModules() {
        return modules;
    }

    public void setModules(DualListModel<Modulo> modules) {
        this.modules = modules;
    }

    public List<Usuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public Usuario getUserModule() {
        return userModule;
    }

    public void setUserModule(Usuario userModule) {
        this.userModule = userModule;
    }

    public Usuario getUserToDelete() {
        return userToDelete;
    }

    public void setUserToDelete(Usuario userToDelete) {
        this.userToDelete = userToDelete;
    }
}
