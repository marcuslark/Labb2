package com.example.labb2;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static MusicList musicList = new MusicList();

    public static void main(String[] args) {

        boolean quit = false;
        printActions();

        while(!quit) {
            System.out.println("Choose (8) for options");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                 System.out.println("\n Shutting down...");
                 quit = true;
                 break;

                case 1:
                 musicList.printMusicList();
                 break;

                case 2:
                 addNewBand();
                 break;

                case 3:
                 removeBand();
                 break;

                case 4:
                 updateBand();
                 break;

                case 5:
                 bandName();
                 break;

                case 6:
                 addFavorite();
                 break;

                case 7:
                 musicList.printFavoriteList();
                 break;

                case 8:
                 printActions();
                 break;

                default:
                 System.out.println("Please enter a valid number!");
                 break;
            }

        }
    }

    //Method addNewBand creates a new band using the constructor in the "Band" class.
    private static void addNewBand() {
        //Asking user for input to use those variables inside the band parameters of the constructor.
        System.out.println("Please enter the name of the Band you'd like to add.");
        String inputName = sc.nextLine();
        System.out.println("Please enter the style(genre) of the music.");
        String inputStyle = sc.nextLine();
        System.out.println("What instruments are used? (everything in the same sentence)");
        String inputInstruments = sc.nextLine();
        System.out.println("How many members is it in the band?");
        int inputAmountOfMembers = sc.nextInt();
        Band newBand = new Band(inputName,inputStyle,inputInstruments,inputAmountOfMembers);
        if(musicList.addNewBand(newBand)) {
            System.out.println("New band added. Name: "+inputName+", style(genre): "+inputStyle);
        } else {
            System.out.println(inputName+" already exist, could not add.");
        }

    }
    //Method removeBand creates a variable of the type Band with the name "existingBandRecord".
    //The method "bandName" inside the class musicList tries to find the name of user-input in the arrayList "myBands"
    //By comparing the input of the user and the already existing band, and then removes the band if it's found.
    private static void removeBand() {
        System.out.println("Please, enter the name of the band you want to remove.");
        String name = sc.nextLine();
        Band existingBandRecord = musicList.bandName(name);
        if(existingBandRecord == null) {
            System.out.println("Could not find the band.");
            return;
        }
        if(musicList.removeBand(existingBandRecord)) {
            System.out.println("The band has been removed!");
        } else {
            System.out.println("Could not remove the band.");
        }
    }
    //Method updateBand uses the same method as "removeBand()" to find the already existing band.
    //Then creates a new band using the method "createBand" inside the "Band" class.
    private static void updateBand() {
        System.out.println("Please, enter the name of the band you'd like to update.");
        String name = sc.nextLine();
        Band existingBandRecord = musicList.bandName(name);
        if(existingBandRecord == null) {
            System.out.println("Could not find the band.");
            return;
        }

        System.out.println("Enter a new name for the band.");
        String newName = sc.nextLine();
        System.out.println("Enter the style(genre) of the band.");
        String newType = sc.nextLine();
        System.out.println("What instruments are used? (everything in the same sentence)");
        String newInstruments = sc.nextLine();
        System.out.println("How many members is it in the band?");
        int newMembers = sc.nextInt();
        sc.nextLine();
        Band newBand = Band.createBand(newName, newType, newInstruments, newMembers);
        if(musicList.updateBand(existingBandRecord, newBand)) {
            System.out.println("The band is updated!");
        } else {
            System.out.println("Could not update the band.");
        }
    }
    //Method bandName searches for an already existing band using the same method as "removeBand()".
    private static void bandName() {
        System.out.println("Please, enter the name of the band.");
        String name = sc.nextLine();
        Band existingBandRecord = musicList.bandName(name);
        if(existingBandRecord == null) {
            System.out.println("Could not find the band.");
            return;
        }

        System.out.println("Found a band! -> "+existingBandRecord.getName()+" with the style(genre) "+existingBandRecord.getStyle());
    }
    //Method addFavorite() first prints the whole list of Bands. User picks their favorite-band.
    //Int bandPosition saves the user's input.
    //Then the method saves their favorite band by copying the band from the "myBands" arrayList into a new arrayList "myFavorites".
    private static void addFavorite() {
        musicList.printMusicList();
        System.out.println("Please, enter a number to choose a band from the list and add it to your favorites.");
        System.out.println();
        int bandPosition = sc.nextInt();
        bandPosition = bandPosition-1;
        Band favoriteBand = musicList.favoriteBand(bandPosition);
        musicList.addNewFavoriteBand(favoriteBand);
        System.out.println("Favorite band added.");
        musicList.printFavoriteList();
    }

    private static void printActions() {
        System.out.println("\n Make your choice!");
        System.out.println();
        System.out.println("\t 0 - Quit Program");
        System.out.println("\t 1 - Show Music-List");
        System.out.println("\t 2 - Add a Band to the list");
        System.out.println("\t 3 - Remove a band from the list");
        System.out.println("\t 4 - Update a band");
        System.out.println("\t 5 - Search for a band");
        System.out.println("\t 6 - Add a band from the list to favorites");
        System.out.println("\t 7 - Show favorites");
        System.out.println("\t 8 - Show all options");
        System.out.println();
    }
}
