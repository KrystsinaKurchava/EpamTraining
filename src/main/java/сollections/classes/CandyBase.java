package сollections.classes;

public abstract class CandyBase {
    private String name;
    private Integer weightInGram;
    protected static final Integer counterForHundredGram = 100;

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

    public Integer getWeightInGram() {
        return weightInGram;
    }

    public abstract Integer getContentOfSugar();

    public abstract Integer getCalories();
}
