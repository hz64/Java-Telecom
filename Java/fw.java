import java.io.*;
import java.net.*;

public class fw {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("��ӭʹ��ZeAy JavaԶ�̿���v1.0");
            System.out.println("https://hz64.github.io/");
            System.out.println("****************************");
            System.out.println("��������������ȴ�����...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("cd:" + clientSocket.getInetAddress().getHostAddress());

                // �����ﴦ��ͻ������ӵĲ���
                // ���磬����һ���µ��߳�������ͻ��˵�����

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

                // �����ﴦ��ͻ��˷��͵�����
                // ���磬��������ִ����Ӧ�Ĳ���������������ͻؿͻ���

                out.println("ROOT:" + command);
            }

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("LOG:" + e.getMessage());
        }
    }
}