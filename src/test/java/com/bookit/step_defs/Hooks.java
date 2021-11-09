package com.bookit.step_defs;

import com.bookit.utilities.DBUtils;
import com.bookit.utilities.Driver;
import io.cucumber.java.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp() {
        // we put a logic that should apply to every scenario
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @io.cucumber.java.Before("db")
    public void dbHook() {
        System.out.println("creating database connection");
        DBUtils.createConnection();
    }

    @After("db")
    public void afterDbHook() {
        System.out.println("closing database connection");
        DBUtils.destroy();

    }
}


