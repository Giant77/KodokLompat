import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class kodokLompat 
{
    final int boxSize = 30;
    final int coinScore = 10;
    final int monsScore = -5;
    int point = 100;
    Random random = new Random();
    Scanner in = new Scanner(System.in);
    int[] coin = new int[boxSize];
    int[] mons = new int[boxSize];
    
    private void init () {
        int monsCount;
        int coinCount;
        int diff;
        
        while (true) {
            System.out.println("\nSilahkan pilih tingkat kesulitan (Angka)");
            System.out.println("1. Easy\n2. Normal\n3. Hard\n4. Hardcore\n");

            diff = in.nextInt();
            if (diff >= 1 && diff <= 4) {
                break;
            } else {
                System.out.println("Tingkat kesulitan yang anda pilih invalid\nSilahkan coba lagi\n");
            }
            
        }
        
        if (diff == 1) {
            System.out.println("Tingkat kesulitan: Easy");
            monsCount = 168;
            coinCount = 106;
        } else if (diff == 2) {
            System.out.println("Tingkat kesulitan: Normal");
            monsCount = 206;
            coinCount = 97;
        } else if (diff == 3) {
            System.out.println("Tingkat kesulitan: Hard");
            monsCount = 214;
            coinCount = 86;
        } else {
            System.out.println("Tingkat kesulitan: Hardcore");
            monsCount = 230;
            coinCount = 70;
        }


        for (int i = 0, tmp; i < monsCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            mons[tmp]++;
        }

        for (int i = 0, tmp; i < coinCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            coin[tmp]++;
        }

    }

    private static void askMovement (int i){
        System.out.println("\nKemana anda akan melompat? (Angka)");
        System.out.println("1. Lompat 1 kotak\n2. Lompat 2 kotak");
        System.out.println("3. Lompat mundur 1 kotak\n4. Lompat mundur 2 kotak");
    }

    private static void askPlayAgain () {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Permainan telah selesai!");
        System.out.println("Apakah anda ingin bermain lagi?");
        System.out.println("1. Main lagi\n2. Exit");
    }

    private static void congratsMsg(int diff, int pointAkhir) {
        if (pointAkhir <= 0) {
            System.out.println("Sayang sekali! Anda hanya kurang beruntung.");
        } else if (pointAkhir > 0 && pointAkhir <= 80) {
            System.out.println("Cukup baik! Anda masih bisa lebih baik lagi!");
        } else if (pointAkhir > 80 && pointAkhir <= 150) {
            System.out.println("Sangat baik! Bisakah Anda melakukan lebih baik lagi?");
        }

        if (diff == 1 && pointAkhir > 150) {
            System.out.println("Hebat! Anda telah menguasai tingkat Easy!");
        } else if (diff == 2 && pointAkhir > 150){
            System.out.println("Luar biasa! Anda telah mengatasi tingkat Normal!");
        } else if (diff == 3 && pointAkhir > 150) {
            System.out.println("Bravo! Anda telah menguasai tingkat Hard!");
        } else if (diff == 4 && pointAkhir > 150) {
            System.out.println("Luar biasa! Anda adalah juara Hardcore sejati!");
        } 
    }
       

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int lompat;
        int replay = 0;
        kodokLompat k = new kodokLompat();
        
        System.out.println("Selamat datang pada permainan Lompat hai katak, lompat!");


        k.init();
        
        System.out.println("==============================================");
        System.out.println("Permainan dimulai:");
        
        while (i < k.boxSize) {
            
            if (i < k.boxSize - 1) {        // ask movement
                askMovement(i);
                lompat = in.nextInt();
                System.out.println("______________________________________________\n");

                if (lompat == 1) {
                    i += 1;
                } else if (lompat == 2) {
                    if ((i += 2) >= k.boxSize){
                        i = k.boxSize - 1;
                    }
                } else if (lompat == 3) {
                    if ((i -= 1) <= 0) {
                        i = 0;
                    }
                } else if (lompat == 4) {
                    if ((i -= 2) <= 0) {
                        i = 0;
                    }
                } else {
                    System.out.println("Opsi yang anda pilih invalid\nSilahkan coba lagi: ");
                    continue;
                }                
            } else {            // end of box, ask replay
                System.out.println("\nAnda telah mencapai kotak terakhir!");
                System.out.println("Point akhir anda " + k.point);
                congratsMsg(k.point, k.point);

                while (true) {      //ask replay
                    askPlayAgain();
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
                    Arrays.fill(k.coin, 0);
                    Arrays.fill(k.mons, 0);
                    k.init();
                } else if (replay == 2) {
                    break;
                }
            } 
                // Scoring
            if (k.coin[i] != 0 && k.mons[i] != 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Waduh!\nAnda bertemu " + k.mons[i] + " monster dan " + k.coin[i] + " koin sekaligus");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore + k.mons[i] * k.monsScore));
                
                k.mons[i] = 0;
                k.coin[i] = 0;
            } else if (k.coin[i] != 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Wah!\nAnda menemukan " + k.coin[i] + " Coin");
                System.out.println("Point anda sekarang: " + (k.point += k.coin[i] * k.coinScore));
                
                k.coin[i] = 0;
            } else if (k.mons[i] != 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Awas!\nAnda bertemu " + k.mons[i] + " Monster");
                System.out.println("Point anda sekarang: " + (k.point += k.mons[i] * k.monsScore));

                k.mons[i] = 0;
            } else {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Zonk!\nAnda tidak menemukan apapun");
                System.out.println("Point anda sekarang: " + k.point);
            }

            if (k.point <= 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("GAME OVER!");
                System.out.println("Point akhir anda " + k.point);
                
                while (true) {      //ask replay
                    askPlayAgain();
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
                    Arrays.fill(k.coin, 0);
                    Arrays.fill(k.mons, 0);
                    k.init();
                } else if (replay == 2) {
                    break;
                }
            } 

        }

        in.close();
        
    }
}
