package accuracycontroller;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;

public class LessonListES implements LessonList {

	//all audio files for spanish
	File aud1 = new File("Recording (1).wav");
	File aud2 = new File("Recording (2).wav");
	File aud3 = new File("Recording (3).wav");
	File aud4 = new File("Recording (4).wav");
	File aud5 = new File("Recording (5).wav");
	File aud6 = new File("Recording (6).wav");
	File aud7 = new File("Recording (7).wav");
	File aud8 = new File("Recording (8).wav");
	File aud9 = new File("Recording (9).wav");
	File aud10 = new File("Recording (10).wav");
	File aud11 = new File("Recording (11).wav");
	File aud12 = new File("Recording (12).wav");
	File aud13 = new File("Recording (13).wav");
	
	ArrayList<String> ES_sent1 = new ArrayList<String>(Arrays.asList(
			"Ella come.", "Él bebe.", "Ella bebe.","Él come.", "Yo corro.", "Él corre.", "Nosotros comemos.", "Nosotros corremos."));
	ArrayList<String> ES_trans1 = new ArrayList<String>(Arrays.asList(
			"She eats.", "He drinks.", "She drinks.","He eats.", "I run.", "He runs.", "We eat.", "We run."));
	ArrayList<File> ES_audio1 = new ArrayList<File>(Arrays.asList(aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8));
	
	Lesson ES1 = new Lesson(ES_sent1, ES_trans1, "ES1", ES_audio1);
	
	ArrayList<String> ES_sent2 = new ArrayList<String>(Arrays.asList(
			"¡Hola!", "¿Cómo estás?", "Estoy bien.", "Gracias.", "De nada."));
	ArrayList<String> ES_trans2 = new ArrayList<String>(Arrays.asList(
			"Hello!", "How are you?", "I'm well.","Thanks.", "You're welcome."));
	ArrayList<File> ES_audio2 = new ArrayList<File>(Arrays.asList(aud9, aud10, aud11, aud12, aud13));
	
	Lesson ES2 = new Lesson(ES_sent2, ES_trans2, "ES2", ES_audio2);
		
	ArrayList<Lesson> ESList = new ArrayList<Lesson>(Arrays.asList(ES1, ES2));
	

	public Lesson getLesson(String s)
	{
		return getLesson(s, ESList);
	};
}
