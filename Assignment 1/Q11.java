class Date{
    int day=1;
    int month=1;
    int year=1970;
    Date(){
    }
    Date(int d){
        day=d;
    }
    Date(int d, int m){
        day=d;
        month=m;
    }
    Date(int d, int m, int y){
        day=d;
        month=m;
        year=y;
    }

    Date prev_day(){
        Date obj=new Date();
        if(day==1){
            if(month==3){
                if((year%400==0)||(year%100!=0 && year%4==0)){
                    obj.day=29;
                    obj.month=2;
                    obj.year=year;
                }else{
                    obj.day=28;
                    obj.month=2;
                    obj.year=year;
                }
            }
            else if(month==1){
                obj.day=31;
                obj.month=12;
                obj.year=year-1;
            }
            else if((month==4) || (month==6) || (month==8) || (month==9) || (month==11)){
                obj.day=31;
                obj.month=month-1;
                obj.year=year;
            }else{
                obj.day=30;
                obj.month=month-1;
                obj.year=year;
            }
        }else{
            obj.day=day-1;
            obj.month=month;
            obj.year=year;
        }
        return obj;
    }

    Date next_day(){
        Date obj=new Date();
        if(month==12){
            if(day==31){
                obj.day=1;
                obj.month=1;
                obj.year=year+1;
            }else {
                obj.day = day + 1;
                obj.month = month;
                obj.year = year;
            }
        }
        if(month==2){
            if(day==28){
                if((year%400==0)||(year%100!=0 && year%4==0)){
                    obj.day=day+1;
                    obj.month=month;
                    obj.year=year;
                }else{
                    obj.day=1;
                    obj.month=month+1;
                    obj.year=year;
                }
            }
            else if(((year%400==0)||(year%100!=0 && year%4==0))&& day==29){
                obj.day=1;
                obj.month=month+1;
                obj.year=year;
            }else{
                obj.day=day+1;
                obj.month=month;
                obj.year=year;
            }
        }
        else if((month==3) || (month==5) || (month==7) || (month==8) || (month==10) ||(month==1)){
            if(day==31){
                obj.day=1;
                obj.month=month+1;
                obj.year=year;
            }else{
                obj.day=day+1;
                obj.month=month;
                obj.year=year;
            }
        }
        else{
            if(day==30){
                obj.day=1;
                obj.year=year;
                obj.month=month+1;
            }
            else{
                obj.day=day+1;
                obj.month=month;
                obj.year=year;
            }
        }
        return obj;
    }

    void print_date(){
        System.out.println(day+"-"+month+"-"+year);
    }
}


public class Q11 {
    public static void main(String[] args) {
        Date d1= new Date(1,1,2025);
        System.out.print("Current date : ");
        d1.print_date();
        System.out.print("Previous date : ");
        d1.prev_day().print_date();
        System.out.print("Next date: ");
        d1.next_day().print_date();
    }
}
