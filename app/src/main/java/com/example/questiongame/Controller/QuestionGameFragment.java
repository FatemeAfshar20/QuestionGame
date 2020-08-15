package com.example.questiongame.Controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questiongame.Model.Question;
import com.example.questiongame.R;

public class QuestionGameFragment extends Fragment {

    public QuestionGameFragment(){

    }
    public static final int REQUEST_CODE_CHEAT = 0;
    public static final int REQUEST_CODE_SETTING = 1;
    public static final String EXTRA_FONT_SIZE = "com.example.questiongame.Controller.FontSize";
    public static final String EXTRA_COLOR_MAIN_LAYOUT = "com.example.questiongame.Controller.Background Color Main Layout";
    public static final String EXTRA_VISIBILITY_CHECK_LAYOUT = "com.example.questiongame.Controller.Visibility Layout";
    public static final String EXTRA_VISIBILITY_NP_LAYOUT = "com.example.questiongame.Controller.Visibility NP Layout";
    public static final String EXTRA_VISIBILITY_FL_LAYOUT = "com.example.questiongame.Controller.Visibility FL Layout";
    public static final String EXTRA_QUESTION_ANSWER = "com.example.questiongame.Controller.QuestionAnswer";
    private Question[] mQuestions = {
            new Question(R.string.question_africa, true, false, false),
            new Question(R.string.question_asia, false, false, false),
            new Question(R.string.question_americas, false, false, false),
            new Question(R.string.question_mideast, false, false, false),
            new Question(R.string.question_oceans, true, false, false),
            new Question(R.string.question_australia, false, false, false)
    };
    private int mCurIndex;
    private TextView mTextView, mTextViewScore, mResultView;
    private ImageButton mBtnTrue, mBtnFalse, mBtnNext, mBtnPrev, mBtnLast, mBtnFirst, mBtnRefresh, mBtnSetting;
    private Button mBtnCheat;
    private ViewGroup mCheckLay, mNextPrevLay, mFirstLastLay, mFinishGameLay, mResultLay,mMainLay;
    private int mScoreNumber = 0;
    private int mAnswerNum = 0;
    private float mFontSize =15;
    private boolean mIsCheat = false;
    private int mColor = Color.WHITE;
    private int mVisibleNP=View.VISIBLE;
    private int mVisibleFL=View.VISIBLE;
    private int mVisibleCheck=View.VISIBLE;
    public static final String ANSWER = "answer";
    public static final String Q_IS_CHEAT = "qIsCheat";
    private static final String TAG = "QuestionGame";
    public static final String BUNDLE_VISIBILITY_OF_CHECK_LAYOUT = "Visibility of Check Layout";
    public static final String BUNDLE_VISIBILITY_OF_NP_LAYOUT = "Visibility of NP Layout";
    public static final String BUNDLE_VISIBILITY_OF_FL_LAYOUT = "Visibility of FL Layout";
    public static final String BUNDLE_KEY_BACKGROUND_COLOR = "Background color";
    public static final String BUNDLE_KEY_FONT_SIZE = "Font size";
    public static final String BUNDLE_KEY_CURRENT_INDEX = "currentIndex";
    private static final String BUNDLE_KEY_ANSWER_NUM = "Answer number";
    public static final String BUNDLE_IS_CHEAT = "qIsCheat";
    public static final String BUNDLE_KEY_SCORE_NUM = "Score number";
    public static final String BUNDLE_KEY_IS_CHEAT_BOOL = "Score number";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_question_game, container, false);

        findElem(view);
        setListener();
        saveInstance(savedInstanceState);
        // Inflate the layout for this fragment
        return view;
    }

    private void saveInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Log.d(TAG, "this is question game   " + savedInstanceState);
            mCurIndex = savedInstanceState.getInt(BUNDLE_KEY_CURRENT_INDEX, 0);
            mAnswerNum = savedInstanceState.getInt(BUNDLE_KEY_ANSWER_NUM, 0);
            mScoreNumber = savedInstanceState.getInt(BUNDLE_KEY_SCORE_NUM, 0);
            mIsCheat=savedInstanceState.getBoolean(BUNDLE_KEY_IS_CHEAT_BOOL,false);
            //--  Setting can change them
            mIsCheat = savedInstanceState.getBoolean(BUNDLE_KEY_IS_CHEAT_BOOL, false);
            mFontSize=savedInstanceState.getFloat(BUNDLE_KEY_FONT_SIZE,0);
            mTextView.setTextSize(mFontSize);
            mColor=savedInstanceState.getInt(BUNDLE_KEY_BACKGROUND_COLOR,0);
            mMainLay.setBackgroundColor(mColor);
            mVisibleCheck=savedInstanceState.getInt(BUNDLE_VISIBILITY_OF_CHECK_LAYOUT,0);
            mCheckLay.setVisibility(mVisibleCheck);
            mVisibleNP=savedInstanceState.getInt(BUNDLE_VISIBILITY_OF_NP_LAYOUT,0);
            mNextPrevLay.setVisibility(mVisibleNP);
            mVisibleFL=savedInstanceState.getInt(BUNDLE_VISIBILITY_OF_FL_LAYOUT,0);
            mFirstLastLay.setVisibility(mVisibleFL);
            //--
            mQuestions[mCurIndex].setCheat(mIsCheat);
            boolean[] answerState = savedInstanceState.getBooleanArray(ANSWER);
            for (int i=0; i<mQuestions.length; i++) {
                mQuestions[i].setAnswer(answerState[i]);
            }
            boolean[] cheatState = savedInstanceState.getBooleanArray(Q_IS_CHEAT);
            for (int i=0; i<mQuestions.length; i++) {
                mQuestions[i].setCheat(cheatState[i]);
            }
            updateQuestion();
        } else
            Log.d(TAG, "is null!   " + savedInstanceState);
    }
    /*

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_CHEAT) {
            mIsCheat = data.getBooleanExtra(CheatFragment.EXTRA_IS_CHEAT, false);
            mQuestions[mCurIndex].setCheat(mIsCheat);
        } else if (requestCode == REQUEST_CODE_SETTING) {
            mColor =data.getIntExtra(Setting.EXTRA_COLOR_MAIN_LAYOUT, mColor);
            if(mColor!=0)
                mMainLay.setBackgroundColor(mColor);

            mFontSize = data.getFloatExtra(Setting.EXTRA_FONT_SIZE, mFontSize);
            if(mFontSize!=0)
                mTextView.setTextSize(mFontSize);

            mVisibleNP=data.getIntExtra(Setting.EXTRA_LAY_NP,mVisibleNP);
            if(mVisibleNP!=0)
                mNextPrevLay.setVisibility(mVisibleNP);

            mVisibleCheck=data.getIntExtra(Setting.EXTRA_LAY_CHECK,mVisibleCheck);
            if(mVisibleCheck!=0)
                mCheckLay.setVisibility(mVisibleCheck);

            mVisibleFL=data.getIntExtra(Setting.EXTRA_LAY_FL,mVisibleFL);
            if(mVisibleFL!=0)
                mFirstLastLay.setVisibility(mVisibleFL);
        }
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();
        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_CHEAT) {
            mIsCheat = data.getBooleanExtra(CheatFragment.EXTRA_IS_CHEAT, false);
            mQuestions[mCurIndex].setCheat(mIsCheat);
        }
    }

    private void findElem(View view) {
        mBtnTrue = view.findViewById(R.id.btn_true);
        mBtnFalse = view.findViewById(R.id.btn_false);
        mBtnNext = view.findViewById(R.id.btn_next);
        mBtnPrev = view.findViewById(R.id.btn_prev);
        mBtnFirst = view.findViewById(R.id.btn_first_question);
        mBtnLast = view.findViewById(R.id.btn_last_question);
        mBtnRefresh = view.findViewById(R.id.btn_refresh);
        mTextView = view.findViewById(R.id.question_text);
        mFinishGameLay = view.findViewById(R.id.finish_game_lay);
        mFinishGameLay.setVisibility(View.GONE);
        mCheckLay = view.findViewById(R.id.check_lay);
        mFirstLastLay = view.findViewById(R.id.first_last_lay);
        mNextPrevLay = view.findViewById(R.id.next_prev_lay);
        mTextViewScore = view.findViewById(R.id.score_num);
        mResultLay = view.findViewById(R.id.result);
        mResultLay.setVisibility(View.GONE);
        mResultView = view.findViewById(R.id.result_text);
        mBtnCheat = view.findViewById(R.id.btn_cheat);
        mBtnSetting=view.findViewById(R.id.btn_setting);
        mMainLay=view.findViewById(R.id.main_lay);
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
                mTextView.setText(mQuestions[mQuestions.length - 1].getQuestionIn());
            }
        });

        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshGame();
            }
        });

        mBtnCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheatActivity.class);
                intent.putExtra(EXTRA_QUESTION_ANSWER, mQuestions[mCurIndex].answerCheck());
                getActivity().startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

    }

    private void updateQuestion() {
        int questionTextResId = mQuestions[mCurIndex].getQuestionIn();
        mTextView.setText(questionTextResId);
    }

    private void checkAnswer(boolean answer) {
        if (mQuestions[mCurIndex].isCheat()) {
            returnToast(R.string.do_not_judge);
        } else {
            if (answer == mQuestions[mCurIndex].answerCheck()) {
                returnToast(R.string.true_answer);
                mScoreNumber++;
            } else {
                returnToast(R.string.false_answer);
            }
            mQuestions[mCurIndex].setAnswer(true);
            mAnswerNum++;
        }
        checkFinishGame(mAnswerNum);
    }

    private void checkFinishGame(int answerNum) {
        if (answerNum == 6)
            finishGame();
    }

    public void finishGame() {
        mCheckLay.setVisibility(View.INVISIBLE);
        mNextPrevLay.setVisibility(View.INVISIBLE);
        mFirstLastLay.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
        mFinishGameLay.setVisibility(View.VISIBLE);
        mTextViewScore.setText(String.valueOf(mScoreNumber));
        mResultLay.setVisibility(View.VISIBLE);
        mBtnCheat.setVisibility(View.INVISIBLE);
        mBtnSetting.setVisibility(View.INVISIBLE);
        if (mScoreNumber < 6)
            mResultView.setText(R.string.fail);

    }

    private void refreshGame() {
        mCheckLay.setVisibility(View.VISIBLE);
        mNextPrevLay.setVisibility(View.VISIBLE);
        mFirstLastLay.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mFinishGameLay.setVisibility(View.GONE);
        mResultView.setVisibility(View.GONE);
        mBtnCheat.setVisibility(View.VISIBLE);
        mBtnSetting.setVisibility(View.VISIBLE);
        for (int i = 0; i < mQuestions.length; i++) {
            mQuestions[i].setAnswer(false);
        }
    }

    public void returnToast(int msg) {
        Toast toast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.TOP | Gravity.RIGHT, 280, 130);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // --Setting Activity can change them
        outState.putInt(BUNDLE_KEY_BACKGROUND_COLOR,mColor);
        outState.putInt(BUNDLE_VISIBILITY_OF_CHECK_LAYOUT,mVisibleCheck);
        outState.putInt(BUNDLE_VISIBILITY_OF_NP_LAYOUT,mVisibleNP);
        outState.putInt(BUNDLE_VISIBILITY_OF_FL_LAYOUT,mVisibleFL);
        outState.putFloat(BUNDLE_KEY_FONT_SIZE,mFontSize);
        //--
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_KEY_CURRENT_INDEX, mCurIndex);
        outState.putInt(BUNDLE_KEY_ANSWER_NUM, mAnswerNum);
        outState.putInt(BUNDLE_KEY_SCORE_NUM, mScoreNumber);
        outState.putBoolean(BUNDLE_KEY_IS_CHEAT_BOOL,mIsCheat);
        boolean[] qAnswered = new boolean[mQuestions.length];
        for (int i = 0; i <qAnswered.length ; i++) {
            qAnswered[i]=mQuestions[i].isAnswer();
        }

        boolean[] qIsCheat= new boolean[mQuestions.length];
        for (int i = 0; i <qIsCheat.length ; i++) {
            qIsCheat[i]=mQuestions[i].isCheat();
        }
        outState.putBooleanArray(Q_IS_CHEAT,qIsCheat);
        outState.putBooleanArray(ANSWER,qAnswered);
    }
}