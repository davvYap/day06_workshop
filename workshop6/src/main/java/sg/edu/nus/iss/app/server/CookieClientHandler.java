package sg.edu.nus.iss.app.server;

import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable{
    private Socket socket;
    private String cookieFile;

    public CookieClientHandler(Socket socket, String cookieFile){
        this.socket = socket;
        this.cookieFile = cookieFile;
    }
    
    @Override
    public void run(){
        NetworkIO netIO = null;
        String request = "";
        String randomCookie = "";
        try{
            netIO = new NetworkIO(socket);  // the inputstream is with NetWorkIO Object, thus only it can read/write from/to clientApp which connected to the socket
            while(true){
                request = netIO.read();     // readUTF from ClientApp
                if(request.trim().equals("end")){
                    netIO.write("End response from client server.");    // writeUTF to ClientApp
                    break;
                }else if(request.trim().equals("get-cookie")){
                    randomCookie = Cookie.getRandomCookie(this.cookieFile);
                    netIO.write("cookie-text_"+randomCookie);
                    break;
                }else{
                    netIO.write("ERROR! Invalid command");
                }
            }
            netIO.close();
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
