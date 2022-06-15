import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExitSave extends SaveLoad {

    //Сохраняет список треугольников в файл при выходе из программы
    public void save(Triangle_LinkList list) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        super.trFile = new File("src/Save/Right_Triangles_SaveLoad_" + time + ".txt");
        super.rtFile = new File("src/Save/Triangles_SaveLoad_" + time + ".txt");
        trSave(list);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rtSave(list);
        if (trSave(list) && rtSave(list)) {
            System.out.println("Saved!");
        } else {
            System.out.println("Failed to save!");
        }
    }

    public ExitSave() {
    }
}
