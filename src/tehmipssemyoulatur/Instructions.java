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
public class Instructions {

    int opcode;

    //Field opcode = new Field(6);
    Instructions(int o) {
        this.opcode = 0;
    }
    
    public static void add(Register D, Register S, Register T){
        D.newValue = S.getValue() + T.getValue();
    }
    
    public static void sub(Register D, Register S, Register T){
        D.newValue = S.getValue() - T.getValue();
    }
    
    public static void mul(Register D, Register S, Register T){
        D.newValue = S.getValue() * T.getValue();
    }
    
    public static void div(Register D, Register S, Register T){
        D.newValue = S.getValue() / T.getValue();
    }
    
    public static void slt(Register D, Register S, Register T){
        if(S.getValue() - T.getValue() > 0){ 
        D.newValue = 1;}
        else{
            D.newValue = 0;
    }
}

class R_Format extends Instructions {

    int rs;
    int rt;
    int rd;
    int shamt;
    int funct;

    R_Format(int s, int t, int d, int sh, int f) {
        super(0);
        this.rs = s;
        this.rt = t;
        this.rd = d;
        this.shamt = sh;
        this.funct = f;
    }
}

class I_Format extends Instructions {

    int rs;
    int rt;
    int adrs_imm;

    I_Format(int o, int s, int t, int ai) {
        super(o);
        this.rs = s;
        this.rt = t;
        this.adrs_imm = ai;
    }
}

class J_Format extends Instructions {

    int trgtadrs;

    J_Format(int o, int ta) {
        super(o);
        this.trgtadrs = ta;
    }
}

/*class I_Format extends Instructions{
 Field rs = new Field(5);
 Field rt = new Field(5);
 Field adrs_imm = new Field(16);
 I_Format(int o, int s, int t, int ai){
 super(o);
 this.rs = s;
 this.rt = t;
 this.adrs_imm = ai;
 }*/
/*class R_Format extends Instructions{
 Field rs = new Field(5);
 Field rt = new Field(5);
 Field rd = new Field(5);
 Field shamt = new Field(5);
 Field funct = new Field(6);
 /* R_Format(int s, int t, int d, int sh, int f){
 super(0);
 this.rs = s;
 this.rt = t;
 this.rd = d;
 this.shamt = sh;
 this.funct = f;
 }*/
/*
class J_Format extends Instructions {

    Field trgtadrs = new Field(26);

    J_Format(int o, int ta) {
        super(o);
        this.trgtadrs = ta;
    }
}
*/
 
}
