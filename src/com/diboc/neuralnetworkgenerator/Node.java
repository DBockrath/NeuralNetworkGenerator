package com.diboc.neuralnetworkgenerator;

public class Node {

    public static double multiply(double in1, double in2) {

        return in1 * in2;

    }

    public static double add(double in1, double in2) {

        return in1 + in2;

    }

    public static double invert(double in) {

        return in * -1;

    }

    public static double tanh(double in) {

        return (2 * sigmoid(2 * in)) - 1;

    }

    public static double sigmoid(double in) {

        return 1 / (1 + Math.pow(Math.E, (in * -1)));

    }

    public static double relu(double in) {

        return Math.max(0, in);

    }

}