package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
		Scanner Input = new Scanner(System.in); 
		File tempFile = new File("AliceReplacedWord.txt");
		
	
		
		System.out.println("Enter the path of a file or directory >>> ");
		String path = Input.nextLine();
		File aliceBook = new File(path);
		
		System.out.println("What word would you like to find?");
		String wordUser = Input.nextLine();
		
		System.out.println("What would you like to replace it with?");
		String replaceWordUser = Input.nextLine();
		
		try (
			Scanner sc = new Scanner(aliceBook);
			PrintWriter writer = new PrintWriter(tempFile);
			) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.contains(wordUser)) {
				line = line.replace(wordUser, replaceWordUser);
			}
			writer.println(line);
		}	
		writer.close();
		} catch(FileNotFoundException e) {
			System.out.println("Your file does not exist.");
			System.exit(1);
		}
		try {FileOutputStream fos = new FileOutputStream(tempFile, true); 
  
         fos.write(replaceWordUser.getBytes());    
         fos.close();    
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}