package com.javarush.task.task18.task1812;

import java.io.*;
import java.sql.SQLOutput;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream question;
    public QuestionFileOutputStream (AmigoOutputStream amigoOutputStream) {
        this.question = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        question.flush();
    }

    @Override
    public void write(int b) throws IOException {
        question.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        question.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        question.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String line = scan.readLine();
        if (line.equals("Д")) question.close();
    }
}

