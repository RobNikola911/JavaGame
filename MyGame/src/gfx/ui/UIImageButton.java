package gfx.ui;

import gfx.ClickListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

  private BufferedImage[] images;
  private ClickListener click;

  public UIImageButton(float x, float y, int width, int height, BufferedImage[] images,
      ClickListener click) {
    super(x, y, width, height);
    this.images = images;
    this.click = click;
  }

  @Override
  public void tick() {
  }

  @Override
  public void render(Graphics g) {
    if (super.isHovering()) {
      //Added if block to avoid exception when load BufferedImage with only 1 element = startScreen.
      if (this.images.length == 1) {
        g.drawImage(this.images[0], (int) super.getX(), (int) super.getY(), super.getWidth(),
            super.getHeight(), null);
      } else {
        g.drawImage(this.images[1], (int) super.getX(), (int) super.getY(), super.getWidth(),
            super.getHeight(), null);
      }
    } else {
      g.drawImage(this.images[0], (int) super.getX(), (int) super.getY(), super.getWidth(),
          super.getHeight(), null);
    }
  }

  @Override
  public void onClick() {
    this.click.onClick();
  }
}
