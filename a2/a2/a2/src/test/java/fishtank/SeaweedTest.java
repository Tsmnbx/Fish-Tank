package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertTrue;


public class SeaweedTest {
    private Seaweed plant;

    @Before

    public void setUp()
    {FishTank.setNull();
    plant = new Seaweed(10);
    }


    @Test
    public void testSeaWeedGrowth(){
        boolean grow = false;
        plant.setLength(1);
        plant.setLocation(8,13);
        for (int i = 0; i < 200; i++){
            plant.update();
        }
        if(plant.getLength() == 2){
            grow = true;
        }

        assertTrue(grow);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }

    @Test
    public void testSeaWeedLength(){
        boolean grow = false;
        plant.setLength(1);
        plant.setLocation(8,13);
        for (int i = 0; i < 1800; i++){
            plant.update();
        }
        if(plant.l== 10){
            grow = true;
        }

        assertTrue(grow);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }

    @Test
    public void testfishCut(){
        plant.setLocation(8,0);
        FishTank.addEntity(8,13,plant);
        Fish fish = mock(Fish.class);
        fish.setLocation(8,13);
        FishTank.addEntity(8,10,fish);
        plant.update();
        fish = null;
        int newL = 3;
        assertEquals(newL,plant.l);
        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}

    }

    @Test
    public void testnoCuttingAtOne(){
        plant.setLocation(8,13);
        plant.l = 1;
        FishTank.addEntity(8,13,plant);
        Fish fish = mock(Fish.class);
        fish.setLocation(8,13);
        FishTank.addEntity(8,13,fish);
        plant.update();
        int newL = 1;
        assertEquals(newL,plant.l);

        for (int x = 0; x < 106; x++) {
            for (int y = 0; y < 48; y++) {
                FishTankEntity e = FishTank.getEntity(x,y);
                e = null;

            }}
    }


}
