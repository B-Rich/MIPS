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
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import static tehmipssemyoulatur.TehMipsSemyoulatur.parseInst;

/**
 *
 * @author Threadcount
 */
public class NewJPanel extends javax.swing.JPanel {

    private RegisterFile RF = new RegisterFile();

    public static void Parsefker(JTextArea J1, JTextArea J2, JTable J) {

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
            
            J.setValueAt(0, 0, 1);
            J.setValueAt(0, 1, 1);
            J.setValueAt(0, 2, 1);
            J.setValueAt(0, 3, 1);
            J.setValueAt(0, 4, 1);
            J.setValueAt(0, 5, 1);
            J.setValueAt(0, 6, 1);
            J.setValueAt(0, 7, 1);

            

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

            J.setValueAt(Val.get("RegDst"), 0, 1);
            J.setValueAt(Val.get("Branch"), 1, 1);
            J.setValueAt(Val.get("MemRead"), 2, 1);
            J.setValueAt(Val.get("MemToReg"), 3, 1);
            J.setValueAt(Val.get("MemWrite"), 4, 1);
            J.setValueAt(Val.get("ALU Src"), 5, 1);
            J.setValueAt(Val.get("RegWrite"), 6, 1);
            J.setValueAt(Val.get("Jump"), 7, 1);

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
        J2.setText(sb.toString());
//        J.setValueAt(Val.get("RegDst"), 0, 1);
//        J.setValueAt(Val.get("Branch"), 1, 1);
//        J.setValueAt(Val.get("MemRead"), 2, 1);
//        J.setValueAt(Val.get("MemToReg"), 3, 1);
//        J.setValueAt(Val.get("MemWrite"), 4, 1);
//        J.setValueAt(Val.get("ALU Src"), 5, 1);
//        J.setValueAt(Val.get("RegWrite"), 6, 1);
//        J.setValueAt(Val.get("Jump"), 7, 1);
    }

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
        if (ln[0].equals("add")
                || ln[0].equals("sub")
                || ln[0].equals("mult")
                || ln[0].equals("div")
                || ln[0].equals("and")
                || ln[0].equals("or")
                || ln[0].equals("sll")
                || ln[0].equals("srl")
                || ln[0].equals("slt")
                || ln[0].equals("sltu")
                || ln[0].equals("jr")) {
            long opcode1 = 0;
            long rd1 = identifyReg(ln[1]);
            long rs1 = identifyReg(ln[2]);
            long rt1 = identifyReg(ln[3]);
            long shamt1 = 0;
            long funct1 = Inst.get(ln[0]);
            v = GetFunctData(opcode1, rd1, rs1, rt1, shamt1, funct1);
            return v;
        }

        if (ln[0].equals("addi")
                || ln[0].equals("sub")
                /*|| ln[0].equals("lw") 
                 || ln[0].equals("sw")*/
                || ln[0].equals("andi")
                || ln[0].equals("ori")
                || ln[0].equals("beq")
                || ln[0].equals("bne")
                || ln[0].equals("bltz")
                || ln[0].equals("bgtz")
                || ln[0].equals("slti")
                || ln[0].equals("sltui")
                || ln[0].equals("jr")) {
            long opcode1 = Inst.get(ln[0]);
            long rt1 = identifyReg(ln[1]);
            long rs1 = identifyReg(ln[2]);
            long imm1 = Long.parseLong(ln[3]);
            v = GetFunctData(opcode1, rs1, rt1, imm1);
            return v;
        }

        if (ln[0].equals("jal")
                || ln[0].equals("j")) {
            long opcode1 = Inst.get(ln[0]);
            long addrs1 = Long.parseLong(ln[1]);
            v = GetFunctData(opcode1, addrs1);
            return v;
        }
        return v;
    }

    public static String binaryToHex(String bin) {
        return String.format("0x%08x", Long.parseLong(bin, 2));
    }

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

    public static String[] parseAll(JTextArea J) {
        String[] strng = J.getText().split("\\n");
        String[] vals = new String[strng.length];
        for (int i = 0; i < strng.length; i++) {
            vals[i] = parseInst(strng[i]);
        }
        return vals;
    }

    public static String parseInst(JTextArea J) {
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
        String[] strng = J.getText().split("\\n");
        for (int i = 0; i < strng.length; i++) {
            String[] ln = strng[i].split("\\s+");
            if (ln[0].equals("add")
                    || ln[0].equals("sub")
                    || ln[0].equals("mult")
                    || ln[0].equals("div")
                    || ln[0].equals("and")
                    || ln[0].equals("or")
                    || ln[0].equals("sll")
                    || ln[0].equals("srl")
                    || ln[0].equals("slt")
                    || ln[0].equals("sltu")
                    || ln[0].equals("jr")) {
                long opcode1 = 0;
                long rd1 = identifyReg(ln[1]);
                long rs1 = identifyReg(ln[2]);
                long rt1 = identifyReg(ln[3]);
                long shamt1 = 0;
                long funct1 = Inst.get(ln[0]);
                v = GetFunctData(opcode1, rd1, rs1, rt1, shamt1, funct1);
                return v;
            }

            if (ln[0].equals("addi")
                    || ln[0].equals("sub")
                    /*|| ln[0].equals("lw") 
                     || ln[0].equals("sw")*/
                    || ln[0].equals("andi")
                    || ln[0].equals("ori")
                    || ln[0].equals("beq")
                    || ln[0].equals("bne")
                    || ln[0].equals("bltz")
                    || ln[0].equals("bgtz")
                    || ln[0].equals("slti")
                    || ln[0].equals("sltui")
                    || ln[0].equals("jr")) {
                long opcode1 = Inst.get(ln[0]);
                long rt1 = identifyReg(ln[1]);
                long rs1 = identifyReg(ln[2]);
                long imm1 = Long.parseLong(ln[3]);
                v = GetFunctData(opcode1, rs1, rt1, imm1);
                return v;
            }

            if (ln[0].equals("jal")
                    || ln[0].equals("j")) {
                long opcode1 = Inst.get(ln[0]);
                long addrs1 = Long.parseLong(ln[1]);
                v = GetFunctData(opcode1, addrs1);
                return v;
            }
        }
        return v;
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
                    || lines[i].startsWith("move")
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

    public static boolean zeroHalt(JTextArea J) {
        int valCnt = 0;
        String[] lines = J.getText().toLowerCase().split("\\n");
        for (int i = 0; i < lines.length; i++) {
            String[] ln = lines[i].split("\\s+");
            if (!(ln[1].equalsIgnoreCase("$zero"))) {
                valCnt++;
            }
        }
        if (valCnt == lines.length) {
            return true;
        }
        return false;
    }

    public static void updateVal(RegisterFile RF, JTextArea J) {
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
//            sb.append(String.format("%.5s %02d Hex 0x%02x 0x%02x 0x%02x 0x%02x Dec %09d\n",
//                    Regs[i],
//                    i,
//                    RF.getRegister(RegisterName.valueOf(i)).getValue(),
//                    RF.getRegister(RegisterName.valueOf(i)).getValue(),
//                    RF.getRegister(RegisterName.valueOf(i)).getValue(),
//                    RF.getRegister(RegisterName.valueOf(i)).getValue(),
//                    RF.getRegister(RegisterName.valueOf(i)).getValue())
//        
//        );
            sb.append(String.format("%.5s %02d Hex 0x%08x  Dec %09d\n",
                    Regs[i],
                    i,
                    RF.getRegister(RegisterName.valueOf(i)).getValue(),
                    RF.getRegister(RegisterName.valueOf(i)).getValue())
            );
        }

        J.setText(sb.toString());
    }

//    public static void FixCase(JTextArea J) {
//        String[] lines = J.getText().toLowerCase().split("\\n");
//        try {
//            File file = new File("Test.txt");
//            BufferedWriter output = new BufferedWriter(new FileWriter(file));
//            for (int i = 0; i < lines.length; i++) {
//                output.write(lines[i]);
//            }
//            output.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static String[] FixCase(JTextArea J) {
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
        return lines;
    }

//    public static void UpdateDisp(JTextArea J) {
//        try {
//            String textLine;
//            FileReader fr = new FileReader("Test.txt");
//            BufferedReader reader = new BufferedReader(fr);
//            textLine = reader.readLine();
//            J.read(reader, "J");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    public static void UpdateDisp(JTextArea J, String[] l) {
        try {
            String textLine;
            FileReader fr = new FileReader("Test.txt");
            BufferedReader reader = new BufferedReader(fr);
            textLine = reader.readLine();
            J.read(reader, "J");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l.length; i++) {
                sb.append(String.format("%.20s\n", l[i]));
            }
            J.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"RegDst", "0"},
                {"Branch", "0"},
                {"MemRead", "0"},
                {"MemToReg", "0"},
                {"MemWrite", "0"},
                {"ALU Src", "0"},
                {"RegWrite", "0"},
                {"Jump", "0"}
            },
            new String [] {
                "Control Lines", "OFF / ON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Parse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Parse All");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton2)))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateVal(RF, jTextArea2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UpdateDisp(jTextArea1, FixCase(jTextArea1));
        if (checkInstValidity(jTextArea1) != true) {
            JOptionPane.showMessageDialog(this, "Invalid or Unsupported instruction. Please check the submitted instructions");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (checkInstValidity(jTextArea1) != true) {
            JOptionPane.showMessageDialog(this, "Cannot parse unidentifited instruction ya Beh.");
        }
        if (zeroHalt(jTextArea1) != true) {
            JOptionPane.showMessageDialog(this, "Cannot write in register Zero ya Beh.");
        }
        Parsefker(jTextArea1, jTextArea2, jTable2);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
