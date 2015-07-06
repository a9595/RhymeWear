package com.tieorange.rhymewear;


public class Rhyme {
    // http://rhymebrain.com/talk?function=getRhymes&word=about

    private String flags;
    private Number freq;
    private Number score;
    private String syllables;
    private String word;

    public String getFlags() {
        return this.flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public Number getFreq() {
        return this.freq;
    }

    public void setFreq(Number freq) {
        this.freq = freq;
    }

    public Number getScore() {
        return this.score;
    }

    public void setScore(Number score) {
        this.score = score;
    }

    public String getSyllables() {
        return this.syllables;
    }

    public void setSyllables(String syllables) {
        this.syllables = syllables;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
