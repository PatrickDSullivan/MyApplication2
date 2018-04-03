package sullivanpd3.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newWordBtn = (Button) findViewById(R.id.newWordBtn);
        final Button findMatchBtn = (Button) findViewById(R.id.findMatchBtn);

        newWordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findWordIntent = new Intent(getApplicationContext(), EnterValuesActivity.class);
                startActivity(findWordIntent);
            }
        });


        findMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText wordText = findViewById(R.id.wordText);
                String wordMatch = wordText.getText().toString();

                Intent findMatchIntent = new Intent(getApplicationContext(), ResultActivity.class);
                findMatchIntent.putExtra("sullivanpd3.edu.MyApplication.FINDMATCH", wordMatch);
                startActivity(findMatchIntent);
            }
        });
    }
}
