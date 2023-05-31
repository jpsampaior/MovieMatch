package com.example.moviematch;

import android.animation.ObjectAnimator;
import android.view.View;

public class FadeEffect {
    public static void fadeIn(View view, int duration) {
        ObjectAnimator fadeAnimator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        fadeAnimator.setDuration(duration);
        fadeAnimator.start();
    }

    public static void fadeOut(View view, int duration) {
        ObjectAnimator fadeAnimator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
        fadeAnimator.setDuration(duration);
        fadeAnimator.start();
    }
}
