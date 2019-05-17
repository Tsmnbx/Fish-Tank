package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FollowingFishTest {
  private Fish followee;
  private FollowingFish follower;

  @Before
  public void setUp() {
    FishTank.setNull();

    followee = mock(Fish.class);
    //note: this is also why we use getters and setters so much in Java,
    //we wouldn't be able to mock the field itself if it were used instead
    //of the getter.
    when(followee.getX()).thenReturn(5);
    //This syntax is introduced by a library called mockito.
    //You can use it however you want, and it will be installed when we
    //run the grader.
    //See: http://www.vogella.com/tutorials/Mockito/article.html from 4 onwards
    when(followee.getY()).thenReturn(10);

    follower = new FollowingFish(followee);
    follower.setLocation(20, 20);
  }

  @Test
  public void testApproachesFromBottomRight() {
    //it should take exactly 15 updates to get from
    //(20, 20) to (5, 10)
    for(int i = 0; i < 15; i++) {
      follower.update();
      System.out.println(follower.getX()+":"+follower.getY());
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(2, vertDist);
    assertEquals(0, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }

  @Test
  public void testApproachesFromBottomLeft() {
    //it should take exactly 15 updates to get from
    //(20, 20) to (35, 10)
    when(followee.getX()).thenReturn(35);
    follower.setLocation(20, 20);
    for(int i = 0; i < 15; i++) {
      follower.update();
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(2, vertDist);
    assertEquals(0, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }

  @Test
  public void testApproachesFromTopLeft() {
    //it should take exactly 15 updates to get from
    //(20, 20) to (35, 30)
    when(followee.getX()).thenReturn(35);
    when(followee.getY()).thenReturn(30);
    follower.setLocation(20, 20);
    for(int i = 0; i < 15; i++) {
      follower.update();
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(2, vertDist);
    assertEquals(0, horizDist);
    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }


  @Test
  public void testApproachesFromTopRight() {
    //it should take exactly 15 updates to get from
    //(20, 20) to (5, 10)
    when(followee.getX()).thenReturn(5);
    when(followee.getY()).thenReturn(30);
    follower.setLocation(20, 20);
    for(int i = 0; i < 15; i++) {
      follower.update();
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(2, vertDist);
    assertEquals(0, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }


  @Test
  public void testApproachFromCorner(){
    when(followee.getX()).thenReturn(5);
    when(followee.getY()).thenReturn(1);
    follower.setLocation(0, 0);
    for(int i = 0; i < 3; i++) {
      follower.update();
      System.out.println(follower.getX()+":"+follower.getY());
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(1, vertDist);
    assertEquals(1, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }

  @Test
  public void testApproachFromSide(){
    when(followee.getX()).thenReturn(5);
    when(followee.getY()).thenReturn(0);
    follower.setLocation(0, 0);
    for(int i = 0; i < 2; i++) {
      follower.update();
      System.out.println(follower.getX()+":"+follower.getY());
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(0, vertDist);
    assertEquals(2, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }

  @Test
  public void testStayStill(){
    when(followee.getX()).thenReturn(1);
    when(followee.getY()).thenReturn(1);
    follower.setLocation(0, 0);
    for(int i = 0; i < 2; i++) {
      follower.update();
      System.out.println(follower.getX()+":"+follower.getY());
    }
    int vertDist = Math.abs(follower.getY() - followee.getY());
    int horizDist = Math.abs(follower.getX() - followee.getX());
    //Follower should be exactly 2 units below followee.
    assertEquals(1, vertDist);
    assertEquals(1, horizDist);

    for (int x = 0; x < 106; x++) {
      for (int y = 0; y < 48; y++) {
        FishTankEntity e = FishTank.getEntity(x,y);
        e = null;

      }}
  }


}
