package de.gabjee.plcctrl.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.gabjee.plcctrl.client.bean.BasicBean;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBean;
import de.gabjee.plcctrl.client.bean.ProcessVarBeanSet;
import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("database")
public interface DatabaseService extends RemoteService {

    Boolean savePlc(PlcBean plc);

    Boolean updatePlc(PlcBean plc);

    Boolean deletePlc(Long plc);

    PlcBean getPlc(Long id);

    List<BasicBean> getPlcs();

    Boolean saveCategory(CategoryBean category);

    Boolean updateCategory(CategoryBean category);

    Boolean deleteCategory(Long category);

    CategoryBean getCategory(Long id);

    List<BasicBean> getCategorys();

    Boolean saveProcessVar(ProcessVarBean var);

    Boolean updateProcessVar(ProcessVarBean var);

    Boolean deleteProcessVar(Long var);

    ProcessVarBean getProcessVar(Long id);

    ProcessVarBeanSet getProcessVarsByCategory(Long category);

    ProcessVarBeanSet getProcessVarsByPlc(Long plc);

    ProcessVarBeanSet getProcessVars();
    
    List<ProcessVarBean> getProcessVarsAll();
}
