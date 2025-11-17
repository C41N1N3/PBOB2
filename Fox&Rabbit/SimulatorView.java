import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimulatorView extends JFrame {
    private final Map<Class, Color> colors;
    private final FieldStats stats;
    private final FieldView fieldView;
    private static final int GRID_VIEW_SCALING_FACTOR = 6;
    public SimulatorView(int height, int width) {
        super("Simulasi Rubah dan Kelinci");
        colors = new HashMap<>();
        stats = new FieldStats();
        setLocation(100, 50);
        setLayout(new BorderLayout());
        fieldView = new FieldView(height, width);
        add(fieldView, BorderLayout.CENTER);
        add(stats, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void setColor(Class animalClass, Color color) {
        colors.put(animalClass, color);
    }

    private Color getColor(Class animalClass) {
        Color col = colors.get(animalClass);
        if (col == null) {
            return Color.BLACK;
        } else {
            return col;
        }
    }

    public void showStatus(int step, Field field) {
        stats.updateStats(step, field);
        fieldView.preparePaint();
        fieldView.drawField(field);
    }

    public boolean isViable(Field field) {
        return stats.isViable(field);
    }
    
    private class FieldView extends JPanel {
        private final int gridWidth, gridHeight;
        private int xScale, yScale;
        private Dimension size;
        private Graphics g;
        private Image fieldImage;
        public FieldView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        public void setScale(int height, int width) {
            xScale = width;
            yScale = height;
        }

        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                                 gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        public void preparePaint() {
            if (!size.equals(getSize())) {
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();
                xScale = size.width / gridWidth;
                if (xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if (yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }
        
        public void drawField(Field field) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, size.width, size.height);
            for (int row = 0; row < gridHeight; row++) {
                for (int col = 0; col < gridWidth; col++) {
                    Object animal = field.getObjectAt(new Location(row, col));
                    if (animal != null) {
                        g.setColor(getColor(animal.getClass()));
                        g.fillRect(col * xScale, row * yScale, xScale - 1, yScale - 1);
                    }
                }
            }
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (fieldImage != null) {
                g.drawImage(fieldImage, 0, 0, null);
            }
        }
    }
}
