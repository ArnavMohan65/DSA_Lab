import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//2.	Write a Program to find the transpose of a given matrix and display its time complexity

//Method 1

//public static void main(String[] args) {
//        int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//
////        Random r = new Random();
////        for(int i = 0; i < m.length; i++)
////        {
////            for(int j = 0; j < m[0].length; j++)
////            {
//////                m[i][j] = r.nextInt(6);
////            }
////        }
//
//        for(int[] i: m){
//        System.out.println(Arrays.toString(i));
//        }
//        System.out.println();
//        T_Matrix(m);
//        }
//static void T_Matrix(int[][] m)
//        {
//        int[][] ans = new int[m[0].length][m.length];
//        for(int i = 0; i < m.length; i++)
//        {
//        for(int j = 0; j < m[0].length; j++)
//        {
////                System.out.println(m[i][j]);
//        ans[j][i] = m[i][j];
////                System.out.println(ans[j][i]);
//        }
////            System.out.print("\n");
//        }
//
//        for(int[] i: ans)
//        {
//        System.out.println(Arrays.toString(i));
//        }
//        }

public class M_12_T_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] m = new int[3][4];

        Random r = new Random();
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m[0].length; j++)
            {
                m[i][j] = r.nextInt(6);
            }
        }

        for(int[] i: m){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        T_Matrix(m);
    }
    static void T_Matrix(int[][] m)
    {
        int[][] ans = new int[m[0].length][m.length];
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m[0].length; j++)
            {
//                System.out.println(m[i][j]);
                ans[j][i] = m[i][j];
//                System.out.println(ans[j][i]);
            }
//            System.out.print("\n");
        }

        for(int[] i: ans)
        {
            System.out.println(Arrays.toString(i));
        }
    }
}