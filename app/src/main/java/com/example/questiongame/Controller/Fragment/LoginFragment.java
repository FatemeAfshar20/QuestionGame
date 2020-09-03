package com.example.questiongame.Controller.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.questiongame.Controller.Activity.QuestionGameActivity;
import com.example.questiongame.Controller.Activity.SignInActivity;
import com.example.questiongame.Model.UserInfo;
import com.example.questiongame.Controller.Activity.QuestionListActivity;
import com.example.questiongame.R;
import com.example.questiongame.Repository.UserInfoRepository;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import static android.app.Activity.RESULT_OK;

public class LoginFragment extends Fragment {

    public static final String EXTRA_USER_INFO_LOGIN = "com.example.loginpage.Controller.User Input Information";
    public static final String EXTRA_USER_LOGIN = "com.example.loginpage.Controller.User Login Information";
    public static final String BUNDLE_USER_INFO = "User Login Information (Save Instance)";

    private Button mBtnLogin, mBtnSignIn;
    private EditText mPass, mUserName;
    private int REQUEST_CODE_SIGNIN = 1;
    private UserInfo mUserInfoLogin =new UserInfo();
    private UserInfo mUserInfoSignIn =new UserInfo();
    private UserInfo mUserLogin=new UserInfo();

    public LoginFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        mUserLogin=getActivity().getIntent().getParcelableExtra(QuestionGameFragment.EXTRA_LOGIN_INFO);
        findElem(view);
        setListener();
        saveUserInformation(savedInstanceState);
        return view;
    }


    private void findElem(View view) {
        mBtnLogin = view.findViewById(R.id.login);
        mBtnSignIn =view.findViewById(R.id.sign_in);
        mPass =view.findViewById(R.id.password);
        mUserName =view.findViewById(R.id.user_name);
    }

    private void setListener() {
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNumeric(mPass.getText().toString())) {
                    mUserInfoLogin.setUserName(mUserName.getText().toString());
                    mUserInfoLogin.setPassword(mPass.getText().toString());
                    Intent intent = new Intent(getActivity(), SignInActivity.class);
                    intent.putExtra(EXTRA_USER_INFO_LOGIN, mUserInfoLogin);
                    startActivityForResult(intent, REQUEST_CODE_SIGNIN);
                }
                else
                    returnSnackbar(view,R.string.in_correct_pass);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCorrectInfo(mUserInfoSignIn) ||
                        isCorrectInfo(UserInfoRepository.getInstance().getUserInfo())) {
                    returnSnackbar(v, R.string.success_login);
                    setIntent(mUserInfoSignIn);
                }else
                    returnSnackbar(v,R.string.fail_login);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_SIGNIN) {
            mUserInfoSignIn=data.getParcelableExtra(SignInFragment.EXTRA_USER_INFO_SIGN);
            if(mUserInfoSignIn!=null)
                setUserInfo(mUserInfoSignIn);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_USER_INFO,mUserInfoSignIn);
    }

    public void saveUserInformation(Bundle bundle){
        if(bundle!=null) {
            mUserInfoSignIn = bundle.getParcelable(BUNDLE_USER_INFO);
            setUserInfo(mUserInfoLogin);
        }
    }

    private void setUserInfo(UserInfo userInfo) {
        mPass.setText(userInfo.getPassword());
        mUserName.setText(userInfo.getUserName());
    }

    private void setIntent(UserInfo userInfo) {
        Intent intent = new Intent(getActivity(),QuestionListActivity.class);
        intent.putExtra(EXTRA_USER_LOGIN, userInfo);
        startActivity(intent);
    }

    private boolean isCorrectInfo(UserInfo userInfo) {
        if (mUserName.getText().toString().equals(userInfo.getUserName()) &&
                mPass.getText().toString().equals(userInfo.getPassword())) {
            return true;
        }
        return false;
    }


    public void returnSnackbar(View view,int msg) {
        Snackbar snackbar=Snackbar.make(view,msg,Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private static boolean isNumeric(String strNum) {
        for (char c : strNum.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}