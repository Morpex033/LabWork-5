public class Right_triangle extends Triangle {

    public Right_triangle() {
    }

    public Right_triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    public boolean checkRinghtAngle(){
        if(super.getAngleA() == 90 || super.getAngleB() == 90 || super.getAngleC() == 90){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("This is right triangle!");
    }

    double MaxSide;

    public double getMaxSide() {
        if (super.getAB() > super.getAC() && super.getAB() > super.getBC()) {
            MaxSide = super.getAB();
            return MaxSide;
        } else if (super.getAC() > super.getAB() && super.getAC() > super.getBC()) {
            MaxSide = super.getAC();
            return MaxSide;
        } else {
            MaxSide = super.getBC();
            return MaxSide;
        }
    }
}
