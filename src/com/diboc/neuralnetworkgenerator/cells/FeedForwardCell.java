package com.diboc.neuralnetworkgenerator.cells;

import com.diboc.neuralnetworkgenerator.Node;

public class FeedForwardCell {

    private double output;
    private double bias;
    private double weight;

    public FeedForwardCell(double[][] input) {

        for (double[] anInput : input)
            for (int col = 0; col < input[0].length; col++)
                output += anInput[col];

        weight = (Math.random() % 10) + .1;

        int rand = (int)Math.round(Math.random());

        if (rand == 0)
            bias = -1;

        else
            bias = 1;

    }

    public void setBias(double bias) {

        this.bias = bias;

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public double getBias() {

        return bias;

    }

    public double getWeight() {

        return weight;

    }

    public double output() {

        return Node.sigmoid(output + bias) * weight;

    }

}