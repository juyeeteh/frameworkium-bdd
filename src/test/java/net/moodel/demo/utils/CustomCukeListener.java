package net.moodel.demo.utils;

import cucumber.runtime.StepDefinitionMatch;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.config.AllureModelUtils;
import ru.yandex.qatools.allure.events.*;

import java.util.List;

public class CustomCukeListener implements Formatter, Reporter {

    private Allure lifecycle = Allure.LIFECYCLE;

    public Allure getLifecycle() {
        return lifecycle;
    }

    private String featureInUse;

    @Override
    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {

    }

    @Override
    public void uri(String s) {

    }

    @Override
    public void feature(Feature feature) {

        featureInUse = feature.getName();
//        TestSuiteStartedEvent suiteStartedEvent = new TestSuiteStartedEvent(feature.getName(), feature.getName());
//        getLifecycle().fire(suiteStartedEvent);
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        System.out.println(scenarioOutline.toString());
    }

    @Override
    public void examples(Examples examples) {

    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
        TestCaseStartedEvent scenStarterEvent = new TestCaseStartedEvent(featureInUse, scenario.getName())
                .withLabels(
                        AllureModelUtils.createFeatureLabel(featureInUse),
                        AllureModelUtils.createStoryLabel(scenario.getName())
//                        AllureModelUtils.createTestLabel(scenario.getName())
                );
        getLifecycle().fire(scenStarterEvent);
    }

    @Override
    public void background(Background background) {

    }


    @Override
    public void scenario(Scenario scenario) {

    }

    @Override
    public void step(Step step) {
        System.out.println("STEP! - " + step.getKeyword() + " " + step.getName() + " " + step.hashCode() );
    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
        TestCaseFinishedEvent scenFinishedEvent = new TestCaseFinishedEvent();
        getLifecycle().fire(scenFinishedEvent);
    }

    @Override
    public void done() {
//        TestSuiteFinishedEvent testSuiteFinishedEvent = new TestSuiteFinishedEvent(featureInUse);
//        getLifecycle().fire(testSuiteFinishedEvent);
    }

    @Override
    public void close() {

    }

    @Override
    public void eof() {

    }



    @Override
    public void before(Match match, Result result) {
        System.out.println("STEP_before");
        StepEvent stepEvent = new StepStartedEvent("START!");
        getLifecycle().fire(stepEvent);
    }

    @Override
    public void result(Result result) {
        System.out.println("STEP_after");
        if(result.getStatus() != "passed"){
            StepFailureEvent stepFailureEvent = new StepFailureEvent().withThrowable(result.getError());
            getLifecycle().fire(stepFailureEvent);
        } else {
            StepFinishedEvent stepFinishedEvent = new StepFinishedEvent();
            getLifecycle().fire(stepFinishedEvent);
        }
        System.out.println("STEPSTOP: " + System.currentTimeMillis());


    }

    @Override
    public void after(Match match, Result result) {

    }

    @Override
    public void match(Match match) {

        StepDefinitionMatch step = (StepDefinitionMatch)match;
//        StepStartedEvent stepStartedEvent = new StepStartedEvent(step.getStepName());
//        ru.yandex.qatools.allure.model.Step step1 = new ru.yandex.qatools.allure.model.Step()
//                .withName(step.getStepName())
//                .withStart(System.currentTimeMillis());
        StepEvent stepEvent = new StepStartedEvent(step.getStepName());
        getLifecycle().fire(stepEvent);
        System.out.println("STEPSTART: " + System.currentTimeMillis() + " " + step.getStepName());

//
//        StepFinishedEvent stepFinishedEvent = new StepFinishedEvent();
//        getLifecycle().fire(stepFinishedEvent);
    }

    @Override
    public void embedding(String s, byte[] bytes) {
        System.out.println("Reporter - EMBEDDING!");

    }

    @Override
    public void write(String s) {
        System.out.println("Reporter - WRITE!");
    }



















}
