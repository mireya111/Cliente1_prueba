package clase;

import javax.swing.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void enviarParanetros(String IP, int puerto, String numero, JLabel resultado1, JLabel resultado2, JLabel resultado3, JLabel resultado4, JLabel resultado5, JLabel resultado6) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            // Aquí iría el código para enviar el número al servidor

            InetAddress inet = InetAddress.getByName(IP);

            // Enviar el número al servidor
            byte[] bufferSalida = numero.getBytes();
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, inet, puerto);
            socket.send(paqueteSalida);

            // Recibir la respuesta del servidor
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(paqueteEntrada);

            String datosRecibidos = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
            String[] partes = datosRecibidos.split(",");
            System.out.println(datosRecibidos);

            if (partes.length == 6) {
                Estudiante estudiante = new Estudiante(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], Integer.parseInt(partes[4]), Boolean.parseBoolean(partes[5]));
                resultado1.setText("ID: " + estudiante.getId());
                resultado2.setText("Nombre: " + estudiante.getNombre());
                resultado3.setText("Telefono: " + estudiante.getTelefono());
                resultado4.setText("Carrera: " + estudiante.getCarrera());
                resultado5.setText("Semestre: " + estudiante.getSemestre());
                resultado6.setText("Gratuidad: " + estudiante.isGratuidad());
            } else {
                resultado1.setText("No se encontró el número de persona");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
