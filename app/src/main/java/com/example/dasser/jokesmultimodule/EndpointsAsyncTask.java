package com.example.dasser.jokesmultimodule;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.dasser.backend.jokes.myApi.MyApi;
import com.example.dasser.jokesui.JokesUiActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    static final String BUNDLE_JOKE = "joke";
    private static MyApi myApiService = null;
    @SuppressLint("StaticFieldLeak") private Activity activity;
    private Runnable runnable;

    EndpointsAsyncTask(Activity activity, Runnable runnable) {
        this.activity = activity;
        this.runnable = runnable;
    }


    @Override
    protected final String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(abstractGoogleClientRequest ->
                            abstractGoogleClientRequest.setDisableGZipContent(true));
            myApiService = builder.build();
        }
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_JOKE, result);

        Intent intent = new Intent(activity, JokesUiActivity.class);
        intent.putExtras(bundle);
        runnable.run();
        activity.startActivity(intent);
    }

}