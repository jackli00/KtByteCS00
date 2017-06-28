
public class Button {

    // constant
    private static final double margin = 0.05;

    // instance variables
    private Button child;
    private final double center_x;
    private final double center_y;
    private final double half_width;
    private final double half_height;
    public final String name;
    private boolean highlighted;

    // create a new button
    public Button(double center_x, double center_y,
                  double half_width, double half_height, String name) {
        this.center_x = center_x;
        this.center_y = center_y;
        this.half_width = half_width;
        this.half_height = half_height;
        this.name = name;
        this.highlighted = false;
    }

    // create a new child button at the end of this button's youngest descendant
    public void procreate(String name) {
        Button b = this;
        while (b.child != null)
            b = b.child;
        b.child = new Button(b.center_x,
                b.center_y - 2 * b.half_height - margin,
                b.half_width, b.half_height, name);
    }

    // draw family tree to StdDraw
    public void drawFamily() {
        Button b = this;
        while (b != null) {
            b.draw();
            b = b.child;
        }
        StdDraw.show();
    }

    // return which child is clicked
    public Button getClickedChild() {
        Button b = this.child;
        while (b != null) {
            if (b.isPressed()) return b;
            b = b.child;
        }

        return null;
    }

    // draw to StdDraw
    public void draw() {
/*        if (this.highlighted) {
            StdDraw.setPenRadius();
            StdDraw.setPenColor(StdDraw.ORANGE);
            StdDraw.filledRectangle(this.center_x, this.center_y,
                    this.half_width, this.half_height);
            StdDraw.setPenColor();
            StdDraw.text(this.center_x, this.center_y, this.name);
            StdDraw.setPenRadius(0.005);
        } else {
            StdDraw.rectangle(this.center_x, this.center_y,
                    this.half_width, this.half_height);
            StdDraw.text(this.center_x, this.center_y, this.name);
        }
  */
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(this.center_x, this.center_y,
                this.half_width, this.half_height);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.text(this.center_x, this.center_y, this.name);
    }

    // draw to StdDraw
    public void reDraw() {
        if (this.highlighted) {
            StdDraw.setPenRadius();
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.filledRectangle(this.center_x, this.center_y,
                    this.half_width, this.half_height);
            StdDraw.setPenColor();
            StdDraw.text(this.center_x, this.center_y, this.name);
            StdDraw.setPenRadius(0.005);
        } else {
            StdDraw.rectangle(this.center_x, this.center_y,
                    this.half_width, this.half_height);
            StdDraw.text(this.center_x, this.center_y, this.name);
        }
    }

    // check if mouse is currently clicking this button or any of its children
    public boolean isPressed() {
        double min_x = this.center_x - this.half_width;
        double max_x = this.center_x + this.half_width;
        double min_y = this.center_y - this.half_height;
        double max_y = this.center_y + this.half_height;

        if (StdDraw.mousePressed() &&
                (StdDraw.mouseX() >= min_x) && (StdDraw.mouseX() <= max_x) &&
                (StdDraw.mouseY() >= min_y) && (StdDraw.mouseY() <= max_y)) {
            reDraw();
            return true;
        } else
            return false;
    }

    // check if this button is the same as another button
    public boolean equals(Button b) {
        if (this.name.equals(b.name))
            return true;
        return false;
    }

    // highlight this button orange
    public void highlight() {
        this.highlighted = true;
    }

    // unhighlight this button
    public void unhighlight() {
        this.highlighted = false;
    }
}