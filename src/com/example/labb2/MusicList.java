package com.example.labb2;
import java.util.ArrayList;

public class MusicList {
    private ArrayList<Band> myBands = new ArrayList<Band>();
    private ArrayList<Band> myFavorites = new ArrayList<>();

    //Method favoriteBand returns a Band from the arrayList "myBands"
    public Band favoriteBand(int bandPosition) {
        return myBands.get(bandPosition);
    }

    public void addNewFavoriteBand(Band band) {
        myFavorites.add(band);
    }

    public boolean addNewBand(Band band) {
        if(findBand(band.getName()) >=0) {
            System.out.println("Band already saved.");
            return false;
        }

        myBands.add(band);
        return true;
    }

    public String bandName(Band band) {
        if(findBand(band) >=0) {
            return band.getName();
        }

        return null;
    }

    public Band bandName(String name) {
        int position = findBand(name);
        if(position>=0) {
            return this.myBands.get(position);
        }

        return null;
    }
    //Method updateBand uses the method "findBand" to find the already existing band, and then changes it to the new band.
    public boolean updateBand(Band oldBand, Band newBand) {
        int foundPosition = findBand(oldBand);
        if(foundPosition<0) {
            System.out.println(oldBand.getName()+", was not found.");
            return false;
        }

        this.myBands.set(foundPosition, newBand);
        System.out.println(oldBand.getName()+", have been updated to "+newBand.getName());
        return true;
    }
    //Method removeBand uses the method "findBand" to find the already existing band, if it's found it will be deleted.
    public boolean removeBand(Band band) {
        int foundPosition = findBand(band);
        if(foundPosition<0) {
            System.out.println(band.getName()+" Oops! Could not find a band with that name!");
            return false;
        }
        this.myBands.remove(foundPosition);
        System.out.println(band.getName()+"-> removed.");
        System.out.println();
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
        System.out.println();
        for(int i=0; i<this.myBands.size(); i++) {
            System.out.println((i+1)+". Name: "+
            this.myBands.get(i).getName()+" Style: "+
            this.myBands.get(i).getStyle()+"."+" Instruments used: "+
            this.myBands.get(i).getInstruments()+". Amount of members in the band: "+
            this.myBands.get(i).getMembers());
            System.out.println();
        }
    }

    public void printFavoriteList() {
        System.out.println("Favorite-List");
        System.out.println();
        for(int i=0; i<this.myFavorites.size(); i++) {
            System.out.println((i+1)+". Name: "+
            this.myFavorites.get(i).getName()+" Style: "+
            this.myFavorites.get(i).getStyle()+"."+" Instruments used: "+
            this.myFavorites.get(i).getInstruments()+". Amount of members in the band: "+
            this.myFavorites.get(i).getMembers());
            System.out.println();
        }

    }

}
