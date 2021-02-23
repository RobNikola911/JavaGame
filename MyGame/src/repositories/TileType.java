package repositories;

public enum TileType {

  FLOOR("floor", false),
  WALL("wall", true);

  String textureName;
  boolean wallType;

  TileType(String textureName, boolean wallType) {
    this.textureName = textureName;
    this.wallType = wallType;
  }
}