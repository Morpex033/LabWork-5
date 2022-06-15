public class GenerateTriangles {

    //Создать три точки и проверить их на принадлежность к прямоугольному треугольнику
    public Triangle generateTriangle(){
        Triangle triangle = new Triangle();
        int[] x = new int[6];
        boolean flag = false;
        while(!flag){
            for(int i = 0; i < x.length; i++){
                x[i] = (int) (Math.random() * 100);
            }
            flag = triangle.IsReal(x[0], x[1], x[2], x[3], x[4], x[5]);
        }
        return new Triangle(x[0], x[1], x[2], x[3], x[4], x[5]);
    }

    //Создать три точки и проверить их на принадлежность к прямоугольному треугольнику
    public Right_triangle generateRightTriangle(){
        int[] x = new int[6];
        boolean flag = false;
        while(!flag){
            for(int i = 0; i < x.length; i++){
                x[i] = (int) (Math.random() * 100);
            }
            Right_triangle triangle = new Right_triangle(x[0], x[1], x[2], x[3], x[4], x[5]);
            if (triangle.checkRightAngle()){
                flag = true;
            }
        }
        return new Right_triangle(x[0], x[1], x[2], x[3], x[4], x[5]);
    }

    //Создать список треугольников
    public Triangle_LinkList generateTriangleLinkList(int n) {
        Triangle_LinkList trList = new Triangle_LinkList();
        for (int i = 0; i < n; i++) {
            trList.trList.add(generateTriangle());
        }
        return trList;
    }

    //Создать список прямоугольных треугольников
    public Triangle_LinkList generateRightTriangleLinkList(int m) {
        Triangle_LinkList rtList = new Triangle_LinkList();
        for (int i = 0; i < m; i++) {
            rtList.rtList.add(generateRightTriangle());
        }
        return rtList;
    }
}
