/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.library;

/**
 *
 * @author Raka New
 */
public class SexLibrary {
    int sex;
    public SexLibrary(){
        
    }
    public String getString(int sex){
        this.sex = sex;
        if(this.sex == 1){
            return "Laki-laki";
        }else{
            return "Perempuan";
        }
    }
}
