package de.gabjee.plcctrl.client.bean;

public class UserBean extends BasicBean {
    
    //TODO password

    public UserBean() {
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
