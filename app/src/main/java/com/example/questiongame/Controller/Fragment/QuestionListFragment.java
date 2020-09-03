package com.example.questiongame.Controller.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questiongame.Adapter.QuestionListAdapter;
import com.example.questiongame.Model.UserInfo;
import com.example.questiongame.R;
import com.example.questiongame.Repository.QuestionBankRep;
import com.google.android.material.textview.MaterialTextView;

public class QuestionListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MaterialTextView mTextUsername;
    public QuestionListFragment() {
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
        View view= inflater.inflate(R.layout.fragment_question_list, container, false);
        mRecyclerView=view.findViewById(R.id.recycler_view);

        if(getActivity().getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        else
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setAdapter(new QuestionListAdapter(QuestionBankRep.getInstance().getQuestions(),getContext()));

        findElem(view);
        setInfo();

        return view;
    }

    private void setInfo() {
        UserInfo userInfo=getActivity().getIntent().getParcelableExtra(LoginFragment.EXTRA_USER_LOGIN);
        mTextUsername.setText(userInfo.getUserName());
    }

    private void findElem(View view) {
        mTextUsername=view.findViewById(R.id.username);
    }
}