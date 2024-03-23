package lesson_14.utils;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;

import java.util.List;

public class TestRailAdapter {
    public static void main(String[] args) {
        TestRail testRail = TestRail.builder("https://testzn.testrail.io/",
                "zhansayanur19999@gmail.com","Backto!505").applicationName("TestRailIntegration").build();
        Run run = testRail.runs().add(1, new Run().setSuiteId(1).setName("TestRun Registration")).execute();
        List<ResultField> customResultFields = testRail.resultFields().list().execute();
        testRail.results().addForCase(run.getId(), 1, new Result().setStatusId(1), customResultFields).execute();
        testRail.runs().close(run.getId()).execute();
    }
}
