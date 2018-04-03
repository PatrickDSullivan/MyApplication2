package sullivanpd3.edu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (getIntent().hasExtra("sullivanpd3.edu.MyApplication.FINDMATCH")) {
            Intent intent = getIntent();
            String wordMatch = intent.getStringExtra("sullivanpd3.edu.MyApplication.FINDMATCH");
            String match = helper.searchMatch(wordMatch);

            if(match.equals("not found")){
                //Error Message
                TextView resultTextView = (TextView) findViewById(R.id.resultsTextView);
                String errorMessage = "Word \nNot \nFound";
                resultTextView.setText(errorMessage);
            }
            else{
                //Give correct matching words
                TextView resultTextView = (TextView) findViewById(R.id.resultsTextView);
                String result = wordMatch+"\n\nis the\nSynonym/Antonym\n of\n\n" + match;
                resultTextView.setText(result);
            }


        }
    }
}
