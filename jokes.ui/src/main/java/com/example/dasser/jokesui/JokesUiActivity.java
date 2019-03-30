package com.example.dasser.jokesui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokesUiActivity extends AppCompatActivity {

    public final String BUNDLE_JOKE = "joke";
    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_ui);

        bundle = getIntent().getExtras();

        String joke;
        if (bundle != null){
            joke = bundle.getString(BUNDLE_JOKE);
            ((TextView) findViewById(R.id.textView_joke)).setText(joke);
        }
    }
}
