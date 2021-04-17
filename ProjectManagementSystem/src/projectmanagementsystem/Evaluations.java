/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.util.Date;

/**
 *
 * @author humza
 */
public class Evaluations {

    private String title;
    private String totalNo;
    private String obtainedNo;
    private String description;
    private Date deadline;
    private String studentRegNo;

    public Evaluations() {
        title = "";
        totalNo = "";
        obtainedNo = "";
        description = "";
        deadline = new Date();
    }
    
    public Evaluations(String title, String totalNo, String description, Date deadline, String regno) {
        this.title = title;
        this.totalNo = totalNo;
        this.description = description;
        this.deadline = deadline;
        this.studentRegNo = regno;
    }

    public Evaluations(String title, String totalNo, String description, Date deadline, String regno, String obtNo) {
        this.title = title;
        this.totalNo = totalNo;
        this.description = description;
        this.deadline = deadline;
        this.studentRegNo = regno;
        this.obtainedNo = obtNo;
    }

    public boolean setTitle(String title) {
        this.title = title;
        return true;
    }

    public boolean setTotalNo(String totalNo) {
        for (int i = 0; i < totalNo.length(); i++) {
            if (totalNo.charAt(i) >= '0' && totalNo.charAt(i) <= '9') {
            } else {
                return false;
            }
        }
        this.totalNo = totalNo;
        return true;
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public boolean setDeadline(Date deadline) {
        this.deadline = deadline;
        return true;
    }

    public boolean setObtainedNo(String obtainedNo) {
        for (int i = 0; i < obtainedNo.length(); i++) {
            if (obtainedNo.charAt(i) >= '0' && obtainedNo.charAt(i) <= '9') {
            } else {
                return false;
            }
        }
        if (Integer.parseInt(obtainedNo) <= Integer.parseInt(totalNo)) {
            this.obtainedNo = obtainedNo;
            return true;
        }
        return false;
    }

    public boolean setStudentRegNo(String regno) {

        if (!regno.equals("")) {
            this.studentRegNo = regno;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getTotalNo() {
        return totalNo;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getObtainedNo() {
        return obtainedNo;
    }

    public String getStudentRegNo() {
        return studentRegNo;
    }
}
