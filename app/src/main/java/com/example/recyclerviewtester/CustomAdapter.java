package com.example.recyclerviewtester;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<String> localDataSet = new ArrayList<>();

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_xml, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(localDataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void updateStrings(List<String> whatever) {
        localDataSet.clear();
        localDataSet.addAll(whatever);
        notifyDataSetChanged();
    }
}
