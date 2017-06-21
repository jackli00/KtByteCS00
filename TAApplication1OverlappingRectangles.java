/**
 * Created by jli on 6/15/2017.
 */
public class TAApplication1OverlappingRectangles {
    boolean overlapping(Rectangle a, Rectangle b) {
        boolean compX;
        if(a.x <= b.x)
            compX = a.x + a.w/2 >= b.x + b.w/2;
        else
            compX = a.x + a.w/2 <= b.x + b.w/2;

        boolean compY;
        if(a.y <= b.y)
            compX = a.y + a.h/2 >= b.y + b.h/2;
        else
            compX = a.y + a.h/2 <= b.y + b.h/2;

        return compX && compX;
    }

    class Rectangle {
        double x, y; //center x,y position
        double w, h; //width
    }

}
