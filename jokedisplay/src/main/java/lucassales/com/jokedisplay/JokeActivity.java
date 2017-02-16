package lucassales.com.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokectivity);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(getIntent().getStringExtra(JOKE));

    }
}
