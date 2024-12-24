public class Chinchilla extends AbstractAnimal implements Petable{
    Coord2D location;
    int dustBathResidueInOz;

    int weightInOz;


    /**
     *
     * @param name
     * @param age
     * @param weightInOz
     * @param location
     * @param dustBathResidueInOz
     */
    public Chinchilla(String name, int age, int weightInOz, Coord2D location,  int dustBathResidueInOz) {
        super(name, age);
        this.location=location;
        this.weightInOz=weightInOz;
        this.dustBathResidueInOz=dustBathResidueInOz;

    }

    /**
     *
     * @return the chinchillas weight
     */
    @Override
    public int getWeightInOz() {
        return weightInOz+dustBathResidueInOz;
    }

    /**
     *
     * @param foodLabel the type of food being asked
     * @return the amount of food a chinchilla can eat
     */
    @Override
    public int eats(String foodLabel) {
        if(foodLabel.equals("pellets"))
        {return 3;}
        if (foodLabel.equals("hay")){
            return 1;}
        else { return 0;}
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
