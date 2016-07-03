import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ShopkinsTest {
 
    Console console = System.console();
    
    public static final int MAX_GUESS = 7;
    private String mGuess;
    private String mShopkinNames = 
        "sugar choco-lava clear-muffin oil beverly-heels fluffy-baby golden-crown kiwi magic-purse french-fries ice-cream-dream pineapple-crush sugar-lump d'lish-donut kooky-cookie";
    private boolean mCorrect;
    private int mCount = 1;
    public List<String> shopkinsLeft = new ArrayList<String>();
    public String getGuess() {
        return mGuess;
    }
    
    public String getShopkinNames() {
        return mShopkinNames;
    }
    
    public boolean getCorrect() {
        return mCorrect;
    }
    
    public int getCount() {
        return mCount;
    }
    
    public List<String> shopkinList() {
        String[] shopkins = mShopkinNames.split(" ");
        
        return Arrays.asList(shopkins);
    }
    
    
    
    public String title(String name) {
        char[] letters = name.toCharArray();
        letters[0] = Character.toUpperCase(letters[0]);
        return name = new String (letters);
    }
    
    
    public ShopkinsTest() {
        shopkinsLeft.addAll(shopkinList());
//        String[] list = shopkinList();
            int number = (int)(Math.random() * (shopkinList().size()));
            
            String word = shopkinList().get(number);
            
        do {
            
            int remaining = MAX_GUESS - getCount();
            mCorrect = false;
            System.out.println("You're choices are: ");
            for (String choice : shopkinsLeft) {
                System.out.println(choice.toUpperCase());
            }
            
            mGuess = console.readLine("%nPlease enter a guess: ");
            
             while (!shopkinsLeft.contains(mGuess)) {
                    System.out.printf("That word isn't in the list, try again%n%n");
                 mGuess = console.readLine("%nPlease enter a guess: ");
                }
            
//            String lowerName = getGuess().toLowerCase();
            String wordTry = "try";
            
            shopkinsLeft.remove(mGuess);
            if (remaining != 1) {
                wordTry = "tries";
            }
            
             if (getGuess().equalsIgnoreCase(word)){
                System.out.printf("%s was correct..YOU WIN!%n%n",getGuess().toUpperCase());
                mCorrect = true;
//                 System.exit(0);
            }  
            
            if (!getGuess().equalsIgnoreCase(word)) {
                
                mCount++;
//                shopkinsLeft.remove(getGuess());
                System.out.printf("Sorry, %s isn't right...try again%n", getGuess().toUpperCase());
                System.out.printf("You have %d %s left%n%n", remaining, wordTry);
               
                 if (remaining == 1){
                System.out.printf("Hint: The word starts with: " + word.charAt(0) + "%n%n");
                 }
                if (remaining <= 0) {
                System.out.printf("Sorry, you are out of guesses.%n%n");
                System.out.printf("The answer was %s%nGame Over%n%n%n", word.toUpperCase());
                System.exit(0);
                }
            }
        }
        while (!getCorrect());
    }
}