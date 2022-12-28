package com.pyy.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.errands.test.R;
import com.pyy.event.ShowToastEvent;

import org.greenrobot.eventbus.EventBus;


public class Fragment_me extends Fragment implements View.OnClickListener {
    public Fragment_me() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        LinearLayout op1 = view.findViewById(R.id.op1);
        TextView op2 = view.findViewById(R.id.op2);
        TextView op3 = view.findViewById(R.id.op3);
        TextView op4 = view.findViewById(R.id.op4);
        TextView op5 = view.findViewById(R.id.op5);
        TextView op6 = view.findViewById(R.id.op6);
        TextView op7 = view.findViewById(R.id.op7);
        TextView op8 = view.findViewById(R.id.op8);

        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);
        op4.setOnClickListener(this);
        op5.setOnClickListener(this);
        op6.setOnClickListener(this);
        op7.setOnClickListener(this);
        op8.setOnClickListener(this);
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.op1:
                Toast.makeText(getContext(), "点击操作1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op2:
                Toast.makeText(getContext(), "点击操作2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op3:
                Toast.makeText(getContext(), "点击操作3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op4:
                Toast.makeText(getContext(), "点击操作4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op5:
                Toast.makeText(getContext(), "点击操作5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op6:
                Toast.makeText(getContext(), "点击操作6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op7:
                Toast.makeText(getContext(), "点击操作7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.op8:
                Toast.makeText(getContext(), "点击操作8", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }
    }

    @Override
    public void onDestroyView() {
//        if (EventBus.getDefault().isRegistered(this))
//            EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }
}