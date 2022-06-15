import java.io.*;
import java.util.LinkedList;

public class SaveLoad implements Serializable {
    private static File trFile = new File("src/Triangles_SaveLoad.txt");
    private static File rtFile = new File("src/Right_Triangles_SaveLoad.txt");
    private Triangle_LinkList tr = new Triangle_LinkList();

    //Сохранить список треугольников в файл
    public boolean trSave(Triangle_LinkList list) {
        var clonedList = list.trList.clone();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(trFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clonedList);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //Сохранить список прямоугольных треугольников в файл
    public boolean rtSave(Triangle_LinkList list) {
        var clonedList = list.rtList.clone();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(rtFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clonedList);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //Загрузить из файла список треугольников
    public Triangle_LinkList trLoad() {
        try {
            FileInputStream fileInputStream = new FileInputStream(trFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tr.trList = (LinkedList<Triangle>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return tr;
    }

    //Загрузить из файла список прямоугольных треугольников
    public Triangle_LinkList rtLoad() {
        try {
            FileInputStream fileInputStream = new FileInputStream(rtFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tr.rtList = (LinkedList<Right_triangle>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return tr;
    }
}
