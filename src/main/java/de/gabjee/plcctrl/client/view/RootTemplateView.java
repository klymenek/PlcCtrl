package de.gabjee.plcctrl.client.view;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.RootTemplatePresenter.RootTemplateViewInterface;

public class RootTemplateView extends BaseView implements RootTemplateViewInterface {

    private Grid table = new Grid(4, 1);
    private Label messageBar = new Label();

    @Override
    protected Widget createWidget() {
        messageBar.setStyleName("messageBar");
        table.setWidget(1, 0, messageBar);
        return table;
    }

    @Override
    public void setBottomWidget(Widget w) {
        table.setWidget(3, 0, w);
    }

    @Override
    public void setMainWidget(Widget w) {
        table.setWidget(2, 0, w);
    }

    @Override
    public void setTopWidget(Widget w) {
        table.setWidget(0, 0, w);
    }

    @Override
    public void clearMainWidget() {
        Widget w = table.getWidget(2, 0);
        if (w != null) {
            w.removeFromParent();
        }
    }

    @Override
    public void setMessage(String message) {
        messageBar.setText(message);
    }
}
