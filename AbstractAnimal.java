public abstract class AbstractAnimal implements Petable {

    public String AbstractName;
    int AbstractAge;

    /**
     *
     * @param AbstractName
     * @param AbstractAge
     */
    public AbstractAnimal(String AbstractName, int AbstractAge) {
        this.AbstractName=AbstractName;
        this.AbstractAge=AbstractAge;
    }

    /**
     *
     * @return AbstractName
     */
    public String getName() {
        return AbstractName;
    }


    public abstract int getWeightInOz();

    /**
     *
     * @return AbstractAge
     */
    public int getAge() {
        return AbstractAge;
    }


    public abstract int eats(String foodLabel);
}