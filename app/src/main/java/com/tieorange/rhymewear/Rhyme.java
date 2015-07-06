package com.tieorange.rhymewear;

public class Rhyme {

    public Rhyme(int iconRes, String title) {
        this.iconRes = iconRes;
        this.title = title;
    }

    public Rhyme(String title) {
        this.title = title;
        this.iconRes = R.drawable.ic_full_cancel;
    }

    public int iconRes;
    public String title;

}