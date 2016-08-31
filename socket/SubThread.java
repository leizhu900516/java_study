package socket.test;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/31.
 */
public class SubThread extends Thread{
    private Socket client;
    public SubThread(Socket client){
        this.client=client;
        this.start();
    }
    //实现跟客户端的信息交互
    public void run() {
        try {
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = br.readLine();
            System.out.println("接收的信息是：" + info);
            OutputStream message = client.getOutputStream();
            PrintStream ps = new PrintStream(message);
            ps.println("接收到消息，回送信息");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new String();
    }
}
