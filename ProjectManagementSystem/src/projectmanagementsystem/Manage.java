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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author humza
 */
public class Manage {

    private static Manage obj;
    private List<User> userList;
    private List<AdvisoryGroup> advisoryGroups;
    private List<Project> projects;
    private List<Evaluations> evaluations;
    private List<Group> groups;
    private List<FinalizedGroup> finalizedGroups;
    private List<ArrayList<Evaluations>> studentEvaluations;

    private Manage() {
        userList = new ArrayList<>();
        advisoryGroups = new ArrayList<>();
        projects = new ArrayList<>();
        evaluations = new ArrayList<>();
        groups = new ArrayList<>();
        finalizedGroups = new ArrayList<>();
        studentEvaluations = new ArrayList<ArrayList<Evaluations>>();

        loadUsers();
        loadAdviseryGroups();
        loadProjects();
        loadEvaluations();
        loadGroups();
        loadFinalizedGroups();
        loadStudentEvaluations();
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

    public List<Evaluations> getEvaluations() {
        return evaluations;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<FinalizedGroup> getFinalizedGroups() {
        return finalizedGroups;
    }

    public List<ArrayList<Evaluations>> getStudentEvaluations() {
        return studentEvaluations;
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
                AdvisorFrame advisorFrame = new AdvisorFrame(index);
                advisorFrame.setVisible(true);
            }
            if (userList.get(index).getType().equals("Student")) {
                StudentFrame studentFrame = new StudentFrame(index);
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
                    fw.write(m.getType() + ";" + m.getUserName() + ";" + m.getGender() + ";" + m.getEmail() + ";" + m.getPassword() + ";" + m.getContactNumber() + ";");
                }
                if (userList.get(i).getType().equals("Adviser")) {
                    Adviser a = (Adviser) userList.get(i);
                    fw.write(a.getType() + ";" + a.getUserName() + ";" + a.getGender() + ";" + a.getEmail() + ";" + a.getPassword() + ";" + a.getContactNumber() + ";" + a.getCnic() + ";" + a.getRole() + ";" + a.getMemberOFAdviseryGroup() + ";");
                }
                if (userList.get(i).getType().equals("Student")) {
                    Student s = (Student) userList.get(i);
                    fw.write(s.getType() + ";" + s.getUserName() + ";" + s.getGender() + ";" + s.getEmail() + ";" + s.getPassword() + ";" + s.getRregistrationNumber() + ";" + s.getDepartment() + ";" + s.getMemberOFGroup() + ";");
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
                fw.write(a.getAG_No() + ";");
                fw.write(a.getAdviser().getRole() + ";" + a.getAdviser().getUserName() + ";" + a.getAdviser().getGender() + ";" + a.getAdviser().getEmail() + ";" + a.getAdviser().getPassword() + ";" + a.getAdviser().getContactNumber() + ";" + a.getAdviser().getCnic() + ";" + a.getAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getCoAdviser().getRole() + ";" + a.getCoAdviser().getUserName() + ";" + a.getCoAdviser().getGender() + ";" + a.getCoAdviser().getEmail() + ";" + a.getCoAdviser().getPassword() + ";" + a.getCoAdviser().getContactNumber() + ";" + a.getCoAdviser().getCnic() + ";" + a.getCoAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getIndAdviser().getRole() + ";" + a.getIndAdviser().getUserName() + ";" + a.getIndAdviser().getGender() + ";" + a.getIndAdviser().getEmail() + ";" + a.getIndAdviser().getPassword() + ";" + a.getIndAdviser().getContactNumber() + ";" + a.getIndAdviser().getCnic() + ";" + a.getIndAdviser().getMemberOFAdviseryGroup() + ";");
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
                fw.write(p.getTitle() + ";" + p.getType() + ";" + p.getDescription() + ";");
                AdvisoryGroup a = p.getAdvisoryGroup();
                fw.write(a.getAG_No() + ";");
                fw.write(a.getAdviser().getRole() + ";" + a.getAdviser().getUserName() + ";" + a.getAdviser().getGender() + ";" + a.getAdviser().getEmail() + ";" + a.getAdviser().getPassword() + ";" + a.getAdviser().getContactNumber() + ";" + a.getAdviser().getCnic() + ";" + a.getAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getCoAdviser().getRole() + ";" + a.getCoAdviser().getUserName() + ";" + a.getCoAdviser().getGender() + ";" + a.getCoAdviser().getEmail() + ";" + a.getCoAdviser().getPassword() + ";" + a.getCoAdviser().getContactNumber() + ";" + a.getCoAdviser().getCnic() + ";" + a.getCoAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getIndAdviser().getRole() + ";" + a.getIndAdviser().getUserName() + ";" + a.getIndAdviser().getGender() + ";" + a.getIndAdviser().getEmail() + ";" + a.getIndAdviser().getPassword() + ";" + a.getIndAdviser().getContactNumber() + ";" + a.getIndAdviser().getCnic() + ";" + a.getIndAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void saveEvaluations() {
        try {
            FileWriter fw = new FileWriter("evaluationsData.txt");
            for (int i = 0; i < evaluations.size(); i++) {
                Evaluations e = evaluations.get(i);
                fw.write(e.getTitle() + ";" + e.getTotalNo() + ";" + e.getDescription() + ";" + new SimpleDateFormat("MMMM dd, yyyy").format(e.getDeadline()) + ";" + e.getStudentRegNo() + ";" + e.getObtainedNo() + ";");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void saveGroups() {
        try {
            FileWriter fw = new FileWriter("groupData.txt");
            for (int i = 0; i < groups.size(); i++) {

                Group g = groups.get(i);
                fw.write(g.getSG_No() + ";");
                fw.write(g.getMember1().getUserName() + ";" + g.getMember1().getGender() + ";" + g.getMember1().getEmail() + ";" + g.getMember1().getPassword() + ";" + g.getMember1().getRregistrationNumber() + ";" + g.getMember1().getDepartment() + ";" + g.getMember1().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember2().getUserName() + ";" + g.getMember2().getGender() + ";" + g.getMember2().getEmail() + ";" + g.getMember2().getPassword() + ";" + g.getMember2().getRregistrationNumber() + ";" + g.getMember2().getDepartment() + ";" + g.getMember2().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember3().getUserName() + ";" + g.getMember3().getGender() + ";" + g.getMember3().getEmail() + ";" + g.getMember3().getPassword() + ";" + g.getMember3().getRregistrationNumber() + ";" + g.getMember3().getDepartment() + ";" + g.getMember3().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember4().getUserName() + ";" + g.getMember4().getGender() + ";" + g.getMember4().getEmail() + ";" + g.getMember4().getPassword() + ";" + g.getMember4().getRregistrationNumber() + ";" + g.getMember4().getDepartment() + ";" + g.getMember4().getMemberOFGroup()+ ";");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void saveFinalizedGroups() {
        try {
            FileWriter fw = new FileWriter("finalizedGroupData.txt");
            for (int i = 0; i < finalizedGroups.size(); i++) {
                FinalizedGroup fg = finalizedGroups.get(i);
                Group g = finalizedGroups.get(i).getGroup();
                Project p = finalizedGroups.get(i).getProject();
                fw.write(g.getSG_No() + ";");
                fw.write(g.getMember1().getUserName() + ";" + g.getMember1().getGender() + ";" + g.getMember1().getEmail() + ";" + g.getMember1().getPassword() + ";" + g.getMember1().getRregistrationNumber() + ";" + g.getMember1().getDepartment() + ";" + g.getMember1().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember2().getUserName() + ";" + g.getMember2().getGender() + ";" + g.getMember2().getEmail() + ";" + g.getMember2().getPassword() + ";" + g.getMember2().getRregistrationNumber() + ";" + g.getMember2().getDepartment() + ";" + g.getMember2().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember3().getUserName() + ";" + g.getMember3().getGender() + ";" + g.getMember3().getEmail() + ";" + g.getMember3().getPassword() + ";" + g.getMember3().getRregistrationNumber() + ";" + g.getMember3().getDepartment() + ";" + g.getMember3().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(g.getMember4().getUserName() + ";" + g.getMember4().getGender() + ";" + g.getMember4().getEmail() + ";" + g.getMember4().getPassword() + ";" + g.getMember4().getRregistrationNumber() + ";" + g.getMember4().getDepartment() + ";" + g.getMember4().getMemberOFGroup()+ ";");
                fw.write("\n");
                fw.write(p.getTitle() + ";" + p.getType() + ";" + p.getDescription() + ";");
                fw.write("\n");
                AdvisoryGroup a = p.getAdvisoryGroup();
                fw.write(a.getAG_No() + ";");
                fw.write(a.getAdviser().getRole() + ";" + a.getAdviser().getUserName() + ";" + a.getAdviser().getGender() + ";" + a.getAdviser().getEmail() + ";" + a.getAdviser().getPassword() + ";" + a.getAdviser().getContactNumber() + ";" + a.getAdviser().getCnic() + ";" + a.getAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getCoAdviser().getRole() + ";" + a.getCoAdviser().getUserName() + ";" + a.getCoAdviser().getGender() + ";" + a.getCoAdviser().getEmail() + ";" + a.getCoAdviser().getPassword() + ";" + a.getCoAdviser().getContactNumber() + ";" + a.getCoAdviser().getCnic() + ";" + a.getCoAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
                fw.write(a.getIndAdviser().getRole() + ";" + a.getIndAdviser().getUserName() + ";" + a.getIndAdviser().getGender() + ";" + a.getIndAdviser().getEmail() + ";" + a.getIndAdviser().getPassword() + ";" + a.getIndAdviser().getContactNumber() + ";" + a.getIndAdviser().getCnic() + ";" + a.getIndAdviser().getMemberOFAdviseryGroup() + ";");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    public void saveStudentEvaluations() {
        try {
            FileWriter fw = new FileWriter("studentEvaluationsData.txt");
            for (int i = 0; i < studentEvaluations.size(); i++) {
                List<Evaluations> se = studentEvaluations.get(i);
                for (int j = 0; j < se.size(); j++) {
                    Evaluations e = se.get(j);
                    fw.write(e.getTitle() + ";" + e.getTotalNo() + ";" + e.getDescription() + ";" + new SimpleDateFormat("MMMM dd, yyyy").format(e.getDeadline()) + ";" + e.getStudentRegNo() + ";" + e.getObtainedNo() + ";");
                    fw.write("\n");
                }
                fw.write(";");
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
                String[] arr = input_line.split(";");
                if (arr[0].equals("Admin")) {
                    Admin addM = new Admin(arr[1], arr[2], arr[3], arr[4], arr[5]);
                    userList.add(addM);
                }
                if (arr[0].equals("Adviser")) {
                    Adviser addT = new Adviser();
                    if (arr.length == 9) {
                        addT = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]);
                    } else if (arr.length == 8) {
                        addT = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                    }
                    userList.add(addT);
                }
                if (arr[0].equals("Student")) {
                    Student addM;
                    if (arr.length == 7) {
                        addM = new Student(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                    } else {
                        addM = new Student(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                    }
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
                String[] arr = input_line.split(";");
                Adviser addA = new Adviser(arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[1], arr[8]);
                String agNo = arr[0];
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addcA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addiA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                advisoryGroups.add(new AdvisoryGroup(addA, addcA, addiA, agNo));
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
                String[] arr = input_line.split(";");
                String title = arr[0];
                String type = arr[1];
                String des = arr[2];
                String agNo = arr[3];
                Adviser addA = new Adviser(arr[5], arr[6], arr[7], arr[8], arr[9], arr[10], arr[4], arr[11]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addcA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addiA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                projects.add(new Project(title, type, des, new AdvisoryGroup(addA, addcA, addiA, agNo)));
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadEvaluations() {
        try {
            FileReader fr = new FileReader("evaluationsData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(";");
                try {
                    if (arr.length == 5) {
                        evaluations.add(new Evaluations(arr[0], arr[1], arr[2], new SimpleDateFormat("MMMM dd, yyyy").parse(arr[3]), arr[4]));
                    } else {
                        evaluations.add(new Evaluations(arr[0], arr[1], arr[2], new SimpleDateFormat("MMMM dd, yyyy").parse(arr[3]), arr[4], arr[5]));

                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadGroups() {
        try {
            FileReader fr = new FileReader("groupData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(";");
                String sgNo = arr[0];
                Student member1 = new Student(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member2 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member3 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member4 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                groups.add(new Group(member1, member2, member3, member4, sgNo));
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadFinalizedGroups() {
        try {
            FileReader fr = new FileReader("finalizedGroupData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            input_line = br.readLine();
            while (input_line != null) {
                String[] arr = input_line.split(";");
                String sgNo = arr[0];
                Student member1 = new Student(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member2 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member3 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Student member4 = new Student(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                input_line = br.readLine();
                arr = input_line.split(";");
                String title = arr[0];
                String type = arr[1];
                String des = arr[2];
                input_line = br.readLine();
                arr = input_line.split(";");
                String agNo = arr[0];
                Adviser addA = new Adviser(arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[1], arr[8]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addcA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                input_line = br.readLine();
                arr = input_line.split(";");
                Adviser addiA = new Adviser(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[0], arr[7]);
                finalizedGroups.add(new FinalizedGroup(new Group(member1, member2, member3, member4, sgNo), new Project(title, type, des, new AdvisoryGroup(addA, addcA, addiA, agNo))));
                input_line = br.readLine();
                
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void loadStudentEvaluations() {
        try {
            FileReader fr = new FileReader("studentEvaluationsData.txt");
            BufferedReader br = new BufferedReader(fr);
            String input_line;
            List<Evaluations> e = new ArrayList<>();
            input_line = br.readLine();
            while (input_line != null) {
                if (input_line.equals(";")) {
                    studentEvaluations.add((ArrayList) e);
                    e = new ArrayList<>();
                } else {
                    String[] arr = input_line.split(";");
                    try {
                        if (arr.length == 5) {
                            e.add(new Evaluations(arr[0], arr[1], arr[2], new SimpleDateFormat("MMMM dd, yyyy").parse(arr[3]), arr[4]));
                        } else {
                            e.add(new Evaluations(arr[0], arr[1], arr[2], new SimpleDateFormat("MMMM dd, yyyy").parse(arr[3]), arr[4], arr[5]));

                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                input_line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {

        }
    }

}
