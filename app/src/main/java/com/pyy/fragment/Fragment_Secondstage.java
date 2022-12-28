package com.pyy.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.errands.test.R;
import com.pyy.adapter.AdapterSecondStage;
import com.pyy.util.ChatDetailItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Secondstage extends Fragment {
    private String sign;
    private Context context;
    private String title;

    public Fragment_Secondstage(Context context, String sign, String title) {
        this.context = context;
        this.sign = sign;
        this.title = title;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondstage, container, false);
        TextView tv_title = view.findViewById(R.id.title);
        tv_title.setText(title);
        RecyclerView rv = view.findViewById(R.id.rv);
        GridLayoutManager manager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rv.addItemDecoration(new ChatDetailItemDecoration(50, 50, 15, 15));
        rv.setLayoutManager(manager);
        AdapterSecondStage adapter = new AdapterSecondStage(context, sign, 1, title);
        rv.setAdapter(adapter);
        return view;
    }


}