/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author humza
 */
public class User {

    private String userName;
    private String userGender;
    private String emailID = "";
    private String password = "";

    /**
     * This function will change the value of userName when called and than tell us
     * whether the userName is changed or not. first it will check the value of parameter
     * name. if the name parameter is valid it will change the userName to name and
     * return true. otherwise if the name is invalid it will return false.
     *
     * @param name String datatype input value to be the new userName
     * @return it returns boolean value, that tells wether the userName was
     * changed or not.
     */
    public boolean setName(String name) {
        boolean flag = true;
        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) == ' ')) {
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            this.userName = name;
        }
        return flag;
    }

    /**
     * This function will change the value of userGender when called and than tell us
     * whether the userGender is changed or not. first it will check the value of parameter
     * gender. if the name parameter is valid it will change the userGender value to gender
     * and return true. otherwise if the gender is invalid it will return false.
     *
     * @param gender String datatype input value to be the new userGender
     * @return it returns boolean value, that tells wether the userGender was
     * changed or not.
     */
    public boolean setGender(String gender) {
        boolean flag;
        if (gender.equals("Male") || gender.equals("Female") || gender.equals("Other")) {
            this.userGender = gender;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * This function will change the value of emailID when called and than tell us
     * whether the emailID is changed or not. first it will check the value of parameter
     * email. if the name parameter is valid it will change the emailID value to email
     * and return true. otherwise if the email is invalid it will return false.
     *
     * @param email String datatype input value to be the new emailID
     * @return it returns boolean value, that tells wether the emailID was
     * changed or not.
     */
    public boolean setEmail(String email) {
        boolean flag;
        String emailRegX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        if (matcher.find()) {
            this.emailID = email;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * This function will change the value of password when called and than tell us
     * whether the password is changed or not. first it will check the value of parameter
     * pass. if the name parameter is valid it will change the password value to pass
     * and return true. otherwise if the pass is invalid it will return false.
     *
     * @param pass String datatype input value to be the new password
     * @return it returns boolean value, that tells wether the password was
     * changed or not.
     */
    public boolean setPassword(String pass) {
        if (password.length() > 7) {
            this.password = pass;
            return true;
        }
        return false;
    }

    /**
     * This function gets the value of userName
     * @return it will return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This function gets the value of userGender
     * @return it will return value of userGender
     */
    public String getGender() {
        return userGender;
    }

    /**
     * This function gets the value of emailID
     * @return it will return value of emailID
     */
    public String getEmail() {
        return emailID;
    }

    /**
     * This function gets the value of password
     * @return it will return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This function gets the type of the class
     * @return it will return type of the class
     */
    public String getType(){
        return "User";
    }
}
