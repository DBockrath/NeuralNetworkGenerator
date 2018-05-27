package com.diboc.neuralnetworkgenerator.layer;

import com.diboc.neuralnetworkgenerator.cells.CellType;
import com.diboc.neuralnetworkgenerator.cells.FeedForwardCell;
import com.diboc.neuralnetworkgenerator.cells.statistics.MeanCell;
import com.diboc.neuralnetworkgenerator.cells.statistics.StandardDeviationCell;
import com.diboc.neuralnetworkgenerator.cells.compression.ConvolutionalCell;
import com.diboc.neuralnetworkgenerator.cells.memory.GatedRecurrentCell;
import com.diboc.neuralnetworkgenerator.cells.memory.LongShortTermMemoryCell;
import com.diboc.neuralnetworkgenerator.cells.memory.RecurrentCell;
import com.diboc.neuralnetworkgenerator.cells.memory.State;

import java.util.ArrayList;

public class Layer extends ArrayList<Object> {

    private LayerType layerType;
    private CellType cellType;

    public Layer(LayerType layerType, CellType cellType, double[][] input, int numberOfNeurons) {

        this.layerType = layerType;
        this.cellType = cellType;

        switch (layerType) {

            case INPUT:

                switch (cellType) {

                    case FEED_FORWARD:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new FeedForwardCell(input));

                        break;

                    case CONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new ConvolutionalCell(input));

                        break;

                    case DECONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new DeconvolutionalCell(input));

                        break;

                    case GATED_RECURRENT:

                        State state = new State();

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new GatedRecurrentCell(state, input));

                        break;

                    case LONG_SHORT_TERM_MEMORY:

                        State s = new State();

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new LongShortTermMemoryCell(s, (LongShortTermMemoryCell)super.get(i - 1), input));

                            else
                                super.add(new LongShortTermMemoryCell(s, null, input));

                        }

                        break;

                    case RECURRENT:

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new RecurrentCell((RecurrentCell)super.get(i - 1), input));

                            else
                                super.add(new RecurrentCell(null, input));

                        }

                        break;

                    case MEAN:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new MeanCell(input));

                        break;

                    case STANDARD_DEVIATION:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new StandardDeviationCell(input));

                        break;

                }

                break;

            case HIDDEN:

                switch (cellType) {

                    case FEED_FORWARD:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new FeedForwardCell(input));

                        break;

                    case CONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new ConvolutionalCell(input));

                        break;

                    case DECONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new DeconvolutionalCell(input));

                        break;

                    case GATED_RECURRENT:

                        State state = new State();

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new GatedRecurrentCell(state, input));

                        break;

                    case LONG_SHORT_TERM_MEMORY:

                        State s = new State();

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new LongShortTermMemoryCell(s, (LongShortTermMemoryCell)super.get(i - 1), input));

                            else
                                super.add(new LongShortTermMemoryCell(s, null, input));

                        }

                        break;

                    case RECURRENT:

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new RecurrentCell((RecurrentCell)super.get(i - 1), input));

                            else
                                super.add(new RecurrentCell(null, input));

                        }

                        break;

                    case MEAN:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new MeanCell(input));

                        break;

                    case STANDARD_DEVIATION:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new StandardDeviationCell(input));

                        break;

                }

                break;

            case OUTPUT:

                switch (cellType) {

                    case FEED_FORWARD:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new FeedForwardCell(input));

                        break;

                    case CONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new ConvolutionalCell(input));

                        break;

                    case DECONVOLUTIONAL:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new DeconvolutionalCell(input));

                        break;

                    case GATED_RECURRENT:

                        State state = new State();

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new GatedRecurrentCell(state, input));

                        break;

                    case LONG_SHORT_TERM_MEMORY:

                        State s = new State();

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new LongShortTermMemoryCell(s, (LongShortTermMemoryCell)super.get(i - 1), input));

                            else
                                super.add(new LongShortTermMemoryCell(s, null, input));

                        }

                        break;

                    case RECURRENT:

                        for (int i = 0; i < numberOfNeurons; i++) {

                            if (i != 0)
                                super.add(new RecurrentCell((RecurrentCell)super.get(i - 1), input));

                            else
                                super.add(new RecurrentCell(null, input));

                        }

                        break;

                    case MEAN:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new MeanCell(input));

                        break;

                    case STANDARD_DEVIATION:

                        for (int i = 0; i < numberOfNeurons; i++)
                            super.add(new StandardDeviationCell(input));

                        break;

                }

                break;

        }

    }

    public LayerType getLayerType() {

        return layerType;

    }

    public CellType getCellType() {

        return cellType;

    }

    public double[][] output() {

        return null;

    }

}