package com.example.hendry.testtopedbrowse.network.api;

import com.example.hendry.testtopedbrowse.network.model.BrowseProductModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Hendry on 2/14/2017.
 */

public interface BrowseApi {
    int CATALOG_OB_RELEASE_DATE = 1;
    int CATALOG_OB_RELEASE_DATE_COUNT_PRODUCT = 2;
    int CATALOG_OB_MOST_PRODUCT = 3;
    int CATALOG_OB_CHEAPEST = 4;
    int CATALOG_OB_MOST_EXPENSIVE = 5;

    int PRODUCT_PROMO = 1;
    int PRODUCT_CHEAPEST = 3;
    int PRODUCT_MOST_EXPENSIVE = 4;
    int PRODUCT_REVIEW = 5;
    int PRODUCT_TALK = 7;
    int PRODUCT_SALES = 8;
    int PRODUCT_NEWEST = 9;
    int PRODUCT_BEST_MATCH = 23;

    String MIDDLE_V1_ACE = "/search/v1/";
    String SEARCH_V1_SHOP = "v1/shop";
    String SEARCH_V1_CATALOG = "v1/catalog";
    String SEARCH_V2_CATALOG = "v2.1/catalog";
    String DEVICE = "device";
    String START = "start";
    String ROWS = "rows";
    String SC = "sc"; //  (category id)
    String DEFAULT_SC = "default_sc"; //  (category id)
    String FLOC = "floc"; // (location id)
    String SHIPPING = "shipping"; // (shipping id)
    String SOURCE = "source"; // Source
    String OB = "ob"; // order by value, could be found at wiki
    String PMIN = "pmin";
    String PMAX = "pmax";
    String FSHOP = "fshop";
    String WHOLESALE = "wholesale";
    String CONDITION = "condition";
    String Q = "q"; // (keyword) or (query)
    String H = "h"; // hotlist id
    String ID = "id";
    String NEGATIVE = "negative";
    String HIGHLIGHT = "highlight";
    String TERMS = "terms";
    String FQ = "fq";
    String ID1 = "-id";
    String SHOP_ID = "shop_id";
    String BREADCRUMB = "breadcrumb";
    String PREORDER = "preorder";
    String IMAGE_SIZE = "image_size";
    String IMAGE_SQUARE = "image_square";
    String HASHTAG = "hashtag";
    String USER_ID = "user_id";
    String UNIQUE_ID = "unique_id";
    String RETURNABLES = "returnables";


    String SEARCH_V2_PRODUCT = "v2.4/product";

    @GET(SEARCH_V2_PRODUCT)
    Observable<Response<BrowseProductModel>> browseProducts(
            @QueryMap Map<String, String> query
    );
}
