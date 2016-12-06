package com.example.ahmed.lplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main3Activity extends AppCompatActivity {
    private static  int flag = 0;
    private static  int played  ;
  MediaPlayer media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        final ArrayList<Integer> songs=new ArrayList<>();
        songs.add(R.raw.ad);
        songs.add(R.raw.er);
        songs.add(R.raw.rt);
        songs.add(R.raw.t);
        played= songs.get(0);
        final ListIterator<Integer> listIterator=songs.listIterator();

        Button play= (Button) findViewById(R.id.play);
        Button next= (Button) findViewById(R.id.next);
        Button per= (Button) findViewById(R.id.per);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i;
                if(flag==0){

                view.setBackgroundResource(R.mipmap.ic_launchervbvb);
                media=MediaPlayer.create(Main3Activity.this,played);
                media.start();
                    i=1;
                }
                else
                {
                    view.setBackgroundResource(R.mipmap.ic_launcherfff);
                    media.release();
                    media=null;
i=0;
                }
                flag=i;
          }
        });

next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(flag==1&&listIterator.hasNext()){

       listIterator.next();
            if(listIterator.hasNext())
            {
            listIterator.next();
                int i=listIterator.previous();
                media.release();
                media=null;
        media=MediaPlayer.create(Main3Activity.this,i);
        media.start();
            played=i;}
            else listIterator.previous();
        }
        if(flag==0&&listIterator.hasNext())
        {
            listIterator.next();
            if(listIterator.hasNext()) {
                listIterator.next();
                int i = listIterator.previous();
                played = i;

            }
        }
    }
});
       per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1&&listIterator.hasPrevious()){
                media.release();
                media=null;
               int i=listIterator.previous();
                    media=MediaPlayer.create(Main3Activity.this,i);
                    media.start();
                    played=i;

            }
            if(flag==0&&listIterator.hasPrevious()){
                int i=listIterator.previous();
            played=i;
            }
            }

        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(flag==1) {
            media.release();
            media = null;
            flag=0;
        }
       }


    @Override
    protected void onRestart() {
        super.onRestart();
        media=MediaPlayer.create(this,played);
        media.start();
        flag=1;

    }
}
