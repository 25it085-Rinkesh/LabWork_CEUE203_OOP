public class Thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16, MAX = 30;
    private static int activeCount = 0;

    public Thermostat(){}
    public Thermostat(String location, int startTemp){
        this.location = location;

        if(startTemp <= MAX && startTemp >= MIN)
            this.temperature = startTemp;
        else
            this.temperature = 22;

        activeCount++;
    }
    public Thermostat(String location){
        this(location, 22);
    }

    public void raise(){
        if(temperature < MAX)
            this.temperature++;
        else
            System.out.println("Already at maximum (30)");
    }

    public void lower(){
        if(temperature > MIN)
            this.temperature--;
        else
            System.out.println("Already at minimum (16)");
    }

    public int getTemperature() {
        return temperature;
    }

    public static int getActiveCount(){
        return activeCount;
    }

    public static void main(String[] args) {
        Thermostat T1 = new Thermostat("Living Room", 20);
        Thermostat T2 = new Thermostat("Bedroom");

        System.out.println("Raising temperature of T1:");
        for(int i = 0; i < 10; i++) {
            T1.raise();
            System.out.println("Temperature: " + T1.getTemperature());
        }

        System.out.println("\nLowering temperature of T1:");
        for(int i = 0; i < 20; i++){
            T1.lower();
            System.out.println("Temperature: " + T1.getTemperature());
        }

        System.out.println("\nActive Thermostats: " + Thermostat.getActiveCount());
    }

}
