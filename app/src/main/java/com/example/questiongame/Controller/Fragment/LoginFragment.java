package com.example.questiongame.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.questiongame.Controller.Activity.QuestionGameActivity;
import com.example.questiongame.Model.UserInfo;
import com.example.questiongame.Controller.Activity.QuestionListActivity;
import com.example.questiongame.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    public static final String EXTRA_LOGIN_INFORMATION = "Login Information";
    private EditText mUsername,mPassword;
    private MaterialButton mBtnLogin;
    private UserInfo mUser=new UserInfo();
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
        return view;
    }

    public void findElem(View view){
        mUsername=view.findViewById(R.id.username);
        mPassword=view.findViewById(R.id.password);
        mBtnLogin=view.findViewById(R.id.login);
    }

    public void setListener(){
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserLogin== null) {
                    if (mPassword.getText().toString().trim().length() > 7) {
                        if (mUsername.getText().toString().length() != 0 && mPassword.getText().toString().length() != 0) {
                            setInfo();
                        } else
                            returnSnackbar(v, R.string.incorrect_input);
                    } else
                        returnSnackbar(v, R.string.incorrect_length);
                }else if(isCorrectInfo()){
                    setInfo();
                }else
                    returnSnackbar(v,R.string.invalid_info);
            }
        });
    }

    private void setInfo() {
        mUser.setUserName(mUsername.getText().toString());
        mUser.setPassword(mPassword.getText().toString());
/*        Intent intent = new Intent();
        intent.putExtra(EXTRA_LOGIN_INFORMATION, mUser);
        startActivity(intent);*/
        Intent intent1=new Intent(getActivity(), QuestionListActivity.class);
        startActivity(intent1);
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

    private boolean isCorrectInfo(){
        if(mUsername.getText().toString().equals(mUserLogin.getUserName())
                && mPassword.getText().toString().equals(mUserLogin.getPassword()))
            return true;
        return false;
    }
}