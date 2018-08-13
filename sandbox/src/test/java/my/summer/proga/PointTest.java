package my.summer.proga;


import org.testng.Assert;
import org.testng.annotations.Test;



public class PointTest {

  @Test
  public void test(){
    Point P3 = new Point(4, 5);
    Point P4 = new Point(1,1);

    Assert.assertEquals(P3.oneMoreDistance(P4), 5.0);
  }


}
