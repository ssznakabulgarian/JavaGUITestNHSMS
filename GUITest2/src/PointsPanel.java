import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PointsPanel extends JComponent {
    private final int pointDiameter = 10;
    private Color currentColor;
    private final ColoredPoint[] points = new ColoredPoint[3];
    private int numberOfCreatedPoints = 0;
    private ColoredPoint movingPoint;

    public PointsPanel() {
        super();
        setBackground(Color.WHITE);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                if(movingPoint != null) {
                    movingPoint.x = e.getX();
                    movingPoint.y = e.getY();
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (numberOfCreatedPoints >= 3) return;
                points[numberOfCreatedPoints++] = new ColoredPoint(e.getX(), e.getY(), currentColor, pointDiameter);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point currentPress = new Point(e.getX(),e.getY());
                for (int i = 0; i < numberOfCreatedPoints; i++) {
                    if(currentPress.distance(points[i]) < pointDiameter*2) movingPoint = points[i];
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                movingPoint = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public void changeCurrentColor(Color color) {
        currentColor = color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(getBackground());
        graphics2D.fillRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);

        for (int i = 0; i < numberOfCreatedPoints; i++) {
            graphics2D.setColor(points[i].getColor());
            graphics2D.fillOval(points[i].x - points[i].getDiameter() / 2,
                    points[i].y - points[i].getDiameter() / 2,
                    points[i].getDiameter(),
                    points[i].getDiameter());
        }

        graphics2D.setColor(Color.black);
        if (numberOfCreatedPoints > 1) {
            for (int i = 0; i < numberOfCreatedPoints; i++)
                graphics2D.drawLine(points[i].x,
                        points[i].y,
                        points[(i + 1) % numberOfCreatedPoints].x,
                        points[(i + 1) % numberOfCreatedPoints].y);
        }

        if (numberOfCreatedPoints == 3) {
            for (int i = 0; i < numberOfCreatedPoints; i++) {
                ColoredPoint midPoint = ColoredPoint.getMidPoint(points[(i + 1) % numberOfCreatedPoints],
                        points[(i + 2) % numberOfCreatedPoints],
                        currentColor, pointDiameter);

                graphics2D.setColor(Color.black);
                graphics2D.drawLine(points[i].x,
                        points[i].y,
                        midPoint.x,
                        midPoint.y);

                graphics2D.setColor(midPoint.getColor());
                graphics2D.fillOval(midPoint.x - midPoint.getDiameter() / 2,
                        midPoint.y - midPoint.getDiameter() / 2,
                        midPoint.getDiameter(),
                        midPoint.getDiameter());
            }
        }
    }
}