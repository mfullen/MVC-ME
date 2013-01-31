/*
 * Copyright PWF Technology LLC
 */
package com.pwf.example.swing;

import com.pwf.example.controller.MovieController;
import com.pwf.example.model.Genre;
import com.pwf.example.model.Movie;
import com.pwf.mvcme.MvcFramework;
import com.pwf.mvcme.MvcMeView;
import com.pwf.mvcme.View;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mfullen
 */
public class ModifyMovie extends javax.swing.JPanel implements View<Movie>
{
    private MvcFramework mvcFramework;

    public MvcFramework getMvcFramework()
    {
        return mvcFramework;
    }

    public void setMvcFramework(MvcFramework mvcFramework)
    {
        this.mvcFramework = mvcFramework;
    }

    public static class EditMovie extends ModifyMovie
    {
        public EditMovie()
        {
            this.getDialog().setTitle("Edit Movie");
        }

        @Override
        public void save()
        {
            MovieController controller = this.getMvcFramework().getController(MovieController.class);
            controller.edited(this.getMovieFromInput());
            this.setVisible(false);
        }

        @Override
        public String getName()
        {
            return MovieController.MOVIE_EDIT;
        }
    }

    public static class CreateMovie extends ModifyMovie
    {
        public CreateMovie()
        {
            this.getDialog().setTitle("Create Movie");
        }

        @Override
        public void save()
        {
            MovieController controller = this.getMvcFramework().getController(MovieController.class);
            controller.created(this.getMovieFromInput());
            this.setVisible(false);
        }

        @Override
        public String getName()
        {
            return MovieController.MOVIE_CREATE;
        }
    }

    static class DeleteMovie extends MvcMeView<Movie>
    {
        public void update(Movie t)
        {
            String message = String.format("Would you like to Delete %s", t);
            int dialogResult = JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION);
            switch (dialogResult)
            {
                case JOptionPane.YES_OPTION:
                    this.getMvcFramework().getController(MovieController.class).deleted(t);
                    break;
            }
        }

        @Override
        public String getName()
        {
            return MovieController.MOVIE_DELETE;
        }
    }

    /**
     * Creates new form ModifyMovie
     */
    public ModifyMovie()
    {
        initComponents();
    }
    private JFrame frame = null;
    private JDialog dialog = new JDialog(frame, "Edit Movie", true);

    public JDialog getDialog()
    {
        return dialog;
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (visible)
        {
            this.getDialog().setLocationRelativeTo(null);
            this.getDialog().add(this);
            this.getDialog().pack();
            this.getDialog().setVisible(visible);
        }
        else
        {
            this.getDialog().dispose();
        }
    }

    public void update(Movie movie)
    {
        this.idText.setText(movie.getId() + "");
        this.titleText.setText(movie.getTitle());

        DefaultComboBoxModel<Genre> model = new DefaultComboBoxModel<Genre>(Genre.values());
        model.setSelectedItem(movie.getGenre());
        this.genreComboBox.setModel(model);
    }

    public Movie getMovieFromInput()
    {
        int id = this.idText.getText().isEmpty() ? 0 : Integer.valueOf(this.idText.getText());
        return new Movie(id, this.titleText.getText(), (Genre) this.genreComboBox.getSelectedItem());
    }

    public void save()
    {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        genreComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Id:");

        idText.setText("...");

        titleText.setText("jTextField1");

        jLabel3.setText("Title");

        jLabel4.setText("Genre");

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idText)
                                    .addComponent(titleText)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox genreComboBox;
    private javax.swing.JLabel idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField titleText;
    // End of variables declaration//GEN-END:variables
}
