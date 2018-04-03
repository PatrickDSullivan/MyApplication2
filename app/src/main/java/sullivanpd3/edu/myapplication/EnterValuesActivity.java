package sullivanpd3.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterValuesActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_values2);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText wordOneTextView = (EditText) findViewById(R.id.wordOneTextView);
                EditText wordTwoTextView = (EditText) findViewById(R.id.wordTwoTextView);

                MatchedWords m = new MatchedWords();
                m.setWord(wordOneTextView.getText().toString());
                m.setMatch(wordTwoTextView.getText().toString());

                helper.insertMatchedPair(m);
                finish();
            }
        });
    }
}
