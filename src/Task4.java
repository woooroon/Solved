import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.stream.*;

public class Task4 {

    public static void main(String[] args) {
        int budget = 150;
        System.out.print("Available products you may to buy: ");
        for (Products dir : Products.values()) {
            System.out.print(dir + " ");
        }
        System.out.println(" ");
        long count = IntStream.of(Products.APPLES.getPrice(), Products.ORANGES.getPrice(), Products.BANANAS.getPrice(), Products.LEMONS.getPrice(), Products.PLUMS.getPrice()).filter(w -> w >= 30).count();
        System.out.println("Number of products, that are more expensive than 30 UAH: "+ count);
        CalculateSum calculateSum;
        calculateSum = (int x, int y, int z) -> x + y + z;
        Products[] products = new Products[]{Products.APPLES, Products.BANANAS, Products.LEMONS};
        System.out.println(" ");
        System.out.println(" Your budget: " + budget + " UAN ");

        System.out.print(" Your basket: ");
        for (Products x : products) {
            System.out.print(" " + x);
        }
        BinaryOperator<Integer> multiply = (x, y) -> x*y; // x - price of product for kilogram, y - number of kilograms
        int priceForFirstProduct =  multiply.apply(products[0].getPrice(),2);
        int priceForSecondProduct = multiply.apply(products[1].getPrice(),1);
        int priceForThirdProduct =  multiply.apply(products[2].getPrice(),3);
        int finalSum = calculateSum.calculate(priceForFirstProduct,priceForSecondProduct,priceForThirdProduct);
        Predicate<Integer> isMatchYourBudget = x -> x <= budget;
        boolean isMatch = isMatchYourBudget.test(finalSum);
        if (isMatch) {
            System.out.println(" ");
            System.out.println(" Purchase amount: " + finalSum + " UAN ");
            System.out.println(" Your balance after purchase: "+(budget-finalSum)+ " UAN ");
        } else {
            System.out.println(" ");
            System.out.println("-----Error-----");
            System.out.println(" Your purchase amount is higher than your budget " +'\n'+" Your final sum: "+finalSum + " UAN ");
        }
    }
}


    enum Products {
        APPLES(24),
        ORANGES(43),
        BANANAS(29),
        LEMONS(37),
        PLUMS(12);

        public int price;

        Products(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    interface CalculateSum {
        int calculate(int x, int y, int z);
    }


