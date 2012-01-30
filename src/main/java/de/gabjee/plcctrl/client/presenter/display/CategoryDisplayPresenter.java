package de.gabjee.plcctrl.client.presenter.display;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.presenter.view_interface.display.BasicBeanDisplayViewInterface;
import de.gabjee.plcctrl.client.view.display.CategoryDisplayView;

@Presenter(view = CategoryDisplayView.class)
public class CategoryDisplayPresenter extends LazyPresenter<CategoryDisplayPresenter.CategoryDisplayViewInterface, MyEventBus> {

    public interface CategoryDisplayViewInterface extends BasicBeanDisplayViewInterface {
    }

    public void onDisplayCategory(CategoryBean category) {
        view.setName(category.getName());
        view.setDescription(category.getDescription());
        eventBus.changeMainWidget(view);
    }
}
