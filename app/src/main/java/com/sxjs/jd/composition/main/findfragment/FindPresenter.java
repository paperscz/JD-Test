package com.sxjs.jd.composition.main.findfragment;

import com.sxjs.jd.entities.FindsBean;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.composition.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by admin on 2017/3/22.
 */

public class FindPresenter extends BasePresenter implements FindContract.Presenter{
    private DataManager mDataManager;

    private FindContract.View mFindView;
    @Inject
    public FindPresenter(DataManager mDataManager, FindContract.View view) {
        this.mDataManager = mDataManager;
        this.mFindView = view;

    }


    @Override
    public void getFindData() {
        addDisposabe(mDataManager.getData(new DisposableObserver<FindsBean>() {
            @Override
            public void onNext(FindsBean findsBean) {
                mFindView.setFindData(findsBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },FindsBean.class, "find.txt"));
    }

    @Override
    public void getMoreFindData() {
        addDisposabe(mDataManager.getData(new DisposableObserver<FindsBean>() {
            @Override
            public void onNext(FindsBean findsBean) {
                mFindView.setMoreData(findsBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },FindsBean.class, "find.txt"));
    }
}
