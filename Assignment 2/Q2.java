class NumberPrinter{
private int num=1;
private final int limit;

NumberPrinter(int limit){
this.limit=limit;
}
public synchronized void printOdd(){
while(num<limit){
        while(num%2==0){
                try{
                        wait();
                }
                catch(InterruptedException e){
                        e.printStackTrace();
                }
        }
        System.out.print(num+" ");
        num++;
        notify();
}
}

public synchronized void printEven(){
while(num<limit){
        while(num%2==1){
                try{
                        wait();
                }
                catch(InterruptedException e){
                        e.printStackTrace();
                }
                }

        }
        System.out.print(num+" ");
        num++;
        notify();
}
}
}

class OddThread implements Runnable{
private NumberPrinter p;
OddThread(NumberPrinter pri){
p=pri;
}

public void run(){
p.printOdd();
}
}

class EvenThread implements Runnable{
private NumberPrinter p;
EvenThread(NumberPrinter pri){
p=pri;
}

public void run(){
p.printEven();
}
}


       
public class Q2 extends Thread{
public static void main(String[]args) throws Exception{

int limit=8;
NumberPrinter p=new NumberPrinter(limit);

Thread oddthread=new Thread(new OddThread(p));
Thread eventhread=new Thread(new EvenThread(p));

oddthread.start();
eventhread.start();
}
}

