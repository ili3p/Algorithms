package my.utility;

import java.io.IOException;

/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

public class SystemIn implements Runnable {
	static String ReadLn(int maxLength) { // utility function to read from stdin
		
		// Provided by Programming-challenges, edit for style only
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) {// Read until max length
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break; // or until end of line in input
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null; // EOF
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String args[]) // entry point from OS
	{
		SystemIn myWork = new SystemIn(); // Construct the boot loader
		myWork.run(); // execute
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	public void run() {
		// Your program here
	}

	// You can insert more classes here if you want.
}