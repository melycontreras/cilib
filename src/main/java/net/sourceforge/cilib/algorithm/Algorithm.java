/**
 * Copyright (C) 2003 - 2009
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.algorithm;

import net.sourceforge.cilib.problem.OptimisationProblem;
import net.sourceforge.cilib.problem.OptimisationSolution;
import net.sourceforge.cilib.util.Cloneable;

/**
 *
 */
public interface Algorithm extends Cloneable {

    public OptimisationSolution getBestSolution();

    public void performIteration();

     /**
     * Not Needed>??>????????????
     */
    public void performInitialisation();

     /**
     * Not Needed>??>????????????
     */
    public void performUninitialisation();

    public Iterable<OptimisationSolution> getSolutions();

    public OptimisationProblem getOptimisationProblem();

    /**
     * ???? Not needed?
     */
    public void reset();

    /**
     * Not Needed>??>????????????
     */
     public int getIterations();

    /**
     * Set the optimisation problem to be solved. By default, the problem is <code>null</code>.
     * That is, it is necessary to set the optimisation problem before calling {@link #initialise()}.
     * @param problem An implementation of the
     * {@link net.sourceforge.cilib.problem.OptimisationProblemAdapter} interface.
     */
    public void setOptimisationProblem(OptimisationProblem problem);
}
