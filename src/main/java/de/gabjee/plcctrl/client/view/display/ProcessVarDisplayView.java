package de.gabjee.plcctrl.client.view.display;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.display.ProcessVarDisplayPresenter.ProcessVarDisplayViewInterface;

public class ProcessVarDisplayView extends BasicBeanDisplayView implements ProcessVarDisplayViewInterface {

    private ToggleButton var = new ToggleButton();

    @Override
    protected Widget createWidget() {
        VerticalPanel mainPanel = (VerticalPanel) super.createWidget();
        HorizontalPanel panel = new HorizontalPanel();
        panel.add(new Label("ProcessVar"));
        panel.add(var);
        var.addStyleName("processvar");
        mainPanel.add(panel);
        return mainPanel;
    }
}
