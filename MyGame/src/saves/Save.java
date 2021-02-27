package saves;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by Home on 2/25/2021.
 */
public class Save {

/*  To save items add
HashMap<Integer, Integer> items,*/
  public static void exportSave( boolean hasArmor, int health,
      int currentHealth) throws IOException {

    String path = System.getProperty("user.dir") + "\\save.ser";
    /*  To save items add
items,*/
    SaveObject saveObject = new SaveObject(hasArmor, health, currentHealth);
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
      oos.writeObject(saveObject);
      System.out.println("success");
    } catch (NotSerializableException e) {
      e.getCause().printStackTrace();
    }
  }

  public static SaveObject importSave() {
    String path = System.getProperty("user.dir") + "\\save.ser";
    SaveObject object = null;
    try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path))) {
      object = (SaveObject) oos.readObject();

    } catch (NotSerializableException e) {
      e.getCause().printStackTrace();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return object;
  }
}
