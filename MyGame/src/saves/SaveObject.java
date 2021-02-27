package saves;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Home on 25/2/2021.
 */
public class SaveObject implements Serializable {

  private HashMap<Integer, Integer> inventory;
  private boolean hasArmor;
  private int health;
  private int currentHealth;

  /*  To save items add
HashMap<Integer, Integer> inventory,*/
  public SaveObject(boolean hasArmor, int health,
      int currentHealth) {
//    this.inventory = inventory;
    this.hasArmor = hasArmor;
    this.health = health;
    this.currentHealth = currentHealth;
  }

/*  public HashMap<Integer, Integer> getInventory() {
    return this.inventory;
  }*/

  public boolean isHasArmor() {
    return this.hasArmor;
  }

  public int getHealth() {
    return this.health;
  }

  public int getCurrentHealth() {
    return this.currentHealth;
  }
}
