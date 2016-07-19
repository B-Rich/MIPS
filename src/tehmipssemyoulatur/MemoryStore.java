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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MemoryStore {

	private ArrayList<Long> memory = new ArrayList<Long>();
	
	public MemoryStore(String filename) throws IOException {
		// create a new input stream
		FileInputStream input = new FileInputStream(filename);
		
		// create a place to store the words we read in
		byte[] b = new byte[4];
		
		// read in the data in the given file
		while (input.read(b) != -1) {
			if (memory.size() == 1027) {
				int foo = 1;
			}
			// create a word from the 4 bytes
			long word = getUnsignedValue(b[0]); //11111 ---  00111111 11111111 10101010
			word += getUnsignedValue(b[1]) << 8;
			word += getUnsignedValue(b[2]) << 16;
			word += getUnsignedValue(b[3]) << 24;
			
			// add the word to our memory store
			memory.add(word);
		}
	}
	

	public long getValue(long location) {
		// we want to access the memory on a word boundary
		long memoryAddress = location >> 2;
		
		// error if we're out of bounds
		if (memoryAddress >= memory.size()) {
			throw new IllegalArgumentException("Memory address out of bounds");
		}
//                if (memoryAddress >= 69500) {
//			throw new IllegalArgumentException("Memory address out of bounds");
//		}
		

		return memory.get((int)memoryAddress);
	}
	


	public void storeValue(long location, long value) {
		// get the word address from the byte address
		long memoryAddress = location >> 2;
		
		// error if we're out of bounds
		if (memoryAddress >= memory.size()) {
			throw new IllegalArgumentException("Memory address out of bounds");
		}
		
		memory.set((int)memoryAddress, value);
	}
	
	public long getUnsignedValue(byte b) {
		if (b >= 0) { return b; }
		
		return 256 + b; //256 - 1 (0 - 255)
	}
}
