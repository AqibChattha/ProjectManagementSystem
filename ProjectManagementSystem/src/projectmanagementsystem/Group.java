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
public class Group {
    private Student member1;
    private Student member2;
    private Student member3;
    private Student member4;
    private String SG_No;

    public Group() {
        this.member1 = new Student();
        this.member2 = new Student();
        this.member3 = new Student();
        this.member4 = new Student();
        SG_No = "";
    }

    public Group(Student member1, Student member2, Student member3, Student member4, String id) {
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        SG_No = id;
    }
    
    public Group(Student member1, Student member2, Student member3, Student member4) {
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
    }
    
    public boolean setMember1(Student member1) {
        if (!member1.getRregistrationNumber().equals("")) {
        this.member1 = member1;
        return true;            
        }
        return false;
    }

    public boolean setMember2(Student member2) {
        if (!member2.getRregistrationNumber().equals("")) {
        this.member2 = member2;
        return true;            
        }
        return false;
    }

    public boolean setMember3(Student member3) {
        if (!member3.getRregistrationNumber().equals("")) {
        this.member3 = member3;
        return true;            
        }
        return false;
    }

    public boolean setMember4(Student member4) {
        if (!member4.getRregistrationNumber().equals("")) {
        this.member4 = member4;
        return true;            
        }
        return false;
    }

    public boolean setSG_No() {
        boolean flag = true;
        String id;
        for (int i = 1; i < 100; i++) {
            id = "SG-"+i;
            for (int j = 0; j < Manage.getObj().getGroups().size(); j++) {
                if (id.equals(Manage.getObj().getGroups().get(j).SG_No)) {
                    flag = false;
                }
            }
            if (flag==true) {
                SG_No = id;
                break;
            }else{
                flag = true;
            }
        }
        return flag;
    }
    public void setSG_No(String id) {
        this.SG_No = id;
    }

    public Student getMember1() {
        return member1;
    }

    public Student getMember2() {
        return member2;
    }

    public Student getMember3() {
        return member3;
    }

    public Student getMember4() {
        return member4;
    }

    public String getSG_No() {
        return SG_No;
    }
}
