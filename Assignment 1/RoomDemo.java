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
        int h=14;
        int b=6;
        int w=6;
        Room r=new Room(h,b,w);
        System.out.println("Volume of room is: "+r.volume());
    }
}
