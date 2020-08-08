package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.questiongame.R;

public class Setting extends AppCompatActivity {
    public static final String EXTRA_FONT_SIZE = "FontSize";
    Button mBtnSmall,mBtnLarge,mBtnMedium;
    float fontSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        fontSize=getIntent().getFloatExtra(QuestionGameActivity.FONT_SIZE,0);
        findElem();
        setListener();
    }

    private void findElem(){
        mBtnLarge=findViewById(R.id.btn_large_font);
        mBtnSmall=findViewById(R.id.btn_small_font);
        mBtnMedium=findViewById(R.id.btn_medium_font);
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
    }

    public void setFontSize(float fontSize) {
        Intent date=new Intent();
        date.putExtra(EXTRA_FONT_SIZE,fontSize);
        setResult(RESULT_OK,date);
    }
}