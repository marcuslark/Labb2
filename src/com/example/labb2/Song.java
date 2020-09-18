package com.example.labb2;

public class Song extends Music {
    private String length;

    public Song(String name, String style, String length) {
        super(name, style);
        this.length = length;
    }

    public String getLength() {
        return length;
    }
}
