package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public abstract class Disc extends Media implements Playable {
    private int length;
    private String director;
    
    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    
    // Getter methods
    public int getLength() {
        return length;
    }
    
    public String getDirector() {
        return director;
    }
} 