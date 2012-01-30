package de.gabjee.plcctrl.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gabjee.plcctrl.client.presenter.RootTemplatePresenter.RootTemplateViewInterface;

public class RootTemplateView extends BaseView implements RootTemplateViewInterface {

    private Grid table = new Grid(4, 1);
    private Label messageBar = new Label();

    @Override
    protected Widget createWidget() {
        messageBar.setStyleName("messageBar");
        table.setWidget(1, 0, messageBar);
        return table;
    }

    @Override
    public void setBottomWidget(Widget w) {
        table.setWidget(3, 0, w);
    }

    @Override
    public void setMainWidget(Widget w) {
        table.setWidget(2, 0, w);
    }

    @Override
    public void setTopWidget(Widget w) {
        table.setWidget(0, 0, w);
    }

    @Override
    public void clearMainWidget() {
        Widget w = table.getWidget(2, 0);
        if (w != null) {
            w.removeFromParent();
        }
    }

    @Override
    public void setMessage(String message) {
        messageBar.setText(message);
    }
    
    @Override
    public void showErrorPanel(String title, String msg) {
        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        final HTML serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                dialogBox.hide();
            }
        });

        // Show the error message to the user
        dialogBox.setText(title);
        serverResponseLabel.addStyleName("serverResponseLabelError");
        serverResponseLabel.setHTML(msg);
        dialogBox.center();
        closeButton.setFocus(true);
    }
}
