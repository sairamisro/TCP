package com.test1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWriteTextFile {

private static void doReadWriteTextFile() {

try {

// input/output file names
String inputFileName = "\\192.168.10.1\\C:\\Users\\sairam\\Downloads\\Rentreceiptformat.pdf";
String outputFileName = "C:\\Demo\\demo1.java";

// Create FileReader Object
FileReader inputFileReader = new FileReader(inputFileName);
FileWriter outputFileReader = new FileWriter(outputFileName);

// Create Buffered/PrintWriter Objects
BufferedReader inputStream = new BufferedReader(inputFileReader);
PrintWriter outputStream = new PrintWriter(outputFileReader);

// Keep in mind that all of the above statements can be combined
// into the following:
//BufferedReader inputStream = new BufferedReader(new FileReader("README_InputFile.txt"));
//PrintWriter outputStream = new PrintWriter(new FileWriter("ReadWriteTextFile.out"));

outputStream.println("+---------- Testing output to a file ----------+");
outputStream.println();

String inLine = null;

while ((inLine = inputStream.readLine()) != null) {
outputStream.println(inLine);
}

outputStream.println();
outputStream.println("+---------- Testing output to a file ----------+");

outputStream.close();
inputStream.close();

} catch (IOException e) {

System.out.println("IOException:");
e.printStackTrace();

}

}


public static void main(String[] args) {
doReadWriteTextFile();
}

}