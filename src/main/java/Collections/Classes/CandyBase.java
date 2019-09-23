package Collections.Classes;
import Collections.Enum.*;

public abstract class CandyBase {
    private String name;
    private String type;
    private Integer weightInGram;


    public CandyBase(String name, Integer weightInGram) {
        this.name = name;

        this.weightInGram = weightInGram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public Integer getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(Integer weightInGram) {
        this.weightInGram = weightInGram;
    }

    public abstract Integer getContentOfSugar();

    public abstract Integer getCalories();
}
