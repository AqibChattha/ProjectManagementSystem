/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author humza
 */
public class Manage {

    private List<User> userList;
    private static Manage obj;

    private Manage() {
        userList = new ArrayList<>();
        userList.add(new Admin());
    }

    public static Manage getObj() {
        if (obj == null) {
            obj = new Manage();
        }
        return obj;
    }

    public List<User> getUserList() {
        return userList;
    }

    public int accountAccessed(List<User> users, String username, String password) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals("") && users.get(i).getPassword().equals("")) {
                index = i;
            }
        }
        return index;
    }

    public void openInterface(List<User> users, String username, String password) {
        int index = accountAccessed(users, username, password);
        System.out.println(index);
        if (index >= 0) {
            if (users.get(index).getType().equals("Admin")) {
                AdministratorFrame administratorFrame = new AdministratorFrame();
                administratorFrame.setVisible(true);
            }
            if (users.get(index).getType().equals("Adviser")) {
                AdvisorFrame advisorFrame = new AdvisorFrame();
                advisorFrame.setVisible(true);
            }
            if (users.get(index).getType().equals("Student")) {
                StudentFrame studentFrame = new StudentFrame();
                studentFrame.setVisible(true);
            }
        }
    }
}
