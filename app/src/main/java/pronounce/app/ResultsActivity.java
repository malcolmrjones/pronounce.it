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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        labelScore = (TextView) findViewById(R.id.label_score);
        labelSentence = (TextView) findViewById(R.id.label_sentence);
        labelSentence = (TextView) findViewById(R.id.label_translationtext);

        currentLesson = (Lesson)getIntent().getSerializableExtra("Lesson");
        result = currentLesson.checkAccuracy(currentLesson.getSentence(), "");
        labelScore.setText( result.getNumberIncorrect() + "/" + result.getNumberTotalWords());
        currentLesson.evaluateWord(currentLesson.getSentence());

        labelSentence.setText(currentLesson.getSentence());
        labelTranslationText.setText(currentLesson.get);

    }

    public void onClickNext(View v) {
        Intent nextPhrase = new Intent(this, LessonActivity.class);
        nextPhrase.putExtra("Lesson", currentLesson);
        startActivity(nextPhrase);
    }
}
