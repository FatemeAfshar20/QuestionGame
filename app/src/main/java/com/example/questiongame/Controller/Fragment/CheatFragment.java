package com.example.questiongame.Controller.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.questiongame.R;

public class CheatFragment extends Fragment {
    public static final String EXTRA_IS_CHEAT = "com.example.questiongame.Controller.IsCheat";
    private Button mBtnCheat, mBtnGoBack;
    private TextView mShowAnswer;
    private boolean checkAnswer;


    public CheatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_cheat, container, false);
        checkAnswer =getActivity(). getIntent().getBooleanExtra(QuestionGameFragment.EXTRA_QUESTION_ANSWER, false);
        findElem(view);
        setListener();
        return view;
    }

    private void findElem(View view) {
        mBtnCheat = view.findViewById(R.id.btn_cheat);
        mBtnGoBack = view.findViewById(R.id.btn_go_back);
        mShowAnswer = view.findViewById(R.id.answer);
    }

    private void setListener() {
        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getActivity().onBackPressed();
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
        getActivity().setResult(Activity.RESULT_OK, date);

    }
}