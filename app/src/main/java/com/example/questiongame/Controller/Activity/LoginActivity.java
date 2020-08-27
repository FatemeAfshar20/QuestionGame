package com.example.questiongame.Controller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.LoginFragment;
import com.example.questiongame.Controller.SingleFragmentActivity;
import com.example.questiongame.R;

public class LoginActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return new LoginFragment();
    }

}