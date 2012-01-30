package de.gabjee.plcctrl.client.bean;

import java.util.List;

public class ProcessVarBeanSet extends BasicBean {

    List<ProcessVarBean> vars;

    public ProcessVarBeanSet(List<ProcessVarBean> vars, Long id, String name, String description) {
        super(id, name, description);
        this.vars = vars;
    }

    public ProcessVarBeanSet() {
    }

    public List<ProcessVarBean> getVars() {
        return vars;
    }

    public void setVars(List<ProcessVarBean> vars) {
        this.vars = vars;
    }
}
