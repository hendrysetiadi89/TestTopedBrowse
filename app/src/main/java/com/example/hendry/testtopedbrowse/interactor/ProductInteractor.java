package com.example.hendry.testtopedbrowse.interactor;

import com.example.hendry.testtopedbrowse.view.ProductView;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hendry on 2/14/2017.
 */

public interface ProductInteractor {
    void getProducts(HashMap<String, String> data,
                     ProductView view,
                     CompositeDisposable compositeDisposable);
}
