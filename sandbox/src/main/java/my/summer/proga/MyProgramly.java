package my.summer.proga;

public class MyProgramly {

  public static void main(String[] args){

    Square s =  new Square(5);

    Rectangle r = new Rectangle(5, 6);

    System.out.println("в главном классе квадрат " + "l = " + s.l +" " + s.area());
    System.out.println("в главном классе прямоугольник " + "a = "+ r.a+", b = " + r.b + " and area = " + r.area());
  }


}