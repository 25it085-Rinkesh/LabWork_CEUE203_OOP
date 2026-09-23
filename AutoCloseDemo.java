class FileResource implements AutoCloseable {

    public FileResource() {
        System.out.println("Resource opened.");
    }

    public void read() throws Exception {
        System.out.println("Reading resource...");

        // Simulate an error
        throw new Exception("Error while reading resource.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (FileResource resource = new FileResource()) {

            resource.read();

        } catch (Exception e) {

            System.out.println(
                    "Original error: " + e.getMessage()
            );
        }

        System.out.println("Program completed.");
    }
}
