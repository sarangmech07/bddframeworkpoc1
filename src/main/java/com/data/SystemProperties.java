package com.data;

import java.lang.reflect.Field;

import static java.lang.System.getProperty;

public interface SystemProperties {

    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String PASS = "PASS";
    public static final String FAIL = "FAIL";
    
    String SNOW_URL = "https://dev96116.service-now.com";
    String SNOW_USERNAME = "admin";
    String SNOW_PASS = "yQLEBzY8tr9f";
    
    String SF_URL = "https://login.salesforce.com";
    String SF_USERNAME = "adm201@certprep2.com";
    String SF_PASS = "Sape@123";

    
    String environmentName = System.getProperty("env.name","QA");
    String DRIVER_TYPE = System.getProperty("driver.type", "CHROME");
    String REMOTE_DRIVER_STATUS = System.getProperty("remote.driver.status", "DISABLED");
    String REMOTE_URL = getProperty("remote.url");
    boolean SCREENSHOT_ON_EVERY_STEP = Boolean.parseBoolean(getProperty("screenshot_on_every_step"));
    String PARALLEL_MODE = System.getProperty("parallel.mode");
    String THREAD_COUNT = System.getProperty("thread.count");
    boolean FEATURE_CHECKPOINT = Boolean.parseBoolean(getProperty("feature.checkpoint"));
    String SUITENAME = System.getProperty("suite", "");
    String BUILD = System.getProperty("build", "");
    String REPORTSPLITCOUNTS = System.getProperty("extentreportbreak", "3");

    public static String getValue(String valueToGet) {
        String concatWithEnviromentName = valueToGet + "_" + environmentName;
        String value = null;
        try {
            Field field = SystemProperties.class.getField(concatWithEnviromentName);
            value = (String) field.get(concatWithEnviromentName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }
}
