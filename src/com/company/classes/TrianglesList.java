package com.company.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrianglesList implements Serializable {
    private final ArrayList<Triangle> triangles;

    public TrianglesList() {
        triangles = new ArrayList<>();
    }

    public ArrayList<Triangle> getList() {
        return triangles;
    }

    @Override
    public String toString() {
        return "Triangles " + triangles;
    }

    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    public void remove(int number) {
        if (number < triangles.size() && number >= 0)
            triangles.remove(number);
    }

    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    public double getAverageSquare() {
        double area = 0;
        for (Triangle triangle : triangles) {
            area += triangle.getSquare();
        }
        return area / triangles.size();
    }

}

