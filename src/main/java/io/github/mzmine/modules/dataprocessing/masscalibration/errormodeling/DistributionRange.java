/*
 * Copyright 2006-2020 The MZmine Development Team
 *
 * This file is part of MZmine.
 *
 * MZmine is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with MZmine; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 * USA
 */


package io.github.mzmine.modules.dataprocessing.masscalibration.errormodeling;

import com.google.common.collect.Range;

import java.util.List;

public class DistributionRange extends DistributionExtract {
  /**
   * Values extracted from a distribution
   */
  protected List<Double> items;

  /**
   * Range of index values from original distribution that were extracted
   */
  protected Range<Integer> indexRange;

  /**
   * Range of values from original distribution that were extracted
   */
  protected Range<Double> valueRange;

  public DistributionRange(List<Double> items, Range<Integer> indexRange, Range<Double> valueRange) {
    super();
    this.items = items;
    this.indexRange = indexRange;
    this.valueRange = valueRange;
  }

  public List<Double> getItems() {
    return items;
  }

  public Range<Integer> getIndexRange() {
    return indexRange;
  }

  public Range<Double> getValueRange() {
    return valueRange;
  }
}