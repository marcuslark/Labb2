package com.example.labb2;

public class Band extends Music {
    private String instruments;
    private int members;

    public Band(String name, String style, String instruments, int members) {
        super(name, style);
        this.instruments = instruments;
        this.members = members;
    }

    public static Band createBand(String name, String style, String instruments, int members ) {
        return new Band(name, style, instruments, members);
    }

    public int getMembers() {
        return members;
    }



    public String getInstruments() {
        return instruments;
    }
}
