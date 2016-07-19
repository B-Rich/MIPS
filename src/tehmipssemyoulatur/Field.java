/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehmipssemyoulatur;

/**
 *
 * @author Threadcount
 */
public class Field {
    Register R;
    int size; //max size
    
    Field(Register r, int s){
        this.R = r;
        this.size = s;
    }
    
    Field(int s){
        this.size = Integer.parseInt(Integer.toBinaryString(s));
    }
    
    Field(Register r){
        this.R = r;
    }
}
