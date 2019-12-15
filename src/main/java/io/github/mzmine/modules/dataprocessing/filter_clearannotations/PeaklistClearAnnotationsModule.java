/*
 * Copyright 2006-2020 The MZmine Development Team
 * 
 * This file is part of MZmine 2.
 * 
 * MZmine 2 is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * MZmine 2 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with MZmine 2; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 * USA
 */

package io.github.mzmine.modules.dataprocessing.filter_clearannotations;

import java.util.Collection;

import javax.annotation.Nonnull;

import io.github.mzmine.datamodel.MZmineProject;
import io.github.mzmine.datamodel.PeakList;
import io.github.mzmine.modules.MZmineModuleCategory;
import io.github.mzmine.modules.MZmineProcessingModule;
import io.github.mzmine.parameters.ParameterSet;
import io.github.mzmine.taskcontrol.Task;
import io.github.mzmine.util.ExitCode;

/**
 * Implements a filter for comparison of peaks in a given row after alignment
 * results. The filter removes rows (features) that meet certain criteria
 * between given peaks in the row e.g. fold change, etc.
 */
public class PeaklistClearAnnotationsModule implements MZmineProcessingModule {

    private static final String MODULE_NAME = "Clear peaklist annotations";
    private static final String MODULE_DESCRIPTION = "This method clears the annotations from the peaklist";

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
    public ExitCode runModule(@Nonnull MZmineProject project,
            @Nonnull ParameterSet parameters, @Nonnull Collection<Task> tasks) {

        final PeakList[] peakLists = parameters
                .getParameter(PeaklistClearAnnotationsParameters.PEAK_LISTS)
                .getValue().getMatchingPeakLists();

        for (PeakList peakList : peakLists) {

            Task newTask = new PeaklistClearAnnotationsTask(project, peakList,
                    parameters);
            tasks.add(newTask);

        }

        return ExitCode.OK;
    }

    @Override
    public @Nonnull MZmineModuleCategory getModuleCategory() {
        return MZmineModuleCategory.PEAKLISTFILTERING;
    }

    @Override
    public @Nonnull Class<? extends ParameterSet> getParameterSetClass() {
        return PeaklistClearAnnotationsParameters.class;
    }
}