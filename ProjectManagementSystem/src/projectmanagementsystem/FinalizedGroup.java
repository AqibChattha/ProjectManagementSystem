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
public class FinalizedGroup {
    private Group group;
    private Project project;

    public FinalizedGroup(){
        group = new Group();
        project = new Project();
    }
    
    public FinalizedGroup(Group group, Project project){
        this.group = group;
        this.project = project;
    }
    
    public boolean setGroup(Group group) {
        if (!group.getSG_No().equals("")) {
            this.group = group;
            return true;
        }
        return false;
    }

    public boolean setProject(Project project) {
        if (!project.getTitle().equals("")) {
            this.project = project;
            return true;
        }
        return false;
    }

    public Group getGroup() {
        return group;
    }

    public Project getProject() {
        return project;
    }
    
}
