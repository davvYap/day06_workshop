package sg.edu.nus.iss.app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    public static void main(String[] args) throws IOException{
        int port = 3001;
        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        String cookieFile = args[1];
        ExecutorService threadpool = Executors.newFixedThreadPool(2); // can support 2 client request simultaneously 
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port %s..."+port);
        while(true){
            Socket socket = server.accept();
            CookieClientHandler cch = new CookieClientHandler(socket, cookieFile);
            threadpool.submit(cch);
        }

    }
}
