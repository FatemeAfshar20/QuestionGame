package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.QuestionGameFragment;
import com.example.questiongame.R;


public class QuestionGameActivity extends AppCompatActivity {

    private QuestionGameFragment mQuestionGameFrag=new QuestionGameFragment();
    private FragmentManager mFragmentManager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fragment_question_game);
        if(fragment ==null){
            mFragmentManager.beginTransaction().add(R.id.fragment_question_game,mQuestionGameFrag).commit();
        }

    }

}