import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IndexTable {
  private int size;
  private GameObject[][] tileLocationMatrix = readPlan("Gamefield.txt");

  public IndexTable() {
    this.size = 72;
  }

  public GameObject[][] readPlan(String fileAccessPath) {
    List<String> content = new ArrayList<>();
    Path filePath = Paths.get(fileAccessPath);
    try {
      content = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Reading error");
    }
    GameObject[][] coordList = new GameObject[content.size()][content.get(0).length()];
    for (int i = 0; i < content.size(); i++) {
      for (int j = 0; j < content.get(i).length(); j++) {
        if (content.get(i).charAt(j) == 'w') {
          Wall wall = new Wall();
          coordList[i][j] = wall;
        } else if (content.get(i).charAt(j) == 'p') {
          Floor floor = new Floor();
          coordList[i][j] = floor;
        }
      }
    }
    return coordList;
  }

  public void drawTileField(Graphics g) {
    for (int y = 0; y < tileLocationMatrix.length; y++) {
      for (int x = 0; x < tileLocationMatrix[y].length; x++) {
        PositionedImage tile = new PositionedImage(tileLocationMatrix[y][x].filePath,
            x * size, y * size);
        tile.draw(g);
      }
    }
  }

  public boolean isWall(int x, int y) {
    if (tileLocationMatrix.length > x && tileLocationMatrix.length > y && x >= 0 && y >= 0) {
      return this.tileLocationMatrix[y][x].getFilePath().equals("img/wall.png");
    } return true;
  }
}