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
import java.util.HashMap;


public class RegisterFile {
	 
	protected HashMap<RegisterName, Register> registers = 
		new HashMap<RegisterName, Register>();
	private boolean disableWrite = false;

	public void setValue(RegisterName registerName, long value) {
		Register register = getRegister(registerName);
		register.setValue(value);
	}
	
	public long getValue(RegisterName registerName) {
		return getRegister(registerName).getValue();
	}
	
	public void disableWrite() {
		disableWrite = true;
	}
	
	public void tick() {
		if (!disableWrite) {
			for (Register register : registers.values()) {
				register.tick();
			}
		} else {
			disableWrite = false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 32; i++) {
                    if(i == 0){
                        builder.append("$zero");
                    }if(i == 1){
                        builder.append("$at");
                    }if((i == 2) || (i == 3)){
                        builder.append("$v");
                        builder.append(i%2);
                    }if((i > 3) && (i < 8)){
                        builder.append("$a");
                        builder.append(i%4);
                    }if((i > 7) && (i < 16)){
                        builder.append("$t");
                        builder.append(i%8);
                    }if((i > 15) && (i < 24)){
                        builder.append("$s");
                        builder.append(i%16);
                    }if(i == 24){
                        builder.append("$t8");
                    }if(i == 25){
                        builder.append("$t9");
                    }if(i == 24){
                        builder.append("$t8");
                    }if((i == 26) || (i == 27)){
                        builder.append("$k");
                        builder.append(i%26);
                    }if(i == 28){
                        builder.append("$gp");
                    }if(i == 29){
                        builder.append("$sp");
                    }if(i == 30){
                        builder.append("$fa");
                    }if(i == 31){
                        builder.append("$ra");
                    }
			builder.append('\t');
			builder.append(Long.toHexString(getRegister(RegisterName.valueOf(i)).getValue()));
                        //builder.append(Long.toBinaryString(getRegister(RegisterName.valueOf(i)).getValue()));
			builder.append('\n');
		}
		
		return builder.toString();
	}
	
	protected boolean validRegister(RegisterName registerName) {
		return registerName.isPrimitive();
	}
	
	public Register getRegister(RegisterName registerName) {
		if (!validRegister(registerName)) {
			throw new IllegalArgumentException(
				"Invalid register: " + registerName.name()
			);
		}
		Register register = registers.get(registerName);
		
		if (register == null) {
			register = new Register();
			registers.put(registerName, register);
		}
		
		return register;
	}
}
