package pronounce.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LessonSelector extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonselector);
    }
    public void button1Action(View v) {
        Intent changeToLesson = new Intent (this, LessonActivity.class);
        startActivity(changeToLesson);
    }
    public void returnHomeAction(View v) {
        Intent returnHome = new Intent(this, MainActivity.class
        );
        startActivity(returnHome);
    }
}
