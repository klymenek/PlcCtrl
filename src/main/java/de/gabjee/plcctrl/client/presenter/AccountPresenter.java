package de.gabjee.plcctrl.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.DatabaseService;
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
    DatabaseService service;
    String user;

    @Override
    public void bindView() {
        view.getShowCart().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                ProcessVarBeanSet varset = service.getProcessVars();
                
                eventBus.displayProcessVarSet(varset);
            }
        });
    }

    public void onLogin(String user) {
        this.user = user;
        view.setUsername(user);
        eventBus.changeBottomWidget(view);
    }
}
