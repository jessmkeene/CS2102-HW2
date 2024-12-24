public class Cat extends AbstractAnimal implements Petable {

    int weightInOz;
    Coord2D location;
    boolean hasBeenPetToday;

    /**
     *
     * @param name
     * @param age
     * @param weightInOz
     * @param location
     * @param hasBeenPetToday
     */
    public Cat(String name, int age, int weightInOz, Coord2D location, boolean hasBeenPetToday) {
        super(name, age);
        this.weightInOz = weightInOz;
        this.location = location;
        this.hasBeenPetToday = hasBeenPetToday;
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
     * @return amount of food eaten by the cat
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("cans") && hasBeenPetToday) {
            return 2;
        } else if (foodLabel.equals("cans")) {
            return 1;
        } else {
            return 1 + weightInOz / 8;
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