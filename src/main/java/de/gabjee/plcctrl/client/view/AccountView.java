package de.gabjee.plcctrl.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.AccountPresenter.AccountViewInterface;

public class AccountView extends BaseView implements AccountViewInterface {

    private Button showCart = new Button("Show Cart");
    private Label username = new Label();

    @Override
    protected Widget createWidget() {
        HorizontalPanel mainPanel = new HorizontalPanel();
        mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        mainPanel.add(new Label("Welcome"));
        mainPanel.add(username);
        mainPanel.add(showCart);

        mainPanel.setStyleName("bar");
        username.addStyleName("username");
        return mainPanel;
    }

    @Override
    public HasClickHandlers getShowCart() {
        return showCart;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    @Override
    public void setUsername(String username) {
        this.username.setText(username);
    }
}
