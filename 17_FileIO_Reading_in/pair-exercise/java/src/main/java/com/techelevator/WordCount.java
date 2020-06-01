package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	static int wordCount = 0;
	static int sentenceCount = 0;

	public static void main(String[] args) throws FileNotFoundException {

		File inputFile = getInputFileFromUser();
		if (inputFile != null) {
			try (Scanner fileScanner = new Scanner(inputFile)) {
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					
					
						if (line == null || line.isEmpty()) {
							continue;
						} else {
							
							String[] words = line.trim().split("\\s+");
							wordCount += words.length;
						
					}
					for (int i = 0; i < line.length()-1; i++) {
						if (line.substring(i, i + 1).equals(".") || line.substring(i, i + 1).equals("!")
								|| line.substring(i, i + 1).equals("?")) {
							sentenceCount++;
						}
					}
				}

			}
		}

		System.out.println("Word Count is: " + wordCount);
		System.out.println("Sentence Count is: " + sentenceCount);

	}

	public int getWordCount() {
		return wordCount;
	}

	public static int getSentenceCount() {
		return sentenceCount;
	}

	private static File getInputFileFromUser() {
		try (Scanner userInput = new Scanner(System.in)) {

			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();

			File inputFile = new File(path);
			if (inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path + " does not exist");
				inputFile = null;
			} else if (inputFile.isFile() == false) {
				System.out.println(path + " is not a file");
				inputFile = null;
			}

			return inputFile;
		}
	}
}