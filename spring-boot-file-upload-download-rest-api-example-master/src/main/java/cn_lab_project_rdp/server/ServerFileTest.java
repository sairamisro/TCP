package cn_lab_project_rdp.server;
//https://cp-algorithms.blogspot.com/2021/03/create-socket-for-http-for-web-page.html
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ServerFileTest {

	public static void main(String args[]) throws Exception {

		ServerSocket server = null;

		Socket socket;

		server = new ServerSocket(4000);

		System.out.println("Server Waiting for image");

		while (true) {
			try {

				socket = server.accept();
				System.out.println("Client connected.");

				InputStream in = socket.getInputStream();

				DataInputStream dis = new DataInputStream(in);
				
//				while(true) {
//			         char ch;
//			         try {
//			            ch = dis.readChar();
//			            System.out.print(ch);
//			         } catch (EOFException e) {
//			            System.out.println("");
//			            System.out.println("End of file reached");
//			            break;
//			         } catch (IOException e) {
//			         }
//			      }

				
				

				int len = dis.readInt();

				System.out.println("Image Size: " + len / 1024 + "KB");
				byte[] data = new byte[len];

				dis.readFully(data);

				dis.close();

				in.close();

				InputStream ian = new ByteArrayInputStream(data);

				BufferedImage bImage = ImageIO.read(ian);

				JFrame f = new JFrame("Server");

				ImageIcon icon = new ImageIcon(bImage);

				JLabel l = new JLabel();

				l.setIcon(icon);

				f.add(l);

				f.pack();

				f.setVisible(true);

			} catch (SocketTimeoutException st) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}

}