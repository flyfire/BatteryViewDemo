package com.solarexsoft.batteryview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by houruhou on 27/10/2017.
 */

public class BatteryView extends View {
    private Context mContext;

    private int mHeadColor;
    private int mBodyColor;
    private int mProgressColor;
    private int mProgress;

    private Paint mHeadPaint;
    private Paint mBodyPaint;
    private Paint mProgressPaint;
    private Paint mTextPaint;


    private RectF mHeadRect;
    private RectF mBodyRect;
    private RectF mProgressRect;

    private int mDefaultWidth;
    private int mDefaultHeight;

    private float DEFAULT_WIDTH = 15;
    private float DEFAULT_HEIGHT = 25;

    public BatteryView(Context context) {
        this(context, null);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BatteryView);
        mHeadColor = typedArray.getColor(R.styleable.BatteryView_headcolor, Color.BLACK);
        mBodyColor = typedArray.getColor(R.styleable.BatteryView_bodycolor, Color.BLACK);
        mProgressColor = typedArray.getColor(R.styleable.BatteryView_progresscolor, Color.GREEN);
        mProgress = typedArray.getInt(R.styleable.BatteryView_progress, 10);

        mHeadPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHeadPaint.setStyle(Paint.Style.STROKE);
        mHeadPaint.setColor(mHeadColor);
        mBodyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBodyPaint.setStyle(Paint.Style.STROKE);
        mBodyPaint.setColor(mBodyColor);
        mProgressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mProgressPaint.setStyle(Paint.Style.FILL);
        mProgressPaint.setColor(mProgressColor);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(15.0f);

        typedArray.recycle();
    }
}
