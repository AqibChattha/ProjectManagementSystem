/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author humza
 */
public class Manage {

    private static Manage obj;
    private List<User> userList;
    private List<AdvisoryGroup> advisoryGroups;
    private List<Project> projects;

    private Manage() {
        userList = new ArrayList<>();
        advisoryGroups = new ArrayList<>();
        projects = new ArrayList<>();
        loadUsers();
        loadAdviseryGroups();
        loadProjects();
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

    public List<AdvisoryGroup> getAdvisoryGroups() {
        return advisoryGroups;
    }
    
    public List<Project> getProjects() {
        return projects;
    }

    public int accountAccessed(String username, String password) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(username) && userList.get(i).getPassword().equals(password)) {
                index = i;
            }
        }
        return index;
    }

    public void openInterface(String username, String password) {
        int index = accountAccessed(username, password);
        if (index >= 0) {
            if (userList.get(index).getType().equals("Admin")) {
                AdministratorFrame administratorFrame = new AdministratorFrame();
                administratorFrame.setVisible(true);
            }
            if (userList.get(index).getType().equals("Adviser")) {
                AdvisorFrame advisorFrame = new AdvisorFrame();
                advisorFrame.setVisible(true);
            }
            if (userList.get(index).getType().equals("Student")) {
                StudentFrame studentFrame = new StudentFrame();
                studentFrame.setVisible(true);
            }
        }
    }

    public void saveUsers() {
        try {
            FileWriter fw = new FileWriter("userData.txt");
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getType().equals("Admin")) {
                    Admin m = (Admin) userList.get(i);
                    fw.write(m.getType() + "," + m.getUserName() + "," + m.getGender() + "," + m.getEmail() + "," + m.getPassword() + "," + m.getContactNumber()+ ",");
                }
                if (userList.get(i).getType().equals("Adviser")) {
                    Adviser a = (Adviser) userList.get(i);
                    fw.write(a.getType() + "," + a.getUserName() + "," + a.getGender() + "," + a.getEmail() + "," + a.getPassword() + "," + a.getContactNumber() + "," + a.getCnic() + "," + a.getRole() + ",");
                }
                if (userList.get(i).getType().equals("Student")) {
                    Student s = (Student) userList.get(i);
                    fw.write(s.getType() + "," + s.getUserName() + "," + s.getGender() + "," + s.getEmail() + "," + s.getPassword() + "," + s.getRregistrationNumber() + "," + s.getDepartment() + ",");
                }
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void saveAdviseryGroups() {
        try {
            FileWriter fw = new FileWriter("adviseryGroupData.txt");
            for (int i = 0; i < advisoryGroups.size(); i++) {

                AdvisoryGroup a = advisoryGroups.get(i);
                fw.write(a.AG_No + ",");
                fw.write(a.adviser.getRole() + "," + a.adviser.getUserName() + "," + a.adviser.getGender() + "," + a.adviser.getEmail() + "," + a.adviser.getPassword() + "," + a.adviser.getContactNumber() + "," + a.adviser.getCnic() + ",");
                fw.write(a.coAdviser.getRole() + "," + a.coAdviser.getUserName() + "," + a.coAdviser.getGender() + "," + a.coAdviser.getEmail() + "," + a.coAdviser.getPassword() + "," + a.coAdviser.getContactNumber() + "," + a.coAdviser.getCnic() + ",");
                fw.write(a.indAdviser.getRole() + "," + a.indAdviser.getUserName() + "," + a.indAdviser.getGender() + "," + a.indAdviser.getEmail() + "," + a.indAdviser.getPassword() + "," + a.indAdviser.getContactNumber() + "," + a.indAdviser.getCnic() + ",");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }
    
    public void saveProjects() {
        try {
            FileWriter fw = new FileWriter("projectData.txt");
            for (int i = 0; i < projects.size(); i++) {
                Project p = projects.get(i);
                fw.write(p.getTitle()+ "," + p.getType()+ "," + p.getDescription()+ "," );
                AdvisoryGroup a = p.getAdvisoryGroup();
                fw.write(a.AG_No + ",");
                fw.write(a.adviser.getRole() + "," + a.adviser.getUserName() + "," + a.adviser.getGender() + "," + a.adviser.getEmail() + "," + a.adviser.getPassword() + "," + a.adviser.getContactNumber() + "," + a.adviser.getCnic() + ",");
                fw.write(a.coAdviser.getRole() + "," + a.coAdviser.getUserName() + "," + a.coAdviser.getGender() + "," + a.coAdviser.getEmail() + "," + a.coAdviser.getPassword() + "," + a.coAdviser.getContactNumber() + "," + a.coAdviser.getCnic() + ",");
                fw.write(a.indAdviser.getRole() + "," + a.indAdviser.getUserName() + "," + a.indAdviser.getGender() + "," + a.indAdviser.getEmail() + "," + a.indAdviser.getPassword() + "," + a.indAdviser.getContactNumber() + "," + a.indAdviser.getCnic() + ",");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void loadUsers() {
        try {
            FileReader fr = new FileReader("userData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(",");
                if (arr[0].equals("Admin")) {
                    Admin addM = new Admin(arr[1], arr[2], arr[3], arr[4], arr[5]);
                    userList.add(addM);
                }
                if (arr[0].equals("Adviser")) {
                    Adviser addT = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                    userList.add(addT);
                }
                if (arr[0].equals("Student")) {
                    Student addM = new Student(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                    userList.add(addM);
                }
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadAdviseryGroups() {
        try {
            FileReader fr = new FileReader("adviseryGroupData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(",");
                Adviser addA = new Adviser(arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[1]);
                Adviser addcA = new Adviser(arr[9], arr[10], arr[11], arr[12], arr[13], arr[14], arr[8]);
                Adviser addiA = new Adviser(arr[16], arr[17], arr[18], arr[19], arr[20], arr[21], arr[15]);
                advisoryGroups.add(new AdvisoryGroup(addA, addcA, addiA , arr[0]));
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadProjects() {
        try {
            FileReader fr = new FileReader("projectData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(",");
                Adviser addA = new Adviser(arr[5], arr[6], arr[7], arr[8], arr[9], arr[10], arr[4]);
                Adviser addcA = new Adviser(arr[12], arr[13], arr[14], arr[15], arr[16], arr[17], arr[11]);
                Adviser addiA = new Adviser(arr[19], arr[20], arr[21], arr[22], arr[23], arr[24], arr[18]);
                AdvisoryGroup ag = new AdvisoryGroup(addA, addcA, addiA , arr[3]);
                projects.add(new Project(arr[0], arr[1], arr[2], ag));
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

}
