package jukeboxapplication;

public class Song 
{
    private String title;
    private String artist;
    private double price;
    private int playcount;
    private double length;
    
    public Song()
    {
        this.title = "Default title";
        this.artist = "Default artist";
        this.price = 0.0;
        this.playcount = 0;
        this.length = 0.0;
    }

    public Song(String title, String artist, double price, double length) 
    {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.length = length;
        this.playcount = 0;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getArtist() 
    {
        return artist;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getPlaycount() 
    {
        return playcount;
    }

    public double getLength() 
    {
        return length;
    }
    
    public void changePrice(double newPrice)
    {
        this.price = newPrice;
    }
    
    public void play()
    {
        this.playcount++;
        System.out.println("Now playing " + title + ", by " + artist + ". This song has been played " + playcount + " times.");
    }
    
    @Override
    public String toString()
    {
        String state = "Title: + " +  title + ", artist: " + artist + ", length: " + length + ", price: " + price + "e, number of plays: " + playcount + ".";
        return state;
    }
}
