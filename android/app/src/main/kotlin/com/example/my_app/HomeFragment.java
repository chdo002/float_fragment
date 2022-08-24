package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.my_app.DetailActivity;
import com.example.my_app.R;

public class HomeFragment extends Fragment {

    private Intent getIntentByClass(Class cls) {
        return new Intent(getActivity(), cls);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.text_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getIntentByClass(DetailActivity.class));
            }
        });
        return view;
    }
}