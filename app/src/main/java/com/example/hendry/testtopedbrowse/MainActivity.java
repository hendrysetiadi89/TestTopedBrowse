package com.example.hendry.testtopedbrowse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.hendry.testtopedbrowse.adapter.ProductAdapter;
import com.example.hendry.testtopedbrowse.network.model.Product;
import com.example.hendry.testtopedbrowse.presenter.ProductPresenter;
import com.example.hendry.testtopedbrowse.presenter.ProductPresenterImpl;
import com.example.hendry.testtopedbrowse.view.ProductView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;


public class MainActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener, ProductView {

    private ProductAdapter productAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
//
    @BindView(R.id.fast_scroll)
    VerticalRecyclerViewFastScroller fastScroller;

    // to store layout, helping to load more
    LinearLayoutManager mLayoutManager;

    ProductPresenter productPresenter;

    CompositeDisposable mCompositeDisposable;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Product List");

        initCompositeDisposable();

        unbinder = ButterKnife.bind(this);

        productPresenter = new ProductPresenterImpl(this);

        productAdapter = new ProductAdapter(this, null);

        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(productAdapter);

        fastScroller.setRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy <= 0) {
                    // no op when going up
                    return;
                }
                // going down
                boolean canLoadMore = productAdapter.canLoadMore(mLayoutManager);
                if (canLoadMore) {
                    productAdapter.setLoading(true);
                    productPresenter.loadMore(
                            productAdapter.getProductSize(),
                            mCompositeDisposable);
                }
            }
        });
        recyclerView.addOnScrollListener(fastScroller.getOnScrollListener());
        fastScroller.setVisibility(View.INVISIBLE);

//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Test");
//                subscriber.onCompleted();
//            }
//        });
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.i("Test", "Completed");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i("Test", "OnNext "+ s);
//            }
//        };
//        observable
//                .map(s -> {return s + " - Dan";})
//                .subscribe(s -> Log.i("Test", "OnNext "+ s));

//        testQuery()
//                .flatMap(new Func1<List<String>, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(List<String> strings) {
//                        return Observable.from(strings);
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.i("Test", s);
//                    }
//                });

        Observable.zip(
                testQuery(),
                Observable.just("Hello"),
                (List<String> strings, String s) -> {
                    strings.add(s);
                    return strings;
                }
                )
                .flatMap(Observable::fromIterable)
                .subscribe(s -> Log.i("Test", s));
    }


    public Observable<List<String>> testQuery (){
        List<String> stringList = new ArrayList<>();
        stringList.add("satu");
        stringList.add("dua");
        stringList.add("tiga");
        return Observable.just( stringList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");
        return true;
    }

    public void initCompositeDisposable(){
        if (null == mCompositeDisposable) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null!= mCompositeDisposable) {
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
    }


    @Override
    public boolean onQueryTextSubmit(String keyword) {
        productAdapter.setData(null);
        productAdapter.notifyDataSetChanged();
        Log.i("Test", "On Submit Search");
        productPresenter.onInitSearchProduct(keyword,
                0,
                mCompositeDisposable);
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService (Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // TODO on Change, give recommendation
        Log.i("Test", "On Query Text Change");
        return true;
    }

    @Override
    public void setAdapterData(List<Product> data) {
        // might come from load more
        if (productAdapter.isIsLoading()) {
            productAdapter.setLoading(false);
            productAdapter.addMoreData(data);
            fastScroller.setVisibility(View.VISIBLE);
        }
        else {
            productAdapter.setData(data);
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoadingProgress(boolean isShow) {
        // TODO show progress
        if (isShow) {

        }
        else {

        }
    }
}
