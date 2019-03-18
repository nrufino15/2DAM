package com.company.MP09.UF3.A4;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc;
    String nom;

    public Client() {
        sc = new Scanner(System.in);
    }

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte [] receivedData = new byte[1024];
        byte [] sendingData;

        sendingData = getFirstRequest();
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,sendingData.length,serverIP,serverPort);
            socket.send(packet);
            packet = new DatagramPacket(receivedData,1024);
            socket.receive(packet);
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }

    }

    private byte[] getDataToRequest(byte[] data, int length) {
        String rebut = new String(data,0, length);
        //Imprimeix el nom del client + el que es reb del server i demana més dades
        System.out.print(nom+"("+rebut+")"+"> ");
        String msg = sc.nextLine();
        return msg.getBytes();
    }

    private byte[] getFirstRequest() {
        System.out.println("Entra el teu nom: ");
        nom = sc.nextLine();
        return nom.getBytes();
    }

    private boolean mustContinue(byte [] data) {
        String msg = new String(data).toLowerCase();
        if(!msg.equals("adeu")) return true;
        else return false;
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.init("localhost",5555);
            client.runClient();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
