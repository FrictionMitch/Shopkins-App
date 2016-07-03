import java.util.Date;

public class ShopkinsTestApp {
    public static void main (String[] args) {
        ShopkinsTest shop = new ShopkinsTest();
        
        int remainingGuesses = shop.MAX_GUESS - shop.getCount();
        int total = shop.getCount();
        Date tDate = new Date();
        String word = "guess";
        String word2 = "guess";
        if (total != 1) {
            word += "es";
        }
        if (remainingGuesses != 1) {
            word2 += "es";
        }
        
        System.out.printf("You made %d %s on %s and had %d %s left%n%n",
                          total, word, tDate, remainingGuesses, word);
        System.out.printf("There were %d shopkins left%n%n",
                          shop.shopkinList().size() - shop.getCount() + 1);
    }
}