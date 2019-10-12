package accuracycontroller;

import java.util.ArrayList;
import java.util.Arrays;

public class LessonListES implements LessonList {

	ArrayList<String> ES_sent1 = new ArrayList<String>(Arrays.asList(
			"Ella come.", "Él bebe.", "Ella bebe.","Él come.", "Yo corro.", "Él corre.", "Nosotros comemos.", "Nosotros corremos."));
	ArrayList<String> ES_trans1 = new ArrayList<String>(Arrays.asList(
			"She eats.", "He drinks.", "She drinks.","He eats.", "I run.", "He runs.", "We eat.", "We run."));
	
	Lesson ES1 = new Lesson(ES_sent1, ES_trans1, "ES1");
	
	ArrayList<String> ES_sent2 = new ArrayList<String>(Arrays.asList(
			"¡Hola!", "¿Cómo estás?", "Estoy bien.", "Gracias.", "De nada."));
	ArrayList<String> ES_trans2 = new ArrayList<String>(Arrays.asList(
			"Hello!", "How are you?", "I'm well.","Thanks.", "You're welcome."));
	
	Lesson ES2 = new Lesson(ES_sent2, ES_trans2, "ES2");
		
	ArrayList<Lesson> ESList = new ArrayList<Lesson>(Arrays.asList(ES1, ES2));
	

	public Lesson getLesson(String s)
	{
		return getLesson(s, ESList);
	};
}
