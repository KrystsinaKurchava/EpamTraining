package Collections.Classes;

import Collections.Enum.*;

public class Candy extends CandyBase {
    private CandyTypesEnum type;
    private static final Integer caloriesInHundredGramHardCandy = 381;
    private static final Integer caloriesInHundredGramRibbonCandy = 305;
    private static final Integer caloriesInHundredGramVeganCandy = 289;
    private static final Integer caloriesInHundredGramWaxCandy = 255;
    private static final Integer InvalidCalories = -1;
    private static final Integer contentOfSugarsInHundredGram = 96;

    public Candy(String name, Integer weightInGram, CandyTypesEnum type) {
        super(name, weightInGram);
        this.type = type;
    }

    @Override
    public Integer getContentOfSugar() {
        return getWeightInGram() * contentOfSugarsInHundredGram / counterForHundredGram;
    }

    @Override
    public Integer getCalories() {
        switch (type) {
            case HARD_CANDY:
                return getWeightInGram() * caloriesInHundredGramHardCandy / counterForHundredGram;
            case RIBBON_CANDY:
                return getWeightInGram() * caloriesInHundredGramRibbonCandy / counterForHundredGram;

            case VEGAN_CANDY:
                return getWeightInGram() * caloriesInHundredGramVeganCandy / counterForHundredGram;

            case WAX_CANDY:
                return getWeightInGram() * caloriesInHundredGramWaxCandy / counterForHundredGram;
        }
        return InvalidCalories;
    }
}
