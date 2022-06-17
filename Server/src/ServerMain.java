import Commands.*;
import Org.ProductCollection;
import manager.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class ServerMain {

    public static void main(String[] args) throws SQLException, IOException {
        SQLConnection.ConnectionToDB();
        SQLConnection.get_values();
        System.out.println(ProductCollection.getCollection().toString());


        try (ServerSocket server = new ServerSocket(8765)) {

            System.out.println("Server started");

            while (true) {
                Socket socket = server.accept();
                new Thread(() -> {
                    System.out.println("Создан поток");
                    try (

                            OutputStream out = socket.getOutputStream();
                            DataOutputStream writer = new DataOutputStream(out);

                            InputStream in = socket.getInputStream();
                            DataInputStream reader = new DataInputStream(in);
                    ) {
                        System.out.println("Подключился клиент");
                        Worker worker = new Worker();
                        while (true) {

                            int len = reader.readInt();
                            byte[] data = new byte[len];
                            if (len > 0) {
                                reader.readFully(data);
                            }

                            CommandToSer commandAndArg = (CommandToSer) Serializator.deserialization(data);
                            CommandAndArg.setPassword(commandAndArg.getPassword());
                            CommandAndArg.setUser(commandAndArg.getUser());

                            if (commandAndArg.getCommand().equals("exit")) {
                                writer.write(worker.work("save", commandAndArg.getArg()));
                                writer.flush();
                                writer.close();
                                reader.close();
                                break;
                            } else if (commandAndArg.getCommand().equals("registration") || commandAndArg.getCommand().equals("login")) {
                                byte[] response = worker.work(commandAndArg.getCommand(), commandAndArg.getArg());
                                writer.writeInt(response.length);
                                writer.write(response);
                                writer.flush();
                            } else if (!commandAndArg.getUser().equals("")) {
                                byte[] response = worker.work(commandAndArg.getCommand(), commandAndArg.getArg());
                                writer.writeInt(response.length);
                                writer.write(response);
                                writer.flush();
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        //System.exit(0);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }).start();
            }
        }
    }
}
