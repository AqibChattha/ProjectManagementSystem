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
public class AdvisoryGroup {

    private Adviser adviser;
    private Adviser coAdviser;
    private Adviser indAdviser;
    private String AG_No;

    public AdvisoryGroup() {
        adviser = new Adviser();
        coAdviser = new Adviser();
        indAdviser = new Adviser();
        AG_No = "";
    }

    public AdvisoryGroup(Adviser adviser, Adviser coAdviser, Adviser indAdviser, String id) {
        this.adviser = adviser;
        this.coAdviser = coAdviser;
        this.indAdviser = indAdviser;
        AG_No = id;
    }
    
    public AdvisoryGroup(Adviser adviser, Adviser coAdviser, Adviser indAdviser) {
        this.adviser = adviser;
        this.coAdviser = coAdviser;
        this.indAdviser = indAdviser;
    }

    public boolean setAdviser(Adviser adviser) {
        if (adviser.getRole().equals("Adviser")) {
            this.adviser = adviser;
            return true;
        }
        return false;
    }

    public boolean setCoAdviser(Adviser coAdviser) {
        if (coAdviser.getRole().equals("Co-Adviser")) {
            this.coAdviser = coAdviser;
            return true;
        }
        return false;
    }

    public boolean setIndAdviser(Adviser indAdviser) {
        if (indAdviser.getRole().equals("Industrial-Adviser")) {
            this.indAdviser = indAdviser;
            return true;
        }
        return false;
    }

    public boolean setAG_No() {
        boolean flag = true;
        String id;
        for (int i = 1; i < 100; i++) {
            id = "AG-"+i;
            for (int j = 0; j < Manage.getObj().getAdvisoryGroups().size(); j++) {
                if (id.equals(Manage.getObj().getAdvisoryGroups().get(j).AG_No)) {
                    flag = false;
                }
            }
            if (flag==true) {
                AG_No = id;
                break;
            }else{
                flag = true;
            }
        }
        return flag;
    }
    public void setAG_No(String id) {
        this.AG_No = id;
    }

    public Adviser getAdviser() {
        return adviser;
    }

    public Adviser getCoAdviser() {
        return coAdviser;
    }

    public Adviser getIndAdviser() {
        return indAdviser;
    }

    public String getAG_No() {
        return AG_No;
    }
}
