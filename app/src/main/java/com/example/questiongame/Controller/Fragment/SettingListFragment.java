package com.example.questiongame.Controller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.questiongame.Model.SettingInfo;
import com.example.questiongame.R;

public class SettingListFragment extends Fragment {
    public static SettingInfo sSettingInfo=new SettingInfo();
    private Button mBtnSmall,mBtnLarge,mBtnMedium,mBtnColorPink,mBtnColorPinkL,mBtnColorPurple,mBtnColorPurpleL,mBtnColorWhite;
    private ImageButton mBtnGoBack;

    public SettingListFragment() {
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
        View view= inflater.inflate(R.layout.setting_list, container, false);
        findElem(view);
        setListener();
        return view;
    }

    private void findElem(View view){
        mBtnLarge=view.findViewById(R.id.btn_large_font);
        mBtnSmall=view.findViewById(R.id.btn_small_font);
        mBtnMedium=view.findViewById(R.id.btn_medium_font);
        mBtnColorPink=view.findViewById(R.id.btn_color_text_pink);
        mBtnColorPinkL=view.findViewById(R.id.btn_color_text_pinkl);
        mBtnColorPurple=view.findViewById(R.id.btn_color_text_purple);
        mBtnColorPurpleL=view.findViewById(R.id.btn_color_text_pl);
        mBtnColorWhite=view.findViewById(R.id.btn_color_text_white);
        mBtnGoBack=view.findViewById(R.id.btn_go_back);
    }

    private void setListener() {
        mBtnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setFontSize(14);
            }
        });

        mBtnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setFontSize(26);
            }
        });

        mBtnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setFontSize(18);
            }
        });

        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        mBtnColorPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setColorText(getResources().getColor(R.color.beauty_pink));
            }
        });

        mBtnColorPurpleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setColorText(getResources().getColor(R.color.beauty_so_pl));
            }
        });

        mBtnColorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setColorText(getResources().getColor(R.color.beauty_purple_light));
            }
        });

        mBtnColorPinkL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sSettingInfo.setColorText(getResources().getColor(R.color.beauty_pink_light));
            }
        });

        mBtnColorWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sSettingInfo.setColorText(getResources().getColor(R.color.black));
            }
        });

    }

}