package com.example.hendry.testtopedbrowse.interactor;

import android.util.Log;

import com.example.hendry.testtopedbrowse.network.model.BrowseProductModel;
import com.example.hendry.testtopedbrowse.network.model.Product;
import com.example.hendry.testtopedbrowse.network.service.BrowseApiService;
import com.example.hendry.testtopedbrowse.view.ProductView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Hendry on 2/14/2017.
 */

public class ProductInteractorImpl implements ProductInteractor {

    private final BrowseApiService browseApiService;

    public interface InterfaceNetwork{
        void onSuccess(List<Product> productList);
        void onError();
        void onComplete();
    }

    public ProductInteractorImpl (){
        browseApiService = new BrowseApiService();
    }

    @Override
    public void getProducts(HashMap<String, String> data,
                            InterfaceNetwork interfaceNetwork,
                            CompositeDisposable compositeDisposable) {
        compositeDisposable.add(
                browseApiService.api.browseProducts(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<Response<BrowseProductModel>>() {
                    @Override
                    public void onNext(Response<BrowseProductModel> browseProductModelResponse) {
                        Log.d("Test", "getProduct2 onNext");
                        interfaceNetwork.onSuccess(browseProductModelResponse.body().getData().getProducts());
                    }

                    @Override
                    public void onError(Throwable e) {
                        interfaceNetwork.onError();
                    }

                    @Override
                    public void onComplete() {
                        interfaceNetwork.onComplete();
                    }
                }));

    }

}
