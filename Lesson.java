package accuracycontroller;

import java.util.ArrayList;
import java.util.Random;

import java.io.File;

public class Lesson {

	ArrayList<String> sentences = new ArrayList<String>();
	ArrayList<String> translations = new ArrayList<String>();
	ArrayList<String> missedWords = new ArrayList<String>();
	ArrayList<File> fileList = new ArrayList<File>();
	String name = "";
	boolean isSentence;
	int toRemove;
	
	public Lesson(ArrayList<String> sentences, ArrayList<String> translations, ArrayList<String> missedWords, String name, ArrayList<File> fileList)
	{
		this.sentences = sentences;
		this.translations = translations;
		this.missedWords = missedWords;	
		this.name = name;
		this.fileList = fileList;
	}
	
	public Lesson(ArrayList<String> sentences, ArrayList<String> translations, String name, ArrayList<File> fileList)
	{
		this.sentences = sentences;
		this.translations = translations;
		this.name = name;
		this.fileList = fileList;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String pickSentence()
	{
		String sentence = "";
		//creates random integer from size of both arrays
		Random r = new Random();
		
		//if smaller, goes to sentence first then missed words
		int sToChoose = r.nextInt(sentences.size() + missedWords.size());
		if(sToChoose < sentences.size())
		{
			sentence = sentences.get(sToChoose);
			toRemove = sToChoose;
			isSentence = true;
		}
		else
		{
			sentence = missedWords.get(sToChoose - sentences.size());
			toRemove = sToChoose - sentences.size();
			isSentence = false;
		}
		
		return sentence;
	}
		
	public void checkAccuracy(String s, String input)
	{
		AccuracyController a1 = new AccuracyController(sentences, missedWords);
		a1.checkAccuracy(s, input);
	}
	
	public void evaluateWord()
	{
		String sentence = this.pickSentence();
		String input = "";
		String translation = "";
		
		System.out.println("Phrase: " + sentence);
		
		//checks if translation needs to be displayed
		if(isSentence)
		{
			translation = translations.get(toRemove);
			System.out.println("Translation: " + translation);
		}
		
		//checks accuracy, displays result within method
		this.checkAccuracy(sentence, input);	
		
		//removes items
		if(isSentence)
		{
			sentences.remove(toRemove);
			translations.remove(toRemove);
		}
		else
		{
			missedWords.remove(toRemove);
		}
	}
}
