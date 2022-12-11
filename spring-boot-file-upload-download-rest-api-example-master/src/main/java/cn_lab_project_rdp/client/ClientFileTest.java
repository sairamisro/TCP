package cn_lab_project_rdp.client;
//https://cp-algorithms.blogspot.com/2021/03/create-socket-for-http-for-web-page.html
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ClientFileTest {

	public static void main(String args[]) throws Exception {
		Socket soc;

		BufferedImage img = null;

		soc = new Socket("localhost", 4000);

		System.out.println("Client is running. ");

		try {

			System.out.println("Reading image from disk. ");

			img = ImageIO.read(new File("C:\\Users\\sai ram\\Pictures\\Screenshot 2022-10-11 082428.png"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			ImageIO.write(img, "png", baos);

			baos.flush();

			byte[] bytes = baos.toByteArray();
			baos.close();

			System.out.println("Sending image to server. ");

			OutputStream out = soc.getOutputStream();

			DataOutputStream dos = new DataOutputStream(out);

			dos.writeInt(bytes.length);

			dos.write(bytes, 0, bytes.length);

			System.out.println("Image sent to server. ");

			dos.close();

			out.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			soc.close();

		}

		soc.close();

	}

}