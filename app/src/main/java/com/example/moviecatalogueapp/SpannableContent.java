package com.example.moviecatalogueapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;


public class SpannableContent {

    public SpannableContent() {

    }

    public Spannable getFormatedTitle(String resString) {
        Spannable title = new SpannableString(resString);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan white = new ForegroundColorSpan(Color.BLACK);
        RelativeSizeSpan font = new RelativeSizeSpan(1.2f);

        title.setSpan(boldSpan, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setSpan(white, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setSpan(font, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return title;
    }


    public Spannable getFormatedYear(String resString) {
        Spannable year = new SpannableString(resString);
        ForegroundColorSpan white = new ForegroundColorSpan(Color.GRAY);
        RelativeSizeSpan font = new RelativeSizeSpan(1.0f);

        year.setSpan(white, 0, year.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        year.setSpan(font, 0, year.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return year;
    }

}