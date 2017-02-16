package com.example.hendry.testtopedbrowse.presenter;

import android.os.Bundle;

import com.example.hendry.testtopedbrowse.network.model.Product;
import com.example.hendry.testtopedbrowse.view.ProductView;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hendry on 2/14/2017.
 */

public interface ProductPresenter {
    void onInitSearchProduct(String keyword,
                         int start,
                         CompositeDisposable compositeDisposable);
    void loadMore( int startFrom,
                    CompositeDisposable compositeDisposable);
}
