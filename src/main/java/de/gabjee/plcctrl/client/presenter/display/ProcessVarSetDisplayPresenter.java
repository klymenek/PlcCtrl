package de.gabjee.plcctrl.client.presenter.display;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.DatabaseServiceAsync;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import de.gabjee.plcctrl.client.view.display.ProcessVarSetDisplayView;
import de.gabjee.plcctrl.client.widget.IView;

@Presenter(view = ProcessVarSetDisplayView.class)
public class ProcessVarSetDisplayPresenter extends LazyPresenter<ProcessVarSetDisplayPresenter.ProcessVarSetDisplayViewInterface, MyEventBus> {

    public interface ProcessVarSetDisplayViewInterface extends LazyView, IView {

        void clear();

        void addProcessVar(String name, String description, String modbusaddr);
    }
    @Inject
    private DatabaseServiceAsync service = null;
    
    public void onDisplayProcessVarSet(ProcessVarBeanSet varset) {
        view.clear();
        service.getProcessVars(new AsyncCallback<ProcessVarBeanSet>() {

            @Override
            public void onFailure(Throwable caught) {
                //do sthg						
            }

            @Override
            public void onSuccess(ProcessVarBeanSet vars) {

                for (ProcessVarBean var : vars.getVars()) {
                    view.addProcessVar(var.getName(), var.getDescription(), String.valueOf(var.getModbusaddr()));
                }

                eventBus.changeMainWidget(view);
            }
        });
    }
}
