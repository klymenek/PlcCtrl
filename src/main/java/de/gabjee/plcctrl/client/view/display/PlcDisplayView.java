package de.gabjee.plcctrl.client.view.display;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.display.PlcDisplayPresenter.PlcDisplayViewInterface;

public class PlcDisplayView extends BasicBeanDisplayView implements PlcDisplayViewInterface {

    private Label ip = new Label();
    private Label port = new Label();

    @Override
    protected Widget createWidget() {
        VerticalPanel mainPanel = (VerticalPanel) super.createWidget();
        HorizontalPanel panel = new HorizontalPanel();
        panel.add(new Label("Code"));
        panel.add(ip);
        panel.add(port);
        ip.addStyleName("price");
        port.addStyleName("price");
        mainPanel.add(panel);
        return mainPanel;
    }

    @Override
    public void setIp(String ip) {
        this.ip.setText(ip);
    }

    @Override
    public void setPort(int port) {
        this.ip.setText(String.valueOf(port));
    }
}
