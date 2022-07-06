package com.grupo4;

import com.grupo4.controller.UserController;
import com.grupo4.model.repository.UserDAO;
import com.grupo4.model.entity.User;
import com.grupo4.view.frmUser;

public class App {
    public static void main(String[] args) {
        User mod = new User();
        UserDAO modC = new UserDAO();
        /*frmUser frm = new frmUser(null);
        
        UserController ctrl = new UserController(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);*/
        System.out.println("Hola");
    }
}
