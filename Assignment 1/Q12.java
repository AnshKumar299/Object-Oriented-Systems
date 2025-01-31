import java.util.*;

class Student{
    int roll;
    String name;
    String[] subs=new String[5];
    Student(int r, String n){
        this.name=n;
        this.roll=r;
    }
    void setsubjs(String [] sub){
        for(int i=0;i<5;i++){
            subs[i]=sub[i];
        }
    }

    int getRoll(){
        return roll;
    }
    String getName(){
        return name;
    }
    String[] getSubs(){
        return subs;
    }
}
class Tabulation_Sheet{
    String name;
    HashMap<Integer, Integer> marks= new HashMap<>();
    void add(int roll, int m){
        marks.put(roll,m);
    }
}

class Marksheet{
    String name;
    int roll;
    HashMap<String,Integer> marks= new HashMap<>();
    Marksheet(Student s, Tabulation_Sheet m1, Tabulation_Sheet m2, Tabulation_Sheet m3, Tabulation_Sheet m4, Tabulation_Sheet m5) {
        this.name = s.name;
        this.roll = s.roll;
        marks.put(s.subs[0], m1.marks.getOrDefault(roll, 0));  // Default 0 if roll not found
        marks.put(s.subs[1], m2.marks.getOrDefault(roll, 0));
        marks.put(s.subs[2], m3.marks.getOrDefault(roll, 0));
        marks.put(s.subs[3], m4.marks.getOrDefault(roll, 0));
        marks.put(s.subs[4], m5.marks.getOrDefault(roll, 0));
    }


    void setName(String s){
        name=s;
    }

    void setMarks(){
        Scanner in=new Scanner(System.in);
        Set<String> keys=marks.keySet();
        marks.clear();
        for(String key:keys){
            System.out.println("Enter marks for "+key);
            int m=in.nextInt();
            marks.put(key,m);
        }
    }

    void display(){
        System.out.println("Name = "+name);
        System.out.println("Roll Number = "+roll);
        Set<String> keys=marks.keySet();
        for(String key: keys){
            System.out.println("Marks for "+key+" = "+marks.get(key));
        }
    }
}
public class Q12 {
    public static void main(String[] args) {
        Student Kaustav = new Student(17,"Kaustav");
        Student Ansh =new Student(73,"Ansh");
        Student Rishi =new Student(55, "Rishi");
        String[] subjects={"OOS","CN","Maths","GGM","SE"};
        Kaustav.setsubjs(subjects);
        Ansh.setsubjs(subjects);
        Rishi.setsubjs(subjects);

        Tabulation_Sheet OOS=new Tabulation_Sheet();
        OOS.add(17,70);
        OOS.add(73,99);
        OOS.add(55,89);

        Tabulation_Sheet CN =new Tabulation_Sheet();
        CN.add(17,90);
        CN.add(73,50);
        CN.add(55,80);

        Tabulation_Sheet Maths= new Tabulation_Sheet();
        Maths.add(17,80);
        Maths.add(73,70);
        Maths.add(55,100);

        Tabulation_Sheet GGM= new Tabulation_Sheet();
        GGM.add(17,80);
        GGM.add(73,80);
        GGM.add(55,80);

        Tabulation_Sheet SE=new Tabulation_Sheet();
        SE.add(17,90);
        SE.add(73,90);
        SE.add(55,75);

        Marksheet Kaustav_Marksheet= new Marksheet(Kaustav,OOS,CN,Maths,GGM,SE);
        Marksheet Ansh_Marksheet= new Marksheet(Ansh,OOS,CN,Maths,GGM,SE);
        Marksheet Rishi_Marksheet= new Marksheet(Rishi,OOS,CN,Maths,GGM,SE);

        Kaustav_Marksheet.display();
        Ansh_Marksheet.display();
        Rishi_Marksheet.display();
    }
}
