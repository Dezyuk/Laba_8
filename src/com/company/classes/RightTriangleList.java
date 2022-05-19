package com.company.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RightTriangleList implements Serializable {
    private final List<RightTriangle> triangles;

    public RightTriangleList() {
        triangles = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Triangles " + triangles;
    }

    public void add(RightTriangle triangle) {triangles.add(triangle);
    }

    public void remove(int number) {
        if (number < triangles.size() && number >= 0)
            triangles.remove(number);
    }

    public void remove(RightTriangle triangle) {
        triangles.remove(triangle);
    }

    public Triangle getLargestRightTriangle() {
        int max_hypotenuse = 0;
        Triangle tmpTriangle = new Triangle(0, 0, 0);
        for (RightTriangle triangle : triangles) {
            if (triangle.getHypotenuse() > max_hypotenuse) {
                tmpTriangle = triangle;
                max_hypotenuse = Math.max(Math.max(triangle.getSide1(), triangle.getSide2()), triangle.getSide3());
            }
        }
        return tmpTriangle;
    }
}
