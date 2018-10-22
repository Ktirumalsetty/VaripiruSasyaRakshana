package org.irri.varipirusasyarakshna;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.irri.varipirusasyarakshna.adapter.MyAdapter;
import org.irri.varipirusasyarakshna.model.FindImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HowToIdentifyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HowToIdentifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HowToIdentifyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String style = " <body style=\"text-align:justify;color:black;font-size:110%;\">";

    private OnFragmentInteractionListener mListener;

    TextView mTextViewContent;
    WebView mWebView;
    ImageView mImageViewOne;
    RecyclerView mRecyclerView;

//    int[] mSudiTheguluImageUrls ={R.drawable.img_aragya_panta,R.drawable.aragya_panta_r};
//    String[] mSudiImageTitles = {"test","test2"};
    List<FindImage> mFindImages;
    Map<String,Integer> mSudimap = new HashMap() {{
        put("దోమ పోటు - తొలిదశ", R.drawable.sudi_1);
        put("దోమ పోటు తుదిదశ", R.drawable.sudi_2);
        put("గోధుమ వర్ణపు దోమ పురుగులు", R.drawable.sudi_3);
        put("తెల్ల వీపు దోమ పురుగులు", R.drawable.sudi_4);
        put("కుబుసము లాంటి దోమల చర్మము", R.drawable.sudi_5);
    }};

    public HowToIdentifyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HowToIdentifyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HowToIdentifyFragment newInstance(String param1, String param2) {
        HowToIdentifyFragment fragment = new HowToIdentifyFragment();
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
//            if (mParam1.equals("sudi")){
//                List<FindImage> values = mSudimap.values().stream().collect(Collectors.toList());
//
//            }
            if (mParam1.equals("sudi")){
                mFindImages = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : mSudimap.entrySet()) {
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    mFindImages.add(new FindImage(entry.getKey().toString(),mSudimap.get(entry.getKey().toString())));
                }
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_how_to_identify, container, false);
        mTextViewContent = view.findViewById(R.id.tv_content);
        mWebView = view.findViewById(R.id.webview);
//        mImageViewOne = view.findViewById(R.id.image1);
        mRecyclerView = view.findViewById(R.id.rv_images);
        TextView mTvNavigateTab2 = view.findViewById(R.id.tv_navigate_tab2);
        mTvNavigateTab2.setPaintFlags(mTvNavigateTab2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTvNavigateTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager  viewPager = (ViewPager) getActivity().findViewById(
                        R.id.container);
                viewPager.setCurrentItem(1);
            }
        });
        loadContent(R.string.sudi_thegulu_identify);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                mImageViewOne.setImageDrawable(getResources().getDrawable(R.drawable.rice_protection));
                GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(),2);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                MyAdapter adapter = new MyAdapter(getActivity(),mFindImages);
                mRecyclerView.setAdapter(adapter);
            }
        }, 1000);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void loadContent(int content) {
        if (mWebView != null)
            mWebView.loadData(style + getString(content) + "</body>", "text/html; charset=utf-8", "utf-8");

    }
}
