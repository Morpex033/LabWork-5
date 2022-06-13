import java.util.Scanner;

public class Main {
    //Написать программу, демонстрирующую
    //работу с классом: дано N треугольников и M прямоугольных треугольников, найти среднюю площадь и
    //минимальный периметр для N треугольников и прямоугольный треугольник с наибольшей гипотенузой.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter number of triangles: ");
        n = sc.nextInt();
        System.out.println("Enter number of right triangles: ");
        m = sc.nextInt();
        Triangle_LinkList trList = new GenerateTriangles().generateTriangleLinkList(n);
        Triangle_LinkList rtList = new GenerateTriangles().generateRightTriangleLinkList(m);
        double area = 0;
        double perimeter = trList.trList.get(0).getPerimeter();
        for (int i = 1; i < n; i++) {
            area += trList.trList.get(i).getArea();
            if (perimeter > trList.trList.get(i).getPerimeter()) {
                perimeter = trList.trList.get(i).getPerimeter();
            }
        }
        System.out.println("Average area: " + area / n);
        System.out.println("Minimal perimeter: " + perimeter);
        double hypotenuse = rtList.rtList.get(0).getMaxSide();
        for (int i = 1; i < m; i++) {
            if (hypotenuse < rtList.rtList.get(i).getMaxSide()) {
                hypotenuse = rtList.rtList.get(i).getMaxSide();
            }
        }
        System.out.println("Maximal hypotenuse of right triangle: " + hypotenuse);
    }
}