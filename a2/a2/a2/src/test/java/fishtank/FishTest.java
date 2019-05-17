package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertTrue;

public class FishTest {

    /* Note: FishTest is in the package fishtank, so it has access to package
       private attributes.

       Also note: It's *vital* that you name any other test classes
       (ClassName)Test in the same directory as this one is in.
       properly capitalized -- we will be autograding your tests, so make sure
       to follow this naming convention!
     */
    private Fish fish;


    @Before
    public void setUp() {
        FishTank.setNull();

        fish = new Fish();
    }

    @Test
    public void testFishBubbles() {
        //Note: This test currently fails, but should pass once you've
      // refactored &
        //fixed the starter code.
        boolean bubbleMade = false;
        for (int i = 0; i < 200; i++) {
            fish.setLocation(5, 10);
            fish.goingRight =
                false; //notice: I can edit package private attributes!
            fish.update();
            //fish should move one tile left and eventually blow a bubble.
            FishTankEntity e = FishTank.getEntity(5 - 1, 10);
            if (e instanceof Bubble) {
                bubbleMade = true;
                e = null;
                break;
            }
        }
        //You could also write "assert bubbleMade", but using the JUnit version
        //makes the message much nicer if it fails.
        assertTrue(bubbleMade);
    }

    //Might create for loops for any y and x if have time

    @Test
    public void testRight(){
        boolean in = false;
        fish.setLocation(105, 4);
        fish.goingRight = true;
        fish.update();
        if (fish.getX() <= 105){
            in = true;
        }

        assertTrue(in);
    }

    @Test
    public void testLeft(){
        boolean in = false;
        fish.setLocation(0, 4);
        fish.goingRight = false;
        fish.update();
        if (fish.getX() >= 0){
            in = true;
        }

        assertTrue(in);

    }

    @Test
    public void testUp(){
        boolean in = false;
        fish.setLocation(4, 0);
        fish.update();
        if (fish.getY() >= 0){
            in = true;
        }

        assertTrue(in);

    }

    @Test
    public void testDown(){

        boolean in = false;
        fish.setLocation(4, 47);
        fish.update();
        if (fish.getY() <= 47){
            in = true;
        }

        assertTrue(in);

    }

    @Test
    public void testgoingRightAlways(){


        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}


        boolean right = true;
        fish.setLocation(0, 47);
        FishTank.addEntity(0,47,fish);
        for (int i = 0; i<100; i++){
            //System.out.println(fish.getX() + ":" + fish.getY());
            fish.goingRight = true;
            int oldX = fish.getX();
            fish.update();
            fish.setLocation(fish.getX(),47);
            int newX = fish.getX();
            if(newX<oldX){
                right = false;
                System.out.println(oldX + ":" + newX);
                System.out.println((FishTank.getEntity(oldX + 1,fish.getY()).getClass()));
                System.out.println("Thing at:"+ (oldX + 1) +":"+ fish.getY());
                System.out.println("Where going right failed"+oldX + ":" + newX);
            }
        }
        assertTrue(right);

    }


    @Test
    public void testgoingLeftAlways(){


        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

        boolean left = true;
        fish.setLocation(105, 47);
        FishTank.addEntity(105,30,fish);
        for (int i = 100; i>0; i--){
            fish.goingRight = false;
            int oldX = fish.getX();
            fish.update();
            fish.setLocation(fish.getX(),47);
            int newX = fish.getX();
            if(oldX<newX){
                left = false;
                System.out.println(oldX + ":" + newX);
                //System.out.println((FishTank.getEntity(oldX - 1,fish.getY()).getClass()));
                System.out.println("Thing at:"+ (oldX - 1) +":"+ fish.getY());
                System.out.println("Where going left failed"+oldX + ":" + newX);
            }
        }
        assertTrue(left);

    }

    @Test
    public void testcollisionFishGoingRight(){
            fish.setLocation(10,20);
            Fish fish2 = mock(Fish.class);
            fish2.setLocation(11,20);
            FishTank.addEntity(10,20,fish);
            FishTank.addEntity(11,20,fish2);
            fish.goingRight = true;
            //fish2.goingRight = false;
            fish.update();
            fish2 = null;
            assertTrue(fish.getX() != 11 || fish.getY() != 20);
            //System.out.println(fish.getX() + ":" + fish.getY());
    }

    @Test
    public void testcollisionFishGoingLeft(){
        fish.setLocation(10,35);
        Fish fish2 = mock(Fish.class);
        fish2.setLocation(9,35);
        FishTank.addEntity(10,35,fish);
        FishTank.addEntity(9,35,fish2);
        fish.goingRight = false;
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue(fish.getX() != 9 || fish.getY() != 35);

    }

    @Test
    public void testCollisionFishGoingUp(){
        fish.setLocation(10,35);
        Fish fish2 = mock(Fish.class);
        fish2.setLocation(10,34);
        FishTank.addEntity(10,35,fish);
        FishTank.addEntity(10,34,fish2);
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue( fish.getX() != 10 || fish.getY() != 34);

    }

    @Test
    public void testCollisionFishGoingDown(){
        fish.setLocation(10,34);
        Fish fish2 = mock(Fish.class);
        fish2.setLocation(10,35);
        FishTank.addEntity(10,34,fish);
        FishTank.addEntity(10,35,fish2);
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue( fish.getX() != 10 || fish.getY() != 35);

    }

    //_________________________________________________________

    @Test
    public void testcollisionBubbleGoingRight(){
        fish.setLocation(10,20);
        Bubble fish2 = mock(Bubble.class);
        fish2.setLocation(11,20);
        FishTank.addEntity(10,20,fish);
        FishTank.addEntity(11,20,fish2);
        fish.goingRight = true;
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        assertTrue(fish.getX() != 11 || fish.getY() != 20);
        //System.out.println(fish.getX() + ":" + fish.getY());
    }

    @Test
    public void testcollisionBubbleGoingLeft(){
        fish.setLocation(10,35);
        Bubble fish2 = mock(Bubble.class);
        fish2.setLocation(9,35);
        FishTank.addEntity(10,35,fish);
        FishTank.addEntity(9,35,fish2);
        fish.goingRight = false;
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue(fish.getX() != 9 || fish.getY() != 35);

    }

    @Test
    public void testCollisionBubbleGoingUp(){
        fish.setLocation(10,35);
        Bubble fish2 = mock(Bubble.class);
        fish2.setLocation(10,34);
        FishTank.addEntity(10,35,fish);
        FishTank.addEntity(10,34,fish2);
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue( fish.getX() != 10 || fish.getY() != 34);

    }

    @Test
    public void testCollisionBubbleGoingDown(){
        fish.setLocation(10,34);
        Bubble fish2 = mock(Bubble.class);
        fish2.setLocation(10,35);
        FishTank.addEntity(10,34,fish);
        FishTank.addEntity(10,35,fish2);
        //fish2.goingRight = false;
        fish.update();
        fish2 = null;
        System.out.println(fish.getX() + ":" + fish.getY());
        assertTrue( fish.getX() != 10 || fish.getY() != 35);

    }





    @Test
    public void testmoveUpOrDown(){

        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

        int counter = 0;
        fish.setLocation(10,23);
        FishTank.addEntity(10,23,fish);
        for (int i = 0; i<1000; i++){
            int oldY = fish.getY();
            fish.update();
            //System.out.println(fish.getX()+":"+fish.getY());
            int newY = fish.getY();
            if(newY!=oldY){
                counter+=1;
                //fish.setLocation(10,23);
            }


        }

        System.out.println("Counter is"+" "+counter);
        assertTrue(counter>=50 && counter<=150);

        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testbubbleblowBehavior(){



        int counter = 0;
        fish.setLocation(10,47);
        FishTank.addEntity(10,47,fish);
        for (int i = 0; i<1000; i++){
            fish.setLocation(10,47);
            fish.update();
            //System.out.println(fish.getX()+":"+fish.getY());
            FishTankEntity e = FishTank.getEntity(fish.getX(), fish.getY()-1);
            if(e instanceof Bubble ){
                counter+=1;
                //System.out.println("Bubble?"+e.getX()+":"+e.getY());
                e = null;
            }


        }
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

        System.out.println("Bubble Counter is"+" "+counter);
        assertTrue(counter>=50 && counter<=150);

    }

    @Test
    public void testTurining(){
        int counter = 0;
        fish.setLocation(10,23);
        FishTank.addEntity(10,23,fish);
        String looknow = "";

        for (int i = 0; i<1000; i++) {
            looknow = fish.appearance;
            fish.update();
            String newlook = fish.appearance;
            if(!looknow.equals(newlook))
            {
                counter += 1;
            }
        }
        System.out.println("Turnaround Counter is"+" "+counter);
        assertTrue(counter>=50 && counter<=150);

        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }



}
