package com.company.classes;

import java.util.Arrays;

public class Triangles {
    private Triangle[] triangles;

    public Triangles(int length) {
        this.triangles = new Triangle[length];
    }

    public Triangles() {
        triangles = new Triangle[0];
    }

    public void setTriangleAt(int index, Triangle triangle) {
        triangles[index] = triangle;
    }

    public void add(Triangle triangle) {
        int n = 0;
        for (Triangle triangle1 : triangles) {
            if (triangle1 == null) {
                break;
            } else {
                n++;
            }
        }
        if (triangles.length == n) {
            resize(n + 1);
        }
        setTriangleAt(n, triangle);
    }

    public void resize(int newLength) {
        Triangle[] tempTriangles = new Triangle[newLength];
        tempTriangles = Arrays.copyOf(triangles, newLength);
        triangles = tempTriangles;
    }

    public double getAverageSquare() {
        double area = 0;
        for (Triangle triangle : triangles) {
            area += triangle.getSquare();
        }
        return area / triangles.length;
    }

    public Triangle getLargestRightTriangle() {
        int max_hypotenuse = 0;
        Triangle tmpTriangle = new Triangle(0, 0, 0);
        for (Triangle triangle : triangles) {
            if ((triangle instanceof RightTriangle) && (((RightTriangle) triangle).getHypotenuse() > max_hypotenuse)) {
                tmpTriangle = triangle;
                max_hypotenuse = Math.max(Math.max(triangle.getSide1(), triangle.getSide2()), triangle.getSide3());
            }
        }
        return tmpTriangle;
    }

    @Override
    public String toString() {
        String result = "Triangles :" + System.lineSeparator();
        for (Triangle triangle : triangles) {
            result += triangle;
        }
        return result;
    }
}
