import java.util.Random;

public class Coin extends Item {
    private int coinPoint;

    /**
     * Memberikan point default pada coin
     */
    public Coin() {
        coinPoint = 10;
    }

    /**
     * Mengembalikan point randomisasi untuk coin
     * @return point random
     */
    public int getRandomizedPoint() {
        Random random = new Random();
        int randcoinPoint = random.nextInt(15 - 1) + 1;
        return randcoinPoint;
    }

    /**
     * Mensimulasikan proses bertemu coin
     * @return point coin
     */
    public int coinEncounter (){
        coinPoint = getRandomizedPoint();
        
        if (coinPoint <= 5) {
            System.out.println("\nHmmm?!\nAnda menemukan Coin kecil");
        } else if (coinPoint > 5 && coinPoint <= 10) {
            System.out.println("\nWah!\nAnda menemukan Coin");
        } else {
            System.out.println("\nLuar biasa!\nAnda menemukan Coin besar");
        }
        System.out.println("coinPoint anda bertambah " + coinPoint);
        return coinPoint;
    }

}
