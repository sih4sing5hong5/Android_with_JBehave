package com.試驗;

import com.example.android_with_jbehave.GridSteps;
import com.漢字.漢字步;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 走全部試驗 extends JUnitStories {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
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
        return new InstanceStepsFactory(configuration(), new 漢字步(), new GridSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(
                "src/test/resources",
                Collections.singletonList("**/*.story"), // 全部的story
//                Collections.singletonList("**/漢字/*.story"), // 漢字底下的story
                null
        );

    }
}