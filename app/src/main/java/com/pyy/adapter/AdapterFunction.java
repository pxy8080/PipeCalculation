package com.pyy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.errands.test.R;
import com.pyy.activity.MainActivity;
import com.pyy.entity.function;
import com.pyy.event.backEvent;
import com.pyy.util.BaseHandleMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class AdapterFunction extends RecyclerView.Adapter<AdapterFunction.Holder> {
    private final Context context;
    private final List<function> data_list;
    public static final int SECOND_STAGE_SIGN = 80;
    private final int last_page;

    public AdapterFunction(Context context, List<function> data_list, int last_page) {
        this.context = context;
        this.data_list = data_list;
        this.last_page = last_page;
    }

    @NonNull
    @Override
    public AdapterFunction.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_calculator, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFunction.Holder holder, int position) {

        holder.image.setImageResource(data_list.get(position).getIcon());
        holder.text.setText(data_list.get(position).getName());
        holder.image.setOnClickListener(view -> {
                    BaseHandleMessage.getInstance().setHandlerMessage(SECOND_STAGE_SIGN, MainActivity.last_page * 10 + position);
                    MainActivity.current_page = 2;
                    MainActivity.title = data_list.get(position).getName();
                    MainActivity.sign = String.valueOf(position);
                    MainActivity.last_page = last_page;
                    EventBus.getDefault().post(new backEvent());
                }
        );
    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    protected static class Holder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }
}
