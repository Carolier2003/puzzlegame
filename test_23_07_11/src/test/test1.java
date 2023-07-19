package test;

import java.util.Random;

/**
 * {@code @Author} 19667
 * {@code @create} 2023/7/13 10:28
 */
public class test1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] data = new int[4][4];
        //初始化一维顺序数组
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱一维数组
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i]= arr[index];
            arr[index]= temp;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        //将一维数组添加到二维数组data中
        for (int i = 0; i < arr.length; i++) {
            data[i/4][i%4] = arr[i];
        }
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
