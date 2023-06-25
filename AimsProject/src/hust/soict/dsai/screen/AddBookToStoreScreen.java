package hust.soict.sec.aims.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.sec.aims.store.Store;
import javax.swing.JFrame;
import hust.soict.sec.aims.screen.controller.AddBookScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;


public class AddBookToStoreScreen extends JFrame{

    private static Store store;

    public static void main(String[] args) {
        new AddBookToStoreScreen(store);
    }

    public AddBookToStoreScreen(Store store) {

        super();

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/addBook.fxml"));

                    AddBookScreenController controller = new AddBookScreenController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
