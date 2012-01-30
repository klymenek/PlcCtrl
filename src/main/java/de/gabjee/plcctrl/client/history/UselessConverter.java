package de.gabjee.plcctrl.client.history;

import com.mvp4g.client.annotation.History;
import com.mvp4g.client.event.EventBusWithLookup;
import com.mvp4g.client.history.HistoryConverter;

@History
public class UselessConverter implements HistoryConverter<EventBusWithLookup> {

    @Override
    public void convertFromToken(String eventType, String param, EventBusWithLookup eventBus) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isCrawlable() {
        return false;
    }
}
