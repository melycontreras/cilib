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
package net.sourceforge.cilib.type.types.container;

import java.util.Collection;
import net.sourceforge.cilib.container.visitor.Visitor;
import net.sourceforge.cilib.type.types.Randomizable;
import net.sourceforge.cilib.type.types.Type;

/**
 * Description for all objects that maintain a structure or collection of objects.
 *
 * @param <E> the type of object the {@linkplain Structure} may contain.
 */
public interface StructuredType<E> extends Collection<E>, Type, Randomizable {

    @Override
    StructuredType<E> getClone();

    /**
     * Accept the {@linkplain Visitor} instance and perform the actions within the
     * {@linkplain Visitor} on the objects contained within this {@linkplain Structure}.
     * @param visitor The {@linkplain Visitor} instance to execute.
     */
    void accept(Visitor<E> visitor);

}
