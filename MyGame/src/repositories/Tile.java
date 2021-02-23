package repositories;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
  private TileType type;
  private int imgPosX;
  private int imgPosY;

  public Tile() {
  }

  public Tile(int ImgPosX, int ImgPosY, TileType type) {
    this.imgPosX = ImgPosX;
    this.imgPosY = ImgPosY;
    this.type = type;
  }

  public void render(Graphics graphics, BufferedImage images, int imgPosX, int imgPosY, TileType type) {
    graphics.drawImage(images, imgPosX, imgPosY, null);
  }

  public TileType getType() {
    return type;
  }

  public void setType(TileType type) {
    this.type = type;
  }


  public void setImgPosX(int imgPosX) {
    this.imgPosX = imgPosX;
  }


  public void setImgPosY(int imgPosY) {
    this.imgPosY = imgPosY;
  }

  public int getImgPosX() {
    return imgPosX;
  }

  public int getImgPosY() {
    return imgPosY;
  }
}