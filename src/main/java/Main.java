import calculator.Calculator;
import model.Product;
import utils.ProductFactory;
import utils.UserInput;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("На сколько человек нужно разделить счёт?");
        int numberOfPerson = UserInput.enterNumberOfGuests();

        while (true) {
            String productName = UserInput.enterProductName();
            double cost = UserInput.enterCostOfTheProduct();
            Product product = ProductFactory.createProduct(productName, cost);
            calculator.add(product);
            System.out.println("Товар успешно добавлен в калькулятор");

            System.out.println("Хотите ли вы добавить еще один товар?");

            String command = UserInput.askToContinueAddingProducts();
            if (command.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        calculator.printAllAddedProducts();
        calculator.calculatePriceForOnePerson(numberOfPerson);


    }
}