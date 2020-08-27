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

import com.example.questiongame.Model.SettingInfo;
import com.example.questiongame.R;

import org.w3c.dom.ls.LSException;

public class Setting extends AppCompatActivity {
    public static final String EXTRA_SETTING_NEW="com.example.questiongame.Controller.Setting Information";
    private Button mBtnSmall,mBtnLarge,mBtnMedium,mBtnColorPink,mBtnColorPinkL,mBtnColorPurple,mBtnColorPurpleL,mBtnColorWhite;
    protected RadioButton mRadioHideCheckLay,mRadioHideNPLay,mRadioHideFLLay;
    private ImageButton mBtnGoBack,mSave;
    private SettingInfo mSettingInfoMainAct;
    private SettingInfo mSettingInfo=new SettingInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
        mSave=findViewById(R.id.save);
    }

    private void setListener() {
        mBtnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        mSettingInfo.setFontSize(14);
            }
        });

        mBtnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSettingInfo.setFontSize(26);
            }
        });

        mBtnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSettingInfo.setFontSize(18);
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
               mSettingInfo.setColor(getResources().getColor(R.color.beauty_pink));
            }
        });

        mBtnColorPurpleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSettingInfo.setColor(getResources().getColor(R.color.beauty_so_pl));
            }
        });

        mBtnColorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSettingInfo.setColor(getResources().getColor(R.color.beauty_purple_light));
            }
        });

        mBtnColorPinkL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSettingInfo.setColor(getResources().getColor(R.color.beauty_pink_light));
            }
        });

        mBtnColorWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSettingInfo.setColor(getResources().getColor(R.color.white));
            }
        });

        mRadioHideNPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mSettingInfo.setLayNP(View.INVISIBLE);
            }
        });

        mRadioHideFLLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSettingInfo.setLaySS(View.INVISIBLE);
            }
        });

        mRadioHideCheckLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mSettingInfo.setLayCheck(View.INVISIBLE);
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewSetting();
            }
        });
    }

    public void setNewSetting(){
        Intent intent=new Intent();
        intent.putExtra(EXTRA_SETTING_NEW,mSettingInfo);
        setResult(RESULT_OK,intent);
    }

}