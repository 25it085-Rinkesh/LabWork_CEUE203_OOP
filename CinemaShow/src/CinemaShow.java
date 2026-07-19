import java.util.Scanner;

public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity){
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public CinemaShow(String title){
        this(title, 100);
    }

    public boolean book(int n){
        if(n <= seatsAvailable){
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        else{
            return false;
        }
    }

    public void cancel(int n){
        seatsAvailable += n;

        if(seatsAvailable > capacity )
            seatsAvailable = capacity;
    }

    public int getSeatsAvailable(){
        return seatsAvailable;
    }

    public static int getTotalBooked(){
        return totalBooked;
    }


    public static void main(String[] args) {
        CinemaShow c1 = new CinemaShow("Pritam and Pedro", 200);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter How many bookings: ");
        int n = sc.nextInt();
        boolean booked = c1.book(n);
        if(booked)
            System.out.println("Seat available: " + c1.getSeatsAvailable());
        else {
            System.out.println("Booking failed");
            System.out.println("Leaves Seat unchanged: " + c1.getSeatsAvailable());
        }

        System.out.println("Enter How many bookings cancel: ");
        n = sc.nextInt();
        c1.cancel(n);
        System.out.println("Seat available: " + c1.getSeatsAvailable());

        System.out.println("Successful Booked seats: " + c1.getTotalBooked());

        sc.close();
    }
}
