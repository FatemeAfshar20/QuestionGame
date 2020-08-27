package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.LoginFragment;
import com.example.questiongame.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_login);
        if(fragment==null)
            fragmentManager.beginTransaction().add(R.id.fragment_login,new LoginFragment()).commit();
    }
}