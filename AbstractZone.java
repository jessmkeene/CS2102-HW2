import java.util.LinkedList;

/**
 * An abstract class representing a zone in the pet rescue.
 * This class provides common functionality for all zones.
 */
public abstract class AbstractZone implements Zoneable {

    public abstract LinkedList<? extends Petable> getZone();

    /**
     * Produces the number of pets in the zone
     *
     * @return the number of total pets in the zone
     */
    public int petsInZone() {
        int count = 0;
        for (Petable pet : this.getZone()) {
            count = count + 1;
        }
        return count;
    }

    /**
     * finds and produces the fattest animal available
     *
     * @return the heaviest pet (the one with the greatest weight according to its
     * getWeightInOz() method)
     * @return null if there are no pets
     */
    public Petable heaviestPet() {
        if (this.getZone().isEmpty()) {
            return null;
        } else {
            int weight = 0;
            Petable largePet = null;
            for (Petable pet : this.getZone()) {
                if (weight < pet.getWeightInOz()) {
                    weight = pet.getWeightInOz();
                    largePet = pet;
                }
            }

            return largePet;
        }
    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     *
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet
     * calculation
     * or -1 if that pet name is not in this zone
     */
    public abstract int inHumanYears(String petName);

    public abstract Zoneable restockPetFood(String foodName, int foodAmt);
    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     *
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for
     * "unknown" logic).
     */

    public abstract Zoneable feedZone();

    /**
     * Fetch me that pet!
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in
     *                the zone
     * @return the pet with that name or null if pet is not in the zone
     */
    public abstract Petable getPet(String petName);


    public abstract String getPantryLabel();


    public abstract String closestPet(int x, int y);

}
