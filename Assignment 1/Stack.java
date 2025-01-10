public class Stack {
    int[] stack;
    int size;
    int top=-1;
    Stack(int s){
        size=s;
        stack=new int[size];
    }
    void push(int elem){
        if(top==size-1){
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top]=elem;
    }

    void pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
            return;
        }
        stack[top]=0;
        top--;
    }

    void print(){
        System.out.println("Stack is: ");
        for(int i=top;i>=0;i--){
            System.out.println("| "+stack[i]+" |");
        }
        System.out.println("------");
    }

    public static void main(String[] args) {
        Stack  s=new Stack(30);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(19);
        s.push(5);
        s.print();
        s.pop();
        s.pop();
        s.pop();
        s.print();
    }
}
