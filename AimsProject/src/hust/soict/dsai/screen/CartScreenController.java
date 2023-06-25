package hust.soict.sec.aims.screen;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.exception.PlayerException;
import hust.soict.sec.aims.media.DigitalVideoDisc;
import hust.soict.sec.aims.media.Disc;
import hust.soict.sec.aims.media.Media;
import hust.soict.sec.aims.media.Playable;
import javafx.beans.value.ChangeListener;


public class CartScreenController {
    private Cart cart;
    public CartScreenController(Cart cart){
        this.cart = cart;
    }
    @FXML
    private Button btnPlay;
    @FXML
    void setBtnPlay() throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        ((Disc) media).play();
    }
    @FXML
    private Button btnRemove;
    @FXML
    private Label costLabel;
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(cart.totalCost() + " $");
    }
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Double> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    void btnPlaceOrderPressed(){
        cart.emptyCart();
    }

    @FXML
    public void initialize(){
        costLabel.setText(cart.totalCost() + " $");

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Double>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if (newValue != null){
                            updateButtonBar(newValue);
                        }
                    }
                }
        );
        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilteredMedia(newValue);
                    }

                    private void showFilteredMedia(String keyword) {
                        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

                        if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String idString = String.valueOf(media.getId());
                                return idString.equals(keyword);
                            });
                        } else if (!keyword.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String title = media.getTitle().toLowerCase();
                                return title.contains(keyword.toLowerCase());
                            });
                        } else {
                            filteredList.setPredicate(null);
                        }
                        tblMedia.setItems(filteredList);
                    }
                });

    }

     void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        }else{
            btnPlay.setVisible(false);
        }
    }
}
