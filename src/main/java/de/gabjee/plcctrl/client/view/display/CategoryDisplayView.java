package de.gabjee.plcctrl.client.view.display;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.display.CategoryDisplayPresenter.CategoryDisplayViewInterface;

public class CategoryDisplayView extends BasicBeanDisplayView implements CategoryDisplayViewInterface {

    private Label price = new Label();

    @Override
    protected Widget createWidget() {
        VerticalPanel mainPanel = (VerticalPanel) super.createWidget();
        HorizontalPanel panel = new HorizontalPanel();
        panel.add(new Label("Price"));
        panel.add(price);
        price.addStyleName("price");
        mainPanel.add(panel);
        return mainPanel;
    }
}
