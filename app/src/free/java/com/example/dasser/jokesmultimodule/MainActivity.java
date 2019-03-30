package com.example.dasser.jokesmultimodule;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView_app_version) TextView mAppVersion_tv;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.button_tellJoke) Button mTellJoke_btn;
    @BindView(R.id.adView) AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            mAppVersion_tv.setText(getString(R.string.msg_app_version, "Free"));
            MobileAds.initialize(MainActivity.this,
                    "ca-app-pub-3940256099942544/6300978111");
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }


        final Runnable runnable = () -> {
            mProgressBar.setVisibility(View.GONE);
            mAppVersion_tv.setVisibility(View.VISIBLE);
            mTellJoke_btn.setVisibility(View.VISIBLE);
        };

        mTellJoke_btn.setOnClickListener(v -> {
            mAppVersion_tv.setVisibility(View.GONE);
            mTellJoke_btn.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
            new EndpointsAsyncTask(MainActivity.this, runnable).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        });
    }




}
