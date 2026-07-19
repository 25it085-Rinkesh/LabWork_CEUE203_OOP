import java.util.Scanner;

enum Coin{ONE, TWO, FIVE, TEN}
class VendingMachine {
    static void main() {

        final int snackPrice = 15;
        int total = 0;

        System.out.println("Snack price: " + snackPrice);
        Scanner sc = new Scanner(System.in);
        System.out.println("Give Coin(ONE, TWO, FIVE, TEN):");
        while (total < snackPrice) {

            String input = sc.next().toUpperCase();

            Coin coin;
            try {
                coin = Coin.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("  Not a valid coin, try again.");
                continue;
            }

            int value = switch (coin) {
                case ONE  -> 1;
                case TWO  -> 2;
                case FIVE -> 5;
                case TEN  -> 10;
            };
            total += value;

        }
        if(total >= snackPrice) {
            int change = total - snackPrice;
            System.out.println("Paid. Change: " + change);
        }
    }
}

