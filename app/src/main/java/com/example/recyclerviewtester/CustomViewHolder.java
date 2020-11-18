package com.example.recyclerviewtester;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class CustomViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public CustomViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.oyaebu);
    }

    public TextView getTextView() {
        return textView;
    }

    public void bind(String s) {
        textView.setText(s);
    }
}
