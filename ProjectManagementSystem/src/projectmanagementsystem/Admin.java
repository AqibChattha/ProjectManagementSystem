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
public class Admin extends User{
    private String contactNumber;

    public Admin(){
        contactNumber = "";
    }
    public Admin(String userName, String userGender, String emailID, String password, String contact){
        super(userName, userGender, emailID, password);
        contactNumber = contact;
    }
    
    /**
     * This function will change the value of contactNumber when called and than tell us
     * whether the contactNumber is changed or not. first it will check the value of parameter
     * number. if the name parameter is valid it will change the contactNumber to number and
     * return true. otherwise if the number is invalid it will return false.
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
     * This function gets the value of contactNumber
     * @return it will return value of contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * This function gets the type of the class
     * @return it will return type of the class
     */
    public String getType(){
        return "Admin";
    }
}
