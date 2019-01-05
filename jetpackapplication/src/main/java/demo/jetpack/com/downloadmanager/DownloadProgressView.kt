package demo.jetpack.com.downloadmanager

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import demo.jetpack.com.R

/**
 * @author Charles.Kuang
 */
class DownloadProgressView : View {
    private lateinit var mBackgroundPaint: Paint
    private lateinit var mDrawingPaint: Paint

    private lateinit var mLoadingAnimation: ValueAnimator
    private lateinit var mCircleBounds: RectF

    private var mCircleRadius: Float = 0f
    private var mStrokeWidth: Float = 0f
    private var mLengthFix: Float = 0f

    private var mCenterX: Float = 0f
    private var mCenterY: Float = 0f
    private var mPaddingX: Float = 0f
    private var mPaddingY: Float = 0f

    private var mBackgroundColor: Int = 0
    private var mDrawingColor: Int = 0

    private var mFromArc = 0f
    private var mToArc = 0f
    private var mProgressValue: Float = 0.toFloat()

    private var mState = State.IDLE

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttrs(context, attrs)
        initPaints()
        initAnimation()
        invalidate()
    }

    @SuppressLint("CustomViewStyleable")
    private fun initAttrs(context: Context, attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.DownloadProgressView, 0, 0)
        try {
            mCircleRadius = array.getDimension(R.styleable.DownloadProgressView_circleRadius, 0f)
            mStrokeWidth = array.getDimension(R.styleable.DownloadProgressView_strokeWidth, 0f)
            mLengthFix = (mStrokeWidth / (2 * Math.sqrt(2.0))).toFloat()
            mBackgroundColor = array.getColor(R.styleable.DownloadProgressView_backgroundColor, 0)
            mDrawingColor = array.getColor(R.styleable.DownloadProgressView_drawingColor, 0)
        } finally {
            array.recycle()
        }
    }

    private fun initPaints() {
        mBackgroundPaint = Paint()
        mBackgroundPaint.flags = Paint.ANTI_ALIAS_FLAG
        mBackgroundPaint.style = Paint.Style.STROKE
        mBackgroundPaint.color = mBackgroundColor
        mBackgroundPaint.strokeWidth = mStrokeWidth

        mDrawingPaint = Paint()
        mDrawingPaint.flags = Paint.ANTI_ALIAS_FLAG
        mDrawingPaint.style = Paint.Style.STROKE
        mDrawingPaint.color = mDrawingColor
        mDrawingPaint.strokeWidth = mStrokeWidth
    }

    private fun initAnimation() {
        mLoadingAnimation = ValueAnimator.ofFloat(mFromArc, mToArc)
        mLoadingAnimation.addUpdateListener { valueAnimator ->
            mProgressValue = valueAnimator.animatedValue as Float
            invalidate()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mCenterX = w / 2f
        mCenterY = h / 2f
        mPaddingX = w / 2f - mCircleRadius
        mPaddingY = h / 2f - mCircleRadius

        mCircleBounds = RectF()
        mCircleBounds.top = mPaddingY
        mCircleBounds.left = mPaddingX
        mCircleBounds.bottom = h / 2f + mCircleRadius
        mCircleBounds.right = w / 2f + mCircleRadius
    }

    private fun drawArrow(canvas: Canvas, drawingPaint: Paint) {
        canvas.drawLine(
            mCenterX,
            mCenterY - mCircleRadius / 2,
            mCenterX,
            mCenterY + mCircleRadius / 2,
            drawingPaint
        )

        canvas.drawLine(
            mCenterX - mCircleRadius / 2,
            mCenterY,
            mCenterX + mLengthFix,
            mCenterY + mCircleRadius / 2 + mLengthFix,
            drawingPaint
        )

        canvas.drawLine(
            mCenterX - mLengthFix,
            mCenterY + mCircleRadius / 2 + mLengthFix,
            mCenterX + mCircleRadius / 2,
            mCenterY,
            drawingPaint
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawing(canvas)
    }

    private fun drawing(canvas: Canvas) {
        canvas.drawCircle(mCenterX, mCenterY, mCircleRadius, mBackgroundPaint)

        when (mState) {
            State.IDLE -> drawArrow(canvas, mBackgroundPaint)
            State.LOADING -> {
                canvas.drawArc(mCircleBounds, -90f, mProgressValue, false, mDrawingPaint)
                drawArrow(canvas, mDrawingPaint)
            }
        }
    }

    fun setProgress(value: Int) {
        if (value <= 0 || value > 100) {
            return
        }
        if (mState != State.LOADING) {
            mState = State.LOADING
        }
        mToArc = value * 3.6f
        mLoadingAnimation.setFloatValues(mFromArc, mToArc)
        mLoadingAnimation.start()
        mFromArc = mToArc
    }

    fun stopLoading() {
        mFromArc = 0f
        mToArc = 0f
        mState = State.IDLE
        invalidate()
    }

    private enum class State {
        IDLE, LOADING
    }
}