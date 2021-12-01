package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class auxiliary_methods extends common_ops{

    @Step("Sleep action")
    public static void sleep(int wait_time) {
        Uninterruptibles.sleepUninterruptibly(wait_time, TimeUnit.SECONDS);
    }

    public static void take_element_screenShot(WebElement imageElement, String imageName)
    {
        image_screenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageElement);
//        imageScreenShot = new AShot().takeScreenshot(driver, imageElement);
        try
        {
            ImageIO.write(image_screenShot.getImage(), "png", new File(get_data("ImageRepo") + imageName +".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }


}
