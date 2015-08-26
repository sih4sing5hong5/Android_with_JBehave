package 臺灣.試驗;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Collections;
import java.util.List;

public class 走全部試驗 extends JUnitStories {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
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
        return new InstanceStepsFactory(configuration(), new 加字串步驟());
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