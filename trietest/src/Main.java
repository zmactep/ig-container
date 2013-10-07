import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 11:08
 */
public class Main {
    public static void main(String [] args) {
        Runtime rt = Runtime.getRuntime();
        Trie<Integer> trie = new Trie<Integer>();
        Random mrand = new Random();

        for(int i = 0; i < 100000; i++) {
           int key = 0;
            for(int j = 0; j < 100; j++) {
                byte c = (byte)mrand.nextInt(4);
                key = trie.insert(key, c);
            }

            if(i % 200 == 0) {
                long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
                System.out.println(usedMB);
            }
        }

        long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        System.out.println(usedMB);
        System.out.println(trie.size());
    }
}
