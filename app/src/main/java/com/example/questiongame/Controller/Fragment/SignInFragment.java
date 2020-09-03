package com.example.questiongame.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.questiongame.Model.UserInfo;
import com.example.questiongame.R;
import com.example.questiongame.Repository.UserInfoRepository;
import com.google.android.material.snackbar.Snackbar;

import static android.app.Activity.RESULT_OK;

public class SignInFragment extends Fragment {

    public static final String EXTRA_USER_INFO_SIGN = "com.example.loginpage.Controller.User Information";
    private Button mBtnSignIn;
    private EditText mPass, mUserName;
    private UserInfo mUserInfoThis = new UserInfo();
    private UserInfo mUserInfoLogin = new UserInfo();

    public SignInFragment() {
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
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        findElem(view);
        setListener();
        setTextInEditText();
        return view;
    }

    private void setTextInEditText() {
        mUserInfoLogin = getActivity().getIntent().getParcelableExtra(LoginFragment.EXTRA_USER_INFO_LOGIN);

        mUserName.setText(mUserInfoLogin.getUserName());
        mUserInfoThis.setUserName(mUserInfoLogin.getUserName());

        mPass.setText(mUserInfoLogin.getPassword());
        mUserInfoThis.setPassword(mUserInfoLogin.getPassword());
    }

    private void findElem(View view) {
        mBtnSignIn = view.findViewById(R.id.btn_sign_in_signin);
        mPass = view.findViewById(R.id.pass_sigin);
        mUserName = view.findViewById(R.id.user_name_signin);
    }

    private void setListener() {
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNumeric(mPass.getText().toString())) {
                    if (mPass.getText().toString().trim().length() > 7){
                        if (mUserName.getText().toString().length() != 0 && mPass.getText().toString().length() != 0) {
                            mUserInfoThis.setUserName(mUserName.getText().toString());
                            mUserInfoThis.setPassword(mPass.getText().toString());
                            UserInfoRepository.getInstance().createUserInfo(mUserInfoThis.getUserName(),
                                    mUserInfoThis.getPassword());
                            setInfo(UserInfoRepository.getInstance().getUserInfo());
                            getActivity().finish();
                        } else
                            returnSnackbar(view, R.string.in_correct_input);
                    }else
                        returnSnackbar(view,R.string.in_correct_length);
                } else
                    returnSnackbar(view, R.string.in_correct_pass);
            }
        });
    }

    private void setInfo(UserInfo userInfo) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USER_INFO_SIGN, userInfo);
        getActivity().setResult(RESULT_OK, intent);
    }

    public void returnSnackbar(View view, int msg) {
        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
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