package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    AdapterFileOutputStream (FileOutputStream fileOutputStream)
    {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] list = s.getBytes();
    fileOutputStream.write(list);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

