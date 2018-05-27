package com.diboc.neuralnetworkgenerator.network;

import com.diboc.neuralnetworkgenerator.cells.CellType;
import com.diboc.neuralnetworkgenerator.layer.Layer;
import com.diboc.neuralnetworkgenerator.layer.LayerType;

import java.util.ArrayList;

public class NeuralNetwork extends ArrayList<Layer> {

    private Complexity complexity;
    private NetworkType type;
    private int numberOfCells = 0;

    public NeuralNetwork(Complexity complexity, NetworkType type, double[][] input, int numberOfLayers) {

        this.complexity = complexity;
        this.type = type;

        for (double[] anInput : input)
            for (int col = 0; col < input[0].length; col++)
                numberOfCells++;

        switch (complexity) {

            case DEEP:

                switch (type) {

                    case PERCEPTRON:
                        break;

                    case FEED_FORWARD:
                        break;

                    case RADIAL_BASIS:
                        break;

                    case RECURRENT:
                        break;

                    case LONG_SHORT_TERM_MEMORY:
                        break;

                    case GATED_RECURRENT:
                        break;

                    case AUTO_ENCODER:
                        break;

                    case VARIATIONAL_AUTO_ENCODER:
                        break;

                    case DENOISING_AUTO_ENCODER:
                        break;

                    case SPARSE_AUTO_ENCODER:
                        break;

                    case MARKOV_CHAIN:
                        break;

                    case HOPFIELD:
                        break;

                    case BOLTZMANN:
                        break;

                    case RESTRICTED_BOLTZMANN:
                        break;

                    case CONVOLUTIONAL:
                        break;

                    case DECONVOLUTIONAL:
                        break;

                    case CONVOLUTIONAL_INVERSE_GRAPHICS:
                        break;

                    case GENERATIVE_ADVERSARIAL:
                        break;

                    case LIQUID_STATE:
                        break;

                    case EXTREME_LEARNING:
                        break;

                    case ECHO_STATE:
                        break;

                    case RESIDUAL:
                        break;

                    case KOHONEN:
                        break;

                    case SUPPORT_VECTOR:
                        break;

                    case NEURAL_TURING:
                        break;

                }

                break;

            case NORMAL:

                switch (type) {

                    case PERCEPTRON:

                        super.add(new Layer(LayerType.INPUT, CellType.FEED_FORWARD, input, numberOfCells));

                        for (int i = 1; i < numberOfLayers - 1; i++)
                            super.add(new Layer(LayerType.HIDDEN, CellType.FEED_FORWARD, super.get(i - 1).output(), super.get(i - 1).size() / 2));

                        super.add(new Layer(LayerType.OUTPUT, CellType.FEED_FORWARD, super.get(super.indexOf(super.size() - 2)).output(), super.get(super.size() - 2).size() / 2));

                        break;

                    case FEED_FORWARD:
                        break;

                    case RADIAL_BASIS:
                        break;

                    case RECURRENT:
                        break;

                    case LONG_SHORT_TERM_MEMORY:
                        break;

                    case GATED_RECURRENT:
                        break;

                    case AUTO_ENCODER:
                        break;

                    case VARIATIONAL_AUTO_ENCODER:
                        break;

                    case DENOISING_AUTO_ENCODER:
                        break;

                    case SPARSE_AUTO_ENCODER:
                        break;

                    case MARKOV_CHAIN:
                        break;

                    case HOPFIELD:
                        break;

                    case BOLTZMANN:
                        break;

                    case RESTRICTED_BOLTZMANN:
                        break;

                    case CONVOLUTIONAL:
                        break;

                    case DECONVOLUTIONAL:
                        break;

                    case CONVOLUTIONAL_INVERSE_GRAPHICS:
                        break;

                    case GENERATIVE_ADVERSARIAL:
                        break;

                    case LIQUID_STATE:
                        break;

                    case EXTREME_LEARNING:
                        break;

                    case ECHO_STATE:
                        break;

                    case RESIDUAL:
                        break;

                    case KOHONEN:
                        break;

                    case SUPPORT_VECTOR:
                        break;

                    case NEURAL_TURING:
                        break;

                }

                break;

        }

    }

    public Complexity getComplexity() {

        return complexity;

    }

    public NetworkType getNetworkType() {

        return type;

    }

    public void train(double[][] input) {



    }

    public double[][] run() {

        return null;

    }

}