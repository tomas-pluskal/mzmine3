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

package io.github.mzmine.modules.visualization.productionfilter;

import java.util.Collection;

import javax.annotation.Nonnull;

import io.github.mzmine.datamodel.MZmineProject;
import io.github.mzmine.datamodel.RawDataFile;
import io.github.mzmine.modules.MZmineModuleCategory;
import io.github.mzmine.modules.MZmineRunnableModule;
import io.github.mzmine.parameters.ParameterSet;
import io.github.mzmine.taskcontrol.Task;
import io.github.mzmine.util.ExitCode;

/**
 * Production ion filter visualizer generated by Shawn Hoogstra : shoogstr@uwo.ca Filter ms/ms scan
 * based upon desired m/z and neutral loss m/z values
 */
public class ProductIonFilterVisualizerModule implements MZmineRunnableModule {

  private static final String MODULE_NAME = "Diagnostic fragmentation filtering";
  private static final String MODULE_DESCRIPTION =
      "This visualizer will filter MS/MS scans based on desired m/z and neutral loss and output a"
          + "plot showing the product ions vs. the precursor ion. In addition it will output a file containing m/z and RT of filtered MS/MS scans. ";

  @Override
  public @Nonnull String getName() {
    return MODULE_NAME;
  }

  @Override
  public @Nonnull String getDescription() {
    return MODULE_DESCRIPTION;
  }

  @Override
  @Nonnull
  public ExitCode runModule(@Nonnull MZmineProject project, @Nonnull ParameterSet parameters,
      @Nonnull Collection<Task> tasks) {

    RawDataFile dataFiles[] = parameters.getParameter(ProductIonFilterParameters.dataFiles)
        .getValue().getMatchingRawDataFiles();

    ProductIonFilterVisualizerWindow newWindow =
        new ProductIonFilterVisualizerWindow(dataFiles[0], parameters);
    newWindow.show();

    return ExitCode.OK;
  }

  @Override
  public @Nonnull MZmineModuleCategory getModuleCategory() {
    return MZmineModuleCategory.VISUALIZATIONRAWDATA;
  }

  @Override
  public @Nonnull Class<? extends ParameterSet> getParameterSetClass() {
    return ProductIonFilterParameters.class;
  }

}
