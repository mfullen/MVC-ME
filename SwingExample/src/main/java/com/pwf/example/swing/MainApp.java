package com.pwf.example.swing;

import com.pwf.example.controller.MovieController;
import com.pwf.mvcme.MvcFramework;
import com.pwf.mvcme.MvcMe;
import javax.swing.JFrame;

/**
 *
 * @author mfullen
 */
public class MainApp
{
    public static void main(String[] args)
    {
        MvcFramework mvcFramework = MvcMe.createMvcFramework();
        mvcFramework.register(new MovieController());

        JFrame frame = new JFrame("Swing Example");

        MoviePanel moviePanel = new MoviePanel();
        mvcFramework.register(moviePanel);

        frame.add(moviePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
