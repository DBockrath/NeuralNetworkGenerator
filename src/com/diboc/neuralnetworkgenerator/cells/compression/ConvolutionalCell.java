package com.diboc.neuralnetworkgenerator.cells.compression;

import com.diboc.neuralnetworkgenerator.Node;

public class ConvolutionalCell {

    // TODO: Filter should not be set to equal the input

    private double[][] input;
    private double[][] bias;
    private double[][] filter;
    private double weight;

    public ConvolutionalCell(double[][] input) {

        this.input = input;

        bias = new double[input.length][input[0].length];
        filter = input;
        weight = (Math.random() % 10) + .1;

        for (int row = 0; row < bias.length; row++) {

            for (int col = 0; col < bias[0].length; col++) {

                int rand = (int)Math.round(Math.random());

                if (rand == 0)
                    bias[row][col] = 1;

                else
                    bias[row][col] = -1;

            }

        }

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public void setBias(int row, int column, double bias) {

        this.bias[row][column] = bias;

    }

    public void setFilter(int row, int column, double filter) {

        this.filter[row][column] = filter;

    }

    public double getWeight() {

        return weight;

    }

    public double getBias(int row, int column) {

        return bias[row][column];

    }

    public double getFilter(int row, int column) {

        return filter[row][column];

    }

    public double getValue() {

        double value = 0;

        for (int row = 0; row < input.length; row++)
            for (int col = 0; col < input[0].length; col++)
                value += (input[row][col] * filter[row][col]) + bias[row][col];

        return value;

    }

    public double output() {

        double value = 0;

        for (int row = 0; row < input.length; row++)
            for (int col = 0; col < input[0].length; col++)
                value += (input[row][col] * filter[row][col]) + bias[row][col];

        return Node.sigmoid(value) * weight;

    }

}