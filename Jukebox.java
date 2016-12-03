package jukeboxapplication;

import java.util.ArrayList;

/**
 *
 * @author Michelle
 */
public class Jukebox 
{
    private String name;
    private ArrayList<Song> songs;

    public Jukebox(String name) 
    {
        this.name = name;
        songs = new ArrayList<Song>();
    }
    
    public Jukebox() 
    {
        this.name = "Default name";
        songs = new ArrayList<Song>();
    }
    
    // Method 1
    public String getName()
    {
        return name;
    }
    
    // Method 2
    public double calcTotalPrice()
    {
        double total = 0.0;
        for(Song currentSong: songs)
        {
            total = total + currentSong.getPrice();
        }
        return total;
    }
    
    // Method 3
    public Song searchByTitle(String searchTitle)
    {
        Song s = null;
        
        for(Song currentSong: songs)
        {
            String currentTitle = currentSong.getTitle();
            if(currentTitle.equalsIgnoreCase(searchTitle))
            {
                s = currentSong;
                break;
            }
        }
        return s;
    }
    
    // Method 4
    public ArrayList<Song> searchByArtist(String searchArtist)
    {
        ArrayList<Song> matches = new ArrayList<Song>();
        
        for(Song currentSong: songs)
        {
            String currentArtist = currentSong.getArtist();
            if(currentArtist.equalsIgnoreCase(searchArtist))
            {
                matches.add(currentSong);
            }
        }
        return matches;
    }
    
    // Method 5
    public String addSong(Song s)
    {
        Song checker = searchByTitle(s.getTitle());
        if(checker == null)
        {
            songs.add(s);
            return "The song was not already in the Jukebox, so it was added";
        }
        else
        {
            return "The song was already in the Jukebox, so it was not added";
        }
    }
    
    // Method 6
    public boolean removeSong(Song s)
    {
        boolean removed = false;
        
        int position = 0;
        for(Song currentSong: songs)
        {
            if(currentSong.getArtist().equals(s.getArtist()) && currentSong.getTitle().equals(s.getTitle()))
            {
                songs.remove(position);
                removed = true;
                break;
            }
            position++;
        }
        
        return removed;
    }
    
    // Method 7
    public void display()
    {
        System.out.println("List of songs contained within the Jukebox:");
        for(Song currentSong: songs)
        {
            System.out.println(currentSong.toString());
        }
    }
    
    // Method 8
    public Song findMostExpensive()
    {
        if(songs.size() > 0)
        {
            double exp = songs.get(0).getPrice();
            Song mostExp = songs.get(0);
            for(Song currentSong: songs)
            {
                if(currentSong.getPrice() > exp)
                {
                    exp = currentSong.getPrice();
                    mostExp = currentSong;
                }
            }
            return mostExp;
        }
        else
        {
            return null;
        }
    }
    
    // Method 9
    public Song findShortest()
    {
        if(songs.size() > 0)
        {
            double shortest = songs.get(0).getLength();
            Song shortestSong = songs.get(0);
            for(Song currentSong: songs)
            {
                if(currentSong.getLength() < shortest)
                {
                    shortest = currentSong.getLength();
                    shortestSong = currentSong;
                }
            }
            return shortestSong;
        }
        else
        {
            return null;
        }
    }
    
    // Method 10
    public Song findMostPlayed()
    {
        if(songs.size() > 0)
        {
            double played = songs.get(0).getPlaycount();
            Song mostPlayed = songs.get(0);
            for(Song currentSong: songs)
            {
                if(currentSong.getPlaycount() > played)
                {
                    played = currentSong.getPlaycount();
                    mostPlayed = currentSong;
                }
            }
            return mostPlayed;
        }
        else
        {
            return null;
        }
    }
}
