package com.example.questiongame.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questiongame.Controller.Activity.QuestionGameActivity;
import com.example.questiongame.Controller.Activity.Setting;
import com.example.questiongame.Controller.Activity.SettingListActivity;
import com.example.questiongame.Controller.Fragment.QuestionGameFragment;
import com.example.questiongame.Model.Question;
import com.example.questiongame.Model.SettingInfo;
import com.example.questiongame.R;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.Holder> {
    List<Question> mQuestions;
    Context mContext;

    public QuestionListAdapter(List<Question> questions, Context context) {
        mQuestions = questions;
        mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.question_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.bind(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
      return mQuestions.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private TextView mQuestionText,mColorText;
        private CheckBox mAnswer;
        private ImageButton mBtnSetting;
        private SettingInfo mSettingInfo;

        public Holder(@NonNull View itemView) {
            super(itemView);
            findElem(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, QuestionGameActivity.class);
                    mContext.startActivity(intent);
                }
            });

            mBtnSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, SettingListActivity.class);
                    mContext.startActivity(intent);
                }
            });

        }

        private void findElem(View view){
            mQuestionText=view.findViewById(R.id.question_text_list);
            mBtnSetting=view.findViewById(R.id.setting_btn);
            mAnswer=view.findViewById(R.id.answer_list);
        }

        public void bind(Question question){
            mQuestionText.setText(question.getQuestionIn());
            //mColorText.setText(setting.getColorText());
            mAnswer.setChecked(question.answerCheck());
            mAnswer.setEnabled(false);
        }

    }

}
