package com.lr.ghp.toolbar_material;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by jimubox on 5/18/2015.
 */
public class JimuLoanToolBar extends LinearLayout {

    public static final int STATUS_ENABLE_TRUE=0;
    public static final int STATUS_ENABLE_FALSE=1;

    private Context mContext;
    private LayoutInflater mInflater;
    private View logoView;
    private Button leftTextView;
    private Button rightTextView;
    private TextView belowTitle;
    private TextView centerTitleView;
    private View titleBarView;
    private View allLeftView;
    private ProgressBar progressView;
    private ImageView rightImageView;
    private Toolbar toolbar;

    public JimuLoanToolBar(Context context) {
        super(context);
        this.mContext=context;
        this.mInflater=LayoutInflater.from(context);
        initView(context);
    }

    public JimuLoanToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        this.mInflater=LayoutInflater.from(context);
        initView(context);
    }

    public JimuLoanToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        this.mInflater=LayoutInflater.from(context);
        initView(context);
    }

    private void initView(Context context) {
        titleBarView=mInflater.inflate(R.layout.toolbar, null);
        toolbar= (Toolbar) titleBarView.findViewById(R.id.toolbar);
        logoView=titleBarView.findViewById(R.id.titleBarLeftImage);
        leftTextView=(Button) titleBarView.findViewById(R.id.titleBarLeftButton);
        rightTextView=(Button) titleBarView.findViewById(R.id.titleBarRightButton);
        allLeftView=titleBarView.findViewById(R.id.titleBarAllLeftView);
        centerTitleView= (TextView) titleBarView.findViewById(R.id.titleBarCenterTitle);
        belowTitle= (TextView) titleBarView.findViewById(R.id.belowTitle);
        progressView=(ProgressBar) titleBarView.findViewById(R.id.titleBarProgress);
        rightImageView=(ImageView)titleBarView.findViewById(R.id.titleBarRightImage);
        this.addView(titleBarView);
    }
    public void setCenterTitleView(String title){
        centerTitleView.setText(title);
    }
    public void setLogoDrawable(Drawable drawable){
        logoView.setVisibility(View.VISIBLE);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN){
            logoView.setBackgroundDrawable(drawable);
        }else {
            logoView.setBackground(drawable);
        }
    }

    public void setLogoHeadView(Bitmap headicon){
        ImageView head=(ImageView)logoView;
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN){
            logoView.setBackgroundDrawable(null);
        }else {
            logoView.setBackground(null);
        }
        head.setVisibility(View.VISIBLE);
        head.setImageBitmap(headicon);
    }

    public void setLogoHeadView(int resid){
        ImageView head=(ImageView)logoView;
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN){
            logoView.setBackgroundDrawable(null);
        }else {
            logoView.setBackground(null);
        }
        head.setVisibility(View.VISIBLE);
        head.setImageResource(resid);
    }

    public void setLogoResource(int resid){
        logoView.setVisibility(View.VISIBLE);
        logoView.setBackgroundResource(resid);
    }

    public void setLeftTextViewContent(int content){
        leftTextView.setVisibility(View.VISIBLE);
        leftTextView.setText(content);
    }
    public void setLeftTextViewContent(String content){
        leftTextView.setVisibility(View.VISIBLE);
        leftTextView.setText(content);
    }

    public void setlogoViewVisibility(int visibility){
        logoView.setVisibility(visibility);
    }

    public void setRightTextViewContent(int content){
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setText(content);
    }
    public void setRightTextViewContent(String content){
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setText(content);
    }

    public void setTitleBarBackgroundColor(int color){
        titleBarView.setBackgroundColor(color);
    }

    public void setTitleBarBackgroundDrawable(Drawable drawable){
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN){
            this.setBackgroundDrawable(drawable);
        }else {
            this.setBackground(drawable);
        }
    }

    public void setTitleBarBackgroundResource(int resid){

    }

    public void setLogoViewOnClickListener(OnClickListener listener){
        logoView.setOnClickListener(listener);
    }

    public void setLeftTextViewOnClickListener(OnClickListener listener){
        leftTextView.setOnClickListener(listener);
    }

    public void setLeftViewOnClickListener(OnClickListener listener){
        leftTextView.setClickable(false);
        allLeftView.setOnClickListener(listener);
    }

    public void setRightViewOnClickListener(OnClickListener listener){
        rightTextView.setOnClickListener(listener);
    }

    public void setRightViewEnable(boolean enable){
        rightTextView.setEnabled(enable);
        if(enable){
            rightTextView.setVisibility(View.VISIBLE);
        }else{
            rightTextView.setVisibility(View.GONE);
        }

    }

    public void showProgress(){
        if(rightTextView.getVisibility()==View.GONE){
            RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams) progressView.getLayoutParams();
            params.rightMargin=25;
            params.alignWithParent=true;
            progressView.setLayoutParams(params);
        }
        progressView.setVisibility(View.VISIBLE);
    }

    public void dismissProgress(){
        progressView.setVisibility(View.GONE);

    }

    public void setLeftViewEnable(boolean enable){
        if(!enable){
            logoView.setVisibility(INVISIBLE);
            leftTextView.setEnabled(false);
            allLeftView.setEnabled(false);
        }
    }

    public void setRightTextViewEnable(boolean enable){
        if(enable){
            rightTextView.setVisibility(View.VISIBLE);
            rightTextView.setEnabled(true);
        }else{
            rightTextView.setVisibility(View.GONE);
            rightTextView.setEnabled(false);
        }
    }

    public void setBarBackgroundColor(int id){
        titleBarView.setBackgroundColor(id);
    }

    public void setRightViewImage(int id){
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setBackgroundDrawable(getResources().getDrawable(id));
    }

    public void setRightViewImage(Drawable drawable){
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setBackgroundDrawable(drawable);
    }

    public void setRightViewColor(int color){
        rightTextView.setTextColor(color);
    }

    public void setRightViewStatus(int status){
        switch (status){
            case STATUS_ENABLE_TRUE:
                rightTextView.setEnabled(true);
                rightTextView.setTextColor(getResources().getColor(R.color.white));
                break;
            case STATUS_ENABLE_FALSE:
                rightTextView.setEnabled(false);
                rightTextView.setTextColor(getResources().getColor(R.color.text_title_color));
                break;
            default:
                break;

        }

    }

    public void setRightImageView(int id){
        rightImageView.setImageResource(id);
        rightImageView.setVisibility(View.VISIBLE);
        rightTextView.setVisibility(View.GONE);
    }

    public void setRightImageViewOnClickListener(OnClickListener listener){
        rightImageView.setOnClickListener(listener);
    }

    public void setLeftImageLayoutParams(RelativeLayout.LayoutParams params){
        logoView.setLayoutParams(params);
        ImageView head=(ImageView)logoView;
        head.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    public void setLeftImageWidthHeight(int width , int height){
        ViewGroup.LayoutParams para;
        para = logoView.getLayoutParams();
        para.width = width;
        para.height = height;
        logoView.setLayoutParams(para);
    }
    public void setBelowTitleText(String text){
        belowTitle.setVisibility(View.VISIBLE);
        belowTitle.setText(text);
    }
}
