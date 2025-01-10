import java.util.Scanner;
class Room {
    int height,width,breadth;
    Room(int a,int b, int c){
        height=a;
        width=b;
        breadth=c;
    }

    int volume(){
        return (height*breadth*width);
    }
}

public class RoomDemo{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter height, breadth and width");
        int h=in.nextInt();
        int b=in.nextInt();
        int w=in.nextInt();
        Room r=new Room(h,b,w);
        System.out.println("Volume of room is: "+r.volume());
    }
}
