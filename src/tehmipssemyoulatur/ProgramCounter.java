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
public class ProgramCounter extends Register {
	private static final int FIRST_INSTRUCTION = 0x1000; //4096
//    private static final int FIRST_INSTRUCTION = 0x00000000;
	

	public ProgramCounter() {
		super(FIRST_INSTRUCTION);
	}
	

	public void increment() {
		newValue = getValue() + 4;
	}
}
