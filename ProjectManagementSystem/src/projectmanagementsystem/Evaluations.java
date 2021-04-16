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
    private String description;
    private Date deadline;

    public Evaluations(){
        title = "";
        totalNo = "";
        description = "";
        deadline = new Date();
    }
    
    public Evaluations(String title, String totalNo, String description, Date deadline){
        this.title = title;
        this.totalNo = totalNo;
        this.description = description;
        this.deadline = deadline;
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

}
