package de.gabjee.plcctrl.client.bean;

public class PlcBean extends BasicBean {

    String ip;
    int port;

    public PlcBean(String ip, int port, Long id, String name, String description) {
        super(id, name, description);
        this.ip = ip;
        this.port = port;
    }

    public PlcBean() {
        //nothing to do
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "id=" + getId() + ", name=" + getName();
    }
}
