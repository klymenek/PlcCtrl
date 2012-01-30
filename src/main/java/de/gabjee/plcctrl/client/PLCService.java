package de.gabjee.plcctrl.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("plc")
public interface PLCService extends RemoteService {

    Integer writeCoil(Boolean state, ProcessVarBean var);

    Boolean readCoil(ProcessVarBean var);
}
