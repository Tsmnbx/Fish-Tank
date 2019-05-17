package fishtank;

/**
 * In Java, an "abstract class" is just a class that doesn't implement
 * some of its methods.
 *
 * In CSC148, you've seen things like this before, where every method in a class
 * simply raised a NotImplementedError. Those are also called abstract classes,
 * and fulfill a similar purpose (try replacing a usage of FishTankEntity with
 * Object in FishTank.java and see if you can understand why it doesn't work.)
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public abstract class FishTankEntity {

    public int xBd =105;
    public int yBd = 47;
    public int length = 0;
    public int height = 0;

    public boolean canMoveTo(int x,int y){
        if (x<0){
            return false;
        }
        if (x>xBd){
            return false;
        }
        if (y<0){
            return false;
        }

        if(y>yBd){
            return false;
        }
        return FishTank.getEntity(x, y) == null;
    }


    private boolean exists = true;

    abstract void update();
    abstract void setLocation(int x, int y);

    void delete() {
        exists = false;
    }

    boolean exists() {
        return this.exists;
    }

    abstract int getX();
    abstract int getY();
}
