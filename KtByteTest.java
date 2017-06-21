import processing.core.PApplet;

/**
 * Created by jli on 6/15/2017.
 */

public class KtByteTest extends PApplet{
    public static void main(String[] args) {
        PApplet.main("KtByteTest");
    }

    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(120,50,240);
    }

    public void draw(){
        ellipse(width/2,height/2,second(),second());
    }


    //supporting functions
    static int maxNumber = 50;
    static int minNumber = 1;

    public static int nextInt() {
        int randomInt = (int) (Math.random() * maxNumber + minNumber);
        return randomInt;
    }

    public static double nextDouble() {
        double randomDouble = Math.random() * maxNumber + minNumber;
        return randomDouble;
    }
}
//check
// insert code below here

