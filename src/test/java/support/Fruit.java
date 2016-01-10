package support;

import java.util.HashMap;
import java.util.Map;

public class Fruit {

    private String name;
    private String colour;
    private int weightInGrams;

    private Map<String, AttributeGetter> getterMap = new HashMap<>();

    //    private Map<String, AttributeSetter> setterMap = new HashMap<>();
    {
        getterMap.put("name", this::getName);
        getterMap.put("colour", this::getColour);
        getterMap.put("weightInGrams", this::getWeightInGrams);

//        setterMap.put("name", this::setName);
//        setterMap.put("colour", this::setColour);
    }

    public Fruit(String name, String colour, int weightInGrams) {
        this.name = name;
        this.colour = colour;
        this.weightInGrams = weightInGrams;
    }


//    public Fruit(Map<String, String> fruitDescription) {
//        for (String attributeName : fruitDescription.keySet()) {
//            setterMap.get(attributeName).setValue(fruitDescription.get(attributeName));
//        }
//    }

    public static Fruit createFruit(Map<String, String> fruitDescription) {
        String name = fruitDescription.get("name");
        String colour = fruitDescription.get("colour");
        return new Fruit(name, colour, 350);
    }

    public Object getValue(String attributeName) {
        return getterMap.get(attributeName).getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return weightInGrams == fruit.weightInGrams && name.equals(fruit.name) && colour.equals(fruit.colour);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + colour.hashCode();
        result = 31 * result + weightInGrams;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    private interface AttributeGetter {

        Object getValue();
    }

//    private interface AttributeSetter {
//        void setValue(String value);
//    }
}
