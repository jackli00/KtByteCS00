import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by jli on 6/28/2017.
 */
public class AnimatedHanoi_Drag {
    static double xWidth;
    static double yHeight;
    static double xLeft;
    static double xRight;
    static double yBottom;
    static double yTop;
    static double xyCenter;
    static double xTextLeft;
    static Button RunButton;
    static Button ContinueButton;
    static int iTotalSteps = 0;
    static int iGame = 1;

    // draw the current state of the Towers of Hanoi game
    public static void draw(int[] pole) {

        int n = pole.length - 1;

        // draw 3 poles
        StdDraw.clear();
        RunButton.draw();
        //ContinueButton.draw();

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < 3; i++) {
            StdDraw.line(i, 0, i, n);
            StdDraw.rectangle(i, 0, 0.2, 0.01);
        }

        // draw N discs
        int[] discs = new int[3];   // discs[p] = # discs on pole p
        for (int i = n; i >= 1; i--) {
            Color color = Color.getHSBColor(1.0f * i / n, 0.7f, 0.7f);
            StdDraw.setPenColor(color);
            StdDraw.setPenRadius(0.035);   // magic constant
            double size = 0.5 * i / n;
            int p = pole[i];
            StdDraw.line(p - size / 2, discs[p], p + size / 2, discs[p]);
            StdDraw.show();
            ++discs[p];
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        StdDraw.textRight(xWidth - 1, yTop - 1, "Game " + iGame + ", Step " + String.valueOf(iTotalSteps));

        StdDraw.show();
        StdDraw.pause(500);
    }

    public static void hanoi(int n) {
        int[] pole = new int[n + 1];       // pole[i] = pole (0-2) that disc i is on
        draw(pole);
        hanoi(n, 0, 1, 2, pole);
    }

    public static void hanoi(int n, int from, int temp, int to, int[] pole) {
        boolean bWait = true;
        while (bWait) {
            if (RunButton.isPressed()) {
                if (n == 0) return;
                hanoi(n - 1, from, to, temp, pole);
                System.out.println("Move disc " + n + " from pole " + from + " to pole " + to);
                iTotalSteps++;

                pole[n] = to;
                draw(pole);
                hanoi(n - 1, temp, from, to, pole);
                bWait = false;
            } else {
                bWait = true;
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        xTextLeft += 0.1;
    }

    public static void main(String[] args) {
        int n = 3; //Integer.parseInt(args[0]);   // number of discs
        int WIDTH = 200;                    // width of largest disc
        int HEIGHT = 20;                     // height of each disc

        // set size of window and sale
        int rWidth = 4 * WIDTH;
        int rHeight = (n + 3) * HEIGHT;

        xLeft = -1;
        xRight = 3;
        xWidth = xRight - xLeft;

        yBottom = -1;
        yTop = n + 3;
        yHeight = yTop - yBottom;
        xTextLeft = xLeft;

        StdDraw.setCanvasSize(rWidth, rHeight);
        StdDraw.setXscale(xLeft, xRight);
        StdDraw.setYscale(yBottom, yHeight);
        StdDraw.enableDoubleBuffering();

        //mouse test
        RunButton = new Button(-0.5, yTop - 1, 0.5, 1, "Solve for me, please!");
        ContinueButton = new Button(1.5, yTop - 1, 0.5, 1, "Fun! New Game!");

        boolean bContinue = true;
        iGame = 1;
        // solve the Towers of Hanoi with n discs
        while(bContinue) {
            hanoi(n);
            iTotalSteps = 0;
            iGame++;
        }
    }
}
