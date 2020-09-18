package com.example.labb2;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static MusicList musicList = new MusicList("Funk-Connection");

    public static void main(String[] args) {

        boolean quit = false;
        printActions();

        while(!quit) {
            System.out.println("Choose! (6)-Options");
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

                case 6:
                 printActions();
            }

        }
    }

    private static void addNewBand() {
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

    private static void printActions() {
        System.out.println("\n Make your choice!");
        System.out.println("\t 0 - Quit Program");
        System.out.println("\t 1 - Show Music-List");
        System.out.println("\t 2 - Add a Band to the list");
        System.out.println("\t 6 - Show all options");
    }
}
