package com.example.alperen.cardgame;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.content.Context;
/**
 * Created by Alperen on 23.03.2017.
 */

public class MyCard extends Button {

    int id;
    boolean isFlipped = false;
    boolean isFlipable = true;
    Drawable bg, fg = null;

    public MyCard(Context c, int id){
        super(c);
        this.id = id;
        setId(id);

        bg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card0_image);

        if (id%8 ==1) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card1_image);
        }
        if (id%8 ==2) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card2_image);
        }
        if (id%8 == 3) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card3_image);
        }
        if (id%8 == 4) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card4_image);
        }
        if (id%8 ==5) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card5_image);
        }
        if (id%8 ==6) {
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card6_image);
        }
        if (id%8 == 7){
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card7_image);
        }
        if (id%8 == 0){
            fg = AppCompatDrawableManager.get().getDrawable(c, R.drawable.card8_image);
        }

        setBackground(bg);
    }

    public void flip(){
        if (!isFlipable){
            return;
        }
        if (!isFlipped){
            setBackground(fg);
            isFlipped = true;
        }
        else {
            setBackground(bg);
            isFlipped = false;
        }

    }
}
