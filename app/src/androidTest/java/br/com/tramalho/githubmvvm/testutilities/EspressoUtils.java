package br.com.tramalho.githubmvvm.testutilities;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AnyOf.anyOf;

/**
 * Created by trama on 19/03/18.
 */

public class EspressoUtils {

    public static void hasText(String... text) {

        for (String s : text) {
            onView(anyOf(withText(s)))
                    .check(matches(isDisplayed()));
        }
    }

    public static IdlingResource waitFor(int waitingTime) {

        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        // Now we wait
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        return idlingResource;
    }

    public static void unregister(IdlingResource idlingResource) {
        Espresso.unregisterIdlingResources(idlingResource);
    }
}
