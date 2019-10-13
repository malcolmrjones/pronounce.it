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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        labelScore = (TextView) findViewById(R.id.label_score);

        currentLesson = (Lesson)getIntent().getSerializableExtra("Lesson");
        result = currentLesson.checkAccuracy(currentLesson.getSentence(), "");
        labelScore.setText( result.getNumberIncorrect() + "/" + result.getNumberTotalWords());
        currentLesson.evaluateWord(currentLesson.getSentence());

    }

    public void onClickNext(View v) {
        Intent nextPhrase = new Intent(this, LessonActivity.class);
        nextPhrase.putExtra("Lesson", currentLesson);
        startActivity(nextPhrase);
    }
}
