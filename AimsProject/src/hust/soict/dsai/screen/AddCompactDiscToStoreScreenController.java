package src.hust.soict.dsai.screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import java.util.List;
import src.hust.soict.dsai.aims.media.Track;
import src.hust.soict.dsai.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.Media;

public class AddCompactDiscToStoreScreenController {
	private StoreScreen storeScreen;
	private Store store;
    @FXML
    private MenuItem viewCart;
    @FXML
    private Button cdAddButton;

    @FXML
    private TextField cdArtist;

    @FXML
    private TextField cdCategory;

    @FXML
    private TextField cdDirector;

    @FXML
    private TextField cdID;

    @FXML
    private TextField cdCost;

    @FXML
    private TextField cdTitle;
    @FXML
    private MenuItem optionViewStore;

    @FXML
    private Button newTrackAddButton;

    @FXML
    private TextField newTrackLength;

  
    @FXML
    private TextField newTrackTitle;

    @FXML
    private TableView<Track> tblTrack;

    @FXML
    private TableColumn<Track, Integer> tblTrackLength;

    @FXML
    private TableColumn<Track, String> tblTrackTitle;
    
    private ObservableList<Track> trackList;
    public AddCompactDiscToStoreScreenController(StoreScreen storeScreen,Store store) {
    	this.storeScreen=storeScreen;
    	this.store=store;
    }

    @FXML
    private void initialize() {
        // Initialize the trackList
        trackList = FXCollections.observableArrayList();

      
        // Associate the trackList with the TableView
        tblTrack.setItems(trackList);

        // Associate the title and length properties with the appropriate TableColumn
        tblTrackTitle.setCellValueFactory(new PropertyValueFactory<Track,String>("Title"));
        tblTrackLength.setCellValueFactory(new PropertyValueFactory<Track,Integer>("Length"));
    }

    @FXML
    void addTrackButtonPressed(ActionEvent event) {
    	String title=newTrackTitle.getText();
    	int length=Integer.parseInt(newTrackLength.getText());
    	Track newTrack=new Track(title,length);
    	tblTrack.getItems().add(newTrack);
    	newTrackLength.clear();
    	newTrackTitle.clear();
    	
    }

    @FXML
    void cdAddButtonPressed(ActionEvent event) {
    	int id=Integer.parseInt(cdID.getText());
    	String title=cdTitle.getText();
    	String category=cdCategory.getText();
    	String director=cdDirector.getText();
    	float cost=Float.parseFloat(cdCost.getText());
    	String artist=cdArtist.getText();
    	ArrayList<Track> tracks=new ArrayList<>(tblTrack.getItems());
    	
    	CompactDisc newCompactDisc=new CompactDisc(id, title, category, cost, artist, director, tracks);
    	store.addMedia(newCompactDisc);
    }
    
    @FXML
    void ViewStorePressed(ActionEvent event) {
    	storeScreen.updateStoreContents();
    	storeScreen.setVisible(true);
    }

    @FXML
    void viewCartPressed(ActionEvent event) {
    	CartScreen cartScreen=new CartScreen(storeScreen.getCart(), storeScreen);
    	cartScreen.setVisible(true);
    }
}
