package com.diboc.neuralnetworkgenerator.cells.memory;

import com.diboc.neuralnetworkgenerator.Node;

public class LongShortTermMemoryCell {

    private State state;
    private LongShortTermMemoryCell previousCell;
    private double output = 0;
    private double weight;
    private boolean isFirstCell = false;

    public LongShortTermMemoryCell(State state, LongShortTermMemoryCell previousCell, double[][] input) {

        this.state = state;

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

        if (isFirstCell) {

            state.multiplyState(Node.sigmoid(output));
            state.addState(Node.multiply(Node.sigmoid(output), Node.tanh(output)));

            return Node.multiply(Node.tanh(state.getState()), Node.sigmoid(output)) * weight;

        } else {

            double sum = previousCell.getValue() + output;
            state.multiplyState(Node.sigmoid(sum));
            state.addState(Node.multiply(Node.sigmoid(sum), Node.tanh(sum)));

            return Node.multiply(Node.tanh(state.getState()), Node.sigmoid(sum)) * weight;

        }

    }

}