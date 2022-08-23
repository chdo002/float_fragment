package com.example.my_app.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.my_app.R;

import io.flutter.embedding.android.FlutterFragment;

public class NotificationsFragment extends Fragment {


    private FlutterFragment mRepGoalsFlutterFragment1;
    private static final String TAG_REP_GOALS_FLUTTER_FRAGMENT_1 = "FLUTTER_FRAGMENT_TAG_1";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (mRepGoalsFlutterFragment1 == null) {
            mRepGoalsFlutterFragment1 = FlutterFragment.withNewEngine()
                    .build();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.card_view7,
                            mRepGoalsFlutterFragment1,
                            TAG_REP_GOALS_FLUTTER_FRAGMENT_1)
                    .commit();
        }

        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }
}