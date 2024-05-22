import facade.DragNDropFacade;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.DragNDropPage;
import pages.HomePage;

import java.net.MalformedURLException;

public class FirstTest extends BaseTest {

    @Test
    public void first() throws MalformedURLException, InterruptedException {

        new HomePage().clickView("Views")
                .clickMenuIntem("Drag and Drop");
    }

    @Test
    public void second() throws MalformedURLException, InterruptedException {

        new HomePage().clickView("Views")
                .clickMenuIntem("Drag and Drop");
    }

    @Test
    public void third() {
        new HomePage().clickMenuItem("Animation");
    }


    @Test
    public void dragNDropTest() throws InterruptedException {

        String textToVerify = new DragNDropFacade()
                .navigateToDragNDropPage()
                .getDragNDropPage()
                .performDragNDrop()
                .getTextToVerify();
        Assertions.assertThat(textToVerify).isEqualTo("Dropped!");
    }
}
