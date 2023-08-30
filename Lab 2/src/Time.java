public class Time {
    //instance variables
    private int hours;
    private int minutes;
    private int seconds;

    //default constructor
    public Time() {
        this.hours = 24;
        this.minutes = 0;
        this.seconds = 0;
    }

    //non default constructor
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    //increment method
    int mins = 0;
    int remaining_mins = 0;
    int secs = 0;
    public void increment(int s) {
        mins = s / 60;
        remaining_mins = mins - 60;
        if (hours < 24) {
            int num = s;
            int counter = 0;
            while(num > 0){
                num --;
                if(num % 60 == 0){
                    counter +=1;
                }
            }
            minutes += counter;
            while(minutes > 0){
                minutes--;
                if(minutes % 60 == 0 && minutes != 0){
                    hours+=1;
                }
            }
        } else if (hours >= 24) {
            if (mins >= 60) {
                hours = 1;
                int num = s;
                int counter = 0;
                while(num > 0){
                    num --;
                }
                minutes += counter;
                if(counter%1!=0){
                    secs = 30;
                }
                while(minutes > 0){
                    minutes --;
                    if(minutes % 60 == 0 && minutes !=0){
                        hours +=1;
                    }
                }
            }
        }

    }
    //method to convert military to regular time
    public String militaryToAmPm() {
        String am_hours = "AM";
        String pm_hours = "PM";
        String timeofday = "";
        if (hours > 12) {
            hours = (hours - 12);
            timeofday = pm_hours;
        } else if (hours == 12) {
            hours = 12;
            timeofday = pm_hours;
        } else if (hours > 0) {
            hours= hours;
            timeofday = am_hours;
        } else {
            hours = 12;
            timeofday = am_hours;
        }
        return hours + ":" + "0" + minutes + ":" + seconds + "0 " + timeofday;
    }


    //print method
    public void print(boolean military) {
        if (military == true) {
             System.out.println(hours + ":" + "0" + minutes + ":" + secs + "0");

        } else {
            System.out.println(militaryToAmPm());
        }

    }
}


