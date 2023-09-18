//1.	Write a Program to find the factorial of a given number using recursion and analyze the time complexity.

public class M_11_R_factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(R_factorial(n));
    }

    static int R_factorial(int n){
        if(n == 0)
            return 1;
        return R_factorial(n - 1) * n;
    }
}