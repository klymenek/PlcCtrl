package de.gabjee.plcctrl.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import de.gabjee.plcctrl.client.view.RootTemplateView;
import de.gabjee.plcctrl.client.widget.IView;

@Presenter(view = RootTemplateView.class)
public class RootTemplatePresenter extends LazyPresenter<RootTemplatePresenter.RootTemplateViewInterface, MyEventBus> {

    public interface RootTemplateViewInterface extends LazyView {

        void setTopWidget(Widget w);

        void clearMainWidget();

        void setMainWidget(Widget w);

        void setBottomWidget(Widget w);

        void setMessage(String message);
        
        void showErrorPanel(String title, String msg);
    }

    public void onChangeTopWidget(IView top) {
        view.setTopWidget(top.getViewWidget());
    }

    public void onChangeBottomWidget(IView bottom) {
        view.setBottomWidget(bottom.getViewWidget());
    }

    public void onChangeMainWidget(IView main) {
        view.setMainWidget(main.getViewWidget());
    }

    public void onDisplayMessage(String message) {
        view.setMessage(message);
    }

    public void onInit() {
        view.clearMainWidget();
        view.setMessage("");
    }

    public void onNotFound() {
        eventBus.init();
        view.setMessage("Page not found");
    }

    public void onDisplayCategory(CategoryBean bean) {
        view.setMessage("");
    }

    public void onDisplayPlc(PlcBean bean) {
        view.setMessage("");
    }

    public void onDisplayProcessVarSet(ProcessVarBeanSet category) {
        view.setMessage("");
    }

    public void onDisplayProcessVar(ProcessVarBean category) {
        view.setMessage("");
    }
    
    public void onError(String title, String msg) {
        view.showErrorPanel(title, msg);
    }
}
