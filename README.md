# DVD Screensaver with ObjectAnimator

This Android project creates a simple screensaver effect similar to the classic DVD screensaver using Animator. The Android logo bounces around the screen, changing color each time it hits the edges.

## Features

- Bouncing Android logo animation resembling the classic DVD screensaver.
- Random color change each time the logo hits the edges.

## How it Works

1. The project uses ObjectAnimator to animate the translation of the Android logo in both the X and Y directions.

2. AccelerateDecelerateInterpolator is used to provide smooth acceleration and deceleration effects to the animation.

3. The animation repeats indefinitely using `ObjectAnimator.INFINITE`.

4. Each time the animation repeats (i.e., when the logo hits the edges), the color of the DVD logo changes randomly from a predefined set of basic colors.

## Dependencies

- This project uses no external dependencies.

## Preview
[preview_01](https://github.com/anchanareghu/Android-Screensaver/assets/143755659/30678307-e911-43f6-af86-3be17c8ee768)

[preview_02](https://github.com/anchanareghu/Android-Screensaver/assets/143755659/d0a4e016-0391-4f2e-8f6d-a48764279a2c)


