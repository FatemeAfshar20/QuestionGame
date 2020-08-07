package com.example.questiongame.Model;

public class Question {
    private int mQuestionIn;
    private boolean mIsTrue;
    private boolean mIsAnswer;

    public int getQuestionIn() {
        return mQuestionIn;
    }

    public void setQuestionIn(int questionIn) {
        mQuestionIn = questionIn;
    }

    public boolean isTrue() {
        return mIsTrue;
    }

    public void setTrue(boolean aTrue) {
        mIsTrue = aTrue;
    }

    public boolean isAnswer() {
        return mIsAnswer;
    }

    public void setAnswer(boolean answer) {
        mIsAnswer = answer;
    }

    public Question(int questionIn, boolean isTrue, boolean isAnswer) {
        mQuestionIn = questionIn;
        mIsTrue = isTrue;
        mIsAnswer = isAnswer;
    }

    public Question() {
    }
}
