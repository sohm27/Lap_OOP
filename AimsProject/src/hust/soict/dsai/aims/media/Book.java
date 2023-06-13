package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;
public class Book extends Media {
	private float cost;
	private List<String> authors= new ArrayList<String>();
	
	
	public Book(float cost, List<String> authors) {
		super();
		this.cost = cost;
		this.authors = authors;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)==false) authors.add(authorName);
	}
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) authors.remove(authorName);
	}
	
}
