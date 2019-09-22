package Project1new;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.io.*;
import java.util.Scanner;

public class MyTimerPanel extends JPanel{
    private GeoCountDownTimer geoCountDownTimer;
    private GeoCountDownTimer geoCountDownTimer2;

    private Timer javaTimer;
    private TimerListener timer;
    private JLabel enterDate;
    private JButton start, stop, inc, dec, reset
            , newDate, inc1, dec1, daysTil, daysFuture;
    private JTextField textField;
    private JMenuItem save, load;
    private JMenu file;
    private JMenuBar menuBar;
    private JFrame frame;


    public static void main(String args[]) {
        JFrame frame = new JFrame("Geo Count Down Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyTimerPanel panel = new MyTimerPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400);

//        JMenuBar menuBar = new JMenuBar();
//        frame.setJMenuBar(menuBar);
//
//        JMenu file = new JMenu("File");
//        menuBar.add(file);
//
//        /** QUESTION: How do i add ActionListeners to JMenuIems? */
//        JMenuItem save = new JMenuItem("Save");
//        file.add(save);
//
//
//        JMenuItem load = new JMenuItem("Load");
//        file.add(load);
    }


    public MyTimerPanel(){
        geoCountDownTimer = new GeoCountDownTimer(12,10,2019);
        geoCountDownTimer2 = new GeoCountDownTimer(5,12,2019);


        setLayout(new FlowLayout());
        setBackground(Color.cyan);

        timer = new TimerListener();

        stop = new JButton("Stop");
        add (stop);
        stop.addActionListener(new ButtonListener());

        start = new JButton("Start");
        add (start);
        start.addActionListener(new ButtonListener());

        reset = new JButton("Reset");
        add(reset);
        reset.addActionListener(new ButtonListener());

        inc = new JButton("Increment");
        add(inc);
        inc.addActionListener(new ButtonListener());

        inc1 = new JButton("Increment Once");
        add(inc1);
        inc1.addActionListener(new ButtonListener());

        dec1 = new JButton("Decrement Once");
        add(dec1);
        dec1.addActionListener(new ButtonListener());

        newDate = new JButton("New Date");
        add(newDate);
        newDate.addActionListener(new ButtonListener());

        dec = new JButton("Decrement");
        add(dec);
        dec.addActionListener(new ButtonListener());

        daysTil = new JButton("Days Until");
        add(daysTil);
        daysTil.addActionListener(new ButtonListener());

        daysFuture = new JButton("Days in Future");
        add(daysFuture);
        daysFuture.addActionListener(new ButtonListener());

        enterDate = new JLabel("Enter Date: ");
        add(enterDate);

        textField = new JTextField(10);
        add(textField);

        javaTimer = new Timer(1000, timer);

        javaTimer.start();
    }

    private void menu(){
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        frame.add(menuBar);
        menuBar.setVisible(true);

        file = new JMenu("File");
        menuBar.add(file);

        /** QUESTION: How do i add ActionListeners to JMenuIems? */
        save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ButtonListener());

        load = new JMenuItem("Load");
        file.add(load);
        load.addActionListener(new ButtonListener());
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            geoCountDownTimer2.inc();
            enterDate.setText(geoCountDownTimer2.toDateString());

            if (geoCountDownTimer.equals(geoCountDownTimer2)) {
                System.out.println ("Time is up!");
                javaTimer.stop();
            }
        }
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == stop)
                javaTimer.stop();

            if(e.getSource() == start)
                javaTimer.start();

            if(e.getSource() == reset)
                geoCountDownTimer2 = new GeoCountDownTimer
                        (1,1,2015);

            if(e.getSource() == inc1)
                geoCountDownTimer2.inc(1);

            if(e.getSource() == dec1)
                geoCountDownTimer2.dec(1);

            if(e.getSource() == daysTil) {
//                JOptionPane.showInputDialog("Enter Date MM/DD/YYYY: ");
                geoCountDownTimer2.daysToGo(JOptionPane
                        .showInputDialog("Enter Date MM/DD/YYYY: "));
            }

            if(e.getSource() == daysFuture){
                String s = JOptionPane.showInputDialog(
                        Integer.parseInt("How many days in future?"));
                geoCountDownTimer2.daysToGo(s);
                textField = new JTextField(geoCountDownTimer2.daysToGo(s) + " days to go.");
            }


            if(e.getSource() == save)
                geoCountDownTimer2.save("Saved Date");

            if(e.getSource() == load)
                geoCountDownTimer2.load("Saved Date");

            if(e.getSource() == inc) {
                JFrame parent = new JFrame();
                int pDays = Integer.parseInt(JOptionPane.showInputDialog
                        (parent, "How many days?"));
                geoCountDownTimer2.inc(pDays);
            }

            if(e.getSource() == dec) {
                JFrame parent = new JFrame();
                int pDays = Integer.parseInt(JOptionPane.showInputDialog
                        (parent, "How many days?"));
                geoCountDownTimer2.dec(pDays);
            }

            if(e.getSource() == newDate) {
                JFrame parent = new JFrame();
                String s = JOptionPane.showInputDialog(null,
                        "Enter New Date: MM/DD/YYYY");
                geoCountDownTimer = new GeoCountDownTimer(s);
            }

        }

    }

}