import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class kodok lompat berisi sebuah minigame tentang kodok yang melompati kotak-
 * kotak untuk mengumpulkan point. masing-masing kotak dapat berisi coin ataupun
 * monster yang akan mengubah poin dari pemain.
 */
public class kodokLompat 
{
    /**
     * Banyak Kotak dalam permainan.
     */
    final int boxSize = 300;
    
    /**
     * Point default yang didapat saat menemukan coin.
     */
    int coinScore = 10;
    
    /**
     * Point default yang dikurang saat bertemu monster.
     */
    int monsScore = -5;
    
    /**
     * Point default dari pemain.
     */
    int point = 100;
    
    /**
     * Pengahasil nilai acak untuk mengacak point, dan lokasi monster dan coin.
     */
    Random random = new Random();
    
    /**
     * Objek scanner untuk membaca input.
     */
    Scanner in = new Scanner(System.in);
    
    /**
     * Array yang mewakili isi dari setiap kotak yang ada.
     * Nilai positif menandakan coin, nilai negatif menandakan monster,
     * dan nilai 0 menandakan kotak yang kosong.
     */
    int[] boxes = new int[boxSize];
    
    /**
     * Menginisialisasikan permainan dengan menanyakan tingkat kesulitan
     * dan men-setup setiap kotak.
     */
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
        
        // Menyetel tingkat kesulitan sesuai dengan input pemain
        if (diff == 1) {
            System.out.println("Tingkat kesulitan: Easy");
            monsCount = 120;
            coinCount = 150;
        } else if (diff == 2) {
            System.out.println("Tingkat kesulitan: Normal");
            monsCount = 150;
            coinCount = 130;
        } else if (diff == 3) {
            System.out.println("Tingkat kesulitan: Hard");
            monsCount = 170;
            coinCount = 110;
        } else {
            System.out.println("Tingkat kesulitan: Hardcore");
            monsCount = 190;
            coinCount = 95;
        }

        // Mengisi kotak dengan monster dan coin secara acak
        int i = 0;
        int tmp = 0;
        while (i < monsCount) {
            tmp = random.nextInt(boxSize - 0);
            if (boxes[tmp] == 0){
                boxes[tmp]--;
                i++;
            }
        }
    
        i = 0;
        while (i < coinCount) {
            tmp = random.nextInt(boxSize - 0);
            if (boxes[tmp] == 0){
                boxes[tmp]++;
                i++;
            }
        }
    }

    /**
     * Menanyakan pemain pergerakan katak selanjutnya
     * dan memperbarui lokasi katak saat ini.
     * @param i menandakan posisi katak saat ini dalam permainan.
     */
    private static void askMovement (int i){
        System.out.println("\nKemana anda akan melompat? (Angka)");
        System.out.println("1. Lompat 1 kotak\n2. Lompat 2 kotak");
        System.out.println("3. Lompat mundur 1 kotak\n4. Lompat mundur 2 kotak");
    }

    /**
     * Menanyakan apakah pemain ingin bermain lagi
     * ataupun keluar dari permainan 
     */
    private static void askPlayAgain () {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Permainan telah selesai!");
        System.out.println("Apakah anda ingin bermain lagi?");
        System.out.println("1. Main lagi\n2. Exit");
    }

    /**
     * Menampilkan pesan selamat berdasarkan point akhir dari pemain dan tingkat kesulitan
     * @param diff Menunjukkan tingkat kesulitan.
     * @param pointAkhir Menunjukkan point akhir dari pemain.
     */
    private static void congratsMsg(int diff, int pointAkhir) {
        if (pointAkhir <= 0) {
            System.out.println("Sayang sekali! Anda hanya kurang beruntung.");
        } else if (pointAkhir > 0 && pointAkhir <= 100) {
            System.out.println("Cukup baik! Anda masih bisa lebih baik lagi!");
        } else if (pointAkhir > 100 && pointAkhir <= 200) {
            System.out.println("Sangat baik! Bisakah Anda melakukan lebih baik lagi?");
        }

        if (diff == 1 && pointAkhir > 200) {
            System.out.println("Hebat! Anda telah menguasai tingkat Easy!");
        } else if (diff == 2 && pointAkhir > 200){
            System.out.println("Luar biasa! Anda telah mengatasi tingkat Normal!");
        } else if (diff == 3 && pointAkhir > 200) {
            System.out.println("Bravo! Anda telah menguasai tingkat Hard!");
        } else if (diff == 4 && pointAkhir > 200) {
            System.out.println("Luar biasa! Anda adalah juara Hardcore sejati!");
        } 
    }

    /**
     * Mensimulasi proses menemukan coin dalam permainan
     * dan mengembalikan point dari coin tersebut
     * @return Point dari coin yang ditemukan.
     */
    private static int coinMsg (){
        Random rand = new Random();
        kodokLompat k1 = new kodokLompat();

        k1.coinScore = rand.nextInt(15 - 1) + 1;
        
        if (k1.coinScore <= 5) {
            System.out.println("\nHmmm?!\nAnda menemukan Coin kecil");
        } else if (k1.coinScore > 5 && k1.coinScore <= 10) {
            System.out.println("\nWah!\nAnda menemukan Coin");
        } else {
            System.out.println("\nLuar biasa!\nAnda menemukan Coin besar");
        }
        System.out.println("Point anda bertambah " + k1.coinScore);
        return k1.coinScore;
    }

    /**
     * Mensimulai proses bertemu monster dalam permainan
     * dan mengembalikan point yang akan berkurang.
     * @return Mengembaikan point yang akan dikurang.
     */
    private static int monsMsg (){
        Random rand = new Random();
        kodokLompat k2 = new kodokLompat();

        k2.monsScore = (rand.nextInt(15 - 1) + 1) * -1;
    
        if (k2.monsScore >= -5) {
            System.out.println("\nHmmm?!\nAnda bertemu Monster kroco");
        } else if (k2.monsScore < -5 && k2.monsScore >= -10) {
            System.out.println("\nAwas!\nAnda bertemu Monster");
        } else {
            System.out.println("\nHati-hati!\nAnda bertemu Monster elit");
        }
        System.out.println("Point anda berkurang " + k2.monsScore);
        return k2.monsScore;
    }

    /**
     * Masuk kedalam bagian main dari permainan
     * @param args Argumen command line (tidak digunakan).
     */
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
            
            if (i < k.boxSize - 1) {
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
            } else {
                System.out.println("\nAnda telah mencapai kotak terakhir!");
                System.out.println("Point akhir anda " + k.point);
                congratsMsg(k.point, k.point);

                while (true) {
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
                    Arrays.fill(k.boxes, 0);
                    k.init();
                } else if (replay == 2) {
                    break;
                }
            } 

            if (k.boxes[i] > 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                k.coinScore = coinMsg();

                System.out.println("Point anda sekarang: " + (k.point += k.coinScore));
                
                k.boxes[i] = 0;
            } else if (k.boxes[i] < 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                k.monsScore = monsMsg();
                System.out.println("Point anda sekarang: " + (k.point += k.monsScore));

                k.boxes[i] = 0;
            } else {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Zonk!\nAnda tidak menemukan apapun");
                System.out.println("Point anda sekarang: " + k.point);
            }

            if (k.point <= 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("GAME OVER!");
                System.out.println("Point akhir anda " + k.point);
                
                while (true) {      //ask play again
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
                    Arrays.fill(k.boxes, 0);
                    k.init();
                } else if (replay == 2) {
                    break;
                }
            } 
        }

        in.close();
    }
}
