import java.io.*;
import java.net.*;

public class fw {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("欢迎使用ZeAy Java远程控制v1.0");
            System.out.println("https://hz64.github.io/");
            System.out.println("****************************");
            System.out.println("服务端已启动，等待连接...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("cd:" + clientSocket.getInetAddress().getHostAddress());

                // 在这里处理客户端连接的操作
                // 例如，创建一个新的线程来处理客户端的请求

                ZeAy ZeAy = new ZeAy(clientSocket);
                Thread thread = new Thread(ZeAy);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("LOG:" + e.getMessage());
        }
    }
}

class ZeAy implements Runnable {
    private Socket clientSocket;

    public ZeAy(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String command;
            while ((command = in.readLine()) != null) {
                System.out.println("ROOT:" + command);

                // 在这里处理客户端发送的命令
                // 例如，根据命令执行相应的操作，并将结果发送回客户端

                out.println("ROOT:" + command);
            }

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("LOG:" + e.getMessage());
        }
    }
}