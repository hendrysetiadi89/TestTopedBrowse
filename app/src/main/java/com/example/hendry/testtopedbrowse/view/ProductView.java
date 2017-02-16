package com.example.hendry.testtopedbrowse.view;

import com.example.hendry.testtopedbrowse.network.model.Product;

import java.util.List;

/**
 * Created by Hendry on 2/14/2017.
 */

public interface ProductView {
    void setAdapterData(List<Product> data);
    void showLoadingProgress(boolean isShow);
}
