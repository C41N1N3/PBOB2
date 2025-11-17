import java.util.List;

public class Rabbit extends Animal {
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 40;
    private static final double BREEDING_PROBABILITY = 0.12;
    private static final int MAX_LITTER_SIZE = 4;
    public Rabbit(boolean randomAge, Field field, Location location) {
        super(field, location);
        if (randomAge) {
        }
    }

    public void act(List<Animal> newRabbits) {
        incrementAge();
        if (isAlive()) {
            int births = breed();
            for(int b = 0; b < births; b++) {
                Field field = getField();
                Location loc = field.freeAdjacentLocation(getLocation());
                if(loc != null) {
                    Rabbit young = new Rabbit(false, field, loc);
                    newRabbits.add(young);
                }
            }
            
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }

    protected int getMaxAge() { return MAX_AGE; }
    protected int getBreedingAge() { return BREEDING_AGE; }
    protected double getBreedingProbability() { return BREEDING_PROBABILITY; }
    protected int getMaxLitterSize() { return MAX_LITTER_SIZE; }
}