package Collections.Classes;
import Collections.Enum.*;

public class Candy extends CandyBase {
    CandyTypesEnum type;
    Integer caloriesInHundredGram;

    public Candy(String name, Integer weightInGram, CandyTypesEnum type) {
        super(name, weightInGram);
        this.type = type;
    }

    @Override
    public Integer getContentOfSugar() {
        return getWeightInGram() * 96 / 100;
    }

    @Override
    public Integer getCalories() {
        switch (type) {
            case HardCandy:
                caloriesInHundredGram = 381;
                break;
            case RibbonCandy:
                caloriesInHundredGram = 305;
                break;
            case VeganCandy:
                caloriesInHundredGram = 289;
                break;
            case WaxCandy:
                caloriesInHundredGram = 446;
                break;
        }
        return getWeightInGram() * caloriesInHundredGram / 100;
    }
}
