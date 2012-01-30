package de.gabjee.plcctrl.client.presenter;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import de.gabjee.plcctrl.client.DatabaseServiceAsync;
import de.gabjee.plcctrl.client.MyEventBus;
import de.gabjee.plcctrl.client.bean.BasicBean;
import de.gabjee.plcctrl.client.bean.CategoryBean;
import de.gabjee.plcctrl.client.bean.PlcBean;
import de.gabjee.plcctrl.client.view.TopBarView;
import de.gabjee.plcctrl.client.widget.IView;
import java.util.List;

@Presenter(view = TopBarView.class)
public class TopBarPresenter extends LazyPresenter<TopBarPresenter.TopBarViewInterface, MyEventBus> {

    public interface TopBarViewInterface extends LazyView, IView {

        String getSelectedCategory();

        void setSelectedCategory(int index);

        void addCategory(String text, String value);

        String getSelectedPlc();

        void setSelectedPlc(int index);

        void addPlc(String text, String value);

        HasClickHandlers getShowCategoryButton();

        HasClickHandlers getShowPlcButton();

        HasValue<Boolean> getSave();
    }
    @Inject
    private DatabaseServiceAsync service = null;
    private List<BasicBean> categorys;
    private CategoryBean categorySelected = null;
    private List<BasicBean> plcs;
    private PlcBean plcSelected = null;

    @Override
    public void bindView() {
        view.getShowPlcButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String plc = view.getSelectedPlc();
                service.getPlc(getIdByName(plc), new AsyncCallback<PlcBean>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        //do sthg						
                    }

                    @Override
                    public void onSuccess(PlcBean deal) {
                        plcSelected = deal;
                        eventBus.displayPlc(deal);
                    }
                });
            }
        });

        view.getShowCategoryButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String category = view.getSelectedCategory();
                service.getCategory(getIdByName(category), new AsyncCallback<CategoryBean>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        //do sthg						
                    }

                    @Override
                    public void onSuccess(CategoryBean category) {
                        categorySelected = category;
                        eventBus.displayCategory(category);
                    }
                });
            }
        });

        view.getSave().addValueChangeHandler(new ValueChangeHandler<Boolean>() {

            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                eventBus.setHistoryStored(event.getValue());
            }
        });
    }

    public void onStart() {
        service.getPlcs(new AsyncCallback<List<BasicBean>>() {

            @Override
            public void onFailure(Throwable caught) {
                //do sthg				
            }

            @Override
            public void onSuccess(List<BasicBean> plcs) {
                service.getCategorys(new AsyncCallback<List<BasicBean>>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        //do sthg				
                    }

                    @Override
                    public void onSuccess(List<BasicBean> categories) {
                        TopBarPresenter.this.categorys = categories;
                        for (BasicBean category : categories) {
                            view.addCategory(category.getName(), category.getId().toString());
                        }

                        if (categorySelected != null) {
                            view.setSelectedCategory(categories.indexOf(categorySelected));
                        }
                        eventBus.changeTopWidget(view);
                    }
                });

                TopBarPresenter.this.plcs = plcs;
                for (BasicBean plc : plcs) {
                    view.addPlc(plc.getName(), plc.getId().toString());
                }

                if (plcSelected != null) {
                    view.setSelectedPlc(plcs.indexOf(plcSelected));
                }

            }
        });
    }

    public void onDisplayPlc(PlcBean bean) {
        if ((bean != null) && (!bean.equals(plcSelected))) {
            plcSelected = bean;
            if (plcs != null) {
                view.setSelectedPlc(plcs.indexOf(plcSelected));
            }
        }
    }

    public void onDisplayCategory(CategoryBean bean) {
        if ((bean != null) && (!bean.equals(categorySelected))) {
            categorySelected = bean;
            if (categorys != null) {
                view.setSelectedPlc(categorys.indexOf(categorySelected));
            }
        }
    }

    public void onInit() {
        view.setSelectedCategory(0);
        view.setSelectedPlc(0);
    }

    private Long getIdByName(String category) {
        Long id = null;
        for (BasicBean basicBean : categorys) {
            if (basicBean.getName().equals(category)) {
                id = basicBean.getId();
                break;
            }
        }
        return id;
    }
}
