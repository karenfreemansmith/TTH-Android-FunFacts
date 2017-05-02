package com.freeman_smith.tthfunfacts;
import android.content.Intent;
import android.os.Bundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

/**
 * Created by Karen Freeman-Smith on 5/1/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants=BuildConfig.class)
public class MainActivityTest {
  private ActivityController<MainActivity> controller;
  private MainActivity activity;

  @Before
  public void setUp() {
    controller = Robolectric.buildActivity(MainActivity.class);
  }

  @After
  public void tearDown() {
    controller.destroy();
  }

  public void createWithIntent(String extra) {
    Intent intent = new Intent(RuntimeEnvironment.application, MainActivity.class);
    Bundle extras = new Bundle();
    extras.putString("extra", extra);
    intent.putExtras(extras);
    activity = controller
        .create()
        .start()
        .visible()
        .get();
  }

  @Test
  public void createsAndDestroysActivity() {
    createWithIntent("foo");
    // add assertions
  }

  @Test
  public void pausesAndResumesActivity() {
    createWithIntent("foo");
    controller.pause().resume();
    // add assertions
  }

  @Test
  public void recreatesActivity() {
    createWithIntent("foo");
    activity.recreate();
    // add assertions
  }

  @Test
  public void clickShowsNextFact() {
    // assert new fact appears
    // assert new color for background
    // assert new color for button text
  }
}
