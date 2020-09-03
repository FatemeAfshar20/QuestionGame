package com.example.questiongame.Controller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.SignInFragment;
import com.example.questiongame.Controller.SingleFragmentActivity;
import com.example.questiongame.R;

public class SignInActivity extends SingleFragmentActivity {
    @Override
    public Fragment getFragment() {
        return new SignInFragment();
    }
}