package fishtank;
import java.awt.*;

/**
 * A fish.
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public class Fish extends FishTankEntity {

    /** How this fish appears on the screen. */
    String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    /** This fish's first coordinate. */
    int X;
    /** This fish's second coordinate. */
    private int Y;
    /** The colour of this fish. */
    Color colour;

    private static int fishNum = 0;
    /* ____________Variables__________________________ */


    /**
     * Constructs a new fish.
     */
    public Fish() {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><>";
        goingRight = true;
        /*___________________*/

        //this.boundFunc();
        int id = fishNum;
        fishNum += 1;

    }



    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
      X = a;
      Y = b;
    }

    int getX() {
        return X;
    }

    int getY() {
        return Y;
    }


    /**
     * Causes this fish to blow a bubble.
     */
    protected void blowBubble() {
		  Bubble b = new Bubble();
		  int bubX =getX();
          int bubY =getY() - 1;

		  b.setLocation(X, bubY);
		  //System.out.println(X + " " + Y);

		  if(bubY>=0){FishTank.addEntity(X, bubY, b);}
    }



    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        String reverse = "";
        for (int i=appearance.length()-1; i>=0; i--) {
            switch (appearance.charAt(i)) {
            case ')': reverse += '('; break;
            case '(': reverse += ')'; break;
            case '>': reverse += '<'; break;
            case '<': reverse += '>'; break;
            case '}': reverse += '{'; break;
            case '{': reverse += '}'; break;
            case '[': reverse += ']'; break;
            case ']': reverse += '['; break;
            /*_________Added for Hungry Fish*/

            default: reverse += appearance.charAt(i); break;
            }
        }

        return reverse;
    }



    /**
     * Turns this fish around, causing it to reverse direction.
     */
    protected void turnAround() {
        goingRight = !goingRight;
        if (goingRight) {
            appearance = reverseAppearance();
        } else {
            appearance = reverseAppearance();
        }
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    /** The font used to draw instances of this class. */
    @SuppressWarnings("CanBeFinal")
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);


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
    public void draw(Graphics g) {
        drawString(g, appearance, X, Y);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    private boolean checkRight(){
        if(X+1 <= xBd){if (FishTank.getEntity(X + 1, Y) != null){return false;}}

        return true;
    }
    private boolean checkLeft(){
        if(X-1 >= 0){if (FishTank.getEntity(X - 1, Y) != null){return false;}}

        return true;
    }

    private boolean checkDown(){
        //System.out.println(Y);
        //System.out.println(Y+1);
        if(Y+1 <= yBd){if (FishTank.getEntity(X, Y + 1) != null){return false;}}

        return true;
    }

    private boolean checkUp(){
        if(Y-1 >= 0){if (FishTank.getEntity(X, Y - 1) != null){return false;}}

        return true;
    }

    public void update() {


        // Move one spot to the right or left.
        if (goingRight) {
            if((X + 1 <= xBd) && (checkRight())) {X += 1;}
            else if ((X - 1 >= 0) && checkLeft()) {
                X -= 1;}

        } else {
            if((X - 1 >= 0) && (checkLeft())) {X -= 1;}
            else if((X + 1 <= xBd) && checkRight()){X += 1;}
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();


        // Figure out whether I turn around.
        d = Math.random();
        if (d <= 0.1) { turnAround(); }

        // Figure out whether to move up or down, or neither.
		d = Math.random();
        if (d <= 0.05) {
            if (Y + 1 <= yBd  && (checkDown())){Y += 1;}
            else if (Y - 1 >= 0 && (checkUp())){Y -= 1;}

        } else if (d < 0.1) {
            if(Y - 1 >= 0 && (checkUp())){Y -= 1;}
            else if (Y + 1 <= yBd  && (checkDown())){Y += 1;}
        }

        if (d <= 0.1) { blowBubble(); }
    }

    /* _________________________________________*/




}

