package support;

import java.util.Map;

public class Fruit {

    private String name;
    private String colour;
    private int weightInGrams;

    public Fruit(String name, String colour, int weightInGrams) {
        this.name = name;
        this.colour = colour;
        this.weightInGrams = weightInGrams;
    }

    public static Fruit createFruit(Map<String, String> fruitDescription) {
        String name = fruitDescription.get("name");
        String colour = fruitDescription.get("colour");
        return new Fruit(name, colour, 350);
    }

    public Object getValue(String attributeName) {
        switch (attributeName) {
            case "name": return getName();
            case "colour": return getColour();
            case "weightInGrams": return getWeightInGrams();
            default:
                throw new RuntimeException("unknown attribute: " + attributeName);
        }
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public void addWeight() {
        switch (getName()) {
            case "apple":
                setWeightInGrams(getWeightInGrams() + 150);
                break;
            case "banana":
                setWeightInGrams(getWeightInGrams() + 200);
                break;
            default:
                throw new RuntimeException("unkown fruit");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return weightInGrams == fruit.weightInGrams && name.equals(fruit.name) && (colour != null ? colour.equals
                (fruit.colour) : fruit.colour == null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + weightInGrams;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{" + name + ", " + colour + ", " + weightInGrams + '}';
    }

}
