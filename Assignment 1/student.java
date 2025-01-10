public class student {
    String name;
    int marks1,marks2,marks3;
    void setName(String s){
        name=s;
    }

    void setMarks(int m1,int m2,int m3){
        marks1=m1;
        marks2=m2;
        marks3=m3;
    }

    float average(){
        return (float) ((marks3+marks2+marks1)/3.0);
    }

    void disp(){
        System.out.println("Name = "+name);
        System.out.println("Total marks = "+(int)(marks1+marks3+marks2));
    }

    public static void main(String[] args) {
        String name="Danish";
        int a=60,b=86,c=47;
        student ob=new student();
        ob.setName(name);
        ob.setMarks(a,b,c);
        System.out.println("Display:  ");
        ob.disp();
        System.out.println("Average marks = "+ob.average());
    }
}
