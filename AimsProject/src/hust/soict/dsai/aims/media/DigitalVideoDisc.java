package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private String director;
	private int length;
	private static int nbDigitalVideoDisc=0;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
        nbDigitalVideoDisc++;
		id+=1;
    }
	
	public void setTitle(String title2) {
		this.title=title2;
		
	}
	@Override
	public void play() {
		System.out.println("Playing DigitalVideoDisc: " + getTitle());
		
	}
	@Override
        public void play() throws PlayerException {
		// TODO Auto-generated method stub
        if (this.getLength()>0) {
		System.out.println("p");
    	} else throw new PlayerException("Error: Length cannot be non-positive!");

	}

} 
