import java.util.*;

class Person {
    private int age;
    private int weight;
    private int height;
    private String address;
    private String dateOfBirth;

    Person(int age, int weight, int height, String address, String dateOfBirth) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    int getage() {
        return age;
    }

    int weight() {
        return weight;
    }

    int height() {
        return height;
    }

    String add() {
        return address;
    }

    String DOB() {
        return dateOfBirth;
    }

    void setage(int s) {
        age = s;
    }

    void setweight(int s) {
        weight = s;
    }

    void setheight(int s) {
        height = s;
    }

    void setaddress(String s) {
        address = s;
    }

    void printDetails() {
        System.out.println("Age = " + getage());
        System.out.println("Weight = " + weight());
        System.out.println("Height = " + height());
        System.out.println("Address = " + add());
        System.out.println("Date of birth = " + DOB());
    }
}

class Employee extends Person {
    private int salary;
    private String dateOfJoining;
    private int experience;

    Employee(int age, int weight, int height, String address, String dateOfBirth, int salary, String dateOfJoining,
            int experience) {
        super(age, weight, height, address, dateOfBirth);
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
    }

    int getsal() {
        return salary;
    }

    String getjoiningDate() {
        return dateOfJoining;
    }

    int getexp() {
        return experience;
    }

    void setsal(int s) {
        salary = s;
    }

    void setexp(int s) {
        experience = s;
    }

    void printDetails() {
        super.printDetails();
        System.out.println("Salary = " + getsal());
        System.out.println("Date of Joining = " + getjoiningDate());
        System.out.println("Experience = " + getexp());
    }
}

class Student extends Person {
    private int roll;
    private int no_of_subjects;
    private String[] listofsubjects;
    private int[] marks;

    Student(int age, int weight, int height, String address, String dateOfBirth, int roll, int no_of_subjects,
            String[] listofsubjects, int[] marks) {
        super(age, weight, height, address, dateOfBirth);
        this.roll = roll;
        this.no_of_subjects = no_of_subjects;
        this.listofsubjects = listofsubjects;
        this.marks = marks;
    }

    char calculateGrade() {
        int total = 0;
        for (int i = 0; i < no_of_subjects; i++) {
            total += marks[i];
        }
        int avg = total / no_of_subjects;

        if (avg > 90) {
            return 'A';
        }
        if (avg > 80) {
            return 'B';
        }
        if (avg > 70) {
            return 'C';
        }
        if (avg > 60) {
            return 'D';
        }
        if (avg > 50) {
            return 'F';
        } else {
            return 'F';
        }
    }

    void printDetails() {
        System.out.println("Student -----------------------------");
        super.printDetails();
        System.out.println("Roll = " + roll);
        System.out.println("Subjects : Marks ----");
        for (int i = 0; i < no_of_subjects; i++) {
            System.out.println(listofsubjects[i] + " : " + marks[i]);
        }
        System.out.println("Grade: " + calculateGrade());
        System.out.println();
    }
}

class Technician extends Employee {
    Technician(int age, int weight, int height, String address, String dateOfBirth, int salary, String dateOfJoining,
            int experience) {
        super(age, weight, height, address, dateOfBirth, salary, dateOfJoining, experience);
    }

    void printDetails() {
        System.out.println("Technician -----------------------------");
        super.printDetails();
    }
}

class Professor extends Employee {
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<String> listOfAdvisee = new ArrayList<String>();

    Professor(int age, int weight, int height, String address, String dateOfBirth, int salary, String dateOfJoining,
            int experience, String[] courses, String[] advisees) {
        super(age, weight, height, address, dateOfBirth, salary, dateOfJoining, experience);

        for (int i = 0; i < courses.length; i++) {
            this.courses.add(courses[i]);
        }

        for (int i = 0; i < advisees.length; i++) {
            listOfAdvisee.add(advisees[i]);
        }
    }

    void addcourse(String s) {
        courses.add(s);
    }

    void addadvisee(String s) {
        listOfAdvisee.add(s);
    }

    void removecourse(String s) {
        courses.remove(s);
    }

    void removeadvisee(String s) {
        listOfAdvisee.remove(s);
    }

    void printDetails() {
        System.out.println("Professor -------------------------------------");
        super.printDetails();
        System.out.println("Courses: --");
        for (String i : courses) {
            System.out.println(i);
        }
        System.out.println("Advisees: --");
        for (String i : listOfAdvisee) {
            System.out.println(i);
        }
    }
}

public class Q9 {
    public static void main(String[] args) {
        Person p = new Person(16, 55, 144, "Kolkata", "12-01-2009");
        Employee e = new Employee(25, 80, 182, "Delhi", "01-01-2000", 90000, "12-09-2020", 5);
        String[] sub = { "Maths", "Physics", "Chemistry", "English" };
        int m[] = { 78, 85, 45, 98 };
        Student s = new Student(12, 50, 154, "Howrah", "02-08-2012", 1254, 4, sub, m);
        Technician t = new Technician(30, 76, 180, "Noida", "15-25-1995", 75000, "12-10-2015", 10);
        String[] cs = { "Computer Science", "Data Analytics", "Machine Learning" };
        String[] adv = { "Ramit", "Sneha", "Rashoshree" };
        Professor prof = new Professor(36, 65, 176, "Guwahati", "02-06-1989", 120000, "02-07-2012", 12, cs, adv);

        System.out.println("Person --------------------------");
        p.printDetails();
        System.out.println();

        System.out.println("Employee -----------------------------");
        e.printDetails();
        System.out.println();
        s.printDetails();
        System.out.println();
        t.printDetails();
        System.out.println();

        prof.addcourse("Deep Learning");
        prof.removeadvisee("Rashoshree");
        prof.addadvisee("Sushar");
        prof.printDetails();
    }

}
