package Collections;

import Collections.Classes.*;
import Collections.Enum.*;

public class NewYearGift {
    private static final Integer initialSugarContent = 3;
    private static final Integer finalSugarContent = 7;

    public static void main(String[] args) {

        CandyBase morning = new ChocolateCandy("Morning", 3, ChocoTypesEnum.MILK_CHOCOLATE);
        CandyBase evening = new ChocolateCandy("Evening", 4, ChocoTypesEnum.DARK_CHOCOLATE);
        CandyBase lunch = new ChocolateCandy("Lunch", 2, ChocoTypesEnum.WHITE_CHOCOLATE);
        CandyBase diner = new ChocolateCandy("Diner", 5, ChocoTypesEnum.MILK_CHOCOLATE);
        CandyBase hardCandy = new Candy("HardCandy", 3, CandyTypesEnum.HARD_CANDY);
        CandyBase ribbonCandy = new Candy("RibbonCandy", 4, CandyTypesEnum.RIBBON_CANDY);
        CandyBase waxCandy = new Candy("WaxCandy", 2, CandyTypesEnum.WAX_CANDY);
        CandyBase veganCandy = new Candy("veganCandy", 3, CandyTypesEnum.VEGAN_CANDY);
        CandyBase waxCandyBig = new Candy("WaxCandyBig", 7, CandyTypesEnum.WAX_CANDY);
        CandyBase hardCandyBig = new Candy("HardCandyBig", 8, CandyTypesEnum.HARD_CANDY);

        NewYearsGiftArray gift = new NewYearsGiftArray();

        gift.addCandyToGift(morning);
        gift.addCandyToGift(evening);
        gift.addCandyToGift(lunch);
        gift.addCandyToGift(diner);
        gift.addCandyToGift(hardCandy);
        gift.addCandyToGift(ribbonCandy);
        gift.addCandyToGift(waxCandy);
        gift.addCandyToGift(veganCandy);
        gift.addCandyToGift(waxCandyBig);
        gift.addCandyToGift(hardCandyBig);

        gift.sortOfGetCalories();

        gift.getWeightGift();

        gift.choiceSweetInTheRangeContentOfSugar(initialSugarContent, finalSugarContent);

    }

}