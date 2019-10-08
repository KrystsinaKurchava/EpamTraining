package сollections;

import сollections.classes.CandyBase;

import java.util.ArrayList;

public class NewYearsGiftArray {
    private ArrayList<CandyBase> newYearGift;

    public NewYearsGiftArray() {
        newYearGift = new ArrayList<CandyBase>();
    }

    public void addCandyToGift(CandyBase name) {
        newYearGift.add(name);
    }

    public Integer getWeightGift() {
        Integer weightGift = 0;
        for (CandyBase giftWeightFor : newYearGift) {
            weightGift = weightGift + giftWeightFor.getWeightInGram();
        }
        System.out.println("Вес подарка составляет " + weightGift + " гр");
        return weightGift;
    }

    public void sortOfGetCalories() {
        System.out.println("Исходный список конфет");
        newYearGift.forEach(System.out::println);
        System.out.println("Список конфет, отсортированный по содержанию каллорий");
        newYearGift.sort((o1, o2) -> o1.getCalories() - o2.getCalories());
        newYearGift.forEach(System.out::println);
    }

    public void choiceSweetInTheRangeContentOfSugar(Integer initialSugarContent, Integer finalSugarContent) {
        System.out.println("Кофеты, содержащие сахар в диапазоне от " + initialSugarContent + " до " + finalSugarContent + ":");
        for (CandyBase contentSugar : newYearGift) {
            if (contentSugar.getContentOfSugar() > initialSugarContent &&
                    contentSugar.getContentOfSugar() < finalSugarContent) {
                System.out.println(contentSugar);
            }
        }
    }
}
