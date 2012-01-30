package de.gabjee.plcctrl.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.LoginPresenter.LoginViewInterface;

public class LoginView extends BaseView implements LoginViewInterface {

    private TextBox username = new TextBox();
    private Button login = new Button("Login");

    @Override
    protected Widget createWidget() {
        HorizontalPanel mainPanel = new HorizontalPanel();
        mainPanel.setStyleName("bar");

        mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        mainPanel.add(username);
        mainPanel.add(login);

        return mainPanel;
    }

    @Override
    public HasClickHandlers getLoginButton() {
        return login;
    }

    @Override
    public HasValue<String> getUserName() {
        return username;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }
}
