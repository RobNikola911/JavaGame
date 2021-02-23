import java.awt.*;

public class Hero extends GameObject {
  protected int heroPosX;
  protected int heroPosY;

  public Hero() {
    heroPosX = 0;
    heroPosY = 0;
    filePath = "img/hero-down.png";
  }

  public Hero(int heroPosX, int heroPosY) {
    this.heroPosX = heroPosX;
    this.heroPosY = heroPosY;
  }

  public int getHeroPosX() {
    return heroPosX;
  }

  public void setHeroPosX(int heroPosX) {
    this.heroPosX = heroPosX;
  }

  public int getHeroPosY() {
    return heroPosY;
  }

  public void setHeroPosY(int heroPosY) {
    this.heroPosY = heroPosY;

  }

  public void heroDirection(String facing) {
    if (facing.equals("up")) {
      setFilePath("img/hero-up.png");
    } else if (facing.equals("left")) {
      setFilePath("img/hero-left.png");
    } else if (facing.equals("right")) {
      setFilePath("img/hero-right.png");
    } else {
      setFilePath("img/hero-down.png");
    }
  }

  public void drawHero(Graphics g) {
    PositionedImage hero = new PositionedImage(filePath, heroPosX, heroPosY);
    hero.draw(g);
  }
}