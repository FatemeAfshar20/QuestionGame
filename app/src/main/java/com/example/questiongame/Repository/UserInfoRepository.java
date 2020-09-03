package com.example.questiongame.Repository;

import com.example.questiongame.Model.UserInfo;

public class UserInfoRepository {
    private static UserInfoRepository sInstance;
    private UserInfo mUserInfo=new UserInfo();

    private UserInfoRepository() {
        createUserInfo("","");
    }

    public void createUserInfo(String name,String password){
        mUserInfo.setUserName(name);
        mUserInfo.setPassword(password);
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public static UserInfoRepository getInstance(){
        if(sInstance==null)
            sInstance=new UserInfoRepository();
        return sInstance;
    }
}
