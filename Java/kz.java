import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class kz {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("��ӭʹ��ZeAy JavaԶ�̿���v1.0");
            System.out.println("https://hz64.github.io/");
            System.out.println("****************************");
            System.out.println("�����ӵ������");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String command;
            while (true) {
                System.out.print("| ");
                command = userInput.readLine();

                if (command.equals("exit")) {
                    break;
                }

                out.println(command);

                String output = in.readLine();
                if (output == null) {
                    System.out.println("�����˵������ѶϿ�");
                    break;
                }

                System.out.println("=" + output);
            }

            userInput.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}