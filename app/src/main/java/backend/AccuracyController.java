package backend;

import java.util.ArrayList;
import java.util.Random;

public class AccuracyController {
	
	ArrayList<String> sentences = new ArrayList<String>();
	ArrayList<String> missedWords = new ArrayList<String>();
	
	AccuracyController(ArrayList<String> sentences, ArrayList<String> missedWords) 
	{
		this.sentences = sentences;
		this.missedWords = missedWords;
	}

	public ArrayList<String> getMissedWords() {
	return this.missedWords; }

	
	public Result checkAccuracy(String s, String input)
	{

		String sentence = s.toLowerCase();
		String speech = input.toLowerCase(); //text input from speech-to-text
		
		//sentences to be updated without non-letters
		String sentence2 = sentence;
		String speech2 = speech;
		
		
		//checks for non-letter characters in normal sentence
		sentence2 = sentence2.replace(".", "");
		sentence2 = sentence2.replace("!", "");
		sentence2 = sentence2.replace("?", "");
		sentence2 = sentence2.replace(",", "");
		sentence2 = sentence2.replace("¿", "");
		sentence2 = sentence2.replace("¡", "");
		
		//checks for non-letter characters in normal sentence
		speech2 = speech2.replace(".", "");
		speech2 = speech2.replace("!", "");
		speech2 = speech2.replace("?", "");
		speech2 = speech2.replace(",", "");
		speech2 = speech2.replace("¿", "");
		speech2 = speech2.replace("¡", "");



		//splits updated lists into individual words.
		String[] correctWords = sentence2.split(" ");
		String[] userWords = speech2.split(" ");
		
		/*
		for(int j = 0; j < correctWords.length; j++)
		{
			System.out.println(correctWords[j]);
		}
		for(int k = 0; k < userWords.length; k++)
		{
			System.out.println(userWords[k]);
		}
		*/
		
		
		//creates true-false array for sentence words.
		ArrayList<Boolean> isCorrect = new ArrayList<Boolean>();
		for(int f = 0; f < correctWords.length; f++)
		{
			isCorrect.add(false);
		}
		
		//sets to true if any interpreted words match
		for(int j = 0; j < correctWords.length; j++)
		{
			for(int k = 0; k < userWords.length; k++)
			{
				if(correctWords[j].equals(userWords[k]) && isCorrect.get(j) == false)
				{
					isCorrect.set(j, true);
				}
			}
		}
		
		//puts words into correct and incorrect categories
		ArrayList<String> trueWords = new ArrayList<String>();
		ArrayList<String> falseWords = new ArrayList<String>();
		
		for(int i = 0; i < isCorrect.size(); i++)
		{
			if(isCorrect.get(i))
			{
				trueWords.add(correctWords[i]);
			}
			else
			{
				
				falseWords.add(correctWords[i]);

				//adds to missedWords to be recalled later
				missedWords.add(correctWords[i]);
			}
		}
		
		System.out.println("Score: " + trueWords.size() + "/" + correctWords.length);
		System.out.println("You missed " + falseWords.size() + " words:");
		for(int w = 0; w < falseWords.size(); w++)
		{
			System.out.println(falseWords.get(w));
		}

		int numberCorrect = trueWords.size();
		int numberTotalWords = correctWords.length;
		return new Result(numberCorrect, numberTotalWords);
		
	}
	
}
