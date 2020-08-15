package com.example.questiongame.Controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questiongame.Model.Question;
import com.example.questiongame.R;


public class QuestionGameActivity extends AppCompatActivity {

    private QuestionGameFragment mQuestionGameFrag=new QuestionGameFragment();
    private FragmentManager mFragmentManager=getSupportFragmentManager();
    private Fragment mFragment=new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragment=mFragmentManager.findFragmentById(R.id.fragment_question_game);
        if(mFragment==null){
            mFragmentManager.beginTransaction().add(R.id.fragment_question_game,mQuestionGameFrag).commit();
        }

    }

}