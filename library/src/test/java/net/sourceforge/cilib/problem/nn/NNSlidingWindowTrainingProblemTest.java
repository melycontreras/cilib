/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.problem.nn;

import net.sourceforge.cilib.io.ARFFFileReader;
import net.sourceforge.cilib.measurement.generic.Iterations;
import net.sourceforge.cilib.nn.architecture.builder.LayerConfiguration;
import net.sourceforge.cilib.pso.PSO;
import net.sourceforge.cilib.stoppingcondition.Maximum;
import net.sourceforge.cilib.stoppingcondition.MeasuredStoppingCondition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test does not compare against anything (the same problem as with unit testing
 * a PSO) but simply executes to see whether there is exceptions.
 */
public class NNSlidingWindowTrainingProblemTest {

    private NNSlidingWindowTrainingProblem problem;

    @Before
    public void setup() {
        problem = new NNSlidingWindowTrainingProblem();
        problem.getDataTableBuilder().setDataReader(new ARFFFileReader());
        problem.getDataTableBuilder().setSourceURL("library/src/test/resources/datasets/iris.arff");
        problem.setTrainingSetPercentage(0.7);
        problem.setGeneralizationSetPercentage(0.3);
        problem.setStepSize(10);
        problem.setChangeFrequency(100);
        problem.setWindowSize(50);

        problem.getNeuralNetwork().getArchitecture().getArchitectureBuilder().addLayer(new LayerConfiguration(4));
        problem.getNeuralNetwork().getArchitecture().getArchitectureBuilder().addLayer(new LayerConfiguration(3));
        problem.getNeuralNetwork().getArchitecture().getArchitectureBuilder().addLayer(new LayerConfiguration(1));
        problem.getNeuralNetwork().getArchitecture().getArchitectureBuilder().getLayerBuilder().setDomain("R(-3:3)");
        problem.initialise();
    }

    @Test
    public void testPercentages() {
        int refTraining = (int) (problem.getWindowSize() * 0.7);
        int refGeneralization = (int) (problem.getWindowSize() * 0.3);
        Assert.assertEquals(refTraining, problem.getTrainingSet().size());
        Assert.assertEquals(refGeneralization, problem.getGeneralizationSet().size());
    }

    @Test
    public void testCalculateFitness() {
        PSO pso = new PSO();
        pso.addStoppingCondition(new MeasuredStoppingCondition(new Iterations(), new Maximum(), 1100));
        pso.setOptimisationProblem(problem);
        pso.performInitialisation();
        pso.performIteration();
    }
}
