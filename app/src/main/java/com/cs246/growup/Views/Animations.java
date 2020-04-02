package com.cs246.growup.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class Animations {
    public static boolean rotateFabAdd(final View view, boolean rotate) {
        view.animate().setDuration(300).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).rotation(rotate ? 135f : 0f);
        return rotate;
    }

    public static void popIn(final View viewIn) {
        viewIn.setVisibility(View.VISIBLE);
        viewIn.setAlpha(0f);
        viewIn.setTranslationY(viewIn.getHeight());
        viewIn.animate().setDuration(250).translationY(0)
                .setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).alpha(1f).start();
    }

    public static void popOut(final View viewOut) {
        viewOut.setVisibility(View.VISIBLE);
        viewOut.setAlpha(1f);
        viewOut.setTranslationY(0);
        viewOut.animate().setDuration(250).translationY(viewOut.getHeight())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        viewOut.setVisibility(View.GONE);
                        super.onAnimationEnd(animation);
                    }
                }).alpha(0f).start();
    }

    public static void initial(final View view) {
        view.setVisibility(View.GONE);
        view.setTranslationY(view.getHeight());
        view.setAlpha(0f);
    }
}
