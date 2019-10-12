package pronounce.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private String[] languagesArray = {"Select", "Spanish"};
    private Spinner languages;
    private String selectedString;
    private Button buttonChangeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonChangeActivity  = findViewById(R.id.buttonChangeActivity);
    }
    public void Button1Action(View v){

        languages  = findViewById(R.id.languages);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languagesArray);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languages.setAdapter(dataAdapter);
        languages.setVisibility(View.VISIBLE);
        buttonChangeActivity.setVisibility(View.VISIBLE);
        languages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                selectedString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void ButtonChangeAction (View v) {
        if (selectedString.equals("Spanish")) {
            Intent intent = new Intent(this, LessonSelector.class);
            startActivity(intent);
        }
    }
}
