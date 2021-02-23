package models;

import javax.swing.*;
import java.awt.*;

public class Board {
  private JFrame frame;
  private Canvas canvas;

  private String title;
  private int width, height;

  public Board(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;
    createBoard();
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public JFrame getFrame() {
    return frame;
  }

  private void createBoard() {
    frame = new JFrame(title);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    ImageIcon image = new ImageIcon("resources/img/hero-down.png"); //create an ImageIcon
    frame.setIconImage(image.getImage()); //change icon of frame

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    canvas.setFocusable(false);

    frame.add(canvas);
    frame.pack();
  }
}