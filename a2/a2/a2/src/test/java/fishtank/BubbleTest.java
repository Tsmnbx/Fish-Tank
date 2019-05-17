package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertTrue;




public class BubbleTest {
        private Bubble bub;
        private Fish fish;

    @Before
    public void setUp()
    {
        FishTank.setNull();
        bub = new Bubble();
        fish = mock(Fish.class);

    }

    //14) Testing the bounds of the bubble and making sure it deletes off map
    @Test
    public void testUpBound(){
        boolean in = false;
        bub.setLocation(4,0);
        bub.floatStraightUp();
        if(bub.getY()>=-1){
            in = true;
        }

        assertTrue(in);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testLeftUpBound(){
        boolean in = false;
        bub.setLocation(0,0);
        bub.floatLeftUp();
        if((bub.getY()>=-1) && (bub.getX()>=-1)){
            in = true;
        }

        assertTrue(in);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testRightUpBound(){
        boolean in = false;
        bub.setLocation(0,0);
        bub.floatRightUp();
        if((bub.getY()>=-1) && (bub.getX()<=bub.xBd)){
            in = true;
        }

        assertTrue(in);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }


    //13) Making sure the bubbles move behavior is correct
    @Test
    public void testrightTimes(){
            int counter = 0;
            bub.setLocation(24,105);
            for(int i = 0; i< 1000; i++){
                int oldX = bub.getX();
                bub.update();
                int newX = bub.getX();
                if(newX > oldX){counter+=1;}
            }
            assertTrue(counter >= 280 && counter <= 380);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testleftTimes(){
        int counter = 0;
        bub.setLocation(24,105);
        for(int i = 0; i< 1000; i++){
            int oldX = bub.getX();
            bub.update();
            int newX = bub.getX();
            if(newX < oldX){counter+=1;}
        }
        assertTrue(counter >= 280 && counter <= 380);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testalwaysUp(){
        boolean up = true;
        bub.setLocation(32,47);
        for(int i = 0; i< 48; i++){
            int oldY = bub.getY();
            bub.update();
            int newY = bub.getY();
            if(newY > oldY){
                up = false;
            }
        }
        assertTrue(up);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }


    @Test
    public void testFishCollisions(){
        boolean still= false;
        fish.setLocation(20,19);
        bub.setLocation(20,20);
        FishTank.addEntity(20,19,fish);
        FishTank.addEntity(20,20,bub);
        bub.update();
        if(bub.getX() !=20 || bub.getY() !=19){
            still = true;
        }

        assertTrue(still);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }


    @Test
    public void testBubbleCollisions(){
        boolean still= false;
        Bubble bub2 = mock(Bubble.class);
        bub2.setLocation(20,19);
        bub.setLocation(20,20);
        FishTank.addEntity(20,19,bub2);
        FishTank.addEntity(20,20,bub);
        System.out.println(FishTank.getEntity(20,19)instanceof Bubble);

        bub.update();
        if(bub.getX() !=20 || bub.getY() !=19){
            still = true;
        }
        System.out.println(FishTank.getEntity(20,19)instanceof Bubble);
        System.out.println(bub.getX());
        System.out.println(bub.getY());
        assertTrue(still);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }

    @Test
    public void testSeaWeedCollisions(){
        boolean still= false;
        Seaweed plant = mock(Seaweed.class);
        plant.setLocation(20,19);
        bub.setLocation(20,20);
        FishTank.addEntity(20,19,plant);
        FishTank.addEntity(20,20,bub);

        bub.update();
        if(bub.getX() !=20 || bub.getY() !=19){
            still = true;
        }
        assertTrue(still);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }


    public void testFollowFishCollisions(){
        boolean still= false;
        FollowingFish bub2 = mock(FollowingFish.class);
        bub2.setLocation(20,19);
        bub.setLocation(20,20);
        FishTank.addEntity(20,19,bub2);
        FishTank.addEntity(20,20,bub);

        bub.update();
        if(bub.getX() !=20 || bub.getY() !=19){
            still = true;
        }
        assertTrue(still);

        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }



}



