import java.io.Serializable;

public class Triangle implements Serializable {

    protected double[] pointA = new double[2];

    public double[] GetPointA() {
        return pointA;
    }

    public void SetPointA(double x, double y) {
        pointA[0] = x;
        pointA[1] = y;
    }

    protected double[] pointB = new double[2];

    public double[] GetPointB() {
        return pointB;
    }

    public void SetPointB(double x, double y) {
        pointB[0] = x;
        pointB[1] = y;
    }

    protected double[] pointC = new double[2];

    public double[] GetPointC() {
        return pointC;
    }

    public void SetPointC(double x, double y) {
        pointC[0] = x;
        pointC[1] = y;
    }

    protected double AB;

    public void setAB() {
        this.AB = Math.sqrt(Math.pow((this.pointB[0] - this.pointA[0]), 2) + Math.pow((this.pointB[1] - this.pointA[1]), 2));
    }

    public double getAB() {
        setAB();
        return AB;
    }

    protected double BC;

    public void setBC() {
        this.BC = Math.sqrt(Math.pow((this.pointC[0] - this.pointB[0]), 2) + Math.pow((this.pointC[1] - this.pointB[1]), 2));
    }

    public double getBC() {
        setBC();
        return BC;
    }

    protected double AC;

    public void setAC() {
        this.AC = Math.sqrt(Math.pow((this.pointC[0] - this.pointA[0]), 2) + Math.pow((this.pointC[1] - this.pointA[1]), 2));
    }

    public double getAC() {
        setAC();
        return AC;
    }

    protected boolean IsRealTriangle;

    //Проверка на то, является ли треугольник реальным
    public void IsReal() {
        if ((getAB() + getBC()) > getAC() && (getAB() + getAC()) > getBC() && (getBC() + getBC()) > getAB()) {
            this.IsRealTriangle = true;
        } else {
            this.IsRealTriangle = false;
        }
    }

    public boolean IsReal(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.SetPointA(x1, y1);
        this.SetPointB(x2, y2);
        this.SetPointC(x3, y3);
        if ((getAB() + getBC()) > getAC() && (getAB() + getAC()) > getBC() && (getBC() + getBC()) > getAB()) {
            return true;
        } else {
            return false;
        }
    }

    protected double Perimeter;

    //Периметр треугольника
    public void setPerimeter() {
        this.Perimeter = getAB() + getBC() + getAC();
    }

    public double getPerimeter() {
        return this.Perimeter;
    }

    protected double Area;

    //Площадь треугольника
    public void setArea() {
        double p = getPerimeter() / 2;
        this.Area = Math.sqrt(p * (p - getAB()) * (p - getBC()) * (p - getAC()));
    }

    public double getArea() {
        return this.Area;
    }

    protected int angleA;

    //Угол А
    public void setAngleA() {
        this.angleA = (int) Math.toDegrees((Math.pow(getAB(), 2) + Math.pow(getAC(), 2) - Math.pow(getBC(), 2)) / (2 * getAB() * getAC()));
    }

    public int getAngleA() {
        if (this.angleA < 0) {
            this.angleA *= -1;
        }
        return this.angleA;
    }

    protected int angleB;

    //Угол В
    public void setAngleB() {
        this.angleB = (int) Math.toDegrees((Math.pow(getBC(), 2) + Math.pow(getAB(), 2) - Math.pow(getAC(), 2)) / (2 * getBC() * getAB()));
    }

    public int getAngleB() {
        if (this.angleB < 0) {
            this.angleB *= -1;
        }
        return this.angleB;
    }

    protected int angleC;

    //Угол С
    public void setAngleC() {
        this.angleC = 180 - (getAngleA() + getAngleB());
    }

    public int getAngleC() {
        return this.angleC;
    }

    public Triangle() {
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.SetPointA(x1, y1);
        this.SetPointB(x2, y2);
        this.SetPointC(x3, y3);
        this.setAB();
        this.setBC();
        this.setAC();
        this.IsReal();
        this.setPerimeter();
        this.setArea();
        this.setAngleA();
        this.setAngleB();
        this.setAngleC();
    }

    //Вывод информации о треугольнике
    public void printInfo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Point A: " + this.GetPointA()[0] + " " + this.GetPointA()[1]);
        System.out.println("Point B: " + this.GetPointB()[0] + " " + this.GetPointB()[1]);
        System.out.println("Point C: " + this.GetPointC()[0] + " " + this.GetPointC()[1]);
        System.out.println("AB: " + this.getAB());
        System.out.println("BC: " + this.getBC());
        System.out.println("AC: " + this.getAC());
        System.out.println("IsRealTriangle: " + this.IsRealTriangle);
        System.out.println("Perimeter: " + this.getPerimeter());
        System.out.println("Area: " + this.getArea());
        System.out.println("Angle A: " + this.getAngleA());
        System.out.println("Angle B: " + this.getAngleB());
        System.out.println("Angle C: " + this.getAngleC());
    }
}
