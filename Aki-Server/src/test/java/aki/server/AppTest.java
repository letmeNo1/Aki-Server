package aki.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import aki.Helper.Operation;
import aki.LaunchOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    aki.Windows.UIElementRef app;

    @Before
    public void initializeUIElement() throws InterruptedException {
        LaunchOption launchOption = new LaunchOption();
        Operation.initializeAppRefForElectron("C:\\Program Files\\YesPlayMusic\\YesPlayMusic.exe",launchOption);
    }

    @Test
    public void testCase() {
        String imageFolderPath = System.getProperty("user.dir") + "/src/test/java/Image/";
        app.findElementLocationByImage(imageFolderPath + "001.png").click();
        app.findElementLocationByImage(imageFolderPath + "happy-HITS.png");
        app.findElementLocationByImage(imageFolderPath + "Play.png").click();
        app.findElementLocationByImage(imageFolderPath + "home.png").click();
        app.findElementLocationByImage(imageFolderPath + "002.png").click();
        app.findElementLocationByImage(imageFolderPath + "Hip-hop.png");
        app.findElementLocationByImage(imageFolderPath + "Play.png").click();
        app.findElementLocationByImage(imageFolderPath + "home.png").click();
        app.findElementLocationByImage(imageFolderPath + "003.png").click();
        app.findElementLocationByImage(imageFolderPath + "breakHeart-pop.png");
        app.findElementLocationByImage(imageFolderPath + "Play.png").click();
        app.findElementLocationByImage(imageFolderPath + "home.png").click();
        app.findElementLocationByImage(imageFolderPath + "Explore.png").click();
        app.findElementLocationByImage(imageFolderPath + "Library.png").click();
        String Desktop =FileSystemView.getFileSystemView().getHomeDirectory().getPath();
        Operation.takeScreenshotForDesktop(Desktop+"/Screenshot_1634617817.png");
    }

    @After
    public void end() throws IOException {
        Operation.killApp();
    }
}
