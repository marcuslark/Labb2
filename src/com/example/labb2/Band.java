package com.example.labb2;

public class Band extends Music {
    private String instruments;
    private int members;

    public Band(String name, String style, String instruments, int members) {
        super(name, style);
        this.instruments = instruments;
        this.members = members;
    }

    public int getMembers() {
        return members;
    }

    public String getInstruments() {
        return instruments;
    }
}
