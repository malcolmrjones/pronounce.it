package pronounce.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.*;
import android.view.View.*;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Button button_exit = (Button)findViewById(R.id.button_exit);
        Button button_listen = (Button)findViewById(R.id.button_listen);
        Button button_record = (Button)findViewById(R.id.button_record);


        button_listen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("Listen to audio...");
            }
        });

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


}
