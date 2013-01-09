package com.pwf.example.swing;

import com.pwf.example.controller.MovieController;
import com.pwf.mvc.ControllersManager;
import com.pwf.mvc.MvcFramework;
import javax.swing.JFrame;

/**
 *
 * @author mfullen
 */
public class MainApp
{
    public static void main(String[] args)
    {
        ControllersManager cm = MvcFramework.createControllersManager();
        cm.addController(new MovieController());

        JFrame frame = new JFrame("Swing Example");

        MoviePanel moviePanel = new MoviePanel();
        moviePanel.setControllerManager(cm);

        frame.add(moviePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
