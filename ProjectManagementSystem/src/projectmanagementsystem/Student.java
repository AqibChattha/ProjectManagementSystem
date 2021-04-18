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
public class Student extends User {

    private String registrationNumber;
    private String department;
    private String memberOfGroup = "";

    public Student() {
        registrationNumber = "";
        department = "";
    }

    public Student(String userName, String userGender, String emailID, String password, String regNo, String dep) {
        super(userName, userGender, emailID, password);
        registrationNumber = regNo;
        this.department = dep;
    }

    public Student(String userName, String userGender, String emailID, String password, String regNo, String dep, String gNo) {
        super(userName, userGender, emailID, password);
        registrationNumber = regNo;
        this.department = dep;
        this.memberOfGroup = gNo;
    }

    /**
     * This function will change the value of registrationNumber when called and
     * than tell us whether the registrationNumber is changed or not. first it
     * will check the value of parameter regNo. if the regNo parameter is valid
     * it will change the registrationNumber to number and return true.
     * otherwise if the regNo is invalid it will return false.
     *
     * @param regNo String datatype input value to be the new registrationNumber
     * @return it returns boolean value, that tells wether the
     * registrationNumber was changed or not.
     */
    public boolean setRegNo(String regNo) {
        boolean flag = true;
        if (regNo.length() > 8) {
            if (regNo.charAt(4) != '-' || !Character.isUpperCase(regNo.charAt(5)) || !Character.isUpperCase(regNo.charAt(6)) || regNo.charAt(7) != '-') {
                return false;
            }
            for (int i = 0; i < regNo.length(); i++) {
                if (i == 4) {
                    i = 8;
                }
                if (regNo.charAt(i) >= '0' && regNo.charAt(i) <= '9') {
                } else {
                    return false;
                }
            }
            for (int i = 0; i < Manage.getObj().getUserList().size(); i++) {
                if (Manage.getObj().getUserList().get(i).getType().equals("Student")) {
                    if (((Student) Manage.getObj().getUserList().get(i)).getRregistrationNumber().equals(regNo)) {
                        return false;
                    }
                }
            }
        }
        this.registrationNumber = regNo;
        return true;
    }

    /**
     * This function will change the value of department when called and than
     * tell us whether the department is changed or not. first it will check the
     * value of parameter dep. if the dep parameter is valid it will change the
     * department to number and return true. otherwise if the dep is invalid it
     * will return false.
     *
     * @param dep String datatype input value to be the new department
     * @return it returns boolean value, that tells wether the department was
     * changed or not.
     */
    public boolean setDepartment(String dep) {
        this.department = dep;
        return true;
    }

    /**
     * This function will change the value of memberOfGroup when called and than
     * tell us whether the memberOfGroup is changed or not. first it will check
     * the value of parameter groupID. if the groupID parameter is valid it will
     * change the memberOfGroup and return true. otherwise if the groupID is
     * invalid it will return false.
     *
     * @param groupID String datatype input value to be the new memberOfGroup
     * @return it returns boolean value, that tells wether the memberOfGroup was
     * changed or not.
     */
    public boolean setMemberOFGroup(String groupID) {
        memberOfGroup = groupID;
        return true;
    }

    /**
     * This function gets the value of registrationNumber
     *
     * @return it will return value of registrationNumber
     */
    public String getRregistrationNumber() {
        return registrationNumber;
    }

    /**
     * This function gets the value of department
     *
     * @return it will return value of department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This function gets the value of memberOfGroup
     *
     * @return it will return value of memberOfGroup
     */
    public String getMemberOFGroup() {
        return memberOfGroup;
    }

    /**
     * This function gets the type of the class
     *
     * @return it will return type of the class
     */
    public String getType() {
        return "Student";
    }
}
