import java.util.Random;
import java.util.Scanner;

public class kodokLompat 
{
    final int boxSize = 10;
    final int coinScore = 10;
    final int monsScore = -5;
    int point = 100;
    Random random = new Random();
    int[] coin = new int[boxSize];
    int[] mons = new int[boxSize];

    public kodokLompat(int difficulty) {
        int monsCount = 3;
        int coinCount = 2;

        for (int i = 0, tmp; i < monsCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            mons[tmp]++;
            // System.out.println(i + ": " + tmp);
        }

        // System.out.println("\ncoin:");
        for (int i = 0, tmp; i < coinCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            coin[tmp]++;
            // System.out.println(i + ": " + tmp);
        }

    }

    static void movement(int i){
        System.out.println("\nSekarang anda berada pada kotak ke-"+ (i+1));
        System.out.println("Kemana anda akan melompat? (Angka)");
        System.out.println("1. Lompat 1 kotak\n2. Lompat 2 kotak");
        System.out.println("3. Lompat mundur 1 kotak\n4. Lompat mundur 2 kotak");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int diff;
        int i = 0;
        int lompat;

        
        System.out.println("Selamat datang pada permainan Lompat hai katak, lompat!\n");
        System.out.println("Silahkan pilih tingkat kesulitan (Angka)");
        System.out.println("1. Easy\n2. Normal\n3. Hard\n4. Hardcore\n");

        diff = in.nextInt();
        kodokLompat k = new kodokLompat(diff);
        
        System.out.println("==============================================");
        System.out.println("Permainan dimulai:");
        
        movement(i);
        lompat  = in.nextInt();

        while (i < k.boxSize - 1) {
            movement(i);
            lompat = in.nextInt();
            
            if (lompat == 1) {
                i += 1;
            } else if (lompat == 2) {
                i += 2;
            } else if (lompat == 3) {
                i -= 1;
            } else if (lompat == 4) {
                i -= 2;
            } else {
                System.out.println("Opsi yang anda pilih invalid\nSilahkan coba lagi: ");
                continue;
            }

            if (k.coin[i] != 0 && k.mons[i] != 0) {
                System.out.println("Waduh!\nAnda bertemu monster dan koin sekaligus");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore) + k.mons[i] * k.monsScore);
                
                k.mons[i] = 0;
                k.coin[i] = 0;
            }

            if (k.coin[i] != 0) {
                System.out.println("Wah!\nAnda menemukan " + k.coin[i] + " Coin");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore));
                
                k.coin[i] = 0;
            }
            if (k.mons[i] != 0) {
                System.out.println("Awas!\nAnda bertemu " + k.mons[i] + " Monster");
                System.out.println("Point anda sekarang: " + (k.point += k.mons[i] * k.monsScore));

                k.mons[i] = 0;
            }


        }

        // for (int j = 0; j < k.boxSize; j++) {
        //     System.out.println(j + ": " + k.mons[j] + "; "+ k.coin[j]);    
        // }

        in.close();
    }
}
