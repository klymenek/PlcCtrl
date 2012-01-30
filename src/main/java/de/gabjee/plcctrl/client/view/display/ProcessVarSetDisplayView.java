package de.gabjee.plcctrl.client.view.display;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.display.ProcessVarSetDisplayPresenter.ProcessVarSetDisplayViewInterface;
import de.gabjee.plcctrl.client.view.BaseView;

public class ProcessVarSetDisplayView extends BaseView implements ProcessVarSetDisplayViewInterface {

    private VerticalPanel mainPanel = new VerticalPanel();

    @Override
    protected Widget createWidget() {
        setStyleName("display");
        return mainPanel;
    }

    @Override
    public void clear() {
        mainPanel.clear();
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    @Override
    public void addProcessVar(String name, String description, String modbusaddr) {
        mainPanel.add(new HTML(buildElement(name, description, modbusaddr)));
    }

    private String buildElement(String name, String description, String modbusaddr) {
        StringBuilder element = new StringBuilder(200);
        element.append("<div><span class=\"name\">");
        element.append(name);
        element.append("</span><span class=\"price\" >");
        element.append(modbusaddr);
        element.append("</span></div><div>");
        element.append(description);
        element.append("<div>");
        return element.toString();
    }
}
