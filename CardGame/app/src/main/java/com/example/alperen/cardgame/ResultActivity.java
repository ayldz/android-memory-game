package com.example.alperen.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Alperen on 24.03.2017.
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tV = (TextView) findViewById(R.id.textView3);
        Intent i = getIntent();
        String mistake = i.getStringExtra("mistake");
        tV.setText("Congratulations! Win with "+mistake+" mistake!");
    }
}
