/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpennmsSeleniumExample {
    private WebDriver driver;
    private String baseUrl="";
    private int timeout = 3;
    private StringBuffer verificationErrors = new StringBuffer();

    public OpennmsSeleniumExample(String url, int timeoutInSeconds) {
         baseUrl = url;
         timeout = timeoutInSeconds;
    }
    
    @Before
    public void setUp() throws Exception {
        System.err.println("Before is being called in Groovy Script: " + this.hashCode());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @Test
    public void testSelenium() throws Exception {
        System.err.println("Test is being called in Groovy Script: " + this.hashCode());
        // open | / |
        assertNotNull(driver);
        driver.get(baseUrl);
        // click | link=Our Story |
        driver.findElement(By.linkText("Our Story")).click();

        // assertText | link=Contact Us | Contact Us
        //assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());
        assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());
    }

    @After
    public void tearDown() throws Exception {
        System.err.println("After is being called in Groovy Script: " + this.hashCode());
        assertNotNull("Driver is null, it should not be null", driver);
        driver.quit();
        
        
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
