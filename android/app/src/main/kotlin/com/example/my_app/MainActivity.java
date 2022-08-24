package com.example.my_app;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import io.flutter.embedding.android.FlutterFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo("home");
            }
        });
        findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo("cart");
            }
        });

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_container, homeFragment, "home");
        fragmentTransaction.add(R.id.frag_container, flutterFragment, "cart");
        fragmentTransaction.commit();
        switchTo("home");
    }

    private final HomeFragment homeFragment = new HomeFragment();

    private final FlutterFragment flutterFragment = FlutterFragment.withNewEngine()
            .build();

    private void switchTo(String tag) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (tag.equals("home")) {
            fragmentTransaction.show(homeFragment);
            fragmentTransaction.hide(flutterFragment);
        } else {
            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.show(flutterFragment);
        }
        fragmentTransaction.commit();
    }

}
