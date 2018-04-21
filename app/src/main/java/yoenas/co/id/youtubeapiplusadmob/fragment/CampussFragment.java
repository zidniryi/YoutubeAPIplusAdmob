package yoenas.co.id.youtubeapiplusadmob.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yoenas.co.id.youtubeapiplusadmob.network.ConfigRetrofit;
import yoenas.co.id.youtubeapiplusadmob.R;
import yoenas.co.id.youtubeapiplusadmob.adapter.MyAdapter;
import yoenas.co.id.youtubeapiplusadmob.responseServer.ItemsItem;
import yoenas.co.id.youtubeapiplusadmob.responseServer.ResponseYoutube;


/**
 * A simple {@link Fragment} subclass.
 */
public class CampussFragment extends Fragment {


    @BindView(R.id.rvYoutube)
    RecyclerView rvYoutube;
    Unbinder unbinder;

    public CampussFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sports, container, false);

        ambilData();

        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    // Todo 4
    private void ambilData() {
        new ConfigRetrofit().service.getVideo("snippet"
                , "25"
                , "Apple"
                , "ID"
                , "sport"
                , "AIzaSyB63m3JSWR6qXaL-mgMvyWbh_ktNRpjHBg")
                .enqueue(new Callback<ResponseYoutube>() {
                    @Override
                    public void onResponse(Call<ResponseYoutube> call, Response<ResponseYoutube> response) {

                        if (response.isSuccessful()) {
                            ResponseYoutube allJSON = response.body();

                            List<ItemsItem> data = allJSON.getItems();

                            MyAdapter adapter = new MyAdapter(data);
                            rvYoutube.setAdapter(adapter);
                            rvYoutube.setLayoutManager(new LinearLayoutManager(getActivity()));

                            Log.d("ResponseJSON", allJSON.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseYoutube> call, Throwable t) {

                    }
                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
