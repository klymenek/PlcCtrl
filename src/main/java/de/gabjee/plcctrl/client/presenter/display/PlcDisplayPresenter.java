package de.gabjee.plcctrl.client.presenter.display;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.presenter.view_interface.display.BasicBeanDisplayViewInterface;
import de.gabjee.plcctrl.client.view.display.PlcDisplayView;

@Presenter(view = PlcDisplayView.class)
public class PlcDisplayPresenter extends LazyPresenter<PlcDisplayPresenter.PlcDisplayViewInterface, MyEventBus> {

    public interface PlcDisplayViewInterface extends BasicBeanDisplayViewInterface {

        void setIp(String code);
        void setPort(int port);
    }

    public void onDisplayPlc(PlcBean plc) {
        view.setName(plc.getName());
        view.setDescription(plc.getDescription());
        view.setIp(plc.getIp());
        view.setPort(plc.getPort());
        eventBus.changeMainWidget(view);
    }
}
