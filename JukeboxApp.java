package jukeboxapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class JukeboxApp 
{
    public static void showMenu()
    {
        System.out.println("***Welcome to the Jukebox Menu!***");
        System.out.println("Please select an option from the following:");
        System.out.println("1) Add a Song to the Jukebox.");
        System.out.println("2) Remove a Song from the Jukebox.");
        System.out.println("3) Play a specific song.");
        System.out.println("4) View the total cost of playing all of the songs in the Jukebox.");
        System.out.println("5) View the most expensive Song.");
        System.out.println("6) View the shortest Song.");
        System.out.println("7) View the most-played Song.");
        System.out.println("8) View all Songs in the Jukebox.");
        System.out.println("9) View all Songs by a specific artist.");
        System.out.println("10) Special secret action.");
        System.out.println("11) Exit the program.");
    }
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of your Jukebox:");
        String jukeboxName = input.nextLine();
        Jukebox jukebox = new Jukebox(jukeboxName);
        
        int choice = -1;
        while (choice != 11)
        {
            showMenu();
            choice = input.nextInt();
            input.nextLine();
            
            if(choice == 1)
            {
                // Add a Song to the Jukebox 
                // (your application should let the user know if the Song was successfully added or not).
                System.out.println("You have selected to add a Song.");
                System.out.println("Please enter the title of this song:");
                String title = input.nextLine();
                System.out.println("Please enter the artist of this song:");
                String artist = input.nextLine();                
                System.out.println("Please enter the length of this song:");
                double length = input.nextDouble();
                input.nextLine();
                System.out.println("Please enter the price of this song:");
                double price = input.nextDouble();
                input.nextLine();
                
                Song newSong = new Song(title, artist, price, length);
                
                String result = jukebox.addSong(newSong);
                System.out.println(result);
            }
            else if(choice == 2)
            {
                //  Remove a Song from the Jukebox 
                // (your application should let the user know whether or not the Song was deleted).
                System.out.println("You have selected to remove a Song.");
                System.out.println("Please enter the title of the song to be removed:");
                String title = input.nextLine();
                System.out.println("Please enter the artist of the song to be removed:");
                String artist = input.nextLine();                
                System.out.println("Please enter the length of the song to be removed:");
                double length = input.nextDouble();
                input.nextLine();
                System.out.println("Please enter the price of the song to be removed:");
                double price = input.nextDouble();
                input.nextLine();
                
                Song newSong = new Song(title, artist, price, length);
                boolean removed = jukebox.removeSong(newSong);
                if(removed)
                {
                    System.out.println("The song was removed successfully.");
                }
                else
                {
                    System.out.println("The song was not removed as it could not be found in the Jukebox.");
                }
                
            }
            else if(choice == 3)
            {
                // Play a specific song.
                System.out.println("You have selected to play a song.");
                System.out.println("Please enter the title of the song you wish to play:");
                String title = input.nextLine();
                Song playSong = jukebox.searchByTitle(title);
                if(playSong == null)
                {
                    System.out.println("The song cannot be played as it was not found in the jukebox.");
                }
                else
                {
                    playSong.play();
                }
            }
            else if(choice == 4)
            {
                // View the total cost of playing all of the songs in the Jukebox.
                double total = jukebox.calcTotalPrice();
                System.out.println("The total cost to play all songs currently in the jukebox is " + total + " euro.");
            }
            else if(choice == 5)
            {
                // View the most expensive Song.
                Song exp = jukebox.findMostExpensive();
                System.out.println("The most expensive song in the Jukebox is: ");
                System.out.println(exp);
            }
            else if(choice == 6)
            {
                // View the shortest Song.
                Song shortest = jukebox.findShortest();
                System.out.println("The shortest song in the Jukebox is: ");
                System.out.println(shortest);
            }
            else if(choice == 7)
            {
                // View the most played Song.
                Song mostPlayed = jukebox.findMostPlayed();
                System.out.println("The most played song in the Jukebox is: ");
                System.out.println(mostPlayed);
            }
            else if(choice == 8)
            {
                // View all Songs in the Jukebox.
                jukebox.display();
            }
            else if(choice == 9)
            {
                // View all songs by a specific artist.
                System.out.println("You have selected to view all songs by a specific artist.");
                System.out.println("Please enter the name of the artist whose catalogue you wish to view:");
                String artist = input.nextLine();
                ArrayList<Song> matches = jukebox.searchByArtist(artist);
                if(matches.size() > 0)
                {
                    for(Song currentSong: matches)
                    {
                        System.out.println(currentSong);
                    }
                }
                else
                {
                    System.out.println("There are no songs by that artist in the Jukebox");
                }
            }
            else if(choice == 10)
            {
                System.out.println("BOO!");
            }
            else if(choice == 11)
            {
                System.out.println("Thank you for using the " + jukebox.getName() + " application.");
                System.out.println("Goodbye!");
            }
            else
            {
                System.out.println("Please enter a selection listed in the menu above.");
            }
        }
    }
}
