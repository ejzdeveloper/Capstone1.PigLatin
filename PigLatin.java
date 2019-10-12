//Author: Jackie Zablah. Java Bootcamp 2019.

package capstone1;

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userChoice = "";
		String userInput = "";
		String[] words;
		String pigLatinWord = "";
		String output = "";

		System.out.println(">>Welcome to the Pig Latin Translator!");

		do {
			System.out.println(">>Enter a line to be translated: <<");
			userInput = scnr.nextLine();

			// Check that the user has actually entered text before translating.
			while (userInput.isEmpty()) {
				System.out.println(">>Oops!! Type at least one word, Try again!!: <<");
				userInput = scnr.nextLine();
			}
			words = userInput.split(" ");
			for (int i = 0; i < words.length; i++) {
				pigLatinWord = translateWord(words[i]); // Translates each word individually
				output += pigLatinWord + " "; // Joins the translated word back into the output
			}

			System.out.println(">>Original Word(s): " + userInput);
			System.out.println(">>Translation: " + output + "\n");

			System.out.print(">> Would you like to translate another sentence? (y/n)?<<");
			userChoice = scnr.next();

			if (userChoice.equalsIgnoreCase("n")) {
				System.out.println(">> Thank you! Goodbye!");
			}

			pigLatinWord = "";
			output = "";
			scnr.nextLine();
		} while (userChoice.equalsIgnoreCase("y"));
		scnr.close();
	}

	static String translateWord(String original) {
		String word = original;
		int pos = -1; // Position of first vowel
		char ch;
		// Don't translates words that have numbers or special symbols.
		// verify is the word has only letters and translate words with contractiosns.
		for (int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || ch == 39)) {
				return word;
			}
		}
		int j = 0;
		while (j < word.length()) {
			ch = word.charAt(j);
			// find the index of the first vowel in the word
			if (isVowel(ch)) {
				pos = j;
				break;
			}
			j++;
		}
		if (pos == 0) {
			// Translating word if the first character is a vowel.
			return word + "way"; // Adding "way" to the end of string
		} else {
			// Translating word if the first character(s) are consonants.
			String a = word.substring(pos); // Extracting all characters in the word beginning from the 1st vowel
			String b = word.substring(0, pos); // Extracting all characters located before the first vowel
			return a + b + "ay"; // Adding "ay" at the end of the extracted words after joining them.
		}
	}

	public static boolean isVowel(char ch) {
		if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'A') || (ch == 'E')
				|| (ch == 'I') || (ch == 'O') || (ch == 'U')) {
			return true;
		}
		return false;
	}

}
