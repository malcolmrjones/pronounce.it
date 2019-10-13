package backend;

import java.util.ArrayList;

public interface LessonList {
	public default Lesson getLesson(String s, ArrayList<Lesson> list)
	{
        for (int i = 0; i < list.size(); i++)
        {
        	if(s.equals(list.get(i).getName()))
        	{
        		return list.get(i);
        	}
        }  
	return null;
	}
}
