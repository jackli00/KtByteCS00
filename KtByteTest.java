import processing.core.PApplet;
import processing.core.PGraphics;

import java.awt.*;

/**
 * Created by jli on 6/15/2017.
 */

public class KtByteTest extends PApplet {
    static int nDisc = 4; //Integer.parseInt(args[0]);   // number of discs
    static int WIDTH = 200;                    // width of largest disc
    static int HEIGHT = 20;                     // height of each disc

    //set size of the window
    static int xWidth = nDisc * WIDTH;
    static int yHeight = (nDisc + 3) * HEIGHT;

    static int xLeft = 0;
    static int xRight = xWidth;
    static int yBottom = 0;
    static int yTop = yHeight;
    static double xyCenter;

    static int txtLeft;

    PGraphics gHanoi;

    public static void main(String[] args) {
        PApplet.main("KtByteTest");
    }

    public void settings() {
        size(xWidth, yHeight);
    }

    public void setup() {
        background(255);
        txtLeft = xLeft;
        gHanoi = createGraphics(xWidth, yHeight);
        hanoi(nDisc);
    }

    public void draw() {
        image(gHanoi,0,0);
    }

    public void draw(int[] pole) {

        int n = pole.length - 1;

        int xStep = xWidth / (n + 1);
        float recHeight = (float) (yHeight * 3.0 / 4.0);
        float recWidth = (float) (xWidth / 40.0);
        float yRec = yHeight - recHeight; //rectangular y coordinate
        float xLength = (float) xStep / 2;
        //float

        gHanoi.beginDraw();
        gHanoi.background(255);

        // draw 3 poles
        int[] iColor = new int[3];
        textSize(recHeight / 10);
        fill(255, 0, 255);
        gHanoi.text("The Game of Hanoi", txtLeft, yRec / 2);

        for (int i = 0; i < 3; i++) {
            int colorPole = color(128, 128, 128); //color grey
            gHanoi.fill(colorPole);
            gHanoi.strokeWeight(1);
            gHanoi.rect((i + 1) * xStep, yRec, 20, recHeight);

            //fill disk color
            int p = pole[i];
            int colorRec = color((int) (255.0 * i / 4), 179, (int) (255.0 * (4 - i) / 4));
            //rect((i + 1) * xStep - 30, yHeight - 20, xWidth / 10, 20);
        }

        // draw N discs
        int[] discs = new int[3];   // discs[p] = # discs on pole p
        for (int i = n; i >= 1; i--) {

            gHanoi.strokeWeight(30);
            float size = (float) (0.5 * i / n);
            int p = pole[i];
            int colDisc = color(204, (float) i / n * 250, 0);
            float fDiscLength = ((float)i + 1) / n * xLength;
            gHanoi.stroke(colDisc);
            gHanoi.line((p + 1) * xStep - fDiscLength, yHeight - discs[p] * yRec, (p + 1) * xStep + fDiscLength, yHeight - discs[p] * yRec);
            ++discs[p];
        }

        gHanoi.endDraw();
        image(gHanoi,0,0);
        delay(500);
    }

    public void mousePressed() {
        background(255);
        redraw();
    }

    public void hanoi(int n) {
        int[] pole = new int[n + 1];       // pole[i] = pole (0-2) that disc i is on
        draw(pole);
        hanoi(n, 0, 1, 2, pole);
    }

    public void hanoi(int n, int from, int temp, int to, int[] pole) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp, pole);
        System.out.println("Move disc " + n + " from pole " + from + " to pole " + to);
        pole[n] = to;
        draw(pole);
        hanoi(n - 1, temp, from, to, pole);
    }
    // draw N discs
/*        int[] discs = new int[3];   // discs[p] = # discs on pole p
        for (int i = n; i >= 1; i--) {
            Color color = Color.getHSBColor(1.0f * i / n, 0.7f, 0.7f);
            StdDraw.setPenColor(color);
            StdDraw.setPenRadius(0.035);   // magic constant
            double size = 0.5 * i / n;
            int p = pole[i];
            StdDraw.line(p - size / 2, discs[p], p + size / 2, discs[p]);
            ++discs[p];
        }

        StdDraw.show();
        StdDraw.pause(10);*/


    //supporting functions
    static int maxNumber = 50;
    static int minNumber = 1;

    public static int nextInt() {
        //int randomInt = (int) (Math.random() * maxNumber + minNumber);
        int randomInt = 9;
        return randomInt;
    }

    public static double nextDouble() {
        double randomDouble = Math.random() * maxNumber + minNumber;
        return randomDouble;
    }
}


