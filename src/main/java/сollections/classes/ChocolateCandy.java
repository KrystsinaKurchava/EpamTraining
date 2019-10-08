package сollections.classes;

import сollections.candyTypes.*;

public class ChocolateCandy extends CandyBase {
    ChocoTypesEnum type;
    private static final Integer contentCaloriesInHundredGram = 544;
    private static final Integer contentOfSugarInHundredGramMilkChocolate = 6;
    private static final Integer caloriesInHundredGramDarkChocolate = 4;
    private static final Integer caloriesInHundredGramWhiteChocolate = 8;
    private static final Integer InvalidContentOfSugar = -1;

    public ChocolateCandy(String name, Integer weightInGram, ChocoTypesEnum type) {
        super(name, weightInGram);
        this.type = type;

    }

    @Override
    public Integer getContentOfSugar() {
        switch (type) {
            case MILK_CHOCOLATE:
                return getWeightInGram() * contentOfSugarInHundredGramMilkChocolate / counterForHundredGram;
            case DARK_CHOCOLATE:
                return getWeightInGram() * caloriesInHundredGramDarkChocolate / counterForHundredGram;
            case WHITE_CHOCOLATE:
                return getWeightInGram() * caloriesInHundredGramWhiteChocolate / counterForHundredGram;
        }
        return InvalidContentOfSugar;
    }

    @Override
    public Integer getCalories() {
        return getWeightInGram() * contentCaloriesInHundredGram / counterForHundredGram;
    }
}
