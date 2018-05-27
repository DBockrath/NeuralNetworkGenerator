package com.diboc.neuralnetworkgenerator.cells.memory;

import com.diboc.neuralnetworkgenerator.Node;

public class State {

    private double value = 0;

    public void addState(double value) {

        this.value = Node.add(this.value, value);

    }

    public void multiplyState(double value) {

        this.value = Node.multiply(this.value, value);

    }

    public double getState() {

        return value;

    }

}