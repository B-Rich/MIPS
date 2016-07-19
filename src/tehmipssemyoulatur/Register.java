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
public class Register {
	private long value = 0;
	private boolean disableWrite = false;
	public long newValue = -1;
	
	public Register() {
		this(0);
	}
	
	public Register(long value) {
		this.value = value;
	}
	
	public long getValue() {
		return value;
	}
	
	public void setValue(long newValue) {
		this.newValue = newValue;
	}
	
	public void disableWrite() {
		this.disableWrite = true;
	}
	
	public void enableWrite() {
		this.disableWrite = false;
	}
	
	public void tick() {
		if (!disableWrite) {
			if (newValue != -1) {
				value = newValue;
				newValue = -1;
			}
		} else {
			disableWrite = false;
		}
	}
}

