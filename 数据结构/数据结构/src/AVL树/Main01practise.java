package AVL树;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yolo
 * @date 2020/3/26-18:42
 */
public class Main01practise {
    public static void main(String[] args) {
        Random random=new Random(20200326);
        int[]arr=new int[25];
        for (int i = 0; i < 25; i++) {
            arr[i]=random.nextInt(200);
        }
        System.out.println(Arrays.toString(arr));
    }
}
