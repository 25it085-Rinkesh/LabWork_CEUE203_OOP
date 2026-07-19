import java.util.Scanner;

public class ParkingLot {

    private int twoWheelers, fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    void park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked.");
            } else {
                System.out.println("Two-wheeler parking is full.");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked.");
            } else {
                System.out.println("Four-wheeler parking is full.");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    void leave(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left.");
            } else {
                System.out.println("No two-wheelers parked.");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left.");
            } else {
                System.out.println("No four-wheelers parked.");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    long Revenue() {
        return revenue;
    }

    void display() {
        System.out.println("\n----- Parking Status -----");
        System.out.println("Two Wheelers : " + twoWheelers + "/" + twoCap);
        System.out.println("Four Wheelers: " + fourWheelers + "/" + fourCap);
        System.out.println("Revenue      : ₹" + Revenue());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Two-Wheeler Capacity: ");
        int twoCap = sc.nextInt();

        System.out.print("Enter Four-Wheeler Capacity: ");
        int fourCap = sc.nextInt();

        ParkingLot p = new ParkingLot(twoCap, fourCap);

        int choice;

        do {
            System.out.println("\n===== Parking Lot Menu =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle type (two/four): ");
                    String parkType = sc.next();
                    p.park(parkType);
                    break;

                case 2:
                    System.out.print("Enter vehicle type (two/four): ");
                    String leaveType = sc.next();
                    p.leave(leaveType);
                    break;

                case 3:
                    p.display();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}