package com.Project.Application.managerintern;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue
    private int managerid;

    //    @FnameValidator()
    @Column(name = "fname")
    private String fname;
    @Size(min = 2, message = "Size not matched")
    @Column(name = "lname")
    private String lname;

    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Intern> internList;

    public Manager() {
    }

    public Manager(int id, String fname, String lname) {
        this.managerid = id;
        this.fname = fname;
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return managerid;
    }

    public void setId(int id) {
        this.managerid = id;
    }

    public String getFname() {
        return fname;
    }

    //    @NotBlank(message = "First Name not provided")
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Intern> getInternList() {
        return internList;
    }

    public void AddIntern(List<Intern> internList) {
        this.internList.addAll(internList);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + managerid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
