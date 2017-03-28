package com.example.alperen.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by Alperen on 23.03.2017.
 */

public class GameActivity extends AppCompatActivity {

    MyCard lastClick = null;
    int match = 0;
    int mistake = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent i = getIntent();
        String username = i.getStringExtra("myName");

        TextView tV = (TextView) findViewById(R.id.textView);
        tV.setText("Welcome "+username);

        GridLayout cards = (GridLayout) findViewById(R.id.cardLayout);

        MyCard deck[] = new MyCard[16];

        for (int j = 0; j<16 ; j++){
            deck[j] = new MyCard(this, j);
        }

        //karistir
        for (int j = 0; j<16; j++){
            int r = (int)(Math.random()*16);

            MyCard temp = deck[r];
            deck[r] = deck[j];
            deck[j] = temp;
        }

        for (int j = 0; j<16; j++)
        {
            final MyCard temp = deck[j];

            cards.addView(temp);
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastClick!=null){
                        temp.flip();

                        if (temp.id!=lastClick.id && temp.id%8 == lastClick.id%8){
                            temp.isFlipable = false;
                            lastClick.isFlipable = false;
                            lastClick = null;

                            match++;

                            if (match == 8)
                            {
                                Intent i = new Intent(GameActivity.this, ResultActivity.class);
                                i.putExtra("mistake", mistake);
                                startActivity(i);
                            }
                        }
                        else {

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    lastClick.flip();
                                    lastClick = null;
                                    temp.flip();
                                }
                            },500);

                            mistake++;
                        }
                    }
                    else {
                        temp.flip();

                        lastClick = temp;
                    }
                }
            });
        }
    }
}
