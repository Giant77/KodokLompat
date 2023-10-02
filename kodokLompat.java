import java.util.Random;
import java.util.Scanner;

public class kodokLompat 
{
    final int boxSize = 10;
    final int coinScore = 10;
    final int monsScore = -5;
    int point = 100;
    Random random = new Random();
    int[] box = new int[boxSize];

    public kodokLompat(String difficulty) {
        int mons = 3;
        int coin = 2;

        for (int i = 0, tmp; i < mons; i++) {
            tmp = random.nextInt(boxSize - 0);
            box[tmp]-= 1;
            System.out.println(i + ": " + tmp);
        }

        System.out.println("\ncoin:");
        for (int i = 0, tmp; i < coin; i++) {
            tmp = random.nextInt(boxSize - 0);
            box[tmp]+= 2;
            System.out.println(i + ": " + tmp);
        }

    }

    public static void main(String[] args) {
        kodokLompat k = new kodokLompat(null);
        
        System.out.println("arr:");
        
        for (int i = 0; i < k.box.length; i++) {
            System.out.println(i + ": " + k.box[i]);    
        }

    }
}
