package de.gabjee.plcctrl.client.view.display;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.view_interface.display.BasicBeanDisplayViewInterface;
import de.gabjee.plcctrl.client.view.BaseView;

public class BasicBeanDisplayView extends BaseView implements BasicBeanDisplayViewInterface {

    private Label name = new Label();
    private Label description = new Label();

    @Override
    protected Widget createWidget() {
        VerticalPanel mainPanel = new VerticalPanel();
        setStyleName("display");
        name.addStyleName("name");
        description.addStyleName("description");
        mainPanel.add(name);
        mainPanel.add(description);
        return mainPanel;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    @Override
    public void setDescription(String description) {
        this.description.setText(description);
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }
}
