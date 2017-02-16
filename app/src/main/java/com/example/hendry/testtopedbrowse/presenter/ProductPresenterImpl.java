package com.example.hendry.testtopedbrowse.presenter;

import android.text.TextUtils;

import com.example.hendry.testtopedbrowse.interactor.ProductInteractor;
import com.example.hendry.testtopedbrowse.interactor.ProductInteractorImpl;
import com.example.hendry.testtopedbrowse.network.api.BrowseApi;
import com.example.hendry.testtopedbrowse.view.ProductView;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Hendry on 2/14/2017.
 */

public class ProductPresenterImpl implements ProductPresenter {
    ProductView productView;
    ProductInteractor productInteractor;

    // store lastkeyword for loadMore
    String lastKeyword;
    // store number of items loaded
    int startOffset = 0;

    public ProductPresenterImpl (ProductView productView) {
        this.productView = productView;
        productInteractor = new ProductInteractorImpl();
    }

    @Override
    public void onInitSearchProduct(String keyword,
                                int start,
                                ProductView view, CompositeDisposable compositeDisposable) {
        // https://ace.tokopedia.com/search/v2.4/product?device=android&start=0&rows=12
        // &source=search_product&hashtag=false
        // &terms=true&image_size=200
        // &q=komputer&ob=23
        // &unique_id=c6305821a23a6c98ba12bc6920b22553

        lastKeyword = keyword;

        productView.showLoadingProgress(true);
        HashMap<String, String> data = new HashMap<>();
        data.put(BrowseApi.DEVICE, "android");
        data.put(BrowseApi.START, String.valueOf(start));
        data.put(BrowseApi.ROWS, "12");
        data.put(BrowseApi.Q, keyword);
        data.put(BrowseApi.OB, "23");
        data.put(BrowseApi.IMAGE_SIZE, "200");
        data.put(BrowseApi.IMAGE_SQUARE, "true");
        data.put(BrowseApi.UNIQUE_ID, "c6305821a23a6c98ba12bc6920b22553");
        data.put(BrowseApi.SOURCE, "search_product");
        productInteractor.getProducts(data, view, compositeDisposable);
    }

    @Override
    public void loadMore(int startOffset, ProductView view, CompositeDisposable compositeDisposable) {
        if (TextUtils.isEmpty(lastKeyword)) return;

        productView.showLoadingProgress(true);
        HashMap<String, String> data = new HashMap<>();
        data.put(BrowseApi.DEVICE, "android");
        data.put(BrowseApi.START, String.valueOf( startOffset) );
        data.put(BrowseApi.ROWS, "12");
        data.put(BrowseApi.Q, lastKeyword);
        data.put(BrowseApi.OB, "23");
        data.put(BrowseApi.TERMS, "true");
        data.put(BrowseApi.IMAGE_SIZE, "200");
        data.put(BrowseApi.IMAGE_SQUARE, "true");
        // should be unique per user/ device, currently hardcode
        data.put(BrowseApi.UNIQUE_ID, "c6305821a23a6c98ba12bc6920b22553");
        data.put(BrowseApi.SOURCE, "search_product");
        productInteractor.getProducts(data, view, compositeDisposable);
    }

}
