import java.util.List;
import java.util.Iterator;

public class Fox extends Animal {
    private static final int BREEDING_AGE = 15;
    private static final int MAX_AGE = 150;
    private static final double BREEDING_PROBABILITY = 0.08;
    private static final int MAX_LITTER_SIZE = 2;
    private static final int RABBIT_FOOD_VALUE = 9;
    private int foodLevel;
    
    public Fox(boolean randomAge, Field field, Location location) {
        super(field, location);
        foodLevel = RABBIT_FOOD_VALUE;
        if(randomAge) {
        }
    }

    public void act(List<Animal> newFoxes) {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            int births = breed();
            for(int b = 0; b < births; b++) {
                Field field = getField();
                Location loc = field.freeAdjacentLocation(getLocation());
                if(loc != null) {
                    Fox young = new Fox(false, field, loc);
                    newFoxes.add(young);
                }
            }
            
            Location newLocation = findFood();
            if (newLocation == null) {
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }
    
    private Location findFood() {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }

    protected int getMaxAge() { return MAX_AGE; }
    protected int getBreedingAge() { return BREEDING_AGE; }
    protected double getBreedingProbability() { return BREEDING_PROBABILITY; }
    protected int getMaxLitterSize() { return MAX_LITTER_SIZE; }
}