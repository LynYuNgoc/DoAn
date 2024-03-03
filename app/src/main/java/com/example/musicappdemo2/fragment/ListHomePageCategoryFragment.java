package com.example.musicappdemo2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicappdemo2.AlbumSongActivity;
import com.example.musicappdemo2.R;
import com.example.musicappdemo2.classes.AlbumCategoryAdapter;
import com.example.musicappdemo2.classes.AlbumItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListHomePageCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListHomePageCategoryFragment extends Fragment implements AlbumCategoryAdapter.AlbumCategoryOnClickListener{

    ArrayList<AlbumItem> albumItems;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListHomePageCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListHomePageCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListHomePageCategoryFragment newInstance(String param1, String param2) {
        ListHomePageCategoryFragment fragment = new ListHomePageCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initSampleData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_home_page_category, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCategory);
        AlbumCategoryAdapter albumCategoryAdapter = new AlbumCategoryAdapter(albumItems,getContext(), this);
        recyclerView.setAdapter(albumCategoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        return view;
    }

    void initSampleData() {
        albumItems = new ArrayList<AlbumItem>();
        albumItems.add(new AlbumItem("album001","Nhạc Việt", "nhac_viet.jpg", "Nhac Viet"));
        albumItems.add(new AlbumItem("album002","Nhạc Hàn", "nhac_han.jpg", "Nhac Han"));
        albumItems.add(new AlbumItem("album003","Nhạc Trung", "nhac_trung.jpg", "Nhac Trung"));
        albumItems.add(new AlbumItem("album004","Nhạc Âu Mỹ", "nhac_au_my.jpg", "Nhac Au My"));
        albumItems.add(new AlbumItem("album005","Nhạc Nhật", "nhac_nhat.jpg", "Nhac Nhat"));
    }

    @Override
    public void onClickAtItem(int position) {
        Intent i = new Intent(getActivity(), AlbumSongActivity.class);
        i.putExtra("ALBUM_ITEM_EXTRA_KEY_NAME",albumItems.get(position));
        startActivity(i);

    }
}