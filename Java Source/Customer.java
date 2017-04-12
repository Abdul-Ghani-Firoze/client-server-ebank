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
public class Customer {

    private String name;
    private String bDate;
    private String add;
    private String email;
    private String mob;

    public Customer(String _name, String _bDate, String _add, String _mob, String _email) {
        this.name = _name;
        this.bDate = _bDate;
        this.add = _add;
        this.email = _email;
        this.mob = _mob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getEmail() {
        return email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
