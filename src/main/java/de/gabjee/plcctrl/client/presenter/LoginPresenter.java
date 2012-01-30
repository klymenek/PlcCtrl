package de.gabjee.plcctrl.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HasValue;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.Constants;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.view.LoginView;
import de.gabjee.plcctrl.client.widget.IView;

@Presenter(view = LoginView.class)
public class LoginPresenter extends LazyPresenter<LoginPresenter.LoginViewInterface, MyEventBus> {

    public interface LoginViewInterface extends LazyView, IView {

        HasValue<String> getUserName();

        HasClickHandlers getLoginButton();
    }

    @Override
    public void bindView() {
        view.getLoginButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String username = view.getUserName().getValue();
                if ((username == null) || (username.length() == 0)) {
                    eventBus.displayMessage("Please enter your username");
                } else {
                    Cookies.setCookie(Constants.USERNAME, username);
                    eventBus.login(username);
                    eventBus.displayMessage("");
                }
            }
        });
    }

    public void onStart() {
        String username = Cookies.getCookie(Constants.USERNAME);
        if (username == null) {
            eventBus.changeBottomWidget(view);
        } else {
            eventBus.login(username);
        }
    }
}
