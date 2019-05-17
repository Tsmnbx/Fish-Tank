package fishtank;
import java.awt.*;

/**
 * A fish.
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public class HungryFish extends Fish /*FishTankEntity*/ {

    /** How this fish appears on the screen. */
    public String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    //_int r;
    //_int c;
    //_private Color colour;


    /**
     * Constructs a new hungry fish.
     */
    //@Override
    public HungryFish() {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><MEHUNGRY>";
        goingRight = true;
    }


    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    // @Override __________________________________________________
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
    //____________________________________________________________


   

}
