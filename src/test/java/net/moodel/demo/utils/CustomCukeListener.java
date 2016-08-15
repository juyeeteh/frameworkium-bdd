package net.moodel.demo.utils;

import cucumber.api.java.Before;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.events.*;
import ru.yandex.qatools.allure.model.Label;
import ru.yandex.qatools.allure.utils.AnnotationManager;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.yandex.qatools.allure.annotations.Stories;

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
        TestSuiteStartedEvent suiteStartedEvent = new TestSuiteStartedEvent(feature.getName(), feature.getName());
        getLifecycle().fire(suiteStartedEvent);
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {

    }

    @Override
    public void examples(Examples examples) {

    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
        TestCaseStartedEvent scenStarterEvent = new TestCaseStartedEvent(featureInUse, scenario.getName());
        AnnotationManager am = buildAnnotationManager(featureInUse, scenario.getName());
        am.update(scenStarterEvent);
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
        TestSuiteFinishedEvent testSuiteFinishedEvent = new TestSuiteFinishedEvent(featureInUse);
        getLifecycle().fire(testSuiteFinishedEvent);
    }

    @Override
    public void close() {

    }

    @Override
    public void eof() {

    }


    public AnnotationManager buildAnnotationManager(String feature, String story) {
        //Add feature and story annotations
        Collection<Annotation> annotations = new ArrayList<>();
        annotations.add(getStoriesAnnotation(new String[] { story }));
        annotations.add(getFeaturesAnnotation(new String[] { feature }));
        return new AnnotationManager(annotations);
    }

    /**
     * Creates Story annotation object
     *
     * @param value story names array
     * @return Story annotation object
     */
    Stories getStoriesAnnotation(final String[] value) {
        return new Stories() {

            @Override
            public String[] value() {
                return value;
            }

            @Override
            public Class<Stories> annotationType() {
                return Stories.class;
            }
        };
    }

    /**
     * Creates Feature annotation object
     *
     * @param value feature names array
     * @return Feature annotation object
     */
    Features getFeaturesAnnotation(final String[] value) {
        return new Features() {

            @Override
            public String[] value() {
                return value;
            }

            @Override
            public Class<Features> annotationType() {
                return Features.class;
            }
        };
    }



    @Override
    public void before(Match match, Result result) {



    }

    @Override
    public void result(Result result) {
        System.out.println(result.hashCode());

    }

    @Override
    public void after(Match match, Result result) {

        if(result.getStatus() != "passed"){
            StepFailureEvent stepFailureEvent = new StepFailureEvent().withThrowable(result.getError());
            getLifecycle().fire(stepFailureEvent);
        }
    }

    @Override
    public void match(Match match) {
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
