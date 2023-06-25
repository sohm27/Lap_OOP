package src.hust.soict.dsai.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import src.hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private StoreScreen storeScreen;
    private Store store;

    public AddDigitalVideoDiscToStoreScreen(StoreScreen storeScreen,Store store) {
        super();
        this.storeScreen = storeScreen;
        this.store=store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book to Store");
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("src/hust/soict/dsai/screen/AddDigitalVideoDiscToStoreScreen.fxml"));
                AddDigitalVideoDiscToStoreScreenController controller = new AddDigitalVideoDiscToStoreScreenController(storeScreen,store);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
