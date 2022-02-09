package ru.gb.lvl2hm6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        new EchoServer().start();
    }
    private void start(){
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился...");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true){
                final String message = in.readUTF();
                if ("/end".equalsIgnoreCase(message)){
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Сервер получил от клиента сообщение: " + message);
                new Thread(() ->{
                    Scanner scanner = new Scanner(System.in);
                    try {
                        while (true) {
                            String str = scanner.nextLine();
                            out.writeUTF(str);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (socket != null){
            try {
                socket.close();
                System.out.println("Сервер завершил работу.");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
