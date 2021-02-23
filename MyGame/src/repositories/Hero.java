package repositories;

import controllers.Characters;
import java.awt.*;
import java.awt.event.KeyEvent;
import services.Images;

public class Hero extends Characters implements java.awt.event.KeyListener {

  String direction;
  private static Tile tile = new Tile();
  private static final int TILE_SIZE = 72;

  public Hero(int x, int y) {
    super(x, y);
  }

  @Override
  public void upDate() {
    //Empty block
  }

  @Override
  public void render(Graphics graphics) {
    if (direction == "right") {
      graphics.drawImage(Images.heroRight, (int) xPosition, (int) yPosition, null);
    } else if (direction == "up") {
      graphics.drawImage(Images.heroUp, (int) xPosition, (int) yPosition, null);
    } else if (direction == "left") {
      graphics.drawImage(Images.heroLeft, (int) xPosition, (int) yPosition, null);
    } else graphics.drawImage(Images.heroDown, (int) xPosition, (int) yPosition, null);
  }

  public void move() {
    super.move();
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      direction = "down";
      yPosition += TILE_SIZE;
    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
      direction = "up";
      yPosition -= TILE_SIZE;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      direction = "left";
      xPosition -= TILE_SIZE;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      direction = "right";
      xPosition += TILE_SIZE;
    }
    //repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //empty block
  }

  @Override
  public void keyPressed(KeyEvent e) {
    //empty block
  }
}