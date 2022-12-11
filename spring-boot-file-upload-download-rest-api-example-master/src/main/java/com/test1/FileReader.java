package com.test1;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;

public class FileReader {

	public static void main(String[] args) {
		System.out.println("********FileReader Start**********");
		
		
		try
		{
			URI uri = new URI("ftp://localhost/Downloads/Rentreceiptformat.pdf");
		    File midiFile = new File(uri);
		    System.out.println(midiFile.exists());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		System.out.println("********FileReader End**********");

	}

}

/*
 * 
 
 File f = new File("//192.168.126.1/Downloads");
		System.out.println("connecting...");

		File[] files = f.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        // Specify the extentions of files to be included.
		        return name.endsWith(".bmp") || name.endsWith(".gif");
		    }
		});

		// get names of the files
		String[] fileNamesArray = null; 
		for (int indx = 0; indx < files.length; indx++) {
		    fileNamesArray[indx] = files[indx].getName();
		}
 
 * */
