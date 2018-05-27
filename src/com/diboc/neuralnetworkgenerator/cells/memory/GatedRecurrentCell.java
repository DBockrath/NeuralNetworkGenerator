package com.diboc.neuralnetworkgenerator.cells.memory;

import com.diboc.neuralnetworkgenerator.Node;

public class GatedRecurrentCell {

    private State state;
    private double output;
    private double weight;

    public GatedRecurrentCell(State state, double input) {

        this.state = state;
        weight = (Math.random() % 10) + .1;
        output = input;

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public double getWeight() {

        return weight;

    }

    public double output() {

        double branch1 = Node.add(state.getState(), output);
        double branch2 = Node.add(Node.multiply(Node.sigmoid(branch1), state.getState()), output);

        state.multiplyState(Node.invert(Node.sigmoid(branch1)));
        state.addState(Node.multiply(Node.tanh(branch2), Node.sigmoid(branch1)));

        return state.getState() * weight;

    }

}