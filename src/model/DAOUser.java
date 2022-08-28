/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class DAOUser {       
    private int code;
    private String cedulaEmpleado;
    private String user;
    private String pass;
    private String charge;
  
    public DAOUser(){   
}

    public DAOUser(int code, String cedulaEmpleado, String user, String pass, String charge) {
        this.code = code;
        this.cedulaEmpleado = cedulaEmpleado;
        this.user = user;
        this.pass = pass;
        this.charge = charge;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCharge() {
        return charge;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
           public   String  toSting()
            
    {
        return this.user;
        
    }    
            
}
