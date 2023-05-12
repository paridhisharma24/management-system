package com.Project.Application.managerintern;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Intern {
    @Id
    private int Iid;
    @Size(min=2)
    @Column(name="fname")
    private String fname;
    @Size(min=2)
    @Column(name="lname")
    private String lname;

    @ManyToOne
    @JoinColumn(name = "Mid")
    Manager manager;

    public Intern(){
    }

    public Intern(int id, String fname, String lname) {
        this.Iid = id;
        this.fname = fname;
        this.lname = lname;
    }

    public int getIid() {
        return Iid;
    }

    public void setIid(int iid) {
        this.Iid = iid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + Iid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
