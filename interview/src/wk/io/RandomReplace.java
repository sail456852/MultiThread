package wk.io;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class RandomReplace {
    public static void main(String[] args) {
        String testStr = "^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0^A0";
        // 2 5 8 11 .....
        Random random = new Random();
        Set<Integer> list = new TreeSet<>();
        do{
            int rInt = random.nextInt( 29 );
            int crIndex = rInt * 3 + 2;
            list.add(crIndex);
        }while(list.size() < 10);

        for (Integer i :
                list) {
            System.out.println("i = " + i);
        }
        // generate random number
        StringBuilder sb = new StringBuilder(testStr);
        for (Integer i:
             list) {
           sb.setCharAt(i, '1');
        }
        System.out.println("sb = " + sb);
    }
}
