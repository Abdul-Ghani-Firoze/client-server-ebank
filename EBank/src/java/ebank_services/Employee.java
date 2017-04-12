/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank_services;
/**
 *
 * @author AbdulGhani
 */
public class Employee {
    private String name;
    private String position;
    private String uName;
    private String password;

    public Employee(String _name, String pos, String _uName, String pass) {
        this.name = _name;
        this.position = pos;
        this.uName = _uName;
        this.password = pass;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
