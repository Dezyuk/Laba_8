package com.company.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class DatabaseJSONE {

    public static void serializeTriangleJSON (TrianglesList trianglesList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DatabaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() +"1.json"), trianglesList);
    }

    public static void serializeRightTriangleJSON (RightTriangleList rightTriangleList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DatabaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() +"0.json"), rightTriangleList);
    }

    public static TrianglesList deserializeTriangleJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-1], TrianglesList.class);
    }

    public static RightTriangleList deserializeRightTriangleJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-2], RightTriangleList.class);
    }

}
