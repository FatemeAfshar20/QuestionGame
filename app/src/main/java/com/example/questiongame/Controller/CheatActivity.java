package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.questiongame.R;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_IS_CHEAT = "com.example.questiongame.Controller.IsCheat";
    private Button mBtnCheat, mBtnGoBack;
    private TextView mShowAnswer;

    private boolean checkAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        checkAnswer = getIntent().getBooleanExtra(QuestionGameActivity.QUESTION_ANSWER, false);
        findElem();
        setListener();
    }

    private void findElem() {
        mBtnCheat = findViewById(R.id.btn_cheat);
        mBtnGoBack = findViewById(R.id.btn_go_back);
        mShowAnswer = findViewById(R.id.answer);
    }

    private void setListener() {
        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBtnCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show answer
                if (checkAnswer)
                    mShowAnswer.setText(R.string.true_answer);
                else
                    mShowAnswer.setText(R.string.false_answer);
                setShowAnswerResult(true);
            }
        });
    }

    private void setShowAnswerResult(boolean isCheat) {
        Intent date = new Intent();
        date.putExtra(EXTRA_IS_CHEAT, isCheat);
        setResult(RESULT_OK, date);
    }
}