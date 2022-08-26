/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class DAOClient {

    private int clientID;
    private String dni;
    private String type;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String debt;

    public DAOClient() {

    }

    public DAOClient(int clientID, String dni, String type, String name, String lastName, String phoneNumber, String email, String address, String debt) {
        this.clientID = clientID;
        this.dni = dni;
        this.type = type;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.debt = debt;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }
    
    

}
