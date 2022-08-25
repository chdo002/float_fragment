package com.example.my_app;

import android.util.Log;

import io.flutter.embedding.android.FlutterFragment;

public class MyFlutterFragment extends FlutterFragment {
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("----->","hidden");
    }
}
