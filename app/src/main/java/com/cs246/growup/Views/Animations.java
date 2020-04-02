package com.cs246.growup.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class Animations {
    public static boolean rotateFabAdd(final View view, boolean rotate) {
        view.animate().setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).rotation(rotate ? 135f : 0f);
        return rotate;
    }
}
