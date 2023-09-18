import java.util.Scanner;

//3.	Write a Program to illustrate the difference between recursion and iteration by giving its time complexities
public class M_13_Fibo_iter_rec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibo_iter(5)); // time complexity = (O(n) = n)
        System.out.println(fibo_rec(5)); // time complexity  = (O(n) = (1 + sqrt(5))/2)^n

    }

    static int fibo_iter(int n)
    {
        int sum = 1;int m;
        int a = 0;
        int b = 1;
        for(int i = 2; i < n;i++)
        {
            m = a + b + i;
            sum += m;
        }
        return sum;
    }

    static int fibo_rec(int n)
    {
        return fibo_rec(n - 1) + fibo_rec(n - 2);
    }
}
