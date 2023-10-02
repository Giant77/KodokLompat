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

    public kodokLompat(String difficulty) {
        int monsCount = 3;
        int coinCount = 2;

        for (int i = 0, tmp; i < monsCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            mons[tmp]++;
            System.out.println(i + ": " + tmp);
        }

        System.out.println("\ncoin:");
        for (int i = 0, tmp; i < coinCount; i++) {
            tmp = random.nextInt(boxSize - 0);
            coin[tmp]++;
            System.out.println(i + ": " + tmp);
        }

    }

    public static void main(String[] args) {
        kodokLompat k = new kodokLompat(null);
        
        System.out.println("arr:");
        
        for (int i = 0; i < k.boxSize; i++) {
            System.out.println(i + ": " + k.mons[i] + "; "+ k.coin[i]);    
        }

    }
}
