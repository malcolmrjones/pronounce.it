package pronounce.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import backend.Lesson;
import backend.Result;

public class ResultsActivity extends AppCompatActivity {

    Result result;
    Lesson currentLesson;
    TextView labelScore;
    TextView labelSentence;
    TextView labelTranslationText;
    TextView labelUserInputText;
    TextView labelTranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        labelScore = (TextView) findViewById(R.id.label_score);
        labelSentence = (TextView) findViewById(R.id.label_sentence);
        labelUserInputText = (TextView) findViewById(R.id.label_userinputtext);
        labelTranslationText = (TextView) findViewById(R.id.label_translationtext);
        labelTranslation = (TextView) findViewById(R.id.label_translation);

        currentLesson = (Lesson)getIntent().getSerializableExtra("Lesson");
        result = currentLesson.checkAccuracy(currentLesson.getSentence(), getIntent().getStringExtra("User Input"));
        labelScore.setText( result.getNumberIncorrect() + "/" + result.getNumberTotalWords());
        currentLesson.evaluateWord(currentLesson.getSentence());
        labelSentence.setText(currentLesson.getSentence());

        labelUserInputText.setText(getIntent().getStringExtra("User Input"));

        System.out.println("TRANSLATION: " + currentLesson.getTranslation());

        if(currentLesson.getIsSentence() == false) labelTranslation.setVisibility(View.INVISIBLE);
        labelTranslationText.setText(currentLesson.getTranslation());
    }

    public void onClickNext(View v) {
        Intent nextPhrase = new Intent(this, LessonActivity.class);
        nextPhrase.putExtra("Lesson", currentLesson);
        startActivity(nextPhrase);
    }
}
