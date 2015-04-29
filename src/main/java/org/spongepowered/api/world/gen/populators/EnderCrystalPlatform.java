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

import org.spongepowered.api.entity.EnderCrystal;
import org.spongepowered.api.util.VariableAmount;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which randomly generates large obsidian pillars with
 * {@link EnderCrystal}s at the peak such as are found in the End.
 */
public interface EnderCrystalPlatform extends Populator {

    /**
     * Gets the probability of a pillar spawning in a chunk.
     * 
     * @return The spawn probability
     */
    double getSpawnProbability();

    /**
     * Sets the probability of a pillar spawning in a chunk. The default value
     * is 0.2.
     * 
     * @param p The spawn probability
     */
    void setSpawnProbability(double p);

    /**
     * Gets the height of the pillar.
     * 
     * @return The height
     */
    VariableAmount getHeight();

    /**
     * Sets the height of the pillar, cannot be negative.
     * 
     * @param height The new height
     */
    void setHeight(VariableAmount height);

    /**
     * Gets the radius of the pillar.
     * 
     * @return The radius
     */
    VariableAmount getRadius();

    /**
     * Sets the radius of the pillar, cannot be negative.
     * 
     * @param radius The new radius
     */
    void setRadius(VariableAmount radius);

    /**
     * A builder for constructing {@link EnderCrystalPlatform} populators.
     */
    interface Builder {

        /**
         * Sets the probability of a pillar spawning in a chunk. The default
         * value is 0.2.
         * 
         * @param p The spawn probability
         * @return This builder, for chaining
         */
        Builder chance(double p);

        /**
         * Sets the height of the pillar.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets the radius of the pillar.
         * 
         * @param radius The base radius
         * @return This builder, for chaining
         */
        Builder radius(VariableAmount radius);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link EnderCrystalPlatform} populator
         * with the settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        EnderCrystalPlatform build() throws IllegalStateException;

    }

}