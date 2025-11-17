import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldStats extends JPanel {
    private JLabel stepLabel;
    private JLabel populationLabel;
    private Map<Class, Counter> counters;
    public FieldStats() {
        setLayout(new BorderLayout());
        stepLabel = new JLabel("Langkah: 0");
        populationLabel = new JLabel("Populasi: ");
        counters = new HashMap<>();
        add(stepLabel, BorderLayout.WEST);
        add(populationLabel, BorderLayout.EAST);
    }

    public void updateStats(int step, Field field) {
        stepLabel.setText("Langkah: " + step + " ");
        for (Counter counter : counters.values()) {
            counter.reset();
        }

        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(new Location(row, col));
                if (animal != null) {
                    Counter counter = getCounter(animal.getClass());
                    counter.increment();
                }
            }
        }

        String popText = "Populasi: ";
        for (Counter counter : counters.values()) {
            popText += counter.getName() + ": " + counter.getCount() + " ";
        }
        populationLabel.setText(popText);
    }

    private Counter getCounter(Class animalClass) {
        Counter counter = counters.get(animalClass);
        if (counter == null) {
            counter = new Counter(animalClass.getName());
            counters.put(animalClass, counter);
        }
        return counter;
    }
    
    public boolean isViable(Field field) {
        for (Counter counter : counters.values()) {
            if (counter.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
}