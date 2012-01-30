package de.gabjee.plcctrl.client.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.view.UselessView;

@Presenter( view = UselessView.class )
public class UselessPresenter extends BasePresenter<UselessView, MyEventBus> {

}
