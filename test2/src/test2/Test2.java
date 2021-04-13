/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;



class shape{
    public int month = 0;
}

class circle extends shape{
    public int s = 1;
    public double i = 0.0;
}
/**
 *
 * @author humza
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        shape s1 = new shape();
        shape s2 = new circle();
        shape s3 = new square();
        System.out.println(s3.g);
    }
    
}
