package com.model;

/**
 * Created by vidhi on 3/20/2019.
 */

public class FacultyModel {

    /**
     * full_name : Prof. Hardik Bhatt
     * department : Electronics and Comm.
     * designation : Assistant Professor & HOD
     * edu_qualification : M.E. (Communication Engineering), B.E. (Electronics & Communication)
     * work_exp : 11 Years of Teaching, 3.6 Years of Industry
     * email : hardik.bhatt@git.org.in, hod.ec@git.org.in
     */

    private String full_name;
    private String department;
    private String designation;
    private String edu_qualification;
    private String work_exp;
    private String email;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEdu_qualification() {
        return edu_qualification;
    }

    public void setEdu_qualification(String edu_qualification) {
        this.edu_qualification = edu_qualification;
    }

    public String getWork_exp() {
        return work_exp;
    }

    public void setWork_exp(String work_exp) {
        this.work_exp = work_exp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
