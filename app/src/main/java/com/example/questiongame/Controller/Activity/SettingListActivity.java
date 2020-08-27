package com.example.questiongame.Controller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.questiongame.Controller.Fragment.SettingListFragment;
import com.example.questiongame.Controller.SingleFragmentActivity;

public class SettingListActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return new SettingListFragment();
    }
}