package com.example.hendry.testtopedbrowse.presenter;

import com.example.hendry.testtopedbrowse.view.ProductView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hendry on 2/14/2017.
 */

public interface ProductPresenter {
    void onInitSearchProduct(String keyword,
                         int start,
                         ProductView view,
                         CompositeDisposable compositeDisposable);
    void loadMore( int startFrom,
                    ProductView view,
                    CompositeDisposable compositeDisposable);
}
