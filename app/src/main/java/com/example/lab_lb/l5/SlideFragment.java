package com.example.lab_lb.l5;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab_lb.R;

public class SlideFragment extends Fragment {

    private String body = "null";

    public SlideFragment() {
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_task, container, false);
        TextView textView = view.findViewById(R.id.L6WTTV);
        textView.setText((CharSequence) body);
        return view;
    }
}
