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
public class Adviser extends User {

    private String contactNumber;
    private String cnic;
    private String role;

    /**
     * This function will change the value of contactNumber when called and than
     * tell us whether the contactNumber is changed or not. first it will check
     * the value of parameter number. if the name parameter is valid it will
     * change the contactNumber to number and return true. otherwise if the number
     * is invalid it will return false.
     *
     * @param number String datatype input value to be the new contactNumber
     * @return it returns boolean value, that tells wether the contactNumber was
     * changed or not.
     */
    public boolean setContactNumber(String number) {
        if (number.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                }else{
                    return false;
                }
            }
            this.contactNumber = number;
            return true;
        }
        return false;
    }

    /**
     * This function will change the value of cnic when called and than tell us
     * whether the cnic is changed or not. first it will check the value of
     * parameter cnic. if the cnic parameter is valid it will change the cnic
     * and return true. otherwise if the cnic is invalid it will return false.
     *
     * @param cnic String datatype input value to be the new cnic
     * @return it returns boolean value, that tells wether the cnic was changed
     * or not.
     */
    public boolean setCnic(String cnic) {
        if (cnic.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (cnic.charAt(i) >= '0' && cnic.charAt(i) <= '9') {
                }else{
                    return false;
                }
            }
            this.cnic = cnic;
            return true;
        }
        return false;
    }

    /**
     * This function will change the value of role when called and than
     * tell us whether the role is changed or not. first it will check
     * the value of parameter role. if the role parameter is valid it will
     * change the role and return true. otherwise if the role
     * is invalid it will return false.
     *
     * @param role String datatype input value to be the new role
     * @return it returns boolean value, that tells wether the role was
     * changed or not.
     */
    public boolean setRole(String role) {
        boolean flag;
        if (role.equals("Adviser") || role.equals("Co-Adviser") || role.equals("Industrial-Adviser")) {
            this.role = role;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * This function gets the value of contactNumber
     * @return it will return value of contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * This function gets the value of cnic
     * @return it will return value of cnic
     */
    public String getCnic() {
        return cnic;
    }

    /**
     * This function gets the value of role
     * @return it will return value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * This function gets the type of the class
     * @return it will return type of the class
     */
    public String getType(){
        return "Adviser";
    }
}
