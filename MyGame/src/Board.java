import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Board extends JComponent implements KeyListener {

  int width;
  int height;

  IndexTable field = new IndexTable();
  Hero hero = new Hero();
  Skeleton skeleton = new Skeleton();


  public Board() {
    width = 720;
    height = 720;
    // set the size of your draw board
    setPreferredSize(new Dimension(width, height));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    field.drawTileField(graphics);
    hero.drawHero(graphics);
    skeleton.drawSkeleton(graphics);

    repaint();

  }

  public static void main(String[] args) {
    // Here is how you set up a new window and adding our board to it
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    // Here is how you can add a key event listener
    // The board object will be notified when hitting any key
    // with the system calling one of the below 3 methods
    frame.addKeyListener(board);
    // Notice (at the top) that we can only do this
    // because this Board class (the type of the board object) is also a KeyListener

  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }
  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box
    int unitX = width / 10;
    int unitY = height / 10;

    if (e.getKeyCode() == KeyEvent.VK_UP) {
      hero.heroDirection("up");
      if (!field.isWall(hero.getHeroPosX() / unitX,
          (hero.getHeroPosY() - unitY) / unitY)) {
        hero.setHeroPosY(hero.heroPosY -= unitY);
      }

    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.heroDirection("down");
      if (!field.isWall(hero.getHeroPosX() / unitX,
          (hero.getHeroPosY() + unitY) / unitY)) {
        hero.setHeroPosY(hero.heroPosY += unitY);
      }
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

      hero.heroDirection("right");
      if (!field.isWall((hero.getHeroPosX() + unitX) / unitX,
          hero.getHeroPosY() / unitY)) {
        hero.setHeroPosX(hero.heroPosX += unitX);
      }
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

      hero.heroDirection("left");
      if (!field.isWall((hero.getHeroPosX() - unitX) / unitX,
          hero.getHeroPosY() / unitY)) {
        hero.setHeroPosX(hero.heroPosX -= unitX);
      }
    }
    System.out.println(hero.heroPosX + " " + hero.heroPosY);
    // and redraw to have a new picture with the new coordinates
    repaint();
  }
}
