package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;

import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;

/**
 * Improving Care Home page.
 */
public class HomeIFrame extends WebContainer<HomeIFrame> {
    public HomeIFrame(@NotNull ExtendedRemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public HomeIFrame waitForElementsToLoad() {
        return this;
    }
}
