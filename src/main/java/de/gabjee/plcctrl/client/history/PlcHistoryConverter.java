package de.gabjee.plcctrl.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.History;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.PlcBean;

@History
public class PlcHistoryConverter extends AbstractHistoryConverter<PlcBean> {

    public String onDisplayPlc(PlcBean plc) {
        return convertToToken(plc);
    }

    @Override
    void serviceCall(Long id, AsyncCallback<PlcBean> callback) {
        service.getPlc(id, callback);
    }

    @Override
    void sendEvent(MyEventBus eventBus, PlcBean result) {
        eventBus.displayPlc(result);
    }
}
