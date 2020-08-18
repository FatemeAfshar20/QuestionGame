package com.example.questiongame.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class SettingInfo implements Parcelable {
    private float mFontSize;
    private int mColor;
    private String mLayName;

    public SettingInfo(Parcel in) {
        this.mColor=in.readInt();
        this.mFontSize=in.readFloat();
        this.mLayName =in.readString();
    }

    public SettingInfo(float fontSize, int color, String layName) {
        mFontSize = fontSize;
        mColor = color;
        mLayName = layName;
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

    public String getLayName() {
        return mLayName;
    }

    public void setLayName(String layName) {
        mLayName = layName;
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
        dest.writeFloat(this.mFontSize);
        dest.writeString(this.mLayName);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingInfo that = (SettingInfo) o;
        return Objects.equals(mLayName, that.mLayName);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(mLayName);
    }
}

