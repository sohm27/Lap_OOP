package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
	private String artist;
    private ArrayList<Track> tracks;
    
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("The track already exists in the CD.");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("The track does not exist in the CD.");
        }
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public void play() throws PlayerException {
    	
        if (this.getLength()>0) {
        	java.util.Iterator iter=tracks.iterator();
        	Track nextTrack;
        	while (iter.hasNext()) {
        		nextTrack=(Track) iter.next();
        		try {
        			nextTrack.play();
        		}catch (PlayerException e) {
					// TODO: handle exception
        			throw e;
				}
        	}
        } else throw new PlayerException("ERROR: CD length is non-positive");
    }
    public String toString() {
        return "CD info: " + this.getId()
        + " - " + this.getTitle()
		+ " - " + this.getCategory()
		+ " - " + this.getArtist()
		+ " - " + this.tracks
		+ ": " + this.getCost() + " $";
	}
	
}
