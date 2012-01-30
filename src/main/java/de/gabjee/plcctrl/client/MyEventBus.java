package de.gabjee.plcctrl.client;

import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.NotFoundHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import de.gabjee.plcctrl.client.history.CategoryHistoryConverter;
import de.gabjee.plcctrl.client.history.PlcHistoryConverter;
import de.gabjee.plcctrl.client.history.ProcessVarHistoryConverter;
import de.gabjee.plcctrl.client.history.ProcessVarSetHistoryConverter;
import de.gabjee.plcctrl.client.presenter.AccountPresenter;
import de.gabjee.plcctrl.client.presenter.LoginPresenter;
import de.gabjee.plcctrl.client.presenter.RootTemplatePresenter;
import de.gabjee.plcctrl.client.presenter.TopBarPresenter;
import de.gabjee.plcctrl.client.presenter.display.CategoryDisplayPresenter;
import de.gabjee.plcctrl.client.presenter.display.PlcDisplayPresenter;
import de.gabjee.plcctrl.client.presenter.display.ProcessVarDisplayPresenter;
import de.gabjee.plcctrl.client.presenter.display.ProcessVarSetDisplayPresenter;
import de.gabjee.plcctrl.client.view.RootTemplateView;
import de.gabjee.plcctrl.client.widget.IView;

@Events(startView = RootTemplateView.class, historyOnStart = true)
public interface MyEventBus extends EventBus {

    @Event(handlers = RootTemplatePresenter.class)
    public void changeTopWidget(IView w);

    @Event(handlers = RootTemplatePresenter.class)
    public void changeBottomWidget(IView w);

    @Event(handlers = RootTemplatePresenter.class)
    public void changeMainWidget(IView w);

    @Event(handlers = {RootTemplatePresenter.class, ProcessVarSetDisplayPresenter.class}, historyConverter = ProcessVarSetHistoryConverter.class)
    public void displayProcessVarSet(ProcessVarBeanSet varset);

    @Event(handlers = {RootTemplatePresenter.class, ProcessVarDisplayPresenter.class}, historyConverter = ProcessVarHistoryConverter.class)
    public void displayProcessVar(ProcessVarBean var);

    @Event(handlers = {RootTemplatePresenter.class, CategoryDisplayPresenter.class, TopBarPresenter.class}, historyConverter = CategoryHistoryConverter.class)
    public void displayCategory(CategoryBean category);

    @Event(handlers = {RootTemplatePresenter.class, PlcDisplayPresenter.class, TopBarPresenter.class}, historyConverter = PlcHistoryConverter.class)
    public void displayPlc(PlcBean plc);

    @Event(handlers = RootTemplatePresenter.class)
    public void displayMessage(String message);

    @InitHistory
    @Event(handlers = {RootTemplatePresenter.class, TopBarPresenter.class})
    public void init();

    @NotFoundHistory
    @Event(handlers = RootTemplatePresenter.class)
    public void notFound();

    @Event(handlers = AccountPresenter.class)
    public void login(String username);

    @Start
    @Event(handlers = {TopBarPresenter.class, LoginPresenter.class})
    public void start();
}
