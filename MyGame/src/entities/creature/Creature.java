package entities.creature;

import entities.EntityImpl;
import game.Handler;

public abstract class Creature extends EntityImpl {

  //CREATURE VARIABLES GO HERE HEALTH DAMAGE ARMOR ETC ETC
  private static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
  private static final int RANDOM_DIVISOR_BOUND = 50;
  private static final int DIRECTION_CHANGE_DELAY = 30;
  private static final int RANDOM_MOVE_STEP_GENERATION_BOUND = 3;
  private static final int DEFAULT_SPEED = 1;

  private float xMove, yMove;

  public Creature(Handler handler, float x, float y, int width, int height) {
    super(handler, x, y, width, height);
    this.xMove = 0;
    this.yMove = 0;
  }

  protected void move() {
    if (!checkEntityCollisions(xMove, 0f)) {
      moveX();
    }
    if (!checkEntityCollisions(0f, yMove)) {
      moveY();
    }
  }

  private void moveX() {
    if (this.xMove > 0) {//Move right
      //Tile (Index in the world matrix)WHERE THE HERO/CREATURE IS POSITIONED AT MOMENT
      int tx =
          (int) (super.getX() + this.xMove + super.getBoundsRect().getX() + super.getBoundsRect()
              .getWidth()) / Tile.getTileWidth();
      if (!collisionWithTile(tx,
          (int) (super.getY() + super.getBoundsRect().getY()) / Tile.getTileHeight()) &&
          !collisionWithTile(tx,
              (int) (super.getY() + super.getBoundsRect().getY() + super.getBoundsRect()
                  .getHeight()) / Tile.getTileHeight())) {
        super.setX(super.getX() + this.xMove);
      } else {
        super.setX(
            (float) (tx * Tile.getTileWidth() - super.getBoundsRect().getX() - super.getBoundsRect()
                .getWidth() - 1));
      }

    } else if (this.xMove < 0) { //Move left
      //Tile (Index in the world matrix)WHERE THE HERO/CREATURE IS POSITIONED AT MOMENT
      int tx =
          (int) (super.getX() + this.xMove + super.getBoundsRect().getX()) / Tile.getTileWidth();
      if (!collisionWithTile(tx,
          (int) (super.getY() + super.getBoundsRect().getY()) / Tile.getTileHeight()) &&
          !collisionWithTile(tx,
              (int) (super.getY() + super.getBoundsRect().getY() + super.getBoundsRect()
                  .getHeight()) / Tile.getTileHeight())) {
        super.setX(super.getX() + this.xMove);
      } else {
        super.setX(
            (float) (tx * Tile.getTileWidth() + Tile.getTileWidth() - this.getBoundsRect().getX()));
      }
    }
  }

  private void moveY() {
    if (this.yMove < 0) { //Move up
      int ty =
          (int) (super.getY() + this.yMove + super.getBoundsRect().getY()) / Tile.getTileHeight();
      if (!collisionWithTile(
          (int) (super.getX() + super.getBoundsRect().getX()) / Tile.getTileWidth(), ty) &&
          !collisionWithTile(
              (int) (super.getX() + super.getBoundsRect().getX() + super.getBoundsRect().getWidth())
                  / Tile.getTileWidth(), ty)) {
        super.setY(super.getY() + this.yMove);
      } else {
        super.setY((float) (ty * Tile.getTileHeight() + Tile.getTileHeight() - super.getBoundsRect()
            .getY()));
      }
    } else if (this.yMove > 0) { //Move down
      int ty =
          (int) (super.getY() + this.yMove + super.getBoundsRect().getY() + super.getBoundsRect()
              .getHeight()) / Tile.getTileHeight();
      if (!collisionWithTile(
          (int) (super.getX() + super.getBoundsRect().getX()) / Tile.getTileWidth(), ty) &&
          !collisionWithTile(
              (int) (super.getX() + super.getBoundsRect().getX() + super.getBoundsRect().getWidth())
                  / Tile.getTileWidth(), ty)) {
        super.setY(super.getY() + this.yMove);
      } else {
        super.setY((float) (ty * Tile.getTileHeight() - super.getBoundsRect().getY() - super
            .getBoundsRect().getHeight() - 1));
      }
    }
  }


  private boolean collisionWithTile(int x, int y) {
    return super.getHandler().getWorld().getTile(x, y).isSolid();
  }

  public int getHealth() {
    return super.getHealth();
  }

  public void setHealth(int health) {
    super.setHealth(health);
  }

  protected static int getDefaultCreatureWidth() {
    return DEFAULT_CREATURE_WIDTH;
  }

  protected static int getDefaultCreatureHeight() {
    return DEFAULT_CREATURE_HEIGHT;
  }

  protected float getxMove() {
    return this.xMove;
  }

  protected float getyMove() {
    return this.yMove;
  }

  protected void setxMove(float xMove) {
    this.xMove = xMove;
  }

  protected void setyMove(float yMove) {
    this.yMove = yMove;
  }

  protected int getRandomDivisorBound() {
    return RANDOM_DIVISOR_BOUND;
  }

  protected int getDirectionChangeDelay() {
    return DIRECTION_CHANGE_DELAY;
  }

  protected int getRandomMoveStepGenerationBound() {
    return RANDOM_MOVE_STEP_GENERATION_BOUND;
  }

  protected int getDefaultSpeed() {
    return DEFAULT_SPEED;
  }
}