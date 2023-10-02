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

    void init (int difficulty) {
        int monsCount = 3;      // change based on diff
        int coinCount = 2;

        for (int i = 0, tmp; i < monsCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            mons[tmp]++;
        }

        for (int i = 0, tmp; i < coinCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            coin[tmp]++;
        }

    }

    static void askMovement (int i){
        System.out.println("\nSekarang anda berada pada kotak ke-"+ (i+1));
        System.out.println("Kemana anda akan melompat? (Angka)");
        System.out.println("1. Lompat 1 kotak\n2. Lompat 2 kotak");
        System.out.println("3. Lompat mundur 1 kotak\n4. Lompat mundur 2 kotak");
    }

    static void askReplay () {
        System.out.println("Permainan telah selesai!");
        System.out.println("Apakah anda ingin bermain lagi?");
        System.out.println("1. Main lagi\n2. Exit");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int diff;
        int i = 0;
        int lompat;
        int replay = 0;
        
        System.out.println("Selamat datang pada permainan Lompat hai katak, lompat!\n");
        System.out.println("Silahkan pilih tingkat kesulitan (Angka)");
        System.out.println("1. Easy\n2. Normal\n3. Hard\n4. Hardcore\n");

        diff = in.nextInt();
        kodokLompat k = new kodokLompat();
        k.init(diff);
        
        System.out.println("==============================================");
        System.out.println("Permainan dimulai:");
        
        while (i < k.boxSize) {
            
            if (i < k.boxSize - 1) {
                askMovement(i);
                lompat = in.nextInt();
                if (lompat == 1) {
                    i += 1;
                } else if (lompat == 2) {
                    // i += 2;

                    if ((i += 2) >= k.boxSize){
                        i = k.boxSize;
                    }
                } else if (lompat == 3) {
                    i -= 1;
                } else if (lompat == 4) {
                    i -= 2;
                } else {
                    System.out.println("Opsi yang anda pilih invalid\nSilahkan coba lagi: ");
                    continue;
                }                
            } else {
                System.out.println("\nAnda telah mencapai kotak terakhir!");
                System.out.println("Point akhir anda " + k.point);

                while (true) {      //ask replay
                    askReplay();
                    replay = in.nextInt();

                    if (replay == 1 || replay == 2) {
                        break;
                    } else {
                        System.out.println("Input invalid!\nSilahkan coba lagi");
                    }                
                }
                
                if (replay == 1) {
                    k.point = 100;
                    i = 0;
                    k.init(diff);
                } else if (replay == 2) {
                    break;
                }
            } 

            if (k.coin[i] != 0 && k.mons[i] != 0) {
                System.out.println("Waduh!\nAnda bertemu monster dan koin sekaligus");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore + k.mons[i] * k.monsScore));
                
                k.mons[i] = 0;
                k.coin[i] = 0;
            } else if (k.coin[i] != 0) {
                System.out.println("Wah!\nAnda menemukan " + k.coin[i] + " Coin");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore));
                
                k.coin[i] = 0;
            } else if (k.mons[i] != 0) {
                System.out.println("Awas!\nAnda bertemu " + k.mons[i] + " Monster");
                System.out.println("Point anda sekarang: " + (k.point += k.mons[i] * k.monsScore));

                k.mons[i] = 0;
            } else {
                System.out.println("Zonk!\nAnda tidak menemukan apapun");
                System.out.println("Point anda sekarang: " + k.point);
            }

            if (k.point <= 0) {
                System.out.println("GAME OVER!");
                System.out.println("Point akhir anda " + k.point + " memiliki nilai yang lebih kecil atau sama dengan 0");
                
                while (true) {      //ask replay
                    askReplay();
                    replay = in.nextInt();

                    if (replay == 1 || replay == 2) {
                        break;
                    } else {
                        System.out.println("Input invalid!\nSilahkan coba lagi");
                    }                
                }
                
                if (replay == 1) {
                    k.point = 100;
                    i = 0;
                    k.init(diff);
                } else if (replay == 2) {
                    break;
                }
            } 

        }

        in.close();
    }
}
