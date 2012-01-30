package de.gabjee.plcctrl.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gabjee.plcctrl.client.bean.BasicBean;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import java.util.List;

/**
 * The async counterpart of
 * <code>DIDOService</code>.
 */
public interface DatabaseServiceAsync {

    void savePlc(PlcBean plc, AsyncCallback<Boolean> callback);

    void updatePlc(PlcBean plc, AsyncCallback<Boolean> callback);

    void deletePlc(Long plc, AsyncCallback<Boolean> callback);

    void getPlc(Long id, AsyncCallback<PlcBean> callback);

    void getPlcs(AsyncCallback<List<BasicBean>> callback);

    void saveCategory(CategoryBean category, AsyncCallback<Boolean> callback);

    void updateCategory(CategoryBean category, AsyncCallback<Boolean> callback);

    void deleteCategory(Long category, AsyncCallback<Boolean> callback);

    void getCategory(Long id, AsyncCallback<CategoryBean> callback);

    void getCategorys(AsyncCallback<List<BasicBean>> callback);

    void saveProcessVar(ProcessVarBean var, AsyncCallback<Boolean> callback);

    void updateProcessVar(ProcessVarBean var, AsyncCallback<Boolean> callback);

    void deleteProcessVar(Long var, AsyncCallback<Boolean> callback);

    void getProcessVar(Long id, AsyncCallback<ProcessVarBean> callback);

    void getProcessVarsByCategory(Long category, AsyncCallback<ProcessVarBeanSet> callback);

    void getProcessVarsByPlc(Long plc, AsyncCallback<ProcessVarBeanSet> callback);

    void getProcessVars(AsyncCallback<ProcessVarBeanSet> callback);
    
    void getProcessVarsAll(AsyncCallback<List<ProcessVarBean>> callback);
}
