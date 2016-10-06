package com.equerest.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by moncher on 06.10.2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/equerest/features/")
public class RunFeatures {
}
