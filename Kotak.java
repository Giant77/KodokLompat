import java.util.Random;
import java.util.Scanner;

public class Kotak {
    private int diff;
    private int monsCount;
    private int coinCount;
    private int point = 100;
    private final int boxSize = 300;
    private final int[] boxes = new int[boxSize];
    private final Scanner in = new Scanner(System.in);

    /**
     * Menginisialisasikan kotak dengan memanggil beberapa method
     * untuk mempersingkat logika utama
     */
    public void init() {
        this.setDiff();
        this.setKotak();
        this.setPosCoin();
        this.setPosMons();
    }

    /**
     * Mengembalikan banyaknya kotak
     * 
     * @return banyak kotak
     */
    public int getBoxSize() {
        return boxSize;
    }

    /**
     * Mengubah point dengan menambahkan point dengan parameter
     * 
     * @param point point yang ditambahkan
     */
    public void alterPoint(int point) {
        this.point += point;
    }

    /**
     * Megembalikan point saat ini
     * 
     * @return point
     */
    public int getPoint() {
        return point;
    }

    /**
     * meminta tingkat kesulitan sesuai input
     */
    public void setDiff() {
        while (true) {
            System.out.println("\nSilahkan pilih tingkat kesulitan (Angka)");
            System.out.println("1. Easy\n2. Normal\n3. Hard\n4. Hardcore");
            System.out.print("Input: ");

            try {
                diff = in.nextInt();
            } catch (Exception e) {
                System.out.println("\nTerjadi error!\nPesan error: " + e);
                in.nextLine();
                continue;
            }

            if (diff >= 1 && diff <= 4) {
                break;
            } else {
                System.out.println("Tingkat kesulitan yang anda pilih invalid\nSilahkan coba lagi\n");
            }
        }
    }

    /**
     * Mengembalikan tingkat kesulitan saat ini
     * 
     * @return tingkat kesulitan
     */
    public int getDiff() {
        return diff;
    }

    /**
     * Mengembalikan isi dari kotak sesuai dengan posisi parameter
     * 
     * @param i posisi saat ini
     * @return isi dari kotak pada posisi i
     */
    public int getBoxes(int i) {
        return boxes[i];
    }

    /**
     * Mengubah isi dari kotak menjadi kosong,
     * karena isi dari kotak telah ditemukan
     * 
     * @param i posisi saat ini
     */
    public void setBoxes(int i) {
        boxes[i] = 0;
    }

    /**
     * Mengatur banyak koin dan monster yang ada pada permainan
     * tergantung dari tingkat kesulitan yang dipilih
     */
    public void setKotak() {
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
    }

    /**
     * Merandomisasi posisi koin, dan memastikan
     * bahwa kotak belum terisi sebelumnya
     */
    public void setPosCoin() {
        int i = 0;
        int tmp;
        Random rand = new Random();

        while (i < coinCount) {
            tmp = rand.nextInt(boxSize - 0);
            if (boxes[tmp] == 0) {
                boxes[tmp]++;
                i++;
            }
        }
    }

    /**
     * Merandomisasi posisi monster, dan memastikan
     * bahwa kotak belum terisi sebelumnya
     */
    public void setPosMons() {
        int i = 0;
        int tmp;
        Random rand = new Random();

        while (i < monsCount) {
            tmp = rand.nextInt(boxSize - 0);
            if (boxes[tmp] == 0) {
                boxes[tmp]--;
                i++;
            }
        }
    }

}
