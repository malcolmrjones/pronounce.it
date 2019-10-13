package backend;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;

public class LessonListES implements LessonList {

	//all audio files for spanish
	File aud1 = new File("recording.wav");
	File aud2 = new File("recording_2.wav");
	File aud3 = new File("recording_3.wav");
	File aud4 = new File("recording_4.wav");
	File aud5 = new File("recording_5.wav");
	File aud6 = new File("recording_6.wav");
	File aud7 = new File("recording_7.wav");
	File aud8 = new File("recording_8.wav");
	File aud9 = new File("recording_9.wav");
	File aud10 = new File("recording_10.wav");
	File aud11 = new File("recording_11.wav");
	File aud12 = new File("recording_12.wav");
	File aud13 = new File("recording_13.wav");
	File aud14 = new File("recording_14.wav");
	File aud15 = new File("recording_15.wav");
	File aud16 = new File("recording_16.wav");
	File aud17 = new File("recording_17.wav");
	File aud18 = new File("recording_18.wav");
	File aud19 = new File("recording_19.wav");
	File aud20 = new File("recording_20.wav");
	File aud21 = new File("recording_21.wav");
	File aud22 = new File("recording_22.wav");
	File aud23 = new File("recording_23.wav");
	File aud24 = new File("recording_24.wav");
	File aud25 = new File("recording_25.wav");
	
	ArrayList<String> ES_sent1 = new ArrayList<String>(Arrays.asList(
			"Ella come.", "El bebé.", "Ella bebé.","El come.", "Yo corro.", "El corre.", "Nosotros comemos.", "Nosotros corremos."));
	ArrayList<String> ES_trans1 = new ArrayList<String>(Arrays.asList(
			"She eats.", "He drinks.", "She drinks.","He eats.", "I run.", "He runs.", "We eat.", "We run."));
	ArrayList<File> ES_audio1 = new ArrayList<File>(Arrays.asList(aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8));
	
	Lesson ES1 = new Lesson(ES_sent1, ES_trans1, "ES1", ES_audio1);
	
	ArrayList<String> ES_sent2 = new ArrayList<String>(Arrays.asList(
			"Hola!", "Como estas?", "Estoy bien.", "Gracias.", "De nada."));
	ArrayList<String> ES_trans2 = new ArrayList<String>(Arrays.asList(
			"Hello!", "How are you?", "I'm well.","Thanks.", "You're welcome."));
	ArrayList<File> ES_audio2 = new ArrayList<File>(Arrays.asList(aud9, aud10, aud11, aud12, aud13));
	
	Lesson ES2 = new Lesson(ES_sent2, ES_trans2, "ES2", ES_audio2);
	
	ArrayList<String> ES_sent3 = new ArrayList<String>(Arrays.asList(
			"Yo bebo el cafe.", "Tu quieres te.", "Ellos quieren un cafe.", "El cafe es negro.", "La leche es blanca.", "La leche y el cafe"));
	ArrayList<String> ES_trans3 = new ArrayList<String>(Arrays.asList(
			"I drink coffee.", "You want the tea.", "They want a coffee.","The coffee is black.", "The milk is white.", "The milk and the coffee"));
	ArrayList<File> ES_audio3 = new ArrayList<File>(Arrays.asList(aud14, aud15, aud16, aud17, aud18, aud19));
	
	Lesson ES3 = new Lesson(ES_sent3, ES_trans3, "ES3", ES_audio3);
		
	
	ArrayList<String> ES_sent4 = new ArrayList<String>(Arrays.asList(
			"Yo estoy en la biblioteca.", "Quiero leer un libro.", "Quien eres?", "Yo no tengo una botella de leche.", "El tiene tres libros.", "Ellos leen mucho."));
	ArrayList<String> ES_trans4 = new ArrayList<String>(Arrays.asList(
			"I am in the library.", "I want to read a book.", "Who are you?","I do not have a bottle of milk.", "He has three books.", "They read a lot."));
	ArrayList<File> ES_audio4 = new ArrayList<File>(Arrays.asList(aud20, aud21, aud22, aud23, aud24, aud25));
	
	Lesson ES4 = new Lesson(ES_sent4, ES_trans4, "ES4", ES_audio4);
		
	
	ArrayList<Lesson> ESList = new ArrayList<Lesson>(Arrays.asList(ES1, ES2, ES3, ES4));
	

	public Lesson getLesson(String s)
	{
		return getLesson(s, ESList);
	};
}
