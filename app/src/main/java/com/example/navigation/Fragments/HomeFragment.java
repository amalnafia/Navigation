package com.example.navigation.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigation.Adapter.HomeAdapter;
import com.example.navigation.Model.CategoryDataModelResponse;
import com.example.navigation.Model.CommonObject;
import com.example.navigation.Model.HeaderRequest;
import com.example.navigation.Model.HeaderResponse;
import com.example.navigation.Model.HomeSliderDataRequest;
import com.example.navigation.Model.ImageSliderDataModelResponse;
import com.example.navigation.R;
import com.example.navigation.Rest.ApiClient;
import com.example.navigation.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class HomeFragment extends Fragment {
    private HomeAdapter homeAdapter;

    @BindView(R.id.home_recycler_view)
    RecyclerView homeRecyclerView;
    List<CommonObject> commonObjectList = new ArrayList<>();
    List<String> imageList= new ArrayList<>();
    private List<CategoryDataModelResponse> categoryList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeAdapter = new HomeAdapter(getActivity());
        homeRecyclerView.setAdapter(homeAdapter);
        getCommonObject();
        return view;
    }

    private void getCommonObject() {
                new CompositeDisposable().add(ApiClient.getClient().create(ApiInterface.class).getCategory(getHeaderRequest()).
                        observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, this::handleError));


    }

    private HeaderRequest getHeaderRequest() {
        return new HeaderRequest("test ", new HomeSliderDataRequest(-1, 1),
                "04525e53150cf718", "2",
                "dQSMs86iUjk:APA91bHDG_MhtLyV47l1h8hd__IAGNRNgP_fjdDG_aGQIvf7tp7Osf_ut71shoZ6jRwHNsCEbHKY6Llkj8IY0FaFOCYTtcMkNErRpLfRo-LfGtbkMZyHL17BOWgY35M3S-eLKWVBKDLW"
                , "Device model: SM-N950F ,Android version: 9 , Api level: 28", 120, "1");
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
    }

    private void handleResponse(HeaderResponse<List<CategoryDataModelResponse>> categoryDataModelResponseHeaderResponse) {
        if (categoryDataModelResponseHeaderResponse.getResultcode() == 1) {
            if (categoryDataModelResponseHeaderResponse.getData() != null) {
                categoryList.addAll(categoryDataModelResponseHeaderResponse.getData());
                requestImages();
            }
        }

    }

    private void requestImages() {
        new CompositeDisposable().add(ApiClient.getClient().
                create(ApiInterface.class).getImageSlider(getHeaderRequest()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse2, this::handleError));

    }

    private void handleResponse2(HeaderResponse<List<ImageSliderDataModelResponse>> imageSliderDataModelResponseHeaderResponse) {
        if (imageSliderDataModelResponseHeaderResponse.getResultcode() == 1) {
            if (imageSliderDataModelResponseHeaderResponse.getData() != null) {
                imageList.add(imageSliderDataModelResponseHeaderResponse.getData().get(0).getMediaPromotionImage());
                commonObjectList.add(new CommonObject(categoryList, imageList));
                homeAdapter.setCommonObject(commonObjectList);
            }
        }

    }


}
