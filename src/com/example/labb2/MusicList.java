package com.example.labb2;
import java.util.ArrayList;

public class MusicList {
    private String myBand;
    private ArrayList<Band> myBands = new ArrayList<Band>();

    public MusicList(String myBand) {
        this.myBand = myBand;
        this.myBands = myBands;
    }

    public boolean addNewBand(Band band) {
        if(findBand(band.getName()) >=0) {
            System.out.println("Band already saved.");
            return false;
        }

        myBands.add(band);
        return true;
    }

    private int findBand(String bandName) {
        for(int i=0; i<this.myBands.size(); i++) {
            Band band = this.myBands.get(i);
            if(band.getName().equals(bandName)) {
                return i;
            }
        }

        return -1;
    }

    private int findBand(Band band) {
        return this.myBands.indexOf(band);
    }

    public void printMusicList() {
        System.out.println("MusicList");
        for(int i=0; i<this.myBands.size(); i++) {
            System.out.println((i+1)+". Name: "+
            this.myBands.get(i).getName()+" Style: "+
            this.myBands.get(i).getStyle()+"."+" Instruments used: "+
            this.myBands.get(i).getInstruments()+". Amount of members in the band: "+
            this.myBands.get(i).getMembers());
        }
    }
}
