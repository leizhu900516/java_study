package socket.test;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/31.
 */
public class Client{
    public Socket clentSocket;
    public Client(){
        while (true) {
            try {
                clentSocket = new Socket("127.0.0.1", 1056);
                System.out.println("连接上服务端");
                //客户端发送信息到服务端
                System.out.println("请输入要发送服务端的信息：");
                BufferedReader sendServerMessage = new BufferedReader(new InputStreamReader(System.in));
                String SendMessages = sendServerMessage.readLine();
                OutputStream message = clentSocket.getOutputStream();
                PrintStream ps = new PrintStream(message);
                ps.println(SendMessages);
                //客户端接收服务端发送的信息
                InputStream is = clentSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String info = br.readLine();
                System.out.println("接收的回送信息是：" + info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        new Client();
    }
}
