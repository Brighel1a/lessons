public class Point {
  public int x;
  public int y;


  //constructor
  Point(int a, int b) {
    x = a;
    y = b;
  }

  public double distance(Point point1, Point point2) {
    double d = Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y));
    return d;
  }

  public double oneMoreDistance(Point point2) {
    return Math.sqrt((x - point2.x) * (x - point2.x) + (y - point2.y) * (y - point2.y));
  }

}
