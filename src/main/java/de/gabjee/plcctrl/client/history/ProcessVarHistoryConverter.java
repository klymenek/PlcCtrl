package de.gabjee.plcctrl.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.History;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;

@History
public class ProcessVarHistoryConverter extends AbstractHistoryConverter<ProcessVarBean> {

    public String onDisplayProcessVar(ProcessVarBean plc) {
        return convertToToken(plc);
    }

    @Override
    void serviceCall(Long id, AsyncCallback<ProcessVarBean> callback) {
        service.getProcessVar(id, callback);
    }

    @Override
    void sendEvent(MyEventBus eventBus, ProcessVarBean result) {
        eventBus.displayProcessVar(result);
    }
}
