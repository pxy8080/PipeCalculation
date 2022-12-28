package com.pyy.fragment;

import android.content.Context;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.errands.test.R;
import com.pyy.adapter.AdapterFunction;
import com.pyy.entity.function;

import java.util.ArrayList;
import java.util.List;

public class Fragment_calculator extends Fragment {

    private int[] icon = {R.mipmap.wantoujisuan, R.mipmap.yaotouwanjisuan, R.mipmap.laihuiwanjisuan,
            R.mipmap.santongjiewanjisuan, R.mipmap.kongjianpianzhijisuan, R.mipmap.pingxingzhuanjiaojisuan,
            R.mipmap.guandaozhuanjiao, R.mipmap.huitujisuan, R.mipmap.canshubiao};

    private String[] iconName = {"弯头计算", "摇头弯计算", "来回弯计算", "三通接弯计算", "空间偏置计算", "平行转角计算",
            "管道转角", "绘图计算", "参数表"};

    private List<function> data_list = new ArrayList<>();
    private Context context;

    public Fragment_calculator(Context context) {
        this.context = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        RecyclerView rv1 = view.findViewById(R.id.rv1);
//        GridLayoutManager manager = new GridLayoutManager(context, 3, RecyclerView.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(context, 3);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        rv1.setLayoutManager(manager);

        AdapterFunction adapter = new AdapterFunction(context, data_list,1);
        rv1.setAdapter(adapter);

        return view;
    }

    public List<function> getData() {
        data_list.clear();
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            data_list.add(new function(icon[i], iconName[i]));
        }
        return data_list;
    }

}