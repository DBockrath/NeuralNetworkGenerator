package com.diboc.neuralnetworkgenerator.cells.statistics;

public class MeanCell {

    private double output;
    private double weight;

    public MeanCell(double[][] input) {

        weight = (Math.random() % 10) + .1;
        double count = 0;

        for (double[] anInput : input) {

            for (int col = 0; col < input[0].length; col++) {

                output += anInput[col];
                count++;

            }

        }

        output /= count;

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public double getWeight() {

        return weight;

    }

    public double output() {

        return output * weight;

    }

}