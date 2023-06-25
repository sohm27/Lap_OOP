package src.hust.soict.dsai.screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import src.hust.soict.dsai.aims.media.Book;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;


import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreenController {
    private StoreScreen storeScreen;
    private Store store;

    @FXML
    private MenuItem optionViewCart;

    @FXML
    private TextField bookAuthors;

    @FXML
    private TextField bookCategory;

    @FXML
    private TextField bookCost;

    @FXML
    private TextField bookID;

    @FXML
    private TextField bookTitle;

    @FXML
    private Button btnAddBookStore;
    
    @FXML
    private MenuItem optionViewStore;

    public AddBookToStoreScreenController(StoreScreen storeScreen,Store store) {
        this.storeScreen = storeScreen;
        this.store=store;
    }

    @FXML
    void btnAddBookPressed(ActionEvent event) {
        String title = bookTitle.getText();
        String category = bookCategory.getText();
        List<String> authors = Arrays.asList(bookAuthors.getText().split(","));
        int id = Integer.parseInt(bookID.getText());
        float cost = Float.parseFloat(bookCost.getText());

        Book book = new Book(id, title, category, cost, authors);
        store.addMedia(book);
    }
    @FXML
    void ViewStorePressed(ActionEvent event) {
    	storeScreen.updateStoreContents();
    	storeScreen.setVisible(true);
    }
    @FXML
    void ViewCartPressed(ActionEvent event) {
    	CartScreen newScreen=new CartScreen(storeScreen.getCart(), storeScreen);
    	newScreen.setVisible(true);
    }
}
