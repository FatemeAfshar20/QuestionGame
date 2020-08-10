package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.questiongame.R;

import org.w3c.dom.ls.LSException;

public class Setting extends AppCompatActivity {
    public static final String EXTRA_FONT_SIZE = "com.example.questiongame.Controller.Font Size";
    public static final String EXTRA_COLOR_MAIN_LAYOUT = "com.example.questiongame.Controller.Background Color Main Layout";
    public static final String EXTRA_LAY_CHECK = "com.example.questiongame.Controller.Layout Check";
    public static final String EXTRA_LAY_NP = "com.example.questiongame.Controller.Layout NP";
    public static final String EXTRA_LAY_FL = "com.example.questiongame.Controller.Layout FL";
    private Button mBtnSmall,mBtnLarge,mBtnMedium,mBtnColorPink,mBtnColorPinkL,mBtnColorPurple,mBtnColorPurpleL,mBtnColorWhite;
    protected RadioButton mRadioHideCheckLay,mRadioHideNPLay,mRadioHideFLLay;
    private ImageButton mBtnGoBack;
    private Intent mDate =new Intent();
    protected float mFontSize;
    protected int mColor;
    protected int mVisibleLayCheck,mVisibleLayNP,mVisibleLayFL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mFontSize =getIntent().getFloatExtra(QuestionGameActivity.EXTRA_FONT_SIZE,0);
        mColor =getIntent().getIntExtra(QuestionGameActivity.EXTRA_COLOR_MAIN_LAYOUT,0);
        mVisibleLayCheck=getIntent().getIntExtra(QuestionGameActivity.EXTRA_VISIBILITY_CHECK_LAYOUT,0);
        mVisibleLayNP=getIntent().getIntExtra(QuestionGameActivity.EXTRA_VISIBILITY_NP_LAYOUT,0);
        mVisibleLayFL=getIntent().getIntExtra(QuestionGameActivity.EXTRA_VISIBILITY_FL_LAYOUT,0);
        findElem();
        setListener();
    }

    private void findElem(){
        mBtnLarge=findViewById(R.id.btn_large_font);
        mBtnSmall=findViewById(R.id.btn_small_font);
        mBtnMedium=findViewById(R.id.btn_medium_font);
        mBtnColorPink=findViewById(R.id.btn_color_pink);
        mBtnColorPinkL=findViewById(R.id.btn_color_pinkl);
        mBtnColorPurple=findViewById(R.id.btn_color_purple);
        mBtnColorPurpleL=findViewById(R.id.btn_color_pl);
        mBtnColorWhite=findViewById(R.id.btn_color_white);
        mBtnGoBack=findViewById(R.id.btn_go_back);
        mRadioHideCheckLay=findViewById(R.id.radio_hide_check_lay);
        mRadioHideFLLay=findViewById(R.id.radio_hide_fl_lay);
        mRadioHideNPLay=findViewById(R.id.radio_hide_np_lay);
    }

    private void setListener() {
        mBtnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        setFontSize(14);
            }
        });

        mBtnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    setFontSize(26);
            }
        });

        mBtnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    setFontSize(18);
            }
        });

        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBtnColorPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackColor(getResources().getColor(R.color.beauty_pink));
            }
        });

        mBtnColorPurpleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackColor(getResources().getColor(R.color.beauty_so_pl));
            }
        });

        mBtnColorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackColor(getResources().getColor(R.color.beauty_purple_light));
            }
        });

        mBtnColorPinkL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackColor(getResources().getColor(R.color.beauty_pink_light));
            }
        });

        mBtnColorWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackColor(getResources().getColor(R.color.white));
            }
        });

        mRadioHideNPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHideLayout(View.INVISIBLE,EXTRA_LAY_NP);
            }
        });

        mRadioHideFLLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHideLayout(View.INVISIBLE,EXTRA_LAY_FL);
            }
        });

        mRadioHideCheckLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHideLayout(View.INVISIBLE,EXTRA_LAY_CHECK);
            }
        });



    }

    private void setFontSize(float fontSize) {
        mDate.putExtra(EXTRA_FONT_SIZE,fontSize);
        setResult(RESULT_OK, mDate);
    }

    private void setBackColor(int color){
        mDate.putExtra(EXTRA_COLOR_MAIN_LAYOUT,color);
        setResult(RESULT_OK, mDate);
    }

    private void setHideLayout(int visibility,String str){
        mDate.putExtra(str,visibility);
        setResult(RESULT_OK,mDate);
    }

}