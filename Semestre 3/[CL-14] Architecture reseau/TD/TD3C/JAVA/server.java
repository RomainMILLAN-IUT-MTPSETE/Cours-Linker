import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class server{
    public static void main(String[] args) throws IOException {
        ServerSocket sockserv = null; //Crée une nouvelle variable ServerSocket a null
        DataInputStream in;
        DataOutputStream out;
        byte mess[]; // Stocker le message

        try {
            sockserv = new ServerSocket(1234); //Instancie un nouveau socket avec le port '1234'

            while(true){//Boucle infinie
                Socket sockcli = sockserv.accept(); //Accepte la connexion du socketserveur
                in = new DataInputStream(sockcli.getInputStream()); //Recupere le message in
                out = new DataOutputStream(sockcli.getOutputStream()); //Recup le message out
                mess = new byte[80]; //Nouveau byte
                in.read(mess,0,80); //Lit les datas et le mets dans mess
                out.write(mess); //Ecrit ce qu'il y a dans mess et le mets dans out
                sockcli.close(); //Ferme le socket client
            }
        } finally {
            try {
                sockserv.close(); //Ferme le serveur socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}