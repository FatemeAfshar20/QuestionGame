package com.example.questiongame.Controller;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.questiongame.Controller.Fragment.LoginFragment;
import com.example.questiongame.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment getFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_fragmwnr);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment==null)
            fragmentManager.beginTransaction().add(R.id.fragment_container,getFragment()).commit();
    }
}
