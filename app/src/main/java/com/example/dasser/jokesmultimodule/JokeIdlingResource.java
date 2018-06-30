package com.example.dasser.jokesmultimodule;

import android.support.test.espresso.IdlingResource;

public class JokeIdlingResource implements IdlingResource {

    private final long startTime;
    private final long waitingTime;
    private ResourceCallback callback;

    public JokeIdlingResource(long waitingTime) {
        this.startTime = System.currentTimeMillis();
        this.waitingTime = waitingTime;
    }

    @Override
    public String getName() {
        return JokeIdlingResource.class.getName() + ":" + waitingTime;
    }

    @Override
    public boolean isIdleNow() {
        long elapsed = System.currentTimeMillis() - startTime;
        boolean idle = (elapsed >= waitingTime);
        if (idle) {
            callback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }
}
