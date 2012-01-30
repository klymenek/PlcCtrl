package de.gabjee.plcctrl.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.DatabaseServiceAsync;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import de.gabjee.plcctrl.client.view.AccountView;
import de.gabjee.plcctrl.client.widget.IView;

@Presenter(view = AccountView.class)
public class AccountPresenter extends LazyPresenter<AccountPresenter.AccountViewInterface, MyEventBus> {

    public interface AccountViewInterface extends LazyView, IView {

        HasClickHandlers getShowCart();

        void setUsername(String username);
    }
    @Inject
    DatabaseServiceAsync service;
    String user;

    @Override
    public void bindView() {
        view.getShowCart().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                service.getProcessVars(new AsyncCallback<ProcessVarBeanSet>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public void onSuccess(ProcessVarBeanSet result) {
                        eventBus.displayProcessVarSet(result);
                    }
                });
            }
        });
    }

    public void onLogin(String username) {
        this.user = username;
        view.setUsername(username);
        eventBus.changeBottomWidget(view);
    }
}
