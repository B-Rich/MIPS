/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehmipssemyoulatur.pipeline.stages;

/**
 *
 * @author Threadcount
 */

import tehmipssemyoulatur.MemoryStore;
import tehmipssemyoulatur.ProgramCounter;
import tehmipssemyoulatur.RegisterName;
import tehmipssemyoulatur.pipeline.PipelineRegister;
import tehmipssemyoulatur.pipeline.PipelineStage;

public class Fetch extends PipelineStage {
	private static final int HALT_INSTRUCTION = 0xFC000000; 
	
	private final PipelineRegister if_id;
	private final MemoryStore memory;
	private final ProgramCounter pc;
	
	public Fetch(
		PipelineRegister if_id, 
		MemoryStore memory, 
		ProgramCounter pc
	) {
		this.if_id = if_id;
		this.memory = memory;
		this.pc = pc;
	}
	
	@Override
	public void run() {
//		long instruction = memory.getValue(pc.getValue());
                long instruction = 0x20080001l;
		//System.out.println(Integer.toHexString(instruction));
		if_id.setValue(RegisterName.INSTRUCTION, instruction);
		if_id.setValue(RegisterName.OP_CODE, 0);
		if_id.setValue(RegisterName.PC, 0);
		
		if (instruction != HALT_INSTRUCTION) {
			pc.increment();
		}
	}

}
