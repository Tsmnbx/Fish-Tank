package fishtank;
import java.awt.*;

/**
 * A bubble.
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public class Bubble extends FishTankEntity {

    /** How this bubble appears on the screen. */
    private String appearance;

    /** The font used to draw instances of this class. */
    @SuppressWarnings("CanBeFinal")
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);

    /** My colour. Ah, the vagaries of British vs. US spelling. */
    @SuppressWarnings("CanBeFinal")
    Color colour;

    /** Use for random movement left and right.  */
    public double d;

    /** This bubble's first coordinate. */
    int x;
    /** This bubble's second coordinate. */
    protected int y;



    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Bubble() {
        // Get a nice-looking grey for the bubble
         colour = Color.gray.darker().darker().darker();
         // start off with . as the appearance
        appearance = ".";
    }

    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
        // set x to a
      x = a;
        // set y to b
      y = b;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  g  the graphics context in which to draw the string.
     * @param  s  the string to draw.
     * @param  x  the x-coordinate of the string's cursor location.
     * @param  y  the y-coordinate of the string's cursor location.
     */
    void drawString(Graphics g, String s, int x, int y) {
        g.setColor(colour);
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics(FONT);
        g.drawString(s, y*fm.charWidth('W'), x*fm.getAscent());
    }


    /**
     * Draws this fish tank item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    void draw(Graphics g) {
        drawString(g, appearance, y, x);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation, moving straight up.
     */
//_________________________________________________________________
    //Grow a bubble
    private void grow(){
        // Figure out whether to grow, if at all.
        d = Math.random();
        // Oocasinally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals("."))appearance="o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o"))appearance="O";
        }
    }

    private void should_delete(){
        if ((y-1 < 0)||(x-1 < 0)||(x+1 > xBd)){
            delete();
        }
    }

    private boolean avoidCollisionUp(){

        if(notLegalMoveY(-1)) {if ((FishTank.getEntity(x,y-1) != null)){
            return false;
        }}

        return true;
    }

    private boolean avoidCollisionL(){
        if(notLegalMoveX(-1) && notLegalMoveY(-1)){if ((FishTank.getEntity(x - 1,y-1) != null)){
            return false;
        }}

        return true;
    }

    private boolean avoidCollisionR(){
        if(notLegalMoveX(+1) && notLegalMoveY(-1)){if ((FishTank.getEntity(x + 1,y-1) != null)){
            return false;
        }}

        return true;
    }

    private boolean notLegalMoveY(int i){
        int Y = y + i;
        return 0 <= Y && Y <= yBd;
    }

    private boolean notLegalMoveX(int i){
        int X = x + i;
        return 0 <= X && X <= xBd;
    }


//__________________________________________________________________


    public void floatStraightUp() {
        grow();
        // Move upwards.
        if(avoidCollisionUp()){
            y--;
            x = x; // no change left or right
             }



    }
    /**
     * Causes this item to take its turn in the fish-tank simulation, moving up and left.
     */
    public void floatLeftUp() {
        grow();
        if(avoidCollisionL()){
            // Move upwards.
            y--;
            x -= 1; //left
        }
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void floatRightUp() {
        grow();

        if (avoidCollisionR()){
            // Move upwards.
            y--;
            x += 1;// right
        }

    }


    public void update() {
        should_delete();
        d = Math.random();
            if (d < 0.33) {
                floatStraightUp();
            } else if (d < 0.66) {
                floatRightUp();
            } else /* heybub.d >= 0.66 */ {
                floatLeftUp();
            }


    }

    //_________________________________________//



}
