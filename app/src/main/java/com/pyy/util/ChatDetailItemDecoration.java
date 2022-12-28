package com.pyy.util;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ChatDetailItemDecoration extends RecyclerView.ItemDecoration {
    private final int left;
    private final int right;
    private final int top;
    private final int bottom;

    public ChatDetailItemDecoration(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.top = top;
        if (parent.getChildPosition(view) == 0 || parent.getChildPosition(view) == 1)
            outRect.top = 0;
        else outRect.top = 4;
        if (parent.getChildPosition(view) % 2 == 0) {
            outRect.left = left;
            outRect.right = 0;
        } else {
            outRect.right = right;
            outRect.left = 0;
        }
    }
}
