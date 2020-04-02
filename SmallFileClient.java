import java.io.*;
import java.net.*;
import java.util.*;


 public class SmallFileClient {

static String file="test.txt";
//static PrintWriter outToServer;
static Socket socket;
public static void main(String[] args) throws IOException
{
    final int PORT=20020;
    String serverHostname = new String("127.0.0.1");

    socket = new Socket(serverHostname, PORT);
    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
    
    BufferedReader br=new BufferedReader(new FileReader(file));
    try
    {
        
        String line = br.readLine();
        while(line!=null)
        {
            //send line to server
            outToServer.writeBytes(line + "\r\n");
            line=br.readLine();
        }

    }catch (Exception e){System.out.println("!!!!");}

    br.close();
    outToServer.flush();
    outToServer.close();
    socket.close();
    
}
}