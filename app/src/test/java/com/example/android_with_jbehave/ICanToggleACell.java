package com.example.android_with_jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ICanToggleACell extends JUnitStory {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // 找和java相同路徑的Story
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // 有Step沒定義到視同Error
                .usePendingStepStrategy(new FailingUponPendingStep())
                // CONSOLE和TXT報表
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withDefaultFormats().withFormats(
                                Format.CONSOLE,
                                Format.TXT
                        )
                );
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new GridSteps());
    }
}