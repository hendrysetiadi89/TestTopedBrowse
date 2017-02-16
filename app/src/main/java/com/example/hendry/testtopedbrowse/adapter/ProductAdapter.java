package com.example.hendry.testtopedbrowse.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hendry.testtopedbrowse.R;
import com.example.hendry.testtopedbrowse.network.model.Product;
import com.example.hendry.testtopedbrowse.presenter.ProductPresenter;
import com.example.hendry.testtopedbrowse.view.ProductView;

import java.util.List;

/**
 * Created by Hendry on 2/14/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // how many item before loadmore
    public static final int VISIBLE_THRESHOLD = 1;

    //TYPE
    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_LOADING = 2;

    // to indicate is the adapter is in loading state
    boolean mIsLoading;

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageProduct;
        TextView textProduct;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textProduct = (TextView) itemView.findViewById(R.id.text_product);
            imageProduct = (ImageView) itemView.findViewById(R.id.image_product);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            // TODO onclick item
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        public ProgressBar progressBar;
        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        }
    }

    List<Product> productList;
    Context mContext;
    ProductView view;
    public ProductAdapter (Context context, List<Product> productList, ProductView view){
        this.productList = productList;
        this.mContext = context;
        this.view = view;
    }

    public void setData (List<Product> productList){
        this.productList = productList;
    }

    public void addMoreData (List<Product> productList){
        int prevSize = this.productList.size();
        int addedSize = productList.size();
        if (addedSize == 0) return;

        this.productList.addAll(productList);
        this.notifyItemRangeChanged(prevSize, addedSize);

    }

    public boolean canLoadMore(LinearLayoutManager layoutManager){
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition ();
        if (
                this.hasMoreDataToLoad()
                && !mIsLoading
                &&
                layoutManager.getItemCount() <= (
                lastVisibleItemPosition
                        + VISIBLE_THRESHOLD)) {
            return true;
        }
        return false;
    }

    public void setLoading(boolean mIsLoading) {
        this.mIsLoading = mIsLoading;
    }

    public boolean isIsLoading() {
        return mIsLoading;
    }

    private boolean hasMoreDataToLoad (){
        //TODO
        // stub
        return true;
    }

    private void loadMore (){
//        int startIndexForQuery = view.getStartIndexForQuery(TAG);
//        if (context != null && context instanceof DiscoveryActivityPresenter) {
//
//            NetworkParam.Product productParam = ((DiscoveryActivityPresenter) context).getProductParam();
//
//            Log.d(TAG, "Product Params " + productParam.toString());
//            if (productParam == null)
//                return;
//
//            productParam.start = Integer.toString(startIndexForQuery);
//            productParam.breadcrumb = false;
//            discoveryInteractor.getProducts(NetworkParam.generateNetworkParamProduct(productParam));
//        }
//
//        break;
        mIsLoading = true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view;
        switch (viewType) {
            case VIEW_TYPE_LOADING:
                view = inflater.inflate(R.layout.item_loading, parent, false);
                return new LoadingViewHolder(view);
            case VIEW_TYPE_ITEM:
                view = inflater.inflate(R.layout.item_product, parent, false);
                return new ProductViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setVisibility(mIsLoading ? View.VISIBLE : View.INVISIBLE);
        }
        else if (holder instanceof ProductViewHolder){ // item
            ProductViewHolder productViewHolder = (ProductViewHolder) holder;

            Product product = productList.get(position);
            productViewHolder.textProduct.setText(product.getProductName());

            Glide.with(mContext)
                .load(product.getProductImage())
                .into(productViewHolder.imageProduct);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == productList.size()) {
            return VIEW_TYPE_LOADING;
        }
        else {
            return VIEW_TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        if (null == productList || productList.size() == 0) return 0;
        return productList.size() + 1; // for loadmore
    }

    public int getProductSize() {
        return productList.size();
    }
}
