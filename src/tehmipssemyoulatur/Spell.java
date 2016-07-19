/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehmipssemyoulatur;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextArea;

/**
 *
 * @author Threadcount
 */
public class Spell {

    /*public void SpellCheck(JTextArea J) throws IOException {
        StringReader sr = new StringReader(J.getText());
        BufferedReader br = new BufferedReader(sr);
        String nextLine = "";
        while ((nextLine = br.readLine()) != null) {
            /* put your code to process the line here. */
//    public void SpellCheck(JTextArea J) {
//        String[] lines = J.getText().toLowerCase().split("\\n"); 
//
//    }
//    
//    public static void SpellCheck(String S) {
//        String lines = S.toLowerCase();
//        //ArrayList<StringBuilder> sb;
//        //StringBuilder sb = new StringBuilder(S);
//        
//        }
    
RegzVal.put("$ra", 0l);
        
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
            J.read(reader, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }
        


