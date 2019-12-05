package com.example.learn_singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learn_singleton.databinding.ActivityMainBinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.example.learn_singleton.R.string.instance;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass instance1 = SingletonClass.getInstance();
                b.tv1.setText(getString(instance, 1, instance1.hashCode()));
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass instance2 = SingletonClass.getInstance();
                b.tv2.setText(getString(instance, 2, instance2.hashCode()));
            }
        });

        //start both the threads
        t1.start();
        t2.start();

    }
}
