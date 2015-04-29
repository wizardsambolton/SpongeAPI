/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.world.gen.populators;

import org.spongepowered.api.data.types.PlantType;
import org.spongepowered.api.util.VariableAmount;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedObject;
import org.spongepowered.api.world.gen.Populator;

import java.util.Collection;

/**
 * Represents a populator which scatters flowers randomly around a chunk.
 */
public interface Flowers extends Populator {

    /**
     * Gets the number of flowers to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getFlowersPerChunk();

    /**
     * Sets the number of flowers to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setFlowersPerChunk(VariableAmount count);

    /**
     * Gets a mutable weighted collection of plant type for this populator to
     * spawn.
     * 
     * @return The plant types
     */
    WeightedCollection<WeightedObject<PlantType>> getFlowerTypes();

    /**
     * A builder for constructing {@link Flowers} populators.
     */
    interface Builder {

        /**
         * Sets the number of flowers to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the plant types for this populator to spawn.
         * 
         * @param types The plant types to spawn
         * @return This builder, for chaining
         */
        Builder types(WeightedObject<PlantType>... types);

        /**
         * Sets the plant types for this populator to spawn.
         * 
         * @param types The plant types to spawn
         * @return This builder, for chaining
         */
        Builder types(Collection<WeightedObject<PlantType>> types);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Flowers} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Flowers build() throws IllegalStateException;

    }

}