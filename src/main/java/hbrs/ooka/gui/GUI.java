package hbrs.ooka.gui;

import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.system.Buchungssystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class GUI {

    private Buchungssystem buchungssystem;

    private JFrame frame;

    public GUI(Buchungssystem b){
        System.out.println("GUI from Buchungssystem");
        buchungssystem = b;
    }

    public void openWindow(){
        //Creating the Frame
        frame = new JFrame("Buchungssystem Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Text Area at the Center
        final JTextArea ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        final JTextField tf = new JTextField(10); // accepts upto 10 characters

        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = tf.getText();
                tf.setText("");
                ta.setText("");
                List<Hotel> hotels = buchungssystem.getPortSuche().getHotelSuche().getHotelByName(query);
                String result = hotels.stream().map(h -> h.getName() + ", " + h.getCity())
                        .collect(Collectors.joining("\n"));
                if(result.length() == 0) result = "Keine Ergebnisse gefunden...";
                ta.setText(result);
            }
        });



        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, sp);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

    }

    public void closeWindow(){
        frame.setVisible(false); //you can't see me!
        frame.dispose(); //Destroy the JFrame object
    }


    public Buchungssystem getBuchungssystem() {
        return buchungssystem;
    }

    public void setBuchungssystem(Buchungssystem buchungssystem) {
        this.buchungssystem = buchungssystem;
    }
}
