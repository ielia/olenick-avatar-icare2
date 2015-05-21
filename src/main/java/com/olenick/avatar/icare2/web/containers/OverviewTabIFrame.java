package com.olenick.avatar.icare2.web.containers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.olenick.avatar.icare2.model.report_values.OverviewValue;
import com.olenick.avatar.icare2.model.report_values.ReportValues;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;

/**
 * Report Overview tab.
 */
public class OverviewTabIFrame extends ReportGraphsTabIFrame<OverviewTabIFrame> {
    private static final Logger log = LoggerFactory
            .getLogger(OverviewTabIFrame.class);

    private static final long TIMEOUT_SECS_GET_ROWS = 240;

    private static final String ELEMENT_ID_GRAPHS_FRAME = "visframe";
    private static final String ELEMENT_ID_RESULTS_FRAME = "ovrvwframe";
    private static final String FINAL_ITEM_NAME = "Total";
    private static final String XPATH_ROWS = "//td[normalize-space(text())='Total']/../../tr";
    private static final String XPATH_RELATIVE_ITEM_NAME = "td[1]";
    private static final String XPATH_RELATIVE_TOP_BOX_PERCENTAGE = "td[2]";
    private static final String XPATH_RELATIVE_COUNT = "td[last()-2]";
    // private static final String XPATH_TOTAL_VALUE =
    // "//td[normalize-space(text())='Total']/../td[last()-2]";

    private PatientExperienceIFrame parent;

    public OverviewTabIFrame(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);
        this.parent = parent;
    }

    public OverviewTabIFrame accessGraphsFrame() {
        this.accessResultsFrame();
        this.switchToFrame(ELEMENT_ID_GRAPHS_FRAME);
        return this;
    }

    public OverviewTabIFrame accessResultsFrame() {
        this.parent.accessPanelFrame();
        this.switchToFrame(ELEMENT_ID_RESULTS_FRAME);
        return this;
    }

    @Override
    public OverviewTabIFrame waitForElementsToLoad() {
        this.accessGraphsFrame().waitForResults();
        return this;
    }

    @Override
    public OverviewTabIFrame exportToPDF() {
        // This is a bit rubbish...
        throw new UnsupportedOperationException(
                "This operation is non-existent in the Overview tab.");
    }

    public ReportValues getValues() {
        ReportValues result = new ReportValues();
        if (this.dataAvailable) {
            for (WebElement row : this.getRows()) {
                String itemName = row
                        .findElement(By.xpath(XPATH_RELATIVE_ITEM_NAME))
                        .getText().trim();
                long count = Long.valueOf(row
                        .findElement(By.xpath(XPATH_RELATIVE_COUNT)).getText()
                        .trim().replace(",", ""));
                float topBoxPercentage = Float.valueOf(row
                        .findElement(
                                By.xpath(XPATH_RELATIVE_TOP_BOX_PERCENTAGE))
                        .getText().trim());
                result.set(itemName, new OverviewValue(count, topBoxPercentage));
                if (FINAL_ITEM_NAME.equals(itemName)) {
                    break; // YES! This is awful, I know.
                }
            }
        } else {
            result.setDataAvailable(false);
        }
        return result;
    }

    private List<WebElement> getRows() {
        List<WebElement> rows = this.getDriver().findElements(
                By.xpath(XPATH_ROWS), TIMEOUT_SECS_GET_ROWS);
        rows.remove(0);
        return rows;
    }
}
