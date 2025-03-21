package Problems.easy;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Инициализируйте переменные buy первым элементом массива цен и profit значением 0.
 * Выполните итерацию по ценам, начиная со второго элемента.
 * Обновите переменную buy если текущая цена ниже текущей цены покупки.
 * Обновите profit если разница между текущей ценой и ценой покупки больше текущей прибыли.
 * Верните конечную прибыль.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();

        int[] prices = {2,4,1};

        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0]; // цена покупки
        int profit = 0;   // профит после продажи

        // иперируемся по всему масиву
        for (int i = 1; i < prices.length; i++) {

            // обновляем если цена меньше
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
                continue;
            }

            // если профит стал больше то обновляем его значение
            if (profit < prices[i] - buyPrice) {
                profit = prices[i] - buyPrice;
            }
        }

        return profit;
    }
}

/*
    public int maxProfit(int[] prices) {
        int delta = 0;

        for (int i = 0; prices.length > i; i++) {
            for (int j = i+1; prices.length > j; j++) {
                int deltaPrice = prices[j] - prices[i];

                if (deltaPrice > delta) {
                    delta = deltaPrice;
                }
            }
        }

        return delta;
    }
 */
