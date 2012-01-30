package de.gabjee.plcctrl.client.presenter.display;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.presenter.view_interface.display.BasicBeanDisplayViewInterface;
import de.gabjee.plcctrl.client.view.display.ProcessVarDisplayView;

@Presenter(view = ProcessVarDisplayView.class)
public class ProcessVarDisplayPresenter extends LazyPresenter<ProcessVarDisplayPresenter.ProcessVarDisplayViewInterface, MyEventBus> {

    public interface ProcessVarDisplayViewInterface extends BasicBeanDisplayViewInterface {

    }

    public void onDisplayProcessVar(ProcessVarBean plc) {
        view.setName(plc.getName());
        view.setDescription(plc.getDescription());
        eventBus.changeMainWidget(view);
    }
}
