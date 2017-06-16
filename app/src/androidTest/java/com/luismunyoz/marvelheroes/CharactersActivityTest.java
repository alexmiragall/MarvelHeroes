package com.luismunyoz.marvelheroes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.luismunyoz.marvelheroes.characters.CharactersActivity;

/**
 * Copyright (c) Tuenti Technologies. All rights reserved.
 */
@RunWith(AndroidJUnit4.class)
public class CharactersActivityTest {
	@Rule
	public ActivityTestRule<CharactersActivity> mActivityRule = new ActivityTestRule<>(CharactersActivity.class);

	@Test
	public void ensureTextChangesWork() {
		onView(withRecycler(R.id.characters_list))
				.perform(swipeDown()).check(matches(ViewMatchers.))

		// Check that the text was changed.
		onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
	}

}
