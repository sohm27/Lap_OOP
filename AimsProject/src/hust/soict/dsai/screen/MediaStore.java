
package hust.soict.sec.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.sec.aims.media.Disc;
import hust.soict.sec.aims.media.Media;
import hust.soict.sec.aims.media.Playable;


public class MediaStore extends JPanel {
    private Media media;
    private StoreScreen storeScreen;

    public MediaStore(Media media, StoreScreen storeScreen){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addToCartDialog = new JDialog(storeScreen, "Add to cart");

                JPanel contentPane = new JPanel();
                contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

                storeScreen.getCart().addMedia(media);

                JLabel result = new JLabel("Add successfully");

                contentPane.add(result);

                addToCartDialog.setContentPane(contentPane);
                addToCartDialog.pack();
                addToCartDialog.setLocationRelativeTo(storeScreen);
                addToCartDialog.setVisible(true);
            }
        });
        container.add(addToCartButton);


        if (media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog playDialog = new JDialog(storeScreen, "Play media");
                    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                    JPanel contentPane = new JPanel();
                    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

                    JLabel playLabel = new JLabel(((Disc)media).play());
                    contentPane.add(playLabel);

                    playDialog.setContentPane(contentPane);
                    playDialog.pack();
                    playDialog.setLocationRelativeTo(storeScreen);
                    playDialog.setVisible(true);
                }
            });

            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
*/

package hust.soict.sec.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.exception.PlayerException;
import hust.soict.sec.aims.media.*;


public class MediaStore extends JPanel {
    public MediaStore(Media media, Cart cart) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+"$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
            }
        });
        container.add(addToCartButton);




        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JDialog dialog = new JDialog();
                    dialog.setTitle(media.getTitle());
                    dialog.setSize(400, 300);

                    String mediaInfo = "";
                    mediaInfo = media.toString();
                    JLabel mediaLabel = new JLabel(mediaInfo);
                    mediaLabel.setVerticalAlignment(JLabel.CENTER);
                    mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                    JScrollPane scrollPane = new JScrollPane(mediaLabel);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                    dialog.add(scrollPane);
                    dialog.setVisible(true);

                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
