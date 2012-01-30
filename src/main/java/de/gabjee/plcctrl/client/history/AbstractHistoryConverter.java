package de.gabjee.plcctrl.client.history;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.history.HistoryConverter;
import de.gabjee.plcctrl.client.Constants;
import de.gabjee.plcctrl.client.DatabaseServiceAsync;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.BasicBean;

public abstract class AbstractHistoryConverter<T extends BasicBean> implements HistoryConverter<MyEventBus> {

    @Inject
    protected DatabaseServiceAsync service = null;

    @Override
    public void convertFromToken(final String eventType, String param, final MyEventBus eventBus) {
        String username = Cookies.getCookie(Constants.USERNAME);
        if (username == null) {
            eventBus.displayMessage("Please login to display your cart.");
        } else {
            String[] idTab = (param == null) ? null : param.split("=");

            if ((idTab != null) && (idTab.length > 1)) {

                serviceCall(Long.parseLong(idTab[1]), new AsyncCallback<T>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onSuccess(T result) {
                        sendEvent(eventBus, result);
                    }
                });
            }
        }
    }

    @Override
    public boolean isCrawlable() {
        return false;
    }

    protected String convertToToken(T form) {
        return "id=" + form.getId();
    }

    abstract void serviceCall(Long id, AsyncCallback<T> callback);

    abstract void sendEvent(MyEventBus eventBus, T result);
}
