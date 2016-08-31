package socket.test;

import sun.java2d.loops.GraphicsPrimitive;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.TrustAnchor;

/**
 * Created by Administrator on 2016/8/31.
 */
public class Server implements Runnable{
    private ServerSocket serverSocket;
    public Server(){
            try {
                serverSocket = new ServerSocket(1056);
                System.out.println("服务端开启");
                Thread tdListen = new Thread(this);
                tdListen.start();

//                InputStream is = clent.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//                String info = br.readLine();
//                System.out.println("接收的信息是："+info);
//                OutputStream message = clent.getOutputStream();
//                PrintStream ps = new PrintStream(message);
//                ps.println("接收到消息，回送信息");
            }catch (Exception e){
                e.printStackTrace();
            }


    }
    public void run(){
        while (true) {
            try {
                Socket clent = serverSocket.accept();
                System.out.println("有机器上线" + clent.getLocalAddress().getHostAddress());
                SubThread sth = new SubThread(clent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
  }
    public static void main(String[] args){

        new Server();
    }
}
