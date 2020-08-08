package com.example.questiongame.Model;

public class Question {
    private int mQuestionIn;
    private boolean mAnswerCheck;
    private boolean mIsAnswer;
    private  boolean mIsCheat;

    public boolean isCheat() {
        return mIsCheat;
    }

    public void setCheat(boolean cheat) {
        mIsCheat = cheat;
    }

    public int getQuestionIn() {
        return mQuestionIn;
    }

    public void setQuestionIn(int questionIn) {
        mQuestionIn = questionIn;
    }

    public boolean answerCheck() {
        return mAnswerCheck;
    }

    public void setAnswerCheck(boolean answerCheck) {
        mAnswerCheck = answerCheck;
    }

    public boolean isAnswer() {
        return mIsAnswer;
    }

    public void setAnswer(boolean answer) {
        mIsAnswer = answer;
    }

    public Question(int questionIn, boolean isTrue, boolean isAnswer,boolean isCheat) {
        mQuestionIn = questionIn;
        mAnswerCheck = isTrue;
        mIsAnswer = isAnswer;
        mIsCheat=isCheat;
    }

    public Question() {
    }
}
