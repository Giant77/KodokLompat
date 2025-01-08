/**
 * Class main yang akan dijalankan
 */
public class MainKodokLompat {
    /**
     * Fungsi main dari program yang akan dijalankan
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Membuat instance baru dari permainan kodok lompat
        Game game = new Game();

        System.out.println("Selamat datang pada permainan Lompat hai katak, lompat!");
        game.kotak.init(); // Menginisialisasikan berbagai hal seperti tingkat kesulitan dan
                           // jumlah koin dan monster yang ada dalam permainan

        System.out.println("==============================================");
        System.out.println("Permainan dimulai:");

        // Memanggil method dengan logika utama permainan
        game.movement(game.kotak.getBoxSize(), game.kotak.getDiff());

    }

}
