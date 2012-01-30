package de.gabjee.plcctrl.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BasicBean implements IsSerializable {

    private Long id = null;
    private String name = null;
    private String description = null;

    public BasicBean(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public BasicBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasicBean) {
            return (id != null) && id.equals(((BasicBean) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BasicBean{" + "name=" + name + '}';
    }
}
