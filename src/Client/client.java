package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class client {
    public static void main(String[] args) {
        try {
            // Récupération de l'adresse IP du serveur
            InetAddress IA = InetAddress.getByName("192.168.147.20");
            
            // Création d'une adresse socket avec l'adresse IP et le port 1234
            InetSocketAddress ISA = new InetSocketAddress(IA, 1234);
            
            // Création d'une socket cliente
            Socket client = new Socket();
            
            // Connexion au serveur en utilisant l'adresse socket
            client.connect(ISA);
            
            // Récupération des flux d'entrée et de sortie de la socket
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            
            // Création de lecteurs pour faciliter la communication
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);
            Scanner scanner = new Scanner(System.in);
            
            // Saisie des nombres et de l'opérateur
            System.out.println("donner nb1 = ");
            String nb1 = scanner.nextLine();
            System.out.println("donner nb2 = ");
            String nb2 = scanner.nextLine();
            String op;
            do {
                System.out.println("donner op = ");
                op = scanner.nextLine();
            } while (!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*")) && !(op.equals("/")));
            
            // Envoi des données au serveur
            PrintWriter pw = new PrintWriter(output, true);
            pw.println(nb1);
            pw.println(nb2);
            pw.println(op);
            
            // Réception et affichage du résultat du serveur
            System.out.println(br.readLine());
        } catch (Exception e) {
            // Gestion des exceptions en cas d'erreur
            System.out.println(e.getMessage());
        }
    }
}

