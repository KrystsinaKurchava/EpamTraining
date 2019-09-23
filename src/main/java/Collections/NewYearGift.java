package Collections;
import Collections.Classes.*;
import Collections.Enum.*;

import java.util.ArrayList;

public class NewYearGift {

    public static void main(String[] args) {
        Integer initialSugarContent = 3;
        Integer finalSugarContent = 7;
        CandyBase morning = new ChocolateCandy("Morning", 3, ChocoTypesEnum.MilkChocolate);
        CandyBase evening = new ChocolateCandy("Evening", 4, ChocoTypesEnum.DarkChocolate);
        CandyBase lunch = new ChocolateCandy("Lunch", 2, ChocoTypesEnum.WhiteChocolate);
        CandyBase diner = new ChocolateCandy("Diner", 5, ChocoTypesEnum.MilkChocolate);
        CandyBase hardCandy = new Candy("HardCandy", 3, CandyTypesEnum.HardCandy);
        CandyBase ribbonCandy = new Candy("RibbonCandy", 4, CandyTypesEnum.RibbonCandy);
        CandyBase waxCandy = new Candy("WaxCandy", 2, CandyTypesEnum.WaxCandy);
        CandyBase veganCandy = new Candy("veganCandy", 3, CandyTypesEnum.VeganCandy);
        CandyBase waxCandyBig = new Candy("WaxCandyBig", 7, CandyTypesEnum.WaxCandy);
        CandyBase hardCandyBig = new Candy("HardCandyBig", 8, CandyTypesEnum.HardCandy);

        ArrayList<CandyBase> gift = new ArrayList<>();
        gift.add(morning);
        gift.add(evening);
        gift.add(lunch);
        gift.add(diner);
        gift.add(hardCandy);
        gift.add(ribbonCandy);
        gift.add(waxCandy);
        gift.add(veganCandy);
        gift.add(waxCandyBig);
        gift.add(hardCandyBig);

        sortOfGetCalories(gift);

        weightGift(gift);

        choiceSweet(gift, initialSugarContent, finalSugarContent);

    }

    private static Integer weightGift(ArrayList<CandyBase> gift) {
        Integer weightGift = 0;
        for (CandyBase giftWeightFor : gift) {
            weightGift = weightGift + giftWeightFor.getWeightInGram();
        }
        System.out.println("Вес подарка составляет " + weightGift + " гр");
        return weightGift;
    }

    private static void sortOfGetCalories(ArrayList<CandyBase> gift) {
        System.out.println("Исходный список конфет");
        gift.forEach(System.out::println);
        System.out.println("Список конфет, отсортированный по содержанию каллорий");
        gift.sort((o1, o2) -> o1.getCalories() - o2.getCalories());
        gift.forEach(System.out::println);
    }

    private static void choiceSweet(ArrayList<CandyBase> gift, Integer initialSugarContent, Integer finalSugarContent) {
        System.out.println("Кофеты, содержащие сахар в диапазоне от " + initialSugarContent + " до " + finalSugarContent + ":");
        for (CandyBase contentSugar : gift) {
            if (contentSugar.getContentOfSugar() > initialSugarContent &&
                contentSugar.getContentOfSugar() < finalSugarContent) {
                System.out.println(contentSugar);
            }
        }
    }
}