package tamar.schetsplus.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Input {
	
	Input(String filename) {
		try {
			readFile(new BufferedReader(new FileReader(filename)));
		} catch (Exception e) {
		}
	}
	

	private void readFile(BufferedReader lines) throws Exception {
		String line;
		
		while ((line = lines.readLine()) != null) {
			Scanner sc = new Scanner(line);
			if (sc.hasNext()) {
				String command = sc.next();
				if (command.equals("R")) {

				}
			}
		}
	}
	
}
