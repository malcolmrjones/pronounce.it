package pronounce.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import backend.LessonListES;

public class LessonSelector extends AppCompatActivity {

    private LessonListES lessonlist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonselector);

        lessonlist = new LessonListES();
    }
    public void button1Action(View v) {
        Intent changeToLesson = new Intent (this, LessonActivity.class);
        changeToLesson.putExtra("Lesson", lessonlist.getLesson("ES1"));
        startActivity(changeToLesson);
    }
    public void button2Action(View v) {
        Intent changeToLesson = new Intent (this, LessonActivity.class);
        changeToLesson.putExtra("Lesson", lessonlist.getLesson("ES2"));
        startActivity(changeToLesson);
    }
    public void button3Action(View v) {
        Intent changeToLesson = new Intent (this, LessonActivity.class);
        changeToLesson.putExtra("Lesson", lessonlist.getLesson("ES3"));
        startActivity(changeToLesson);
    }
    public void button4Action(View v) {
        Intent changeToLesson = new Intent (this, LessonActivity.class);
        changeToLesson.putExtra("Lesson", lessonlist.getLesson("ES4"));
        startActivity(changeToLesson);
    }
    public void returnHomeAction(View v) {
        Intent returnHome = new Intent(this, MainActivity.class
        );
        startActivity(returnHome);
    }
}
