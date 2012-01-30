package de.gabjee.plcctrl.client.history;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.History;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.CategoryBean;

@History
public class CategoryHistoryConverter extends AbstractHistoryConverter<CategoryBean> {

    public String onDisplayCategory(CategoryBean category) {
        return convertToToken(category);
    }

    @Override
    void serviceCall(Long id, AsyncCallback<CategoryBean> callback) {
        service.getCategory(id, callback);
    }

    @Override
    void sendEvent(MyEventBus eventBus, CategoryBean result) {
        eventBus.displayCategory(result);
    }
}
