package com.diboc.neuralnetworkgenerator.cells.memory;

import com.diboc.neuralnetworkgenerator.Node;

public class RecurrentCell {

    private RecurrentCell previousCell;
    private double output = 0;
    private double weight;
    private boolean isFirstCell = false;

    public RecurrentCell(RecurrentCell previousCell, double[][] input) {

        if (previousCell == null)
            isFirstCell = true;

        else
            this.previousCell = previousCell;

        weight = (Math.random() % 10) + .1;

        for (double[] anInput : input)
            for (int col = 0; col < input[0].length; col++)
                output += anInput[col];

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public double getWeight() {

        return weight;

    }

    public double getValue() {

        return previousCell.getValue() + output;

    }

    public double output() {

        if (isFirstCell)
            return Node.tanh(output) * weight;

        else
            return Node.tanh(Node.add(previousCell.getValue(), output)) * weight;

    }

}