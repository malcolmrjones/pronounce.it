package pronounce.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import backend.Lesson;
import backend.LessonListES;

public class LessonActivity2 extends AppCompatActivity {

    private LessonListES currentList;
    private Lesson currentLesson;
    private String currentSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Button button_exit = (Button)findViewById(R.id.button_exit);
        Button button_listen = (Button)findViewById(R.id.button_listen);
        Button button_record = (Button)findViewById(R.id.button_record);

        currentList = new LessonListES();
        if (getIntent().getSerializableExtra("Lesson") == null)
        currentLesson = currentList.getLesson("ES2");
        else {
            currentLesson = (Lesson)getIntent().getSerializableExtra("Lesson");
        }

        currentLesson.pickSentence();
        currentSentence = currentLesson.getSentence();

        button_record.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("Recording audio...");
                final MediaRecorder recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                recorder.setAudioEncodingBitRate(128000);
                recorder.setAudioSamplingRate(44100);
                System.out.println(Environment.getExternalStorageDirectory().getAbsolutePath());
                File yourFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/aud.mp4");
                try {
                    yourFile.createNewFile();
                    recorder.setOutputFile(yourFile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    recorder.prepare();
                    recorder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Button button_stop = (Button)findViewById(R.id.button_stop);
                button_stop.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        recorder.stop();
                        recorder.reset();
                        recorder.release();
                        System.out.println("Recording stopped...");
                    }
                });
            }
        });


    }
    public void onClickExit (View v) {
        Intent exitToLessonPage = new Intent(this, LessonSelector.class);
        startActivity(exitToLessonPage);
        // System.out.println("Exit lesson...");
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
        startActivity(submitForResults);
    }
}
