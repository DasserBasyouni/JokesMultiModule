package com.example.dasser.jokesmultimodule;

import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import com.example.dasser.jokesui.JokesUiActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.dasser.jokesmultimodule.EndpointsAsyncTask.BUNDLE_JOKE;
import static junit.framework.Assert.assertFalse;


@RunWith(AndroidJUnit4.class)
public class LoadingJokesTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void asyncTaskTest() {
        waitForAppThenCheck(DateUtils.SECOND_IN_MILLIS * 25);
    }

    private static void waitForAppThenCheck(long waitingTime) {
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        IdlingResource idlingResource = new JokeIdlingResource(waitingTime);
        IdlingRegistry.getInstance().register(idlingResource);

        onView(withId(R.id.button_tellJoke)).perform(click());

        assertFalse(JokesUiActivity.bundle.isEmpty());

        String receivedJoke = JokesUiActivity.bundle.getString(BUNDLE_JOKE);
        if (receivedJoke != null) {
            assertFalse("Failed to connect to GCE in 25 sec",
                    receivedJoke.contains("failed to connect"));
        } else
            assertFalse("Bundle doesn't contains joke" ,false);


        IdlingRegistry.getInstance().unregister(idlingResource);
    }
}
