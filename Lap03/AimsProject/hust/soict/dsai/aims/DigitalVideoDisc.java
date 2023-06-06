package hust.soict.dsai.aims.disc;


public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDisc=0;
	private int id=0;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	public int getId() {
		return id;
	}
	public DigitalVideoDisc(String title) {
		this.title = title;
		nbDigitalVideoDisc++;
		id+=1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
		id+=1;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
		id+=1;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc++;
		id+=1;
	}
	public void setTitle(String title2) {
		this.title=title2;
		
	}

}
