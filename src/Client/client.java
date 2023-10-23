package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class client {
    public static void main(String[] args) {
        try {
            
            // Création d'une socket cliente
            Socket client = new Socket("localhost",1234);
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

