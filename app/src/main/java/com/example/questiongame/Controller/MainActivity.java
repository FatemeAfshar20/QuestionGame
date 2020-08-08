package com.example.questiongame.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.questiongame.Model.Question;
import com.example.questiongame.R;


public class MainActivity extends AppCompatActivity {

    private Question[] mQuestions = {
            new Question(R.string.question_africa, true, false),
            new Question(R.string.question_asia, false, false),
            new Question(R.string.question_americas, false, false),
            new Question(R.string.question_mideast, false, false),
            new Question(R.string.question_oceans, true, false),
            new Question(R.string.question_australia, false, false)
    };
    int mCurIndex;
    TextView mTextView,mTextViewScore,mResultView;
    ImageButton mBtnTrue, mBtnFalse, mBtnNext, mBtnPrev, mBtnLast, mBtnFirst,mBtnRefresh,mBtnCheat;
    ViewGroup mCheckLay,mNextPrevLay,mFirstLastLay,mFinishGameLay,mResultLay;
    int mScoreNumber =0;
    int mAnswerNum =0;
    private static final String TAG = "QuestionGame";
    private static final String BUNDLE_KEY_CURRENT_INDEX = "currentIndex";
    private static final String BUNDLE_KEY_ANSWER_NUM = "Answer number";
    private static final String BUNDLE_KEY_SCORE_NUM = "Score number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null) {
            Log.d(TAG, "this is question game   " + savedInstanceState);
           mCurIndex= savedInstanceState.getInt(BUNDLE_KEY_CURRENT_INDEX,0);
           mAnswerNum=savedInstanceState.getInt(BUNDLE_KEY_ANSWER_NUM,0);
           mScoreNumber=savedInstanceState.getInt(BUNDLE_KEY_SCORE_NUM,0);

        } else
            Log.d(TAG,"is null!   "+savedInstanceState);
        setContentView(R.layout.activity_main);
        findElem();
        setListener();
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    private void findElem() {
        mBtnTrue=findViewById(R.id.btn_true);
        mBtnFalse=findViewById(R.id.btn_false);
        mBtnNext=findViewById(R.id.btn_next);
        mBtnPrev=findViewById(R.id.btn_prev);
        mBtnFirst=findViewById(R.id.btn_first_question);
        mBtnLast=findViewById(R.id.btn_last_question);
        mBtnRefresh=findViewById(R.id.btn_refresh);
        mTextView = findViewById(R.id.question);
        mFinishGameLay=findViewById(R.id.finish_game_lay);
        mFinishGameLay.setVisibility(View.GONE);
        mCheckLay=findViewById(R.id.check_lay);
        mFirstLastLay=findViewById(R.id.first_last_lay);
        mNextPrevLay=findViewById(R.id.next_prev_lay);
        mTextViewScore=findViewById(R.id.score_num);
        mResultLay=findViewById(R.id.result);
        mResultLay.setVisibility(View.GONE);
        mResultView=findViewById(R.id.result_text);
        mBtnCheat=findViewById(R.id.btn_cheat);
    }

    private void setListener() {
        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mQuestions[mCurIndex].isAnswer()) {
                    checkAnswer(false);
                    mBtnTrue.setEnabled(false);
                }
                mBtnTrue.setEnabled(true);
            }
        });

        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mQuestions[mCurIndex].isAnswer()) {
                    checkAnswer(true);
                    mBtnFalse.setEnabled(false);
                }
             mBtnFalse.setEnabled(true);
            }
        });

       mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurIndex = (mCurIndex + 1) % mQuestions.length;
                updateQuestion();
            }
        });

       mBtnPrev.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mCurIndex = (mCurIndex - 1 + mQuestions.length) % mQuestions.length;
               updateQuestion();
           }
       });

       mBtnFirst.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mTextView.setText(mQuestions[0].getQuestionIn());
           }
       });

       mBtnLast.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mTextView.setText(mQuestions[mQuestions.length-1].getQuestionIn());
           }
       });

       mBtnRefresh.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               refreshGame();
           }
       });

    }

    private void updateQuestion() {
        int questionTextResId = mQuestions[mCurIndex].getQuestionIn();
        mTextView.setText(questionTextResId);
    }

    private void checkAnswer(boolean answer){
        if(answer==mQuestions[mCurIndex].isTrue()){
            returnToast(R.string.true_answer);
            mScoreNumber++;
        }else{
           returnToast(R.string.false_answer);
        }
        mQuestions[mCurIndex].setAnswer(true);
        mAnswerNum++;
        checkFinishGame(mAnswerNum);

    }

    private void checkFinishGame(int answerNum){
        if(answerNum==6)
            finishGame();
    }

    public void finishGame(){
       mCheckLay.setVisibility(View.INVISIBLE);
       mNextPrevLay.setVisibility(View.INVISIBLE);
       mFirstLastLay.setVisibility(View.INVISIBLE);
       mTextView.setVisibility(View.INVISIBLE);
        mFinishGameLay.setVisibility(View.VISIBLE);
        mTextViewScore.setText(String.valueOf(mScoreNumber));
        mResultLay.setVisibility(View.VISIBLE);
        if(mScoreNumber<6)
            mResultView.setText(R.string.fail);

    }

    private void refreshGame(){
        mCheckLay.setVisibility(View.VISIBLE);
        mNextPrevLay.setVisibility(View.VISIBLE);
        mFirstLastLay.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mFinishGameLay.setVisibility(View.GONE);
        mResultView.setVisibility(View.GONE);

        for (int i = 0; i < mQuestions.length; i++) {
            mQuestions[i].setAnswer(false);
        }
    }

    public void returnToast(int msg) {
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.TOP | Gravity.RIGHT, 280, 200);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_KEY_CURRENT_INDEX, mCurIndex);
        outState.putInt(BUNDLE_KEY_ANSWER_NUM,mAnswerNum);
        outState.putInt(BUNDLE_KEY_SCORE_NUM,mScoreNumber);
    }

}