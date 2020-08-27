package com.example.questiongame.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.CheatFragment;
import com.example.questiongame.R;

public class CheatActivity extends AppCompatActivity {
    private CheatFragment mCheatFrag=new CheatFragment();
    private FragmentManager mFragmentManager=getSupportFragmentManager();
    private Fragment mFragment=new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mFragment=mFragmentManager.findFragmentById(R.id.fragment_cheat);

        if(mFragment==null){
            mFragmentManager.beginTransaction().add(R.id.fragment_cheat,mCheatFrag).commit();
        }

    }


}