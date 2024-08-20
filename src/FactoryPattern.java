import java.util.Scanner;

 interface Shape {
    void draw();
}

//circle
class Circle implements Shape{
    public void draw(){
        System.out.println("Drawing circle");
    }

}

//square
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}


abstract class ShapeFactory{
    public abstract Shape createShape();
}

class CircleFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class SquareFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Square();
    }
}




public class FactoryPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter shape you want to draw circle/square");
        String shapeType=sc.nextLine();
        ShapeFactory factory;
        if(shapeType.equalsIgnoreCase("circle")){
            factory=new CircleFactory();
        } else if (shapeType.equalsIgnoreCase("square")) {
            factory=new SquareFactory();
        }
        else{
            System.out.println("Unknown shape type");
            sc.close();
            return;

        }
        Shape shape= factory.createShape();
        shape.draw();
        sc.close();


    }
}