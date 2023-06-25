package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Store {
	public Media[] getItemsInStore() {
		// TODO Auto-generated method stub
		return null;
	}
	   private static final int MAX_ITEM = 2000;
	    
	   private ArrayList<Media> itemsInStore  = new ArrayList<>();

	   public Store(){};
	   public void removeMedia(Media media){
	        if (itemsInStore.contains(media)){
	            itemsInStore.remove(media);
	            System.out.println("This media is successfully removed.");
	        } else {
	            System.out.println("This media is not in store.");
	        }
	    }
	   public void addMedia(Media media){
	        if (itemsInStore.contains(media)){
	            System.out.println("This median is already in store.");
	        } else {
	            itemsInStore.add(media);
	            System.out.println("This media is successfully added.");

	        }
	    }
	    
	    
	    public static int getMaxItem() {
	        return MAX_ITEM;
	    }

	    public ArrayList<Media> getItemsInStore1() {
	        return itemsInStore;
	    }

	    public boolean searchTitle(String title){
	            for (Media media: itemsInStore){
	                if (media.getTitle().equals(title)){
	                    return true;
	                }
	            }
	            return false;
	    
	    }
	    public void display(){
	        for (Media media: itemsInStore){
	            System.out.println(media);
	        }
	    }
		public Media searchMedia(String title) {
			// TODO Auto-generated method stub
			return null;
		}	
}
  
