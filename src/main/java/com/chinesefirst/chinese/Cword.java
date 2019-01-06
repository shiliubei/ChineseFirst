package com.chinesefirst.chinese;

public class Cword {
    private String hieroglyph;
    private String meaning;



    public Cword(String hieroglyph, String meaning) {
        this.hieroglyph = hieroglyph;
        this.meaning = meaning;
    }
    public Cword() {

    }

    public String getHieroglyph() { return hieroglyph; }
    public void setHieroglyph(String hieroglyph) { this.hieroglyph = hieroglyph; }
    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

}
