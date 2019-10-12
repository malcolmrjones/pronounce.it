package pronounce.app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaRecorder;
import android.os.Bundle;
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

        button_exit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("Exit lesson...");
            }
        });

        button_listen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("Listen to audio...");
            }
        });

        button_record.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("Recording audio...");
                final MediaRecorder recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
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
                        System.out.println("Recording stopped...");
                    }
                });
            }
        });



    }



}
