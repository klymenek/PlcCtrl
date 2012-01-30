package de.gabjee.plcctrl.client.bean;

public class ProcessVarBean extends BasicBean {

    int modbusaddr;
    CategoryBean category;
    PlcBean plc;

    public ProcessVarBean(int modbusaddr, CategoryBean category, PlcBean plc, Long id, String name, String description) {
        super(id, name, description);
        this.modbusaddr = modbusaddr;
        this.category = category;
        this.plc = plc;
    }

    public ProcessVarBean() {
    }

    public int getModbusaddr() {
        return modbusaddr;
    }

    public void setModbusaddr(int modbusaddr) {
        this.modbusaddr = modbusaddr;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public PlcBean getPlc() {
        return plc;
    }

    public void setPlc(PlcBean plc) {
        this.plc = plc;
    }
}
