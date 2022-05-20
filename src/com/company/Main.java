package com.company;

import com.company.classes.*;

import java.io.IOException;

public class Main {

    public static final int M = 5;
    public static final int N = 5;
    public static final int MAX_SIDE = 100;

    public Main() {
    }

    /**
     * 16. Создать класс треугольник, члены класса – длины 3-х сторон. Предусмотреть в классе методы
     * проверки существования треугольника, вычисления и вывода сведений о фигуре – длины сторон, углы,
     * периметр, площадь. Создать производный класс – прямоугольный треугольник, 30предусмотреть в
     * классе проверку, является ли треугольник прямоугольным. Написать программу, демонстрирующую
     * работу с классом: дано M треугольников и N прямоугольных треугольников, найти среднюю площадь М
     * треугольников и прямоугольный треугольник с наибольшей гипотенузой.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        int side1, side2, side3;


        System.out.println("\n--------------------------------\n");

        TrianglesList trianglesList = new TrianglesList();
        RightTriangleList rightTrianglesList = new RightTriangleList();

        TrianglesList trianglesList1 = new TrianglesList();
        RightTriangleList rightTriangleList1 = new RightTriangleList();
        /**
         * Loading data from the previous session
         */
        try {
            trianglesList = Database.deserializeTriangle();
            rightTrianglesList = Database.deserializeRightTriangle();

            //-----------------------------------------------------------------------

            trianglesList1 = DatabaseJSONE.deserializeTriangleJSON();
            rightTriangleList1 = DatabaseJSONE.deserializeRightTriangleJSON();

            System.out.println(trianglesList);
            System.out.println(rightTrianglesList);

            System.out.println("\n--------------------------------\n");

            System.out.println(trianglesList1);
            System.out.println(rightTriangleList1);
        } catch (Exception e) {
            for (int i = 0; i < M; i++) {
                while (!Triangle.existsTriangle(side1 = ((int) (Math.random() * MAX_SIDE + 1)), side2 = ((int) (Math.random() * MAX_SIDE + 1)), side3 = ((int) (Math.random() * MAX_SIDE + 1)))) {
                    //System.out.println(side1 + " " + side2 + " " + side3);
                }
                trianglesList.add(new Triangle(side1, side2, side3));
                trianglesList1.add(new Triangle(side1, side2, side3));
            }
            System.out.println(trianglesList);
            System.out.println(trianglesList.getAverageSquare());


            System.out.println("\n--------------------------------\n");


            for (int i = 0; i < N; i++) {
                while (!RightTriangle.existsRightTriangle(side1 = ((int) (Math.random() * MAX_SIDE + 1)), side2 = ((int) (Math.random() * MAX_SIDE + 1)), side3 = ((int) (Math.random() * MAX_SIDE + 1)))) {
                    //System.out.println(side1 + " " + side2 + " " + side3);
                }
                rightTrianglesList.add(new RightTriangle(side1, side2, side3));
                rightTriangleList1.add(new RightTriangle(side1, side2, side3));
            }
            System.out.println(rightTrianglesList);
            System.out.println(rightTrianglesList.getLargestRightTriangle());


            System.out.println("\n--------------------------------\n");

        }

        Database.serializeTriangle(trianglesList);
        Database.serializeRightTriangle(rightTrianglesList);

        //-----------------------------------------------------------------

        DatabaseJSONE.serializeTriangleJSON(trianglesList1);
        DatabaseJSONE.serializeRightTriangleJSON(rightTriangleList1);

    }
}
