package Collections.Classes;
import Collections.Enum.*;

public class ChocolateCandy extends CandyBase {
    ChocoTypesEnum type;
    Integer contentOfSugarInHundredGram;

    public ChocolateCandy(String name, Integer weightInGram, ChocoTypesEnum type) {
        super(name, weightInGram);
        this.type = type;

    }

    @Override
    public Integer getContentOfSugar() {
        switch (type) {
            case MilkChocolate:
                contentOfSugarInHundredGram = 6;
                break;
            case DarkChocolate:
                contentOfSugarInHundredGram = 4;
                break;
            case WhiteChocolate:
                contentOfSugarInHundredGram = 8;
                break;
        }
        return  getWeightInGram() * contentOfSugarInHundredGram / 100;

    }

    @Override
    public Integer getCalories() {
        return getWeightInGram() * 544 / 100;
    }
}
