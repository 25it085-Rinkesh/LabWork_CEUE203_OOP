import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;
        int total = 0;
        String type;

        while(true){
            System.out.print("Enter vehicle number (or done): ");
            String number = sc.next();

            if ("done".equalsIgnoreCase(number)) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            type = sc.next();

            Vehicle vehicle = new Vehicle(number, type);
            total += switch (vehicle.type()){
                case "bike"-> {
                    bikeCount++;
                    yield 20;
                }
                case "car"-> {
                    carCount++;
                    yield 50;
                }

                case "truck"-> {
                    truckCount++;
                    yield 150;
                }

                default -> {
                    System.out.println("Invalid vehicle type");
                    yield 0;
                }
            };
        }

        System.out.println("Total toll: " + total);
        if(bikeCount >= carCount && bikeCount >= truckCount)
            System.out.println("Mot frequent: Bike" );
        else if(carCount >= bikeCount && carCount >= truckCount)
            System.out.println("Most frequnt: Car");
        else
            System.out.println("Most frequnt: Truck");
    }
}
