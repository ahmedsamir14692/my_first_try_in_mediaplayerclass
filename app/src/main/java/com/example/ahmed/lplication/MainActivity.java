package com.example.ahmed.lplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  android.transition.Scene scene1= android.transition.Scene.getSceneForLayout((FrameLayout)findViewById(R.id.fr),R.layout.set1,this);
        final android.transition.Scene scene2= android.transition.Scene.getSceneForLayout((FrameLayout)findViewById(R.id.fr),R.layout.set2,this);

        android.transition.TransitionManager transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.manger,(FrameLayout)findViewById(R.id.fr));
       findViewById(R.id.activity_main).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TransitionManager.go(scene2);
           }
       });


    }
}
