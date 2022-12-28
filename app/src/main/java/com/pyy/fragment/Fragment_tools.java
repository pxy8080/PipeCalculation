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

public class Fragment_tools extends Fragment {
    private int[] icon = {R.mipmap.guandaochaxun, R.mipmap.guandaocidian, R.mipmap.zhishiku, R.mipmap.sanjiaojisuan,
            R.mipmap.kexuejisuan, R.mipmap.shipinjiaoxue, R.mipmap.wenyiwen, R.mipmap.zhaorenzhaohuo,
            R.mipmap.guanjianshangcheng, R.mipmap.zaixiankefu};

    private String[] iconName = {"管道查询", "管道词典", "知识库", "三角计算", "科学计算", "视频教学",
            "问一问", "找人找活", "管件商城", "在线客服"};

    private List<function> data_list = new ArrayList<>();
    private Context context;

    public Fragment_tools(Context context) {
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
        GridLayoutManager manager = new GridLayoutManager(context, 3, RecyclerView.VERTICAL, false);
        rv1.setLayoutManager(manager);
        AdapterFunction adapter = new AdapterFunction(context, data_list,2);
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