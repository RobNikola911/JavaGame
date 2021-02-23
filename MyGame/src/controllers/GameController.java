package controllers;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import models.Board;
import repositories.GameMap;
import repositories.Hero;
import repositories.Tile;
import services.Images;

public class GameController implements Runnable {

  private Board board;
  public int width, height;
  public String title;
  private GameMap map;

  private static final int IMAGE_SIZE = 72;

  private boolean running = false;
  private Thread thread;

  private BufferStrategy bufferStrategy;
  private Graphics graphics;

  Hero hero = new Hero(0, 0);
  Tile tile = new Tile();


  public GameController(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;
  }

  private void init() {
    board = new Board(title, width, height);
    board.getFrame().addKeyListener(hero);
    map = new GameMap();
    Images.init();
  }

  private void upDate() {
  }

  private void render() {
    //Storing the data before displaying on the screen to make the display smoother
    bufferStrategy = board.getCanvas().getBufferStrategy();
    if (bufferStrategy == null) {
      board.getCanvas().createBufferStrategy(3);
      return;
    }
    graphics = bufferStrategy.getDrawGraphics();

    // Clear Screen
    graphics.clearRect(0, 0, width, height);

    // Draw here

    GameMap.drawMap(graphics);

    hero.render(graphics);

    //End drawing

    bufferStrategy.show();
    graphics.dispose();
  }


  /* Needs for Runnable interface
  starts the program, refresh the variables and renders the elements to the screen.
  At the end it is stopping the program if necessary
   */
  public void run() {
    init();
    while (running) {
      upDate();
      render();
    }
    stop();
  }

  //Starts the thread
  public synchronized void start() {
    if (running)
      return;
    running = true;
    thread = new Thread(this);
    thread.start();

  }

  //Stops the thread
  public synchronized void stop() {
    if (!running)
      return;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}