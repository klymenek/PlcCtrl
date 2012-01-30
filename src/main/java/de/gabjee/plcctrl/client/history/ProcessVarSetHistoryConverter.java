package de.gabjee.plcctrl.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.History;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;

@History
public class ProcessVarSetHistoryConverter extends AbstractHistoryConverter<ProcessVarBeanSet> {

    public String onDisplayProcessVarSet(ProcessVarBeanSet plc) {
        return convertToToken(plc);
    }

    @Override
    void serviceCall(Long id, AsyncCallback<ProcessVarBeanSet> callback) {
        service.getProcessVars(callback);
    }

    @Override
    void sendEvent(MyEventBus eventBus, ProcessVarBeanSet result) {
        eventBus.displayProcessVarSet(result);
    }
}
