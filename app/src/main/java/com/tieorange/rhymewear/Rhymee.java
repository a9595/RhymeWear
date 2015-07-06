package com.tieorange.rhymewear;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tieorange on 7/6/2015.
 */
public class Rhymee {

    @SerializedName("syllables")
    private String syllables;

    @SerializedName("flags")
    private String flags;

    @SerializedName("freq")
    private String freq;

    @SerializedName("score")
    private String score;

    @SerializedName("word")
    private String word;

    public String getSyllables() {
        return syllables;
    }

    public void setSyllables(String syllables) {
        this.syllables = syllables;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "ClassPojo [syllables = " + syllables + ", flags = " + flags + ", freq = " + freq + ", score = " + score + ", word = " + word + "]";
    }
}
