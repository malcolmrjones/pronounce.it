package accuracycontroller;

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
	
	public void checkAccuracy(String s, String input)
	{
		String sentence = s.toLowerCase();
		String speech = input.toLowerCase(); //text input from speech-to-text
		
		//sentences to be updated without non-letters
		String sentence2 = s;
		String speech2 = speech;
		
		
		//checks for non-letter characters in normal sentence
		for(int i = 0; i < sentence.length(); i++)
		{
			if(sentence.charAt(i) == '.')
			{
				sentence2 = sentence.replace(".", "");
			}
			if(sentence.charAt(i) == '!')
			{
				sentence2 = sentence.replace("!", "");
			}
			if(sentence.charAt(i) == '?')
			{
				sentence2 = sentence.replace("?", "");
			}
			if(sentence.charAt(i) == ',')
			{
				sentence2 = sentence.replace(",", "");
			}
			if(sentence.charAt(i) == '¿')
			{
				sentence2 = sentence.replace("¿", "");
			}
			if(sentence.charAt(i) == '¡')
			{
				sentence2 = sentence.replace("¡", "");
			}
		}
		
		//checks for non-letter characters in normal sentence
			for(int i = 0; i < speech.length(); i++)
			{
				if(speech.charAt(i) == '.')
				{
					speech2 = speech.replace(".", "");
				}
				if(speech.charAt(i) == '!')
				{
					speech2 = speech.replace("!", "");
				}
				if(speech.charAt(i) == '?')
				{
					speech2 = speech.replace("?", "");
				}
				if(speech.charAt(i) == ',')
				{
					speech2 = speech.replace(",", "");
				}
				if(speech.charAt(i) == '¿')
				{
					speech2 = speech.replace("¿", "");
				}
				if(speech.charAt(i) == '¡')
				{
					speech2 = speech.replace("¡", "");
				}
			}
		
		
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
		
	}
	
}
