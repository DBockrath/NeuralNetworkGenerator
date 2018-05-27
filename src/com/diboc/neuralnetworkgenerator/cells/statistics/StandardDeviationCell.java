package com.diboc.neuralnetworkgenerator.cells.statistics;

public class StandardDeviationCell {

    private double[][] output;
    private double weight;
    private double count = 0;

    public StandardDeviationCell(double[][] input) {

        output = input;
        weight = (Math.random() % 10) + .1;

        for (double[] anInput : input)
            for (int col = 0; col < input[0].length; col++)
                count++;

    }

    public void setWeight(double weight) {

        this.weight = weight;

    }

    public double getWeight() {

        return weight;

    }

    public double output() {

        double sum = 0;

        for (double[] anOutput : output)
            for (int col = 0; col < output[0].length; col++)
                sum += anOutput[col];

        double mean = sum / count;
        double deviationSum = 0;

        for (double[] anOutput : output)
            for (int col = 0; col < output[0].length; col++)
                deviationSum += Math.pow(anOutput[col] - mean, 2);

        double deviationMean = deviationSum / count;
        return Math.sqrt(deviationMean) * weight;

    }

}