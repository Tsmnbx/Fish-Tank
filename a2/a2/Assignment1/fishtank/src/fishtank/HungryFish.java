package fishtank;
import java.awt.*;

/**
 * A fish.
 */
public class HungryFish {

    /** How this fish appears on the screen. */
    public String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    /** This fish's first coordinate. */
    int r;
    /** This fish's second coordinate. */
    int c;
    /** The colour of this fish. */
    private Color colour;


    /**
     * Constructs a new hungry fish.
     */
    public HungryFish() {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><MEHUNGRY>";
        goingRight = true;
    }


    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
      r = a;
      c = b;
    }



    /**
     * Causes this fish to blow a bubble.
     */
    protected void blowBubble() {
        Bubble b = new Bubble();
        if((FishTank.myLittleFishies[r][c] instanceof Fish || FishTank.myLittleFishies[r][c] instanceof HungryFish)== false) {
                b.setLocation(c, r);
                System.out.println(r + " " + c + " " + "Bubble from HungryFish");

                FishTank.myLittleFishies[r][c] = b;
            }

    }



    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
      System.out.println("Turnign around" + this.appearance);
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
            default: reverse += appearance.charAt(i); break;
            }
        }
        System.out.println("Turned around" + this.appearance);
        appearance = reverse;
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

    /** The font used to draw instances of this class. */
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
        drawString(g, appearance, r, c);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void move() {
        outOf();
        // Move one spot to the right or left.
        if (goingRight) {
            if (c+1<(640/6)) {
                c += 1;
            }
            else {
                c -= 1;
                turnAround();

            }
        } else {
            if(c-1>0) {
                c -= 1;
            }
            else {
                turnAround();
                c += 1;
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) { blowBubble(); }

        // Figure out whether I turn around.
        d = Math.random();
        if (d < 0.1) { turnAround(); }

        // Figure out whether to move up or down, or neither.
        d = Math.random();
        if (d < 0.1 ) {
            if (r+1<(480/10)) {
                r += 1;
            }
            else {
                r-=1;
            }
        } else if (d < 0.2) {
            if(r-1>15) {
                r -= 1;
            }
            else {
                r +=1;
            }
        }
    }
    public void outOf() {
        if(r>=(480/10)|| r<=0){
            System.out.println("HungryFISH OUT OF BOUNDS!!! for r coordinate" + " "+ r+","+c);
            colour = Color.magenta;
        }
        if(c>=(640/6)|| c<=0){
            System.out.println("HungryFISH OUT OF BOUNDS!!! for c coordinate" + " " + r+","+c);
            colour = Color.magenta;

        }
    }
}
