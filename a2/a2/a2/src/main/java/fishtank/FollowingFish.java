package fishtank;
import java.awt.*;

/**
 * A fish.
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public class FollowingFish extends Fish {

    /**
     * How this fish appears on the screen.
     */
    String appearance;

    /**
     * Indicates whether this fish is moving right.
     */
    boolean goingRight;

    /**
     * This fish's first coordinate.
     */
    int X;
    /**
     * This fish's second coordinate.
     */
    private int Y;
    /**
     * The colour of this fish.
     */
    Color colour;

    /**
     * The entity that our fish is following
     */
    Fish de;


    /**
     * Constructs a new hungry fish.
     */
    public FollowingFish(Fish f) {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><FOLLOW>";
        goingRight = true;
        de = f;
    }


    /**
     * Set this item's location.
     *
     * @param a the first coordinate.
     * @param b the second coordinate.
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
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        System.out.println("Turnign around" + this.appearance);
        String reverse = "";
        for (int i = appearance.length() - 1; i >= 0; i--) {
            switch (appearance.charAt(i)) {
                case ')':
                    reverse += '(';
                    break;
                case '(':
                    reverse += ')';
                    break;
                case '>':
                    reverse += '<';
                    break;
                case '<':
                    reverse += '>';
                    break;
                case '}':
                    reverse += '{';
                    break;
                case '{':
                    reverse += '}';
                    break;
                case '[':
                    reverse += ']';
                    break;
                case ']':
                    reverse += '[';
                    break;
                default:
                    reverse += appearance.charAt(i);
                    break;
            }
        }
        System.out.println("Turned around" + this.appearance);
        appearance = reverse;
        return reverse;
    }


    /**
     * Turns this fish to fc
     */
    protected void turnToFace() {
        if (de.getX() < this.getX() && goingRight) {
            goingRight = false;
            reverseAppearance();
        } else if (de.getX() > this.getX() && !goingRight) {
            goingRight = true;
            reverseAppearance();
        }
    }

    /**
     * The font used to draw instances of this class.
     */
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);


    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param g the graphics context in which to draw the string.
     * @param s the string to draw.
     * @param x the x-coordinate of the string's cursor location.
     * @param y the y-coordinate of the string's cursor location.
     */
    void drawString(Graphics g, String s, int x, int y) {
        g.setColor(colour);
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics(FONT);
        g.drawString(s, x * fm.charWidth('W'), y * fm.getAscent());
    }


    /**
     * Draws this fish tank item.
     *
     * @param g the graphics context in which to draw this item.
     */
    public void draw(Graphics g) {
        drawString(g, appearance, X, Y);
    }


    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void update() {
        turnToFace();

        // Move one spot to the right or left.
        if (goingRight) {
            if (canMoveTo(X + 1, Y)) {
                X += 1;
            }

        } else {
            if (canMoveTo(X - 1, Y)) {
                X -= 1;
            }
        }

        if (Math.abs(de.getY() - Y) > 2) {
            if (de.getY() < Y) {

                        Y -= 1;
                    }
                 else  {Y += 1;}

            }

        else if (Math.abs(de.getY() - Y) == 1 && Math.abs(de.getX() - X) > 2) {
             if (de.getX() < X) {

                X -= 1;
            }
            else  {

                X += 1;
            }

        }

        else if (Math.abs(de.getY() - Y) == 0 && Math.abs(de.getX() - X) > 2) {
            if (de.getX() < X) {

                X -= 1;
            }
            else  {

                X += 1;
            }

        }


        }
    }

