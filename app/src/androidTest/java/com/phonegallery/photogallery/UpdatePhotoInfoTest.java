package com.phonegallery.photogallery;

/**
 * Created by kellyliu on 2017-06-10.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UpdatePhotoInfoTest {


    @Rule
    public ActivityTestRule<HongKong> mActivityRule =
            new ActivityTestRule<>(HongKong.class);

    @Test
    public void ensureTextChangesWork() {
        // Click on the Hong Kong Tag to trigger the alert dialog
        onView(withId(R.id.hkPhotoTags)).perform(click());

        // Check the dialog title text is displayed
        onView(withText("Update Photo Tags")).check(matches(isDisplayed()));

        //onView(withText("Hong Kong")).perform(clearText(), typeText("HK"), closeSoftKeyboard());

        //onView(withText("UPDATE TAGS")).perform(click());

/**
        // Click on the Hong Kong Tag to trigger the alert dialog
        onView(withId(R.id.hkPhotoCategories)).perform(click());

        // Check the dialog title text is displayed
        onView(withText("Update Photo Categories")).check(matches(isDisplayed()));*/

        /**onView(withId(R.id.))
         .perform(typeText(""), closeSoftKeyboard());
         onView(withId(R.id.changeText)).perform(click());

         // Check that the text was changed.
         onView(withId(R.id.inputField)).check(matches(withText("Lalala")));*/
    }
}