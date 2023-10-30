import java.util.Arrays;

//3.	Write a Program to implement stack operations using arrays
public class M_23_stackArr {
    public int[] arr;
    public static int top;

    public M_23_stackArr(int size){
        arr = new int[size];
        top  = -1;
    }
    public void push(int val) {
        if (top == arr.length - 1){
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = val;
    }
    public int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
//            return -1;
        }
        int val = arr[top];
//        arr[top] = arr[top - 1];
        top--;
        arr = Arrays.copyOf(arr,arr.length - 1);
        return val;
    }
    public int top(){
        return top;
    }
    public void display() {
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    public boolean isempty()
    {
        return top == -1;
    }
    public static void main(String[] args) {
        M_23_stackArr l = new M_23_stackArr(5);
        l.push(3);
        l.push(2);
        l.push(5);
        l.push(8);
        l.push(17);
        System.out.println("top : " + top);
        l.display();
//        System.out.println(l.pop());
//        l.display();
//        System.out.println(l.top());
//        System.out.println(l.empty());
//        System.out.println(l.top);
        l.pop();
        l.pop();
        l.pop();
        l.pop();
        l.pop();
        System.out.println(l.top());
        System.out.println(l.isempty());
        l.display();
//        System.out.println(l.empty());
    }
}
