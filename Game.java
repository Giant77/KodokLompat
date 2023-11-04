import java.util.Scanner;

public class Game {
    private int i = 0;  // iteration/position variable
    private int lompat; // movement input variable
    private int replay; // play again input variabel
    private Scanner in = new Scanner(System.in);
    Monster mons = new Monster();
    Coin koin = new Coin();
    Kotak kotak = new Kotak();
    
    /**
     * Menanyakan pergerakan kodok selanjutnya 
     */
    public static void askMovement (){
        System.out.println("\nKemana Kodok akan melompat? (Angka)");
        System.out.println("1. Lompat 1 kotak\n2. Lompat 2 kotak");
        System.out.println("3. Lompat mundur 1 kotak\n4. Lompat mundur 2 kotak");
    }

    /**
     * Menanyakan dan meminta apakah pemain ingin bermain lagi
     * dan dijalankan sesuai input yang diterima
     */
    public void askPlayAgain () {
        // akan keluar dari loop jika input yang diterima adalah angka yang valid
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println("Permainan telah selesai!");
            System.out.println("Apakah anda ingin bermain lagi?");
            System.out.println("1. Main lagi\n2. Exit");

            replay = in.nextInt();

            if (replay == 1 || replay == 2) {
                break;
            } else {
                System.out.println("Input invalid!\nSilahkan coba lagi");
            }
        }
        
        // jika ingin bermain kembali, kotak di re-inisialisasi, dan i (posisi sekarang) direset
        if (replay == 1) {
            kotak = new Kotak();
            kotak.init();
            i = 0;
        } else if (replay == 2) {
            System.exit(0);
        }

    }

    /**
     * Menampilkan pesan ketika kodok telah mencapai
     * kotak terakhir ataupun terjadi game over
     * 
     * @param diff pesan berbeda tergantu tingkat kesulitan
     * @param pointAkhir pesan berdasarkan poin akhir
     */
    public static void congratsMsg(int diff, int pointAkhir) {
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
     * logika utama permainan kodok lompat
     * 
     * @param boxSize banyak kotak yang ada
     * @param difficulty jumlah koin dan monster tergantung tingkat kesulitan
     */
    public void movement(int boxSize, int difficulty) {
        while (i < boxSize) {
            
            if (i < boxSize - 1) {
                askMovement();
                lompat = in.nextInt();
                System.out.println("______________________________________________\n");
                
                // pergerakan kodok tergantung dari input user
                if (lompat == 1) {
                    i += 1;
                } else if (lompat == 2) {
                    // mengembalikan posisi kotak menjadi banyak kotak maksimum
                    // jika setelah ditambahkan lebih besar dari banyak kotak maksimum
                    if ((i += 2) >= boxSize){
                        i = boxSize - 1;
                    }
                } else if (lompat == 3) {
                    if ((i -= 1) <= 0) {
                        i = 0;
                    }
                } else if (lompat == 4) {
                    // mengembalikan posisi kotak menjadi index kotak terkecil,
                    // jika setelah dikurangkan lebih kecil dari index kotak minimum
                    if ((i -= 2) <= 0) {
                        i = 0;
                    }
                } else {
                    System.out.println("Opsi yang anda pilih invalid\nSilahkan coba lagi: ");
                    continue;
                }
            } else {    // jika berada pada kotak terakhir, maka permainan selesai
                System.out.println("\nAnda telah mencapai kotak terakhir!");
                System.out.println("Point akhir anda " + kotak.getPoint());
                congratsMsg(difficulty, kotak.getPoint());

                askPlayAgain();
            }

            // menampilkan pesan berdasarkan isi dari kotak dan posisi sekarang
            if (kotak.getBoxes(i) > 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                kotak.alterPoint(koin.coinEncounter());

                System.out.println("Point anda sekarang: " + kotak.getPoint());
                kotak.setBoxes(i);                
            } else if (kotak.getBoxes(i) < 0) {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                kotak.alterPoint(mons.monsEncounter());

                System.out.println("Point anda sekarang: " + kotak.getPoint());
                kotak.setBoxes(i);
            } else {
                System.out.println("Sekarang anda berada pada kotak ke-"+ (i+1));
                System.out.println("Zonk!\nAnda tidak menemukan apapun");
                System.out.println("Point anda sekarang: " + kotak.getPoint());
            }

            if (kotak.getPoint() <= 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("GAME OVER!");
                System.out.println("Point akhir anda " + kotak.getPoint());
                congratsMsg(difficulty, kotak.getPoint());

                askPlayAgain();
            }

        }
    }
}