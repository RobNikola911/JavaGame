package controllers;

import java.awt.*;

public abstract class Characters {

  public static final int DEFAULT_HP = 10;
  public static final int DEFAULT_DP = 10;
  public static final int DEFAULT_SP = 10;
  public static final int DEFAULT_SPEED = 72;

  protected int xPosition, yPosition;
  protected int hp;
  protected int dp;
  protected int sp;
  protected int speed;
  protected int xMove, yMove;
  protected int xCoordinate, yCoordinate;
  static protected int[][] currentPosition = new int[1][1];


  public Characters(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    hp = DEFAULT_HP;
    dp = DEFAULT_DP;
    sp = DEFAULT_SP;
    speed = DEFAULT_SPEED;
    xMove = 72;
    yMove = 72;
  }

  public abstract void upDate();

  public abstract void render(Graphics graphics);

  public void move() {
    xPosition += xMove;
    yPosition += yMove;
  }

  public int getCurrentPosition() {
    return currentPosition[xCoordinate][yCoordinate];
  }

  //GETTERS & SETTERS

  public int getxPosition() {
    return xPosition;
  }

  public void setxPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  public int getyPosition() {
    return yPosition;
  }

  public void setyPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getDp() {
    return dp;
  }

  public void setDp(int dp) {
    this.dp = dp;
  }

  public int getSp() {
    return sp;
  }

  public void setSp(int sp) {
    this.sp = sp;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getxMove() {
    return xMove;
  }

  public void setxMove(int xMove) {
    this.xMove = xMove;
  }

  public int getyMove() {
    return yMove;
  }

  public void setyMove(int yMove) {
    this.yMove = yMove;
  }
}