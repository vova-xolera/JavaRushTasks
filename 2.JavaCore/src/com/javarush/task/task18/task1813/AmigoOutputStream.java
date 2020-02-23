package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream stream;
    public AmigoOutputStream(FileOutputStream fileStream) throws FileNotFoundException {
        super(fileName);
        this.stream = fileStream;
    }
    public static String fileName = "C:/tmp/result.txt";

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        stream.flush();
        String Str1 = "JavaRush © All rights reserved.";
        byte[] Str2 = Str1.getBytes();
        write(Str2);
        stream.close();
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
