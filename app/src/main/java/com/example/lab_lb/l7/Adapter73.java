package com.example.lab_lb.l7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_lb.R;

import java.util.List;

public class Adapter73 extends RecyclerView.Adapter<Adapter73.ViewHolder>{

    private final LayoutInflater inflater;

    private final List<MsgButton> mass;

    private Context context;

    private final OnStateClickListener onClickListener;

public interface OnStateClickListener{
    void onStateClick(int position);
}

    public Adapter73(Context context, List<MsgButton> states, OnStateClickListener onClickListener) {
        this.mass = states;
        this.onClickListener = onClickListener;
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public Adapter73.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter73, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter73.ViewHolder holder, int position) {
        MsgButton str = mass.get(position);

        holder.nameView.setText(str.getText());
        holder.nameView.setBackgroundColor(str.getColor());

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
    final Button nameView;

    ViewHolder(View view){
        super(view);
        nameView =  view.findViewById(R.id.text);

    }
}
}