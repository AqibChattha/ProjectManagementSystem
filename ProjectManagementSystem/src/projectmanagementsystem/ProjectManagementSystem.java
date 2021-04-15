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
public class ProjectManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manage.getObj();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    
}
