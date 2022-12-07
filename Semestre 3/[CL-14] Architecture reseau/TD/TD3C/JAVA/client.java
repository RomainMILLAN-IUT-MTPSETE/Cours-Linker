import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        InetAddress inetAddress= InetAddress.getByName("127.0.0.1");
        SocketAddress socketAddress=new InetSocketAddress(inetAddress, 1234);

        socket.bind(socketAddress);
        socket.connect(socketAddress);
        System.out.println("Inet address: "+socket.getInetAddress());
        System.out.println("Port number: "+socket.getLocalPort());


        socket.getOutputStream().write(new Byte[8]);
    }
}
