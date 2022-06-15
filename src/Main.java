import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Main implements Serializable {
    //Написать программу, демонстрирующую
    //работу с классом: дано N треугольников и M прямоугольных треугольников, найти среднюю площадь и
    //минимальный периметр для N треугольников и прямоугольный треугольник с наибольшей гипотенузой.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        System.out.println("Enter number of triangles: ");
        n = getNumber(n);
        System.out.println("Enter number of right triangles: ");
        m = getNumber(m);
        Triangle_LinkList trList = new GenerateTriangles().generateTriangleLinkList(n);
        trList.rtList = new GenerateTriangles().generateRightTriangleLinkList(m).rtList;
        System.out.println("Average area: " + averageArea(trList.trList));
        System.out.println("Minimal perimeter: " + minimalPerimeter(trList.trList));
        System.out.println("Maximal hypotenuse of right triangle: " + maximalHypotenuse(trList.rtList));
        SaveLoad saveLoad = new SaveLoad();
        saveLoad.trSave(trList);
        saveLoad.rtSave(trList);
        System.out.println("Saved to files");
        trList.rtList.clear();
        trList.trList.clear();
        System.out.println("Cleared");
        System.out.println("Loaded from files");
        System.out.println("Waiting for loading...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trList = saveLoad.trLoad();
        trList = saveLoad.rtLoad();
        System.out.println("Average area: " + averageArea(trList.trList));
        System.out.println("Minimal perimeter: " + minimalPerimeter(trList.trList));
        System.out.println("Maximal hypotenuse of right triangle: " + maximalHypotenuse(trList.rtList));
        ExitSave exitSave = new ExitSave();
        exitSave.save(trList);
    }

    //Написать метод, вычисляющий среднюю площадь треугольников в списке
    static double averageArea(LinkedList<Triangle> trList) {
        double area = 0;
        for (int i = 0; i < trList.size(); i++) {
            area += trList.get(i).getArea();
        }
        return area / trList.size();
    }

    //Написать метод, вычисляющий минимальный периметр треугольников в списке
    static double minimalPerimeter(LinkedList<Triangle> trList) {
        double perimeter = trList.get(0).getPerimeter();
        for (int i = 1; i < trList.size(); i++) {
            if (perimeter > trList.get(i).getPerimeter()) {
                perimeter = trList.get(i).getPerimeter();
            }
        }
        return perimeter;
    }

    //Написать метод, вычисляющий максимальную гипотенузу прямоугольного треугольника в списке
    static double maximalHypotenuse(LinkedList<Right_triangle> trList) {
        double hypotenuse = trList.get(0).getMaxSide();
        for (int i = 1; i < trList.size(); i++) {
            if (hypotenuse < trList.get(i).getMaxSide()) {
                hypotenuse = trList.get(i).getMaxSide();
            }
        }
        return hypotenuse;
    }


    //Метод, проверяющий введенное число на правильность ввода
    static int getNumber(Integer number) {
        Scanner sc = new Scanner(System.in);
        boolean isNumber = false;
        do {
            try {
                String str = sc.nextLine();
                number = Integer.parseInt(str);
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
            }
        } while (!isNumber);
        return number;
    }
}