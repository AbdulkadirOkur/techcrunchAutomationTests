package com.techcrunch.stepDefinitions;

import com.techcrunch.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    //This is for closing the driver after every test
    @After
    public void teardownScenario(Scenario scenario){
        Driver.closeDriver();
    }
}
