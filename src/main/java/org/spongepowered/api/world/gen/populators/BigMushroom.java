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

import org.spongepowered.api.util.VariableAmount;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedObject;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.types.MushroomType;
import org.spongepowered.api.world.gen.types.MushroomTypes;

import java.util.Collection;

/**
 * Represents a populator which places a number of large mushrooms. The type of
 * mushroom to place can be set or can be randomized.
 */
public interface BigMushroom extends Populator {

    /**
     * Gets a mutable {@link WeightedCollection} of possible mushroom types to
     * spawn. If the list is empty then a {@link MushroomType} will be selected
     * at random from all available {@link MushroomTypes}.
     * 
     * @return The weighted list
     */
    WeightedCollection<WeightedObject<MushroomType>> getType();

    /**
     * Gets a representation of the amount of mushrooms which will be attempted
     * to be spawned per chunk.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @return The number of mushrooms attempted to be spawned per chunk
     */
    VariableAmount getMushroomsPerChunk();

    /**
     * Sets the representation of the amount of mushrooms which will be
     * attempted to be spawned per chunk.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount to attempt to create
     */
    void setMushroomsPerChunk(VariableAmount count);

    /**
     * A builder for constructing {@link BigMushroom} populators.
     */
    interface Builder {

        /**
         * Sets the weighted {@link MushroomType}s to select from during
         * generation.
         * 
         * @param types The weighted types
         * @return This builder, for chaining
         */
        Builder types(WeightedObject<MushroomType>... types);

        /**
         * Sets the weighted {@link MushroomType}s to select from during
         * generation.
         * 
         * @param types The weighted types
         * @return This builder, for chaining
         */
        Builder types(Collection<WeightedObject<MushroomType>> types);

        /**
         * Sets the number of mushrooms which will be attempted to be spawned.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of mushrooms which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new amount to attempt to create
         * @return This builder, for chaining
         */
        Builder mushroomsPerChunk(VariableAmount count);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link BigMushroom} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        BigMushroom build() throws IllegalStateException;

    }

}