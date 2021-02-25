package entities;

import java.awt.Graphics;

public interface Entity {
  void tick();

  void render(Graphics g);

  void die();
}