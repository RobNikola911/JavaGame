import controllers.GameController;

public class StartGame {

  public static void main(String[] args) {
    GameController gameController = new GameController("wanderer", 720, 720);
    gameController.start();
  }
}