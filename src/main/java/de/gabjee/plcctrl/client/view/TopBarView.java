package de.gabjee.plcctrl.client.view;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.presenter.TopBarPresenter.TopBarViewInterface;

public class TopBarView extends BaseView implements TopBarViewInterface {

    private ListBox plc = new ListBox();
    private ListBox category = new ListBox();
    private Button showPlc = new Button("SHOW");
    private Button showCategory = new Button("SHOW");
    private CheckBox save = new CheckBox("Save in History");

    @Override
    protected Widget createWidget() {
        HorizontalPanel mainPanel = new HorizontalPanel();

        save.setValue(true);

        mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        mainPanel.add(new Label("Products :"));
        mainPanel.add(category);
        mainPanel.add(showCategory);
        mainPanel.add(new Label("Deals :"));
        mainPanel.add(plc);
        mainPanel.add(showPlc);
        mainPanel.add(save);

        mainPanel.setStyleName("bar");

        return mainPanel;
    }

    @Override
    public HasClickHandlers getShowPlcButton() {
        return showPlc;
    }

    @Override
    public HasClickHandlers getShowCategoryButton() {
        return showCategory;
    }

    @Override
    public HasValue<Boolean> getSave() {
        return save;
    }

    @Override
    public Widget getViewWidget() {
        return this;
    }

    @Override
    public void addPlc(String text, String value) {
        plc.addItem(text, value);
    }

    @Override
    public void addCategory(String text, String value) {
        category.addItem(text, value);
    }

    @Override
    public String getSelectedPlc() {
        return plc.getValue(plc.getSelectedIndex());
    }

    @Override
    public String getSelectedCategory() {
        return category.getValue(category.getSelectedIndex());
    }

    @Override
    public void setSelectedPlc(int index) {
        plc.setSelectedIndex(index);
    }

    @Override
    public void setSelectedCategory(int index) {
        category.setSelectedIndex(index);
    }
}
