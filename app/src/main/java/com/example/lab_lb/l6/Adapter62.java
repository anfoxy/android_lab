package com.example.lab_lb.l6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_lb.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter62 extends RecyclerView.Adapter<Adapter62.ViewHolder>{

    private final LayoutInflater inflater;

    private final List<String> mass;

    private Context context;

    private final OnStateClickListener onClickListener;

public interface OnStateClickListener{
    void onStateClick(int position);
}

    public Adapter62(Context context, List<String> states, OnStateClickListener onClickListener) {
        this.mass = states;
        this.onClickListener = onClickListener;
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public Adapter62.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter62, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter62.ViewHolder holder, int position) {
        String str = mass.get(position);

        holder.nameView.setText(str);


        holder.nameView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onClickListener.onStateClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mass.size();
    }
public static class ViewHolder extends RecyclerView.ViewHolder {
    final TextView nameView;

    ViewHolder(View view){
        super(view);
        nameView = (TextView) view.findViewById(R.id.text);

    }
}
}