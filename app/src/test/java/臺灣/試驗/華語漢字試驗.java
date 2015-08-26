package 臺灣.試驗;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CasePreservingResolver;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class 華語漢字試驗 extends JUnitStory {

    // 從MostUsefulConfiguration改我們要的
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // 找和java相同路徑的Story
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // 設定Story行為檔佮JUnit設定檔的檔名對應
                .useStoryPathResolver(new CasePreservingResolver())
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

    // 定義Steps步驟檔
    @Override
    public InjectableStepsFactory stepsFactory() {
        // 可定義超過一個Steps步驟檔
        return new InstanceStepsFactory(configuration(), new 加字串步驟());
    }
}