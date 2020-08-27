package com.example.questiongame.Controller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questiongame.Adapter.QuestionListAdapter;
import com.example.questiongame.R;
import com.example.questiongame.Repository.QuestionBankRep;

public class QuestionListFragment extends Fragment {
    RecyclerView mRecyclerView;
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new QuestionListAdapter(QuestionBankRep.getInstance().getQuestions(),getContext()));

        return view;
    }
}