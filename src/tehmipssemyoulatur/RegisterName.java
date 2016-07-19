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
public enum RegisterName {
	$zero, // Register Zero ($zero)
	$at, // Assembler temp ($at)
	$v0, // Function return ($v0)
	$v1, // Function return ($v1)
	$a0, // Function argument ($a0)
	$a1, // Function argument ($a1)
	$a2, // Function argument ($a2)
	$a3, // Function argument ($a3)
	$t0, // Temporary value ($t0)
	$t1, // Temporary value ($t1)
	$t2, // Temporary value ($t2)
	$t3, // Temporary value ($t3)
	$t4, // Temporary value ($t4)
	$t5, // Temporary value ($t5)
	$t6, // Temporary value ($t6)
	$t7, // Temporary value ($t7)
	$s0, // Saved temporary ($s0)
	$s1, // Saved temporary ($s1)
	$s2, // Saved temporary ($s2)
	$s3, // Saved temporary ($s3)
	$s4, // Saved temporary ($s4)
	$s5, // Saved temporary ($s5)
	$s6, // Saved temporary ($s6)
	$s7, // Saved temporary ($s7)
	$t8, // Temporary value ($t8)
	$t9, // Temporary value ($t9)
	$k0, // Reserved for OS ($k0)
	$k1, // Reserved for OS ($k1)
	$gp, // Global pointer ($gp)
	$sp, // Stack pointer ($sp)
	$fp, // Frame pointer ($fp) 
	$ra, // Return address ($ra)
	INSTRUCTION(false),
	R_S(false),
	R_T(false),
	R_D(false),
	IMMEDIATE(false),
	SHAMT(false),
	ADDRESS(false), 
	REG_DST(false), // Control signal for R_T and R_D
	ALU_SRC(false), // ALU input from SIGN_EXTENDER or READ_DATA_2
	MEM_TO_REG(false), // Control signal for taking data from ALU_RESULT or READ_DATA
	REG_WRITE(false), //Control signal for writing in registers
	MEM_READ(false), //Control signal for reading from Data Memory
	MEM_WRITE(false), //Control signal for writing from Data Memory
	BRANCH(false),
	BRANCH_NE(false),
	ALU_OP(false),
	JUMP(false),
	JUMP_SRC(false),
	READ_DATA_1(false),
	READ_DATA_2(false),
	ALU_RESULT(false),
	MEM_RESULT(false),
	WRITE_DATA(false),
	HALT(false),
	OP_CODE(false),
	PC(false); //Program counter
	
	private final boolean isPrimitive;
	
	private RegisterName() {
		this(true);
	}
	
	//Not a control line
        private RegisterName(boolean isPrimitive) {
		this.isPrimitive = isPrimitive;
	}
	
	
        public boolean isPrimitive() {
		return isPrimitive;
	}
	
	public static RegisterName valueOf(long ordinal) {
		for (RegisterName name : RegisterName.values()) {
			if (name.ordinal() == ordinal) {
				return name;
			}
		}
		
		return null;
	}
}

