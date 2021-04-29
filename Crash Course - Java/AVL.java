/****
 *
 * @author Koh Si Xing
 *
 */

import java.util.Scanner;
import java.util.stream.*;

public class AVL {
    public static void main(String[] args) {
        System.out.println("---- Minimum number of nodes for AVL Tree ----");
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int result = minNodes(h);

        System.out.println("Result for minimum number of nodes for height " + h + " : " + result);
        //IntStream.rangeClosed(3,17).map(i -> minNodes(i)).forEach(System.out::println);
    }

    public static int minNodes(int height) {
        // Base Conditions
        if (height == 0)
            return 1;
        else if (height == 1)
            return 2;

        return (1 + minNodes(height - 1) + minNodes(height - 2));
    }

}

