package com.pyy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.errands.test.R;
import com.pyy.activity.MainActivity;
import com.pyy.entity.function;
import com.pyy.event.backEvent;
import com.pyy.util.BaseHandleMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class AdapterSecondStage extends RecyclerView.Adapter<AdapterSecondStage.Holder> {
    private final String sign;
    private final Context context;
    public static final int THIRD_STAGE_SIGN = 90;
    private final int last_page;
    private String title;
    private final List<Integer> imgs;

    public AdapterSecondStage(Context context, String sign, int last_page, String title) {
        this.sign = sign;
        this.context = context;
        this.last_page = last_page;
        this.title = title;
        imgs=getImg(sign);
    }

    @NonNull
    @Override
    public AdapterSecondStage.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_secondstage, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterSecondStage.Holder holder, int position) {
        holder.image.setImageResource(imgs.get(position));
        holder.image.setOnClickListener(view -> {
            try {
                BaseHandleMessage.getInstance().setHandlerMessage(THIRD_STAGE_SIGN, Integer.valueOf(sign) * 10 + position);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MainActivity.current_page = 3;
            MainActivity.last_page = last_page;
            EventBus.getDefault().post(new backEvent());
            MainActivity.title = title;
        });
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView image;

        public Holder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }


    List<Integer> getImg(String sign) {
        List<Integer> imgs = new ArrayList<>();
        if (sign.equals("10")) {
            imgs.add(R.mipmap.wantou1);
            imgs.add(R.mipmap.wantou2);
        } else if (sign.equals("11")) {
            imgs.add(R.mipmap.yaotouwan1);
            imgs.add(R.mipmap.yaotouwan2);
            imgs.add(R.mipmap.yaotouwan3);
            imgs.add(R.mipmap.yaotouwan4);
            imgs.add(R.mipmap.yaotouwan5);
            imgs.add(R.mipmap.yaotouwan6);
            imgs.add(R.mipmap.yaotouwan7);
        } else if (sign.equals("12")) {
            imgs.add(R.mipmap.laihuiwan1);
            imgs.add(R.mipmap.laihuiwan2);
            imgs.add(R.mipmap.laihuiwan3);
            imgs.add(R.mipmap.laihuiwan4);
            imgs.add(R.mipmap.laihuiwan5);
            imgs.add(R.mipmap.laihuiwan6);
        } else if (sign.equals("13")) {
            imgs.add(R.mipmap.santongjiewan1);
            imgs.add(R.mipmap.santongjiewan2);
            imgs.add(R.mipmap.santongjiewan3);
            imgs.add(R.mipmap.santongjiewan4);
            imgs.add(R.mipmap.santongjiewan5);
            imgs.add(R.mipmap.santongjiewan6);
        } else if (sign.equals("14")) {
            imgs.add(R.mipmap.kongjianlaihuiwan1);
            imgs.add(R.mipmap.kongjianlaihuiwan2);
            imgs.add(R.mipmap.kongjianlaihuiwan3);
            imgs.add(R.mipmap.kongjianlaihuiwan4);
            imgs.add(R.mipmap.kongjianyaotouwan1);
            imgs.add(R.mipmap.kongjianyaotouwan2);
            imgs.add(R.mipmap.kongjianyaotouwan3);
            imgs.add(R.mipmap.kongjianyaotouwan4);
            imgs.add(R.mipmap.kongjianyaotouwan5);
            imgs.add(R.mipmap.kongjianyaotouwan6);
        } else if (sign.equals("15")) {
            imgs.add(R.mipmap.pingxingzhuanjiao1);
            imgs.add(R.mipmap.pingxingzhuanjiao2);
        } else if (sign.equals("16")) {
            imgs.add(R.mipmap.guandaozhuanjiao1);
            imgs.add(R.mipmap.guandaozhuanjiao2);
            imgs.add(R.mipmap.guandaozhuanjiao3);
        } else if (sign.equals("17")) {
            imgs.add(R.mipmap.huitujisuan1);
        } else if (sign.equals("18")) {

        } else if (sign.equals("20")) {

        } else if (sign.equals("21")) {
            imgs.add(R.mipmap.dianquan);
            imgs.add(R.mipmap.falan);
            imgs.add(R.mipmap.famen);
            imgs.add(R.mipmap.guandao);
            imgs.add(R.mipmap.guanxie);
            imgs.add(R.mipmap.peijian);
            imgs.add(R.mipmap.qianjia);
            imgs.add(R.mipmap.tongyong);
        } else if (sign.equals("22")) {

        } else if (sign.equals("23")) {
            imgs.add(R.mipmap.sanjiao1);
            imgs.add(R.mipmap.sanjiao2);
        } else if (sign.equals("24")) {

        } else if (sign.equals("25")) {
            imgs.add(R.mipmap.laihuowanjisuanshipinjiaoxue);
            imgs.add(R.mipmap.santongjiewanjisuanshipinjiaoxue);
            imgs.add(R.mipmap.wantoujisuanshipinjiaoxue);
            imgs.add(R.mipmap.yaotouwanjisuanshipinjiaoxue);
        } else if (sign.equals("26")) {

        } else if (sign.equals("27")) {

        } else if (sign.equals("28")) {

        } else if (sign.equals("29")) {

        }
        return imgs;
    }
}
