package facade;

import pages.DragNDropPage;
import pages.HomePage;

public class DragNDropFacade {

    public DragNDropFacade navigateToDragNDropPage() throws InterruptedException {

        new HomePage().clickView("Views").clickMenuIntem("Drag and Drop");
        return this;
    }

    public DragNDropPage getDragNDropPage(){
        return new DragNDropPage();
    }

}
