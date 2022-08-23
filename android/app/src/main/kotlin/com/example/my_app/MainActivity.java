package com.example.my_app;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_app.ui.home.HomeFragment;
import com.example.my_app.ui.notifications.NotificationsFragment;

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
        fragmentTransaction.add(R.id.frag_container, notificationsFragment, "cart");
        fragmentTransaction.commitAllowingStateLoss();
        switchTo("home");
    }

    private HomeFragment homeFragment = new HomeFragment();

    private NotificationsFragment notificationsFragment = new NotificationsFragment();


    private void switchTo(String tag) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (tag.equals("home")) {
            fragmentTransaction.show(homeFragment);
            fragmentTransaction.hide(notificationsFragment);
//            fragmentTransaction.replace(R.id.frag_container, new HomeFragment());
        } else {
            fragmentTransaction.show(notificationsFragment);
            fragmentTransaction.hide(homeFragment);
//            fragmentTransaction.replace(R.id.frag_container, new NotificationsFragment());
        }
        fragmentTransaction.commitNowAllowingStateLoss();
    }

}
