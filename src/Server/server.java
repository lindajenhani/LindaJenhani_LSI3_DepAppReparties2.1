package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            // Création d'un serveur socket écoutant sur le port 1234
            ServerSocket ss = new ServerSocket(1234);
            
            // Attente d'une connexion cliente
            Socket clientSocket = ss.accept();
            
            // Récupération des flux d'entrée et de sortie de la connexion cliente
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            
            // Création de lecteurs pour faciliter la communication
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);
            
            // Lecture des nombres et de l'opérateur envoyés par le client
            int nb1 = Integer.parseInt(br.readLine());
            int nb2 = Integer.parseInt(br.readLine());
            String op = br.readLine();
            
            int res = 0;
            // Calcul en fonction de l'opérateur
            switch (op) {
                case "+":
                    res = nb1 + nb2;
                    break;
                case "-":
                    res = nb1 - nb2;
                    break;
                case "*":
                    res = nb1 * nb2;
                    break;
                case "/":
                    res = nb1 / nb2;
                    break;
            }
            
            // Envoi du résultat au client
            PrintWriter pw = new PrintWriter(output, true);
            pw.println(res);
        } catch (IOException e) {
            // Gestion des exceptions en cas d'erreur
            System.out.println(e.getMessage());
        }
    }
}

