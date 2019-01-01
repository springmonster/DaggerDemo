package demo.jetpack.com.downloadmanager;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import demo.jetpack.com.R;

public class DownloadProgressBar extends View {

    private static final String TAG = DownloadProgressBar.class.getSimpleName();
    private static final int DEFAULT_PROGRESS_DURATION = 1000;
    private static final int DEFAULT_RESULT_DURATION = 1000;
    private static final float DEFAULT_OVERSHOOT_VALUE = 2.5f;

    private Paint mCirclePaint;
    private Paint mDrawingPaint;

    private float mRadius;
    private float mStrokeWidth;
    private float mLineWidth;
    private float mLengthFix;

    private float mCenterX;
    private float mCenterY;
    private float mPaddingX;
    private float mPaddingY;

    private int mCircleBackgroundColor;
    private int mDrawingColor;
    private int mProgressBackgroundColor;
    private int mProgressColor;
    private int mProgressDuration;
    private int mResultDuration;

    private ValueAnimator mManualProgressAnimation;

    private RectF mCircleBounds;
    private RectF mProgressBackgroundBounds = new RectF();
    private RectF mProgressBounds = new RectF();

    private AnimatorSet mManualProgressAnimationSet;
    private float mFromArc = 0;
    private float mToArc = 0;
    private float mCurrentGlobalManualProgressValue;

    private enum State {
        IDLE, ANIMATING_MANUAL_PROGRESS
    }

    private State mState;
    private State mResultState;
    private State mWhichProgress;

    public DownloadProgressBar(Context context) {
        super(context);
    }

    public DownloadProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DownloadProgressView, 0, 0);
        try {
            mRadius = array.getDimension(R.styleable.DownloadProgressView_circleRadius, 0);
            mStrokeWidth = array.getDimension(R.styleable.DownloadProgressView_strokeWidth, 0);
            mLineWidth = array.getDimension(R.styleable.DownloadProgressView_lineWidth, 0);
            mLengthFix = (float) (mLineWidth / (2 * Math.sqrt(2)));
            mProgressDuration = array.getInteger(R.styleable.DownloadProgressView_progressDuration, DEFAULT_PROGRESS_DURATION);
            mResultDuration = array.getInteger(R.styleable.DownloadProgressView_resultDuration, DEFAULT_RESULT_DURATION);
            mProgressBackgroundColor = array.getColor(R.styleable.DownloadProgressView_progressBackgroundColor, 0);
            mDrawingColor = array.getColor(R.styleable.DownloadProgressView_drawingColor, 0);
            mProgressColor = array.getColor(R.styleable.DownloadProgressView_progressColor, 0);
            mCircleBackgroundColor = array.getColor(R.styleable.DownloadProgressView_circleBackgroundColor, 0);
        } finally {
            array.recycle();
        }
    }

    private void init() {
        mCirclePaint = new Paint();
        mCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(mCircleBackgroundColor);
        mCirclePaint.setStrokeWidth(mStrokeWidth);

        mDrawingPaint = new Paint();
        mDrawingPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mDrawingPaint.setStyle(Paint.Style.STROKE);
        mDrawingPaint.setColor(mDrawingColor);
        mDrawingPaint.setStrokeWidth(mLineWidth);

        mState = State.IDLE;
        setupAnimations();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = w / 2f;
        mCenterY = h / 2f;
        mPaddingX = w / 2f - mRadius;
        mPaddingY = h / 2f - mRadius;

        mCircleBounds = new RectF();
        mCircleBounds.top = mPaddingY;
        mCircleBounds.left = mPaddingX;
        mCircleBounds.bottom = h / 2f + mRadius;
        mCircleBounds.right = w / 2f + mRadius;
    }

    private void setupAnimations() {
        mManualProgressAnimation = ValueAnimator.ofFloat(mFromArc, mToArc);
        mManualProgressAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurrentGlobalManualProgressValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        mManualProgressAnimation.start();
    }

    private void drawing(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, mRadius, mCirclePaint);
        switch (mState) {
            case IDLE:
                drawArrow(canvas, mCirclePaint);
                break;
            case ANIMATING_MANUAL_PROGRESS:
                canvas.drawArc(mCircleBounds, -90, mCurrentGlobalManualProgressValue, false, mDrawingPaint);

                drawArrow(canvas, mDrawingPaint);
                break;
        }
    }

    private void drawArrow(Canvas canvas, Paint drawingPaint) {
        canvas.drawLine(mCenterX, mCenterY - mRadius / 2, mCenterX, mCenterY + mRadius / 2, drawingPaint);
        canvas.drawLine(mCenterX - mRadius / 2, mCenterY, mCenterX + mLengthFix, mCenterY + mRadius / 2 + mLengthFix, drawingPaint);
        canvas.drawLine(mCenterX - mLengthFix, mCenterY + mRadius / 2 + mLengthFix, mCenterX + mRadius / 2, mCenterY, drawingPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawing(canvas);
    }

    public void playManualProgressAnimation() {
        mState = State.ANIMATING_MANUAL_PROGRESS;
        invalidate();
    }

    public void setProgress(int value) {
        if (value <= 1 || value > 100)
            return;
        mToArc = value * 3.6f;
        mManualProgressAnimation.setFloatValues(mFromArc, mToArc);
        mManualProgressAnimation.start();
        mFromArc = mToArc;
        invalidate();
    }
}