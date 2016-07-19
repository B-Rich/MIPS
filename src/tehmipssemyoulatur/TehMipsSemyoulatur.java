/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehmipssemyoulatur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Threadcount
 */
public class TehMipsSemyoulatur {

    public static long identifyReg(String S) {
        HashMap<String, Long> Regz
                = new HashMap<String, Long>();
        Regz.put("$zero", 0l);
        Regz.put("$at", 1l);
        Regz.put("$v0", 2l);
        Regz.put("$v1", 3l);
        Regz.put("$a0", 4l);
        Regz.put("$a1", 5l);
        Regz.put("$a2", 6l);
        Regz.put("$a3", 7l);
        Regz.put("$t0", 8l);
        Regz.put("$t1", 9l);
        Regz.put("$t2", 10l);
        Regz.put("$t3", 11l);
        Regz.put("$t4", 12l);
        Regz.put("$t5", 13l);
        Regz.put("$t6", 14l);
        Regz.put("$t7", 15l);
        Regz.put("$s0", 16l);
        Regz.put("$s1", 17l);
        Regz.put("$s2", 18l);
        Regz.put("s3", 19l);
        Regz.put("$s4", 20l);
        Regz.put("$s5", 21l);
        Regz.put("$s6", 22l);
        Regz.put("$s7", 23l);
        Regz.put("$t8", 24l);
        Regz.put("$t9", 25l);
        Regz.put("$k0", 26l);
        Regz.put("$k1", 27l);
        Regz.put("$gp", 28l);
        Regz.put("$sp", 29l);
        Regz.put("$fp", 30l);
        Regz.put("$ra", 31l);
        return Regz.get(S);

    }

    public static String GetFunctData(long opcode1, long rd1, long rs1, long rt1, long shamt1, long funct1) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%06d%05d%05d%05d%05d%06d",
                Long.parseLong(Long.toBinaryString(opcode1)),
                Long.parseLong(Long.toBinaryString(rs1)),
                Long.parseLong(Long.toBinaryString(rt1)),
                Long.parseLong(Long.toBinaryString(rd1)),
                Long.parseLong(Long.toBinaryString(shamt1)),
                Long.parseLong(Long.toBinaryString(funct1))));
        String tmp = binaryToHex(sb.toString());
        return tmp;
    }

    public static String GetFunctData(long opcode1, long rs1, long rt1, long imm1) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%06d%05d%05d%016d",
                Long.parseLong(Long.toBinaryString(opcode1)),
                Long.parseLong(Long.toBinaryString(rs1)),
                Long.parseLong(Long.toBinaryString(rt1)),
                Long.parseLong(Long.toBinaryString(imm1))));
        String tmp = binaryToHex(sb.toString());
        return tmp;
    }

    public static String GetFunctData(long opcode1, long addrs1) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%06d%026d",
                Long.parseLong(Long.toBinaryString(opcode1)),
                Long.parseLong(Long.toBinaryString(addrs1))));
        String tmp = binaryToHex(sb.toString());
        return tmp;
    }

    public static void SpellCheck(String S) {
        String lines = S.toLowerCase();
        if (lines.startsWith("add")) {
            System.out.println("Add");
        }
        if (lines.startsWith("sub")) {
            System.out.println("Subtract");
        }
    }

    public static boolean checkInstValidity(JTextArea J) {
        int valCnt = 0;
        String[] lines = J.getText().toLowerCase().split("\\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("add")
                    || lines[i].startsWith("addi")
                    || lines[i].startsWith("sub")
                    || lines[i].startsWith("and")
                    || lines[i].startsWith("andi")
                    || lines[i].startsWith("or")
                    || lines[i].startsWith("ori")
                    || lines[i].startsWith("nor")
                    || lines[i].startsWith("slt")
                    || lines[i].startsWith("sltu")
                    || lines[i].startsWith("slti")
                    || lines[i].startsWith("sltui")
                    || lines[i].startsWith("sll")
                    || lines[i].startsWith("srl")
                    || lines[i].startsWith("sra")
                    || lines[i].startsWith("bne")
                    || lines[i].startsWith("beq")
                    || lines[i].startsWith("bgtz")
                    || lines[i].startsWith("bltz")
                    || lines[i].startsWith("mult")
                    || lines[i].startsWith("div")
                    || lines[i].startsWith("j")
                    || lines[i].startsWith("jr")
                    || lines[i].startsWith("jal")
                    || lines[i].startsWith("lw")
                    || lines[i].startsWith("sw")
                    || lines[i].startsWith("add")
                    || lines[i].startsWith("add")) {
                valCnt++;
            }

        }
        if (valCnt == lines.length) {
            return true;
        }
        return false;
    }

    public static void FixCase(JTextArea J) {
        String[] lines = J.getText().toLowerCase().split("\\n");
        try {
            File file = new File("Test.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < lines.length; i++) {
                output.write(lines[i]);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateDisp(JTextArea J) {
        try {
            String textLine;
            FileReader fr = new FileReader("Test.txt");
            BufferedReader reader = new BufferedReader(fr);
            textLine = reader.readLine();
            J.read(reader, "J");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*public static void GetFuct(JTextArea J) {
     try {
     String textLine;
     FileReader fr = new FileReader("Test.txt");
     BufferedReader reader = new BufferedReader(fr);
     textLine = reader.readLine();
     J.read(reader, "J");
     } catch (Exception e) {
     e.printStackTrace();
     }

     }*/
    String inst = "add $t1 $t2 $t3";

//    public static void GetFunct(String strng){
//        if(strng.startsWith("add")){
//            String dlm =" $";
//            String[] ln = strng.split("\\s+");
//            String[] val = new String[ln.length];
//            int s = 0;
//            //String[] ln = strng.split(dlm);
//            for(int i = 1 ; i < ln.length ; i++){
//                if(ln[i].startsWith("$")){
//                    val[i] = ln[i].replace("$t", "");
////                    val[i] = ln[i].replace(",", "");
//                    s += Integer.parseInt(val[i]);
//                }
//                //s = Integer.parseInt(val[0]) + Integer.parseInt(val[1]);
//                System.out.println(val[i]);
//                System.out.println(ln[i]);
//                System.out.println(s);
//            }
//        }
//    }
    public static String parseInst(String strng) {
        HashMap<String, Long> Inst
                = new HashMap<String, Long>();
        Inst.put("add", 32l);
        Inst.put("addi", 8l);
        Inst.put("sub", 34l);
        Inst.put("and", 36l);
        Inst.put("andi", 12l);
        Inst.put("or", 37l);
        Inst.put("ori", 13l);
        Inst.put("nor", 39l);
        Inst.put("slt", 42l);
        Inst.put("sltu", 43l);
        Inst.put("slti", 10l);
        Inst.put("sltui", 11l);
        Inst.put("sll", 0l);
        Inst.put("srl", 2l);
        Inst.put("sra", 3l);
        Inst.put("bne", 4l);
        Inst.put("beq", 5l);
        Inst.put("bgtz", 7l);
        Inst.put("bltz", 1l);
        Inst.put("mult", 24l);
        Inst.put("div", 26l);
        Inst.put("j", 2l);
        Inst.put("jr", 8l);
        Inst.put("jal", 3l);
        Inst.put("lw", 35l);
        Inst.put("sw", 43l);
        Inst.put("nop", 63l);
        Inst.put("halt", 255l);
        String v = null;
        String[] ln = strng.split("\\s+");
        if (ln[0].startsWith("add")
                || ln[0].startsWith("sub")
                || ln[0].startsWith("mult")
                || ln[0].startsWith("div")
                || ln[0].startsWith("and")
                || ln[0].startsWith("or")
                || ln[0].startsWith("sll")
                || ln[0].startsWith("srl")
                || ln[0].startsWith("slt")
                || ln[0].startsWith("sltu")
                || ln[0].startsWith("jr")) {
            long opcode1 = 0;
            long rd1 = identifyReg(ln[1]);
            long rs1 = identifyReg(ln[2]);
            long rt1 = identifyReg(ln[3]);
            long shamt1 = 0;
            long funct1 = Inst.get(ln[0]);
            v = GetFunctData(opcode1, rd1, rs1, rt1, shamt1, funct1);
            return v;
        }

        if (ln[0].startsWith("addi")
                //                || ln[0].startsWith("subi")
                /*|| ln[0].startsWith("lw") 
                 || ln[0].startsWith("sw")*/
                || ln[0].startsWith("andi")
                || ln[0].startsWith("ori")
                || ln[0].startsWith("beq")
                || ln[0].startsWith("bne")
                || ln[0].startsWith("bltz")
                || ln[0].startsWith("bgtz")
                || ln[0].startsWith("slti")
                || ln[0].startsWith("sltui")
                || ln[0].startsWith("jr")) {
            long opcode1 = Inst.get(ln[0]);
            long rt1 = identifyReg(ln[1]);
            long rs1 = identifyReg(ln[2]);
            long imm1 = Long.parseLong(ln[3]);
            v = GetFunctData(opcode1, rs1, rt1, imm1);
            return v;
        }

        if (ln[0].startsWith("jal")
                || ln[0].startsWith("j")) {
            long opcode1 = Inst.get(ln[0]);
            long addrs1 = Long.parseLong(ln[1]);
            v = GetFunctData(opcode1, addrs1);
            return v;
        }
        return v;
    }

    public static void GetFunct(String strng) {
        if (strng.startsWith("add")) {
            String dlm = " $";
            String[] ln = strng.split("\\s+");
            String opcode = "000000";
//            String rd = Long.toBinaryString(getIndexValue(ln[1]);
//            String rs = Long.toBinaryString(getIndexValue(ln[2]);
//            String rt = Long.toBinaryString(getIndexValue(ln[3]);
//            String rd = identifyReg(ln[1]);
            String rs = Long.toBinaryString(10);
            String rt = Long.toBinaryString(12);
            String shamt = "00000";
            String funct = "100000";
            String i = opcode + /*rd + */ rs + rt + shamt + funct;
            long Inst = Long.parseLong(Long.toHexString(Long.parseLong(i)));
            //long tst = Long.parseLong(Long.toHexString(Long.parseLong(rd)));
            //String[] val = new String[ln.length];
//            int s = 0;
//            //String[] ln = strng.split(dlm);
//            for(int i = 1 ; i < ln.length ; i++){
//                if(ln[i].startsWith("$")){
//                    val[i] = ln[i].replace("$t", "");
////                    val[i] = ln[i].replace(",", "");
//                    s += Integer.parseInt(val[i]);
//                }
//                //s = Integer.parseInt(val[0]) + Integer.parseInt(val[1]);
//                System.out.println(val[i]);
//                System.out.println(ln[i]);
//                System.out.println(s);
//            }
            //System.out.println(Inst);
            //System.out.println(tst);
        }
    }

    /*public static void UpdateDisp(String S) {
     try {
     String textLine;
     FileReader fr = new FileReader("Test.txt");
     BufferedReader reader = new BufferedReader(fr);
     textLine = reader.readLine();
     J.read(reader, "J");
     } catch (Exception e) {
     e.printStackTrace();
     }

     }*/
    public static String binaryToHex(String bin) {
        return String.format("0x%08x", Long.parseLong(bin, 2));
    }

    /*public HashMap<controlLine, Long> setCtrlLns(long o, long f){
     HashMap<controlLine, Long> vals = new HashMap<controlLine, Long>();
        
     vals.put(controlLine.REGDST, 0l);
     ID_EX.setVal(controlLine.REGDST, 0l);
            
     vals.put(controlLine.REGWRITE, 0l);
     ID_EX.setVal(controlLine.REGWRITE, 0l);
            
     vals.put(controlLine.MEMWRITE, 0l);
     ID_EX.setVal(controlLine.MEMWRITE, 0l);
            
     vals.put(controlLine.MEMREAD, 0l);
     ID_EX.setVal(controlLine.MEMREAD, 0l);
            
     vals.put(controlLine.MEMRESULT, 0l);
     ID_EX.setVal(controlLine.MEMRESULT, 0l);
            
     vals.put(controlLine.ALUSRC, 0l);
     ID_EX.setVal(controlLine.ALUSRC, 0l);
            
     vals.put(controlLine.ALUOP, 0l);
     ID_EX.setVal(controlLine.ALUOP, 0l);
            
     vals.put(controlLine.ALURESULT, 0l);
     ID_EX.setVal(controlLine.ALURESULT, 0l);

     vals.put(controlLine.ALURESULT, 0l);
     ID_EX.setVal(controlLine.ALURESULT, 0l);
                        
     vals.put(controlLine.BRANCH, 0l);
     ID_EX.setVal(controlLine.BRANCH, 0l);
            
     vals.put(controlLine.BRANCHNE, 0l);
     ID_EX.setVal(controlLine.BRANCHNE, 0l);
            
     vals.put(controlLine.JUMP, 0l);
     ID_EX.setVal(controlLine.JUMP, 0l);
            
     vals.put(controlLine.JUMPSRC, 0l);
     ID_EX.setVal(controlLine.JUMPSRC, 0l);
            
     vals.put(controlLine.HALT, 0l);
     ID_EX.setVal(controlLine.HALT, 0l);
            
     if(IF_ID.getVal((controlLine.OPCODE)) == NOP){
     return vals;
     }
            
     switch((int)o){
     case ArthmtcOPCode:
     vals.put(controlLine.REGDST, 1l);
     ID_EX.setVal(controlLine.REGDST, 1l);
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
                    
     switch((int)f){
     case ADD:
     vals.put(controlLine.ALUOP, 0l);
     ID_EX.setVal(controlLine.ALUOP, 0l);
     break;
     case SUB:
     vals.put(controlLine.ALUOP, 1l);
     ID_EX.setVal(controlLine.ALUOP, 1l);
     break;
     case AND:
     vals.put(controlLine.ALUOP, 2l);
     ID_EX.setVal(controlLine.ALUOP, 2l);    
     break;
     case OR:
     vals.put(controlLine.ALUOP, 3l);
     ID_EX.setVal(controlLine.ALUOP, 3l);
     break;
     case NOR:
     vals.put(controlLine.ALUOP, 4l);
     ID_EX.setVal(controlLine.ALUOP, 4l);
     break;
     case SLT:
     vals.put(controlLine.ALUOP, 5l);
     ID_EX.setVal(controlLine.ALUOP, 5l);
     break;
     case MULT:
     vals.put(controlLine.ALUOP, 6l);
     ID_EX.setVal(controlLine.ALUOP, 6l);
     break;
     case DIV:
     vals.put(controlLine.ALUOP, 7l);
     ID_EX.setVal(controlLine.ALUOP, 7l);    
     break;
     case SRA:
     vals.put(controlLine.ALUOP, 8l);
     ID_EX.setVal(controlLine.ALUOP, 8l);    
     break;    
     }
     break;
                    
     case ADDI:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);  
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;
                
     case ANDI:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);
     vals.put(controlLine.ALUOP, 2l);
     ID_EX.setVal(controlLine.ALUOP, 2l); 
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;
                
     case ORI:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);
     vals.put(controlLine.ALUOP, 3l);
     ID_EX.setVal(controlLine.ALUOP, 3l); 
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;
                
     case SLTI:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);
     vals.put(controlLine.ALUOP, 5l);
     ID_EX.setVal(controlLine.ALUOP, 5l); 
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;    
                
     case BEQ:
     vals.put(controlLine.ALUOP, 1l);
     ID_EX.setVal(controlLine.ALUOP, 1l);
     vals.put(controlLine.BRANCH, 1l);
     ID_EX.setVal(controlLine.BRANCH, 1l); 
     break;
             
     case BGTZ:
     vals.put(controlLine.ALUOP, 1l);
     ID_EX.setVal(controlLine.ALUOP, 1l);
     vals.put(controlLine.BRANCH, 1l);
     ID_EX.setVal(controlLine.BRANCH, 1l); 
     break;    
            
     case BLTZ:
     vals.put(controlLine.ALUOP, 1l);
     ID_EX.setVal(controlLine.ALUOP, 1l);
     vals.put(controlLine.BRANCH, 1l);
     ID_EX.setVal(controlLine.BRANCH, 1l); 
     break;    
                
     case BNE:
     vals.put(controlLine.BRANCHNE, 3l);
     ID_EX.setVal(controlLine.BRANCHNE, 3l); 
     vals.put(controlLine.ALUOP, 1l);
     ID_EX.setVal(controlLine.ALUOP, 1l);
     vals.put(controlLine.BRANCH, 1l);
     ID_EX.setVal(controlLine.BRANCH, 1l); 
     break;
                
     case J:
     vals.put(controlLine.JUMP, 1l);
     ID_EX.setVal(controlLine.JUMP, 1l);
     break;
                
     case JAL:
     vals.put(controlLine.JUMP, 1l);
     ID_EX.setVal(controlLine.JUMP, 1l);
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;    
                
     case LW:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);
     vals.put(controlLine.MEMTOREG, 1l);
     ID_EX.setVal(controlLine.MEMTOREG, 1l);
     vals.put(controlLine.MEMREAD, 1l);
     ID_EX.setVal(controlLine.MEMREAD, 1l);
     vals.put(controlLine.REGWRITE, 1l);
     ID_EX.setVal(controlLine.REGWRITE, 1l);
     break;
                
     case SW:
     vals.put(controlLine.ALUSRC, 1l);
     ID_EX.setVal(controlLine.ALUSRC, 1l);
     vals.put(controlLine.MEMWRITE, 1l);
     ID_EX.setVal(controlLine.MEMWRITE, 1l);
     break;
                
     case HALT:
     vals.put(controlLine.HALT, 1l);
     ID_EX.setVal(controlLine.HALT, 1l);
     break;     
                
     }
     //RIP
     //REKT
     return vals;
     }*/
    public static HashMap<String, Long> Parsefker(JTextArea J) {
        long PC = 0l;
//        HashMap<String, Long> Regz
//                = new HashMap<String, Long>();
//        Regz.put("$zero", 0l);
//        Regz.put("$at", 1l);
//        Regz.put("$v0", 2l);
//        Regz.put("$v1", 3l);
//        Regz.put("$a0", 4l);
//        Regz.put("$a1", 5l);
//        Regz.put("$a2", 6l);
//        Regz.put("$a3", 7l);
//        Regz.put("$t0", 8l);
//        Regz.put("$t1", 9l);
//        Regz.put("$t2", 10l);
//        Regz.put("$t3", 11l);
//        Regz.put("$t4", 12l);
//        Regz.put("$t5", 13l);
//        Regz.put("$t6", 14l);
//        Regz.put("$t7", 15l);
//        Regz.put("$s0", 16l);
//        Regz.put("$s1", 17l);
//        Regz.put("$s2", 18l);
//        Regz.put("s3", 19l);
//        Regz.put("$s4", 20l);
//        Regz.put("$s5", 21l);
//        Regz.put("$s6", 22l);
//        Regz.put("$s7", 23l);
//        Regz.put("$t8", 24l);
//        Regz.put("$t9", 25l);
//        Regz.put("$k0", 26l);
//        Regz.put("$k1", 27l);
//        Regz.put("$gp", 28l);
//        Regz.put("$sp", 29l);
//        Regz.put("$fp", 30l);
//        Regz.put("$ra", 31l);
        HashMap<String, Long> RegzVal
                = new HashMap<String, Long>();
        RegzVal.put("$zero", 0l);
        RegzVal.put("$at", 0l);
        RegzVal.put("$v0", 0l);
        RegzVal.put("$v1", 0l);
        RegzVal.put("$a0", 0l);
        RegzVal.put("$a1", 0l);
        RegzVal.put("$a2", 0l);
        RegzVal.put("$a3", 0l);
        RegzVal.put("$t0", 0l);
        RegzVal.put("$t1", 0l);
        RegzVal.put("$t2", 0l);
        RegzVal.put("$t3", 0l);
        RegzVal.put("$t4", 0l);
        RegzVal.put("$t5", 0l);
        RegzVal.put("$t6", 0l);
        RegzVal.put("$t7", 0l);
        RegzVal.put("$s0", 0l);
        RegzVal.put("$s1", 0l);
        RegzVal.put("$s2", 0l);
        RegzVal.put("s3", 0l);
        RegzVal.put("$s4", 0l);
        RegzVal.put("$s5", 0l);
        RegzVal.put("$s6", 0l);
        RegzVal.put("$s7", 0l);
        RegzVal.put("$t8", 0l);
        RegzVal.put("$t9", 0l);
        RegzVal.put("$k0", 0l);
        RegzVal.put("$k1", 0l);
        RegzVal.put("$gp", 0l);
        RegzVal.put("$sp", 0l);
        RegzVal.put("$fp", 0l);
        String v = null;
        String[] strng = J.getText().split("\\n");
        for (int i = 0; i < strng.length; i++) {
            String[] ln = strng[i].split("\\s+");

            if (ln[0].startsWith("add")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) + RegzVal.get(ln[3])));
            }

            if (ln[0].startsWith("sub")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) - RegzVal.get(ln[3])));

                if (ln[0].startsWith("mult")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) * RegzVal.get(ln[3])));
                }
                if (ln[0].startsWith("div")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) / RegzVal.get(ln[3])));
                }
                if (ln[0].startsWith("and")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) & RegzVal.get(ln[3])));
                }

                if (ln[0].startsWith("or")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) | RegzVal.get(ln[3])));
                }

                if (ln[0].startsWith("sll")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) << Long.parseLong(ln[3])));
                }

                if (ln[0].startsWith("srl")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) >> Long.parseLong(ln[3])));
                }

                if (ln[0].startsWith("slt")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) > RegzVal.get(ln[3]) ? 0l : 1l));
                }

                if (ln[0].startsWith("sltu")) {
                    RegzVal.put(ln[1], (Math.abs(RegzVal.get(ln[2])) > Math.abs(RegzVal.get(ln[3])) ? 0l : 1l));
                }

                if (ln[0].startsWith("slti")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) > Long.parseLong(ln[3]) ? 0l : 1l));
                }

                if (ln[0].startsWith("sltui")) {
                    RegzVal.put(ln[1], (Math.abs(RegzVal.get(ln[2])) > Math.abs(Long.parseLong(ln[3])) ? 0l : 1l));
                }

                if (ln[0].startsWith("jr")) {
                    PC = RegzVal.get("$ra");
                }

                if (ln[0].startsWith("j")) {
                    PC = 4 * Long.parseLong(ln[1]);
                }

                if (ln[0].startsWith("jal")) {
                    PC = 4 * Long.parseLong(ln[1]);
                    RegzVal.put("$ra", PC);
                }

                if (ln[0].startsWith("addi")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) + Long.parseLong(ln[3])));
                }

                if (ln[0].startsWith("sub")) {
                    RegzVal.put(ln[1], (RegzVal.get(ln[2]) - RegzVal.get(ln[3])));

                    if (ln[0].startsWith("mult")) {
                        RegzVal.put(ln[1], (RegzVal.get(ln[2]) * RegzVal.get(ln[3])));
                    }
                    if (ln[0].startsWith("div")) {
                        RegzVal.put(ln[1], (RegzVal.get(ln[2]) / RegzVal.get(ln[3])));
                    }
                    if (ln[0].startsWith("andi")) {
                        RegzVal.put(ln[1], (RegzVal.get(ln[2]) & Long.parseLong(ln[3])));
                    }

                    if (ln[0].startsWith("ori")) {
                        RegzVal.put(ln[1], (RegzVal.get(ln[2]) | Long.parseLong(ln[3])));
                    }

                    if (ln[0].startsWith("beq")) {
                        while (RegzVal.get(ln[2]) != RegzVal.get(ln[3])) {
                            int f = 0;
                            parseInst(strng[i]);
                        }
                    }

                    if (ln[0].startsWith("bne")) {
                        while (RegzVal.get(ln[2]) == RegzVal.get(ln[3])) {
                            int f = 0;
                            //parseInst(strng[i]);
                        }
                    }

                    if (ln[0].startsWith("move")) {
                        RegzVal.put(ln[1], (RegzVal.get(ln[2]) + 0));
                    }
                }
            }
        }
        return RegzVal;
    }

    public static void Parsefker(JTextArea J1, JTextArea J2) {
        long PC = 0l;
        HashMap<String, Long> Regz
                = new HashMap<String, Long>();
        Regz.put("$zero", 0l);
        Regz.put("$at", 1l);
        Regz.put("$v0", 2l);
        Regz.put("$v1", 3l);
        Regz.put("$a0", 4l);
        Regz.put("$a1", 5l);
        Regz.put("$a2", 6l);
        Regz.put("$a3", 7l);
        Regz.put("$t0", 8l);
        Regz.put("$t1", 9l);
        Regz.put("$t2", 10l);
        Regz.put("$t3", 11l);
        Regz.put("$t4", 12l);
        Regz.put("$t5", 13l);
        Regz.put("$t6", 14l);
        Regz.put("$t7", 15l);
        Regz.put("$s0", 16l);
        Regz.put("$s1", 17l);
        Regz.put("$s2", 18l);
        Regz.put("$s3", 19l);
        Regz.put("$s4", 20l);
        Regz.put("$s5", 21l);
        Regz.put("$s6", 22l);
        Regz.put("$s7", 23l);
        Regz.put("$t8", 24l);
        Regz.put("$t9", 25l);
        Regz.put("$k0", 26l);
        Regz.put("$k1", 27l);
        Regz.put("$gp", 28l);
        Regz.put("$sp", 29l);
        Regz.put("$fp", 30l);
        Regz.put("$ra", 31l);
        HashMap<String, Long> RegzVal
                = new HashMap<String, Long>();
        RegzVal.put("$zero", 0l);
        RegzVal.put("$at", 0l);
        RegzVal.put("$v0", 0l);
        RegzVal.put("$v1", 0l);
        RegzVal.put("$a0", 0l);
        RegzVal.put("$a1", 0l);
        RegzVal.put("$a2", 0l);
        RegzVal.put("$a3", 0l);
        RegzVal.put("$t0", 0l);
        RegzVal.put("$t1", 0l);
        RegzVal.put("$t2", 0l);
        RegzVal.put("$t3", 0l);
        RegzVal.put("$t4", 0l);
        RegzVal.put("$t5", 0l);
        RegzVal.put("$t6", 0l);
        RegzVal.put("$t7", 0l);
        RegzVal.put("$s0", 0l);
        RegzVal.put("$s1", 0l);
        RegzVal.put("$s2", 0l);
        RegzVal.put("$s3", 0l);
        RegzVal.put("$s4", 0l);
        RegzVal.put("$s5", 0l);
        RegzVal.put("$s6", 0l);
        RegzVal.put("$s7", 0l);
        RegzVal.put("$t8", 0l);
        RegzVal.put("$t9", 0l);
        RegzVal.put("$k0", 0l);
        RegzVal.put("$k1", 0l);
        RegzVal.put("$gp", 0l);
        RegzVal.put("$sp", 0l);
        RegzVal.put("$fp", 0l);
        RegzVal.put("$ra", 0l);

        HashMap<String, Long> Val
                = new HashMap<String, Long>();
        Val.put("RegDst", 0l);
        Val.put("Branch", 0l);
        Val.put("MemRead", 0l);
        Val.put("MemToReg", 0l);
        Val.put("MemWrite", 0l);
        Val.put("ALU Src", 0l);
        Val.put("RegWrite", 0l);
        Val.put("Jump", 0l);

        HashMap<String, Long> Mem
                = new HashMap<String, Long>();
        Mem.put("0", 0l);
        Mem.put("4", 0l);
        Mem.put("8", 0l);
        Mem.put("12", 0l);
        Mem.put("16", 0l);
        Mem.put("20", 0l);
        Mem.put("24", 0l);
        Mem.put("28", 0l);
        Mem.put("32", 0l);
        Mem.put("36", 0l);
        Mem.put("40", 0l);
        Mem.put("44", 0l);
        Mem.put("48", 0l);
        Mem.put("52", 0l);
        Mem.put("56", 0l);
        Mem.put("60", 0l);
        Mem.put("64", 0l);
        Mem.put("68", 0l);
        Mem.put("72", 0l);
        Mem.put("76", 0l);
        Mem.put("80", 0l);
        Mem.put("84", 0l);
        Mem.put("88", 0l);
        Mem.put("92", 0l);
        Mem.put("96", 0l);
        Mem.put("100", 0l);
        Mem.put("104", 0l);
        Mem.put("108", 0l);
        Mem.put("112", 0l);
        Mem.put("116", 0l);
        Mem.put("120", 0l);
        Mem.put("124", 0l);
        Mem.put("128", 0l);

        String v = null;
        String[] strng = J1.getText().split("\\n");
        for (int i = 0; i < strng.length; i++) {
            String[] ln = strng[i].split("\\s+");

            if (ln[0].equals("addi")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) + Long.parseLong(ln[3])));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("add")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) + RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("sub")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) - RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("mult")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) * RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }
            if (ln[0].equals("div")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) / RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }
            if (ln[0].equals("and")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) & RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("or")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) | RegzVal.get(ln[3])));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("nor")) {
                RegzVal.put(ln[1], (~(RegzVal.get(ln[2]) | RegzVal.get(ln[3]))));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("sll")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) << Long.parseLong(ln[3])));
            }

            if (ln[0].equals("srl")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) >> Long.parseLong(ln[3])));
            }

            if (ln[0].equals("slt")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) > RegzVal.get(ln[3]) ? 0l : 1l));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);

            }

            if (ln[0].equals("sltu")) {
                RegzVal.put(ln[1], (Math.abs(RegzVal.get(ln[2])) > Math.abs(RegzVal.get(ln[3])) ? 0l : 1l));
            }

            if (ln[0].equals("slti")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) > Long.parseLong(ln[3]) ? 0l : 1l));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);

            }

            if (ln[0].equals("sltui")) {
                RegzVal.put(ln[1], (Math.abs(RegzVal.get(ln[2])) > Math.abs(Long.parseLong(ln[3])) ? 0l : 1l));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("jr")) {
                PC = RegzVal.get("$ra");
            }

            if (ln[0].equals("j")) {
                PC = 4 * Long.parseLong(ln[1]);
                Val.put("Jump", 1l);
            }

            if (ln[0].equals("jal")) {
                PC = 4 * Long.parseLong(ln[1]);
                RegzVal.put("$ra", PC);
            }

            if (ln[0].equals("andi")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) & Long.parseLong(ln[3])));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("ori")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) | Long.parseLong(ln[3])));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("beq")) {
                Val.put("Branch", 1l);
                while (RegzVal.get(ln[2]) != RegzVal.get(ln[3])) {
                    int f = 0;
                    parseInst(strng[i]);
                }
            }

            if (ln[0].equals("bne")) {
                Val.put("Branch", 1l);
                while (RegzVal.get(ln[2]) == RegzVal.get(ln[3])) {
                    int f = 0;
                    //parseInst(strng[i]);
                }
            }

            if (ln[0].equals("move")) {
                RegzVal.put(ln[1], (RegzVal.get(ln[2]) + 0));
                Val.put("RegDst", 1l);
                Val.put("RegWrite", 1l);
            }

            if (ln[0].equals("lw")) {
                RegzVal.put(ln[1], (Mem.get(ln[2]) + 0));
                Val.put("ALU Src", 1l);
                Val.put("RegWrite", 1l);
                Val.put("MemToReg", 1l);
                Val.put("MemRead", 1l);
            }

            if (ln[0].equals("sw")) {
                Mem.put(ln[2], (RegzVal.get(ln[1]) + 0));
                Val.put("ALU Src", 1l);
                Val.put("MemWrite", 1l);
            }

        }

        String[] Regs = new String[32];
        Regs[0] = "$zero";
        Regs[1] = "$at";
        Regs[2] = "$v0";
        Regs[3] = "$v1";
        Regs[4] = "$a0";
        Regs[5] = "$a1";
        Regs[6] = "$a2";
        Regs[7] = "$a3";
        Regs[8] = "$t0";
        Regs[9] = "$t1";
        Regs[10] = "$t2";
        Regs[11] = "$t3";
        Regs[12] = "$t4";
        Regs[13] = "$t5";
        Regs[14] = "$t6";
        Regs[15] = "$t7";
        Regs[16] = "$s0";
        Regs[17] = "$s1";
        Regs[18] = "$s2";
        Regs[19] = "$s3";
        Regs[20] = "$s4";
        Regs[21] = "$s5";
        Regs[22] = "$s6";
        Regs[23] = "$s7";
        Regs[24] = "$t8";
        Regs[25] = "$t9";
        Regs[26] = "$k0";
        Regs[27] = "$k1";
        Regs[28] = "$gp";
        Regs[29] = "$sp";
        Regs[30] = "$fp";
        Regs[31] = "$ra";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(String.format("%.5s %02d Hex 0x%08x  Dec %09d\n",
                    Regs[i],
                    i,
                    RegzVal.get(Regs[i]),
                    RegzVal.get(Regs[i]))
            );
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame.setDefaultLookAndFeelDecorated(true);
        NewJPanel J = new NewJPanel();
        JFrame frame = new JFrame("MIPS Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(J);
        frame.setSize(960, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        String a = "aDd";
        String s = "suB";
        String inst = "add $t1 $t2 $t3";

        // String opcode = "000000"; 
        // String rd = Long.toBinaryString(getIndexValue(lines[1]); 01011 01100 00000 100000
        // String rs = Long.toBinaryString(getIndexValue(lines[2]);
        // String rt = Long.toBinaryString(getIndexValue(lines[3]);
        // String shamt = "00000";
        //String funct = "100000";
        //String i = opcode + rd + rs + rt + shamt +funct
        // Long Inst = Long.parseLong(Long.toHexString(i))
        //String inst = "add 1 2 3";
        //int h = Integer.parseInt("t1") + Integer.parseInt("t2");
        //GetFunct(inst);
//            String opcode = "000000";
//            String rd = Long.toBinaryString(9);
//            String rs = Long.toBinaryString(10);
//            String rt = Long.toBinaryString(12);
//            String shamt = "00000";
//            String funct = "100000";
        long opcode1 = 0;
        long rd1 = identifyReg("$t0");
        long rs1 = identifyReg("$s0");
        long rt1 = identifyReg("$s2");
        long shamt1 = 0;
        long funct1 = 32;
//            String i = opcode + rd + rs + rt + shamt +funct;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%06d%05d%05d%05d%05d%06d",
                Long.parseLong(Long.toBinaryString(opcode1)),
                Long.parseLong(Long.toBinaryString(rd1)),
                Long.parseLong(Long.toBinaryString(rs1)),
                Long.parseLong(Long.toBinaryString(rt1)),
                Long.parseLong(Long.toBinaryString(shamt1)),
                Long.parseLong(Long.toBinaryString(funct1))));
        String tmp = binaryToHex(sb.toString());

        //long Inst = Long.parseLong(Long.toHexString(Long.parseLong(i)));
        //long tst = Long.parseLong(Long.toHexString(Long.parseLong(rd)));
        //System.out.println(Inst);
        //System.out.println(tst);
//            long Inst1 = Long.parseLong(tmp);
//            Long Inst1 = Long.parseLong(tmp);
//            Long yotta = 0xAl;
        System.out.println(parseInst(inst));
        System.out.println(sb.toString());
        System.out.println(tmp);
//            System.out.println(Inst1);
        System.out.println(14 | 3);
        //System.out.println(h);

        SpellCheck(a);
        SpellCheck(s);

    }
}
