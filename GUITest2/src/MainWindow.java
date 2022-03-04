import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow {
	private Color[] colors;
	private JFrame window;
	private PointsPanel panel;
	private final int pagePadding = 10;
	private final int colorPickSize = 30;
	private Color currentSelection = Color.red;
	private final MouseListener colorPickClickListener = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			currentSelection = e.getComponent().getBackground();
			panel.changeCurrentColor(currentSelection);
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	};

	public MainWindow(Color[] colors) {
		this.colors = colors;
		window = new JFrame("GUI App");
		window.setBounds(200, 200, 800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);

		JLabel colorPick;
		for (int i = 0; i < colors.length; i++) {
			colorPick = new JLabel("");
			colorPick.setBounds(pagePadding,  pagePadding + i * colorPickSize, colorPickSize, colorPickSize);
			colorPick.setBackground(colors[i]);
			colorPick.setOpaque(true);
			colorPick.setBorder(new Border() {
				@Override
				public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
					g.setColor(Color.black);
					g.drawLine(x,y,x+width,y);
					g.drawLine(x,y,x,y+height);
					g.drawLine(x+width,y,x+width,y+height);
					g.drawLine(x,y+height,x+width,y+height);
				}

				@Override
				public Insets getBorderInsets(Component c) {
					return new Insets(8,8,8,8);
				}

				@Override
				public boolean isBorderOpaque() {
					return true;
				}
			});
			colorPick.addMouseListener(colorPickClickListener);
			colorPick.setVisible(true);
			window.add(colorPick);
		}

		panel = new PointsPanel();
		panel.setBounds(pagePadding + 2 * colorPickSize, pagePadding, 600, 600);
		panel.changeCurrentColor(currentSelection);
		window.add(panel);

		window.setVisible(true);
	}
}
