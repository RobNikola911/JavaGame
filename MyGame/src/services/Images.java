package services;

import java.awt.image.BufferedImage;

public class Images {

  private static final int width = 72, height = 72;

  public static BufferedImage floor, wall, heroDown, heroUp, heroLeft, heroRight, skeleton, boss;

  public static void init() {
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/wandererSpriteSheet.png"));

    floor = sheet.crop(0, 0, width, height);
    wall = sheet.crop(0, height, width, height);
    boss = sheet.crop(0, height * 2, width, height);
    skeleton = sheet.crop(0, height * 3, width, height);
    heroDown = sheet.crop(width, 0, width, height);
    heroRight = sheet.crop(width, height, width, height);
    heroLeft = sheet.crop(width, height * 2, width, height);
    heroUp = sheet.crop(width, height * 3, width, height);
  }
}