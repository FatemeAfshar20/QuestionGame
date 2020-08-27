package com.example.questiongame.Repository;

import com.example.questiongame.Model.Question;
import com.example.questiongame.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionBankRep {
    private static QuestionBankRep sInstance;
    private List<Question> mQuestions=new ArrayList<>();
    private Question[] mQuestion = {
            new Question(R.string.question_africa, true, false, false),
            new Question(R.string.question_asia, false, false, false),
            new Question(R.string.question_americas, false, false, false),
            new Question(R.string.question_mideast, false, false, false),
            new Question(R.string.question_oceans, true, false, false),
            new Question(R.string.question_australia, false, false, false),
            new Question(R.string.question_africa, true, false, false),
            new Question(R.string.question_asia, false, false, false),
            new Question(R.string.question_americas, false, false, false),
            new Question(R.string.question_mideast, false, false, false),
            new Question(R.string.question_oceans, true, false, false),
            new Question(R.string.question_australia, false, false, false),
            new Question(R.string.question_africa, true, false, false),
            new Question(R.string.question_asia, false, false, false),
            new Question(R.string.question_americas, false, false, false),
            new Question(R.string.question_mideast, false, false, false),
            new Question(R.string.question_oceans, true, false, false),
            new Question(R.string.question_australia, false, false, false),
            new Question(R.string.question_africa, true, false, false),
            new Question(R.string.question_asia, false, false, false),
            new Question(R.string.question_americas, false, false, false),
            new Question(R.string.question_mideast, false, false, false),
            new Question(R.string.question_oceans, true, false, false),
            new Question(R.string.question_australia, false, false, false)
    };

    public List<Question> getQuestions() {
        return mQuestions;
    }

    private void initQuestion(){
        mQuestions.addAll(Arrays.asList(mQuestion));
    }

    private QuestionBankRep() {
        initQuestion();
    }

    public static QuestionBankRep getInstance() {
        if(sInstance==null)
            sInstance=new QuestionBankRep();
        return sInstance;
    }
}
