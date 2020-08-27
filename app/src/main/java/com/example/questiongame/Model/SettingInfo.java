package com.example.questiongame.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class SettingInfo implements Parcelable {
    private float mFontSize;
    private int mColor;
    private int mColorText;
    private int mLayNP;
    private int mLaySS;
    private int mLayCheck;

    public SettingInfo(Parcel in) {
        this.mColor=in.readInt();
        this.mColorText=in.readInt();
        this.mFontSize=in.readFloat();
        this.mLayNP =in.readInt();
        this.mLaySS=in.readInt();
        this.mLayCheck=in.readInt();
    }


    public SettingInfo(float fontSize, int color, int colorText, int layNP, int laySS, int layCheck) {
        mFontSize = fontSize;
        mColor = color;
        mColorText = colorText;
        mLayNP = layNP;
        mLaySS=laySS;
        mLaySS=layCheck;
    }

    public SettingInfo(){

    }

    public float getFontSize() {
        return mFontSize;
    }

    public void setFontSize(float fontSize) {
        mFontSize = fontSize;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public int getColorText() {
        return mColorText;
    }

    public void setColorText(int colorText) {
        mColorText = colorText;
    }

    public int getLayNP() {
        return mLayNP;
    }

    public void setLayNP(int layNP) {
        mLayNP = layNP;
    }

    public int getLaySS() {
        return mLaySS;
    }

    public void setLaySS(int laySS) {
        mLaySS = laySS;
    }

    public int getLayCheck() {
        return mLayCheck;
    }

    public void setLayCheck(int layCheck) {
        mLayCheck = layCheck;
    }

    public static final Creator<SettingInfo> CREATOR = new Creator<SettingInfo>() {
        @Override
        public SettingInfo createFromParcel(Parcel in) {
            return new SettingInfo(in);
        }
        @Override
        public SettingInfo[] newArray(int size) {
            return new SettingInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mColor);
        dest.writeInt(this.mColorText);
        dest.writeFloat(this.mFontSize);
        dest.writeInt(this.mLayNP);
        dest.writeInt(this.mLaySS);
        dest.writeInt(this.mLayCheck);
    }

}

