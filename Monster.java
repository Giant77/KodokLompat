import java.util.Random;

public class Monster extends Item {
    private int monsPoint;

    /**
     * Memberikan point default pada monster
     */
    public Monster() {
        monsPoint = -5;
    }

    /**
     * Mengembalikan point randomisasi untuk monster
     * @return point random
     */
    public int getRandomizedPoint() {
        Random random = new Random();
        int randPoint = (random.nextInt(15 - 1) + 1) * -1;
        return randPoint;
    }

    /**
     * Mensimulasikan proses bertemu monster
     * @return point monster
     */
    public int monsEncounter() {
        monsPoint = getRandomizedPoint();
    
        if (monsPoint >= -5) {
            System.out.println("\nHmmm?!\nAnda bertemu Monster kroco");
        } else if (monsPoint < -5 && monsPoint >= -10) {
            System.out.println("\nAwas!\nAnda bertemu Monster");
        } else {
            System.out.println("\nHati-hati!\nAnda bertemu Monster elit");
        }
        System.out.println("Point anda berkurang " + monsPoint);
        return monsPoint;
    }
    
}
