package de.gabjee.plcctrl.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;

/**
 * The async counterpart of <code>DIDOService</code>.
 */
public interface PLCServiceAsync {

    void writeCoil(Boolean state, ProcessVarBean var, AsyncCallback<Integer> callback);

    void readCoil(ProcessVarBean var, AsyncCallback<Boolean> callback);
}
