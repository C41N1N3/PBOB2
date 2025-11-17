import java.util.List;
import java.util.Random;

public abstract class Animal {
    private boolean alive;
    private Field field;
    private Location location;
    private int age;
    private static final Random rand = Randomizer.getRandom();
    
    public Animal(Field field, Location location) {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;
    }
    
    abstract public void act(List<Animal> newAnimals);
    
    public boolean isAlive() {
        return alive;
    }

    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    protected Field getField() {
        return field;
    }
    
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }
    
    protected int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    protected boolean canBreed() {
        return age >= getBreedingAge();
    }
    
    abstract protected int getMaxAge();
    abstract protected int getBreedingAge();
    abstract protected double getBreedingProbability();
    abstract protected int getMaxLitterSize();
}