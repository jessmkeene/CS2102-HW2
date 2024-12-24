public class Bird extends AbstractAnimal implements Petable {
    int weightInOz;
    Coord2D location;

    boolean wingsClipped;

    /**
     *
     * @param name
     * @param age
     * @param weightInOz
     * @param location
     * @param wingsClipped
     */
    public Bird(String name, int age, int weightInOz, Coord2D location, boolean wingsClipped) {
        super(name, age);
        this.weightInOz = weightInOz;
        this.location = location;
        this.wingsClipped = wingsClipped;
    }

    /**
     *
     * @return weight in ounces
     */
    @Override
    public int getWeightInOz() {
        return weightInOz;
    }

    /**
     *
     * @param foodLabel the type of food being asked
     * @return amount of food eaten
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("seeds")) {
            return 1;
        } else {
            return 0;
        }
    }


    public int ageInHumanYears() {
        return 0;
    }


    public int foodNeeded() {
        return 0;
    }


    public int getLocation() {
        return 0;
    }
}