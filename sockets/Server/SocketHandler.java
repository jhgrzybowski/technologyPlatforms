package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Message.Message;

public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) { this.socket = socket; }

    @Override
    public void run(){
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())){

            outputStream.writeObject("ready");
            int n = (Integer) inputStream.readObject();
            outputStream.writeObject("ready for messages");

            for(int i = 0; i < n; i++){
                Message message = (Message) inputStream.readObject();
                System.out.println(message);
            }

            outputStream.writeObject("finished");

        } catch (IOException except){
            except.printStackTrace();
        } catch(ClassNotFoundException except) {
            except.printStackTrace();
        } finally {
            try {
                if(!socket.isClosed()) socket.close();
            } catch (IOException except){
                except.printStackTrace();
            }
        }
    }
}
