package ru.gb.lvl2hm6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoClient(){
        start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                String str = scanner.nextLine();
                out.writeUTF(str);
                if ("/end".equalsIgnoreCase(str)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new EchoClient();
    }

    private void start() {
        try {
            socket = new Socket("localhost",8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() ->{
                try {
                    while (true) {
                        final String message = in.readUTF();
                        if ("/end".equalsIgnoreCase(message)) {
                            System.out.println("Завершаем соединение...");
                            closeConnection();
                            break;
                        }
                        System.out.println("Сервер отправил " + message);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void closeConnection(){
        if (in !=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out !=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket !=null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
