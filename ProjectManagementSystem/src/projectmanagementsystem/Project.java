/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

/**
 *
 * @author humza
 */
public class Project {

    private String title;
    private String type;
    private String description;
    private AdvisoryGroup advisoryGroup;

    public Project() {
        title = "";
        type = "";
        description = "";
        advisoryGroup = new AdvisoryGroup();
    }

    public Project(String title, String type, String description, AdvisoryGroup ag) {
        this.title = title;
        this.type = type;
        this.description = description;
        advisoryGroup = ag;
    }

    public boolean setTitle(String title) {
        this.title = title;
        return true;
    }

    public boolean setType(String type) {
        if (type.equals("Research") || type.equals("Hybrid") || type.equals("Entrepreneurship")) {
            this.type = type;
            return true;
        }
        return false;
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public boolean setAdvisoryGroup(AdvisoryGroup advisoryGroup) {
        this.advisoryGroup = advisoryGroup;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public AdvisoryGroup getAdvisoryGroup() {
        return advisoryGroup;
    }
}
