package com.company.classes;

import java.io.Serializable;

public class Triangle implements Serializable {
    protected int side1;
    protected int side2;
    protected int side3;


    public Triangle(int side1, int side2, int side3) {
        this.setSide1(side1);
        this.setSide2(side2);
        this.setSide3(side3);
    }

    public static boolean existsTriangle(int side1, int side2, int side3) {
        return (side1 > 0) && (side2 > 0) && (side3 > 0) && (side1 + side2 > side3) && (side1 + side3 > side2) && (side3 + side2 > side1);
    }

    public int getSide1() {
        return side1;
    }

    protected void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    protected void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    protected void setSide3(int side3) {
        this.side3 = side3;
    }

    public float getAngles(float sideA, float sideB, float sideC) {
        return (float) Math.toDegrees(Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideB * sideA)));
    }

    public int getPerimeter() {
        return (side1 + side2 + side3);
    }

    public float getSquare() {
        float p = (side1 + side2 + side3) / 2f;
        return (float) Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Triangle : {" +
                "side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                ", angleA = " + getAngles(side1, side2, side3) +
                ", angleB = " + getAngles(side1, side3, side2) +
                ", angleC = " + getAngles(side3, side2, side1) +
                ", perimeter = " + getPerimeter() +
                ", square = " + getSquare() +
                '}' +
                System.lineSeparator();
    }
}
