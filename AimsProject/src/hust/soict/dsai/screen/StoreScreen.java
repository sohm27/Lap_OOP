package hust.soict.sec.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.media.*;
import hust.soict.sec.aims.store.Store;



public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
  
    JPanel createNorth(){
        JPanel north =new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        //change in here
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel  header =  new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
        JLabel  title  = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cart = new  JButton("View Cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
    JPanel createCenter(){
        JPanel center= new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaInStore =store.getItemsInStore();
        for (int i=0;i<2;i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }
    public StoreScreen(Store store){
        this.store=store;
        Container cp =getContentPane();
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    
    public static void main(String[] args){
        Store store = new Store();   
        DigitalVideoDisc  dvd1= new DigitalVideoDisc("loyal");
        DigitalVideoDisc  dvd2= new DigitalVideoDisc("benetal");
        store.addMedia(dvd1); 
        store.addMedia(dvd2); 
        new StoreScreen(store);
    }
}
