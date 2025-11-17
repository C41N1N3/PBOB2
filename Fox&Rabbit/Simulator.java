import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

public class Simulator {
    private static final int DEFAULT_WIDTH = 120;
    private static final int DEFAULT_DEPTH = 80;
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;
    private List<Animal> animals;
    private Field field;
    private int step;
    private SimulatorView view;
    public Simulator() {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    public Simulator(int depth, int width) {
        if (width <= 0 || depth <= 0) {
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        animals = new ArrayList<>();
        field = new Field(depth, width);
        view = new SimulatorView(depth, width);
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
        reset();
    }

    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
        }
    }

    public void simulateOneStep() {
        step++;
        List<Animal> newAnimals = new ArrayList<>();
        for (Iterator<Animal> it = animals.iterator(); it.hasNext();) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if (!animal.isAlive()) {
                it.remove();
            }
        }

        animals.addAll(newAnimals);
        view.showStatus(step, field);
    }
    
    public void reset() {
        step = 0;
        animals.clear();
        field.clear();
        populate();
        view.showStatus(step, field);
    }

    private void populate() {
        Randomizer.reset();
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (Randomizer.getRandom().nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                } else if (Randomizer.getRandom().nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
            }
        }
    }
}