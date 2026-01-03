package com.ppc.tokokomputer;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimHelper {

    public static void fadeIn(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        view.startAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    public static void fadeOut(View view) {
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(300);
        view.startAnimation(anim);
        view.setVisibility(View.GONE);
    }

    public static void scaleUp(View view) {
        ScaleAnimation anim = new ScaleAnimation(
                0.95f, 1.0f, 0.95f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        anim.setDuration(200);
        view.startAnimation(anim);
    }

    public static void bounce(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.05f, 1f);
        animator.setDuration(300);
        animator.start();
    }

    public static void shake(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX",
                0, 25, -25, 25, -25, 15, -15, 6, -6, 0);
        animator.setDuration(500);
        animator.start();
    }

    public static void cartAddAnimation(View view) {
        // Animasi khusus untuk menambah ke keranjang
        ScaleAnimation scaleAnim = new ScaleAnimation(
                0.5f, 1.2f, 0.5f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnim.setDuration(300);

        ScaleAnimation scaleBackAnim = new ScaleAnimation(
                1.2f, 1.0f, 1.2f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleBackAnim.setDuration(200);
        scaleBackAnim.setStartOffset(300);

        view.startAnimation(scaleAnim);
        view.postDelayed(() -> view.startAnimation(scaleBackAnim), 300);
    }
}