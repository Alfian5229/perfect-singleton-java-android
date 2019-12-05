package com.example.learn_singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learn_singleton.databinding.ActivityMainBinding;

import static com.example.learn_singleton.R.string.instance;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2;
        instance2 = (SingletonClass) instance1.clone();
        b.tv1.setText(getString(instance, 1, instance1.hashCode()));
        b.tv2.setText(getString(instance, 2, instance2.hashCode()));
    }
}
