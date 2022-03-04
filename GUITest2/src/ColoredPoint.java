import java.awt.*;

public class ColoredPoint extends  Point{
    private Color color;
    private int diameter;

    public ColoredPoint(int x, int y, Color color, int diameter){
        super(x,y);
        this.color = color;
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public static ColoredPoint getMidPoint(ColoredPoint a, ColoredPoint b, Color color, int diameter){
        return new ColoredPoint((a.x + b.x) / 2, (a.y + b.y) / 2, color, diameter);
    }
}
