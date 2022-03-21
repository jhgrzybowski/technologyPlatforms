package Server;

public class Server {
    private static int port = 1500;

    public static void main(String[] args) {
        System.out.println("Started server on port " + port);
        new Thread(new IncomingSocketHandler(port)).start();
    }
}
