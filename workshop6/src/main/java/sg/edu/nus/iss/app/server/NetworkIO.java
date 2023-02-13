package sg.edu.nus.iss.app.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;

    // 
    public NetworkIO(Socket socket) throws IOException{
       is = socket.getInputStream();
       dis = new DataInputStream(is); 
       // DataInputStream disNew = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

       os = socket.getOutputStream();
       dos = new DataOutputStream(os);
       // DataOutputStream dosNew = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public String read() throws IOException{
        return dis.readUTF();   // read data from the client
    }

    public void write(String msg)throws IOException{
        dos.writeUTF(msg);      // write data to the client
        dos.flush();
    }

    public void close() throws IOException{
        dis.close();
        is.close();
        dos.close();
        os.close();
    }
}
