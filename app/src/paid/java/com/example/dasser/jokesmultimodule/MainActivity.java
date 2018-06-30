package com.example.dasser.jokesmultimodule;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView_app_version) TextView mAppVersion_tv;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.button_tellJoke) Button mTellJoke_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAppVersion_tv.setText(getString(R.string.msg_app_version, "Paid"));


        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                mAppVersion_tv.setVisibility(View.VISIBLE);
                mTellJoke_btn.setVisibility(View.VISIBLE);
            }
        };

        mTellJoke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAppVersion_tv.setVisibility(View.GONE);
                mTellJoke_btn.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(MainActivity.this, runnable).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

            }
        });
    }


}
