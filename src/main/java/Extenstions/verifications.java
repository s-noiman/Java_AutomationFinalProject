package Extenstions;

import Utilities.auxiliary_methods;
import Utilities.common_ops;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends common_ops {

    @Step("Verify the text in element is the same as expected text")
    public static void element_text(WebElement elem, String expected_text, String massage) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected_text, massage);
    }

    @Step("Verify the actual text is the same as expected text")
    public static void string_value(String actual_text, String expected_text, String massage) {
        assertEquals(actual_text, expected_text, massage);
    }

    @Step("Verify all actual texts is the same as expects text")
    public static void string_values(List<String> actual_texts, List<String> expected_texts, String massage) {
        soft_assert = new SoftAssert();
        //null
        for(int index = 0; index < actual_texts.size() && index < expected_texts.size(); index++) {
            soft_assert.assertEquals(actual_texts.get(index), expected_texts.get(index), massage);
        }
        soft_assert.assertAll();
    }

    @Step("Verify the text in element is the same as expected text")
    public static void is_elem_exists(WebElement elem, Boolean expected_result, String massage) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        if(expected_result)
            assertTrue(elem.isDisplayed(), massage);
        else assertFalse(elem.isDisplayed(), massage);
    }

    @Step("Verify Element visually")
    public static void VisualElement(WebElement imageElement, String expectedImageName)
    {
        auxiliary_methods.take_element_screenShot(_login.grafana_icon, "GrafanaIcon");
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(get_data("ImageRepo") + expectedImageName + ".png"));
        }
        catch (Exception e) {
            System.out.println("Error reading image file: " + e);
        }
        Screenshot imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = img_diff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }
}
