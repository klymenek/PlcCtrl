package de.gabjee.plcctrl.client.bean;

public class CategoryBean extends BasicBean {

    public CategoryBean() {
    }

    //TODO Parent Category??? Tree Implementation
    @Override
    public String toString() {
        return getName();
    }
}
