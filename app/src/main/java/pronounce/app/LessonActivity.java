package pronounce.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.view.*;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import backend.Lesson;
import backend.LessonListES;

public class LessonActivity extends AppCompatActivity {

    private Lesson currentLesson;
    private String currentSentence;
    private String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        userInput = "";

        TextView title = (TextView)findViewById(R.id.textView2);
        Button button_exit = (Button)findViewById(R.id.button_exit);
        Button button_listen = (Button)findViewById(R.id.button_listen);
        Button button_record = (Button)findViewById(R.id.button_record);


        currentLesson = (Lesson)getIntent().getSerializableExtra("Lesson");

        title.setText("Lesson " + currentLesson.getName().substring(currentLesson.getName().length()-1));

        currentLesson.pickSentence();
        currentSentence = currentLesson.getSentence();

    }

    public void onClickExit (View v) {
        Intent exitToLessonPage = new Intent(this, LessonSelector.class);
        startActivity(exitToLessonPage);
        // System.out.println("Exit lesson...");
    }

    public void onClickRecord(View v) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-ES");

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        }
        else {
            System.out.println("This Device Does Not Support Speech to Text");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 10:
                if(resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result =  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    System.out.println("RESULTS: " + result.get(0));
                    userInput = result.get(0);
                }
                break;
        }
    }

    public void onClickPlay(View v) {

        TextView labelword = (TextView)findViewById(R.id.label_word);

        if(currentLesson.getIsSentence()) {
            labelword.setText("");
            String filename = currentLesson.getCurrentFile().getName();
            filename = filename.substring(0, filename.length() - 4);
            System.out.println(filename);
            MediaPlayer mp = MediaPlayer.create(this, getResources().getIdentifier(filename, "raw", getPackageName()));
            mp.start();
            System.out.println("Listen to audio...");
        }
        else
        {
            String word = currentLesson.getSentence();
            labelword.setText(word);

        }
    }

    public void onClickSubmit(View v) {
        Intent submitForResults = new Intent(this, ResultsActivity.class);
        submitForResults.putExtra("Lesson", currentLesson);
        submitForResults.putExtra("User Input", userInput);
        startActivity(submitForResults);
    }
}

