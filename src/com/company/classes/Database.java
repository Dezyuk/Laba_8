package com.company.classes;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Database {
    public static void serializeTriangle(TrianglesList trianglesList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Database/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".t");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trianglesList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void serializeRightTriangle(RightTriangleList trianglesList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Database/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".rt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trianglesList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static TrianglesList deserializeTriangle() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/Database").listFiles())[Objects.requireNonNull(new File("./src/Database").listFiles()).length-1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TrianglesList trianglesList = (TrianglesList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return trianglesList;
    }
    public static RightTriangleList deserializeRightTriangle() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/Database").listFiles())[Objects.requireNonNull(new File("./src/Database").listFiles()).length-2]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        RightTriangleList trianglesList = (RightTriangleList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return trianglesList;
    }
}
