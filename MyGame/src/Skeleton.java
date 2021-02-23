import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Skeleton extends GameObject {
  protected int skeletonPosX;
  protected int skeletonPosY;


  public Skeleton() {
    skeletonPosX = 0;
    skeletonPosY = 0;
    filePath = "img/skeleton.png";
  }

  public Skeleton(int heroPosX, int heroPosY) {
    this.skeletonPosX = heroPosX;
    this.skeletonPosY = heroPosY;
  }

  public int getSkeletonPosX() {
    return skeletonPosX;
  }

  public void setSkeletonPosX(int skeletonPosX) {
    this.skeletonPosX = skeletonPosX;
  }

  public int getSkeletonPosY() {
    return skeletonPosY;
  }

  public void setSkeletonPosY(int skeletonPosY) {
    this.skeletonPosY = skeletonPosY;

  }

  public void randomCoord() {
    List<Integer> content = new ArrayList<>();


  }

  public void drawSkeleton(Graphics g) {
    PositionedImage skeleton = new PositionedImage(filePath,
        skeletonPosX + (int) (Math.random() * 720),
        skeletonPosY + (int) (Math.random() * 720));
    skeleton.draw(g);
  }
}