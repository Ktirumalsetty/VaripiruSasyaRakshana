package org.irri.varipirusasyarakshna;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import org.irri.varipirusasyarakshna.model.FindImage;
import org.irri.varipirusasyarakshna.model.MethdodsSource;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProprietaryMethodsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProprietaryMethodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProprietaryMethodsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String style = " <body style=\"text-align:justify;color:black;font-size:100%;\">";
    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView mTextViewContent;
    WebView mWebView;
    String stringRes;

    public ProprietaryMethodsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProprietaryMethodsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProprietaryMethodsFragment newInstance(int param1, String param2) {
        ProprietaryMethodsFragment fragment = new ProprietaryMethodsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            switch (mParam1) {
                case MethdodsSource.SUDI_THEGULU:
                    stringRes = getString(R.string.sudi_thegulu_prop_methods);
                    break;
                case MethdodsSource.THATAKU_THEGULU:
                    stringRes = getString(R.string.thataku_thegulu_prop_methods);
                    break;
                case MethdodsSource.KAMPU_NALLI:
                    stringRes = getString(R.string.kampu_nalli_prop_methods);
                    break;
                case MethdodsSource.THELLA_ROGAM:
                    stringRes = getString(R.string.thella_rogam_prop_methods);
                    break;
                case MethdodsSource.GOTTAPU_ROGAM:
                    stringRes = getString(R.string.gottapu_rogam_prop_methods);
                    break;
                case MethdodsSource.KANDAMU_THOLUCHU_PURUGU:
                    stringRes = getString(R.string.kandamu_tholuchu_prop_methods);
                    break;
                case MethdodsSource.AAKU_NALLI:
                    stringRes = getString(R.string.aaku_nalli_prop_methods);
                    break;

                case MethdodsSource.AGGI_THEGULU:
                    stringRes = getString(R.string.aggi_thegulu_prop_methods);
                    break;
                case MethdodsSource.PAAMU_PODA_THEGULU:
                    stringRes = getString(R.string.paamu_poda_prop_methods);
                    break;
                case MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU:
                    stringRes = getString(R.string.godhuma_rangu_prop_methods);
                    break;
                case MethdodsSource.POTTA_KULLU_THEGULU:
                    stringRes = getString(R.string.potta_kullu_prop_methods);
                    break;
                case MethdodsSource.MAANI_PANDU_THEGULU:
                    stringRes = getString(R.string.mani_pandu_prop_methods);
                    break;
                case MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU:
                    stringRes = getString(R.string.bacteria_aaku_endu_prop_methods);
                    break;
                case MethdodsSource.TUNGRO_VIRUS_THEGULU:
                    stringRes = getString(R.string.tungro_prop_methods);
                    break;
                case MethdodsSource.VOODA_KALUPU_MOKKA:
                    stringRes = getString(R.string.vooda_prop_methods);
                    break;
                case MethdodsSource.THUNGA_JAATHI:
                    stringRes = getString(R.string.thunga_prop_methods);
                    break;
                case MethdodsSource.VEDALPAKU_KALUPU:
                    stringRes = getString(R.string.vedalpaku_aaku_kalupu_prop_methods);
                    break;
                case MethdodsSource.NEETI_KALUPU:
                    stringRes = getString(R.string.neeti_kalupu_prop_methods);
                    break;
                case MethdodsSource.KANKI_NALLI:
                    stringRes = getString(R.string.kanki_nalli_prop_methods);
                case MethdodsSource.GOTTAPU_PURUGU:
                    stringRes = getString(R.string.gottapu_purugu_prop_methods);
                    break;
                case MethdodsSource.HORD_MAGGET:
                    stringRes = getString(R.string.hord_magget_prop_methods);
                    break;
                case MethdodsSource.THAMARA_PURUGULU:
                    stringRes = getString(R.string.thamara_purugu_prop_methods);
                    break;
                case MethdodsSource.RELLU_RALCHU_PURUGU:
                    stringRes = getString(R.string.rellu_ralchu_purugu_prop_methods);
                    break;
                case MethdodsSource.GADDI_JATHULU:
                    stringRes = getString(R.string.gaddi_jathulu_prop_methods);
                    break;
                case MethdodsSource.AROGYA_PANTA_DOS_DONTS:
                    stringRes = getString(R.string.aarogyamina_panta_donts);
                    break;
                case MethdodsSource.BAKANE_THEGULU:
                    stringRes = getString(R.string.bakane_thegulu_prop_methods);
                    break;
                case MethdodsSource.KANDAMU_KULLU_THEGULU:
                    stringRes = getString(R.string.kandam_kullu_thegulu_prop_methods);
                    break;
                case MethdodsSource.VARIGINJA_MARPU_THEGULU:
                    stringRes = getString(R.string.variginja__marpu_thegulu_prop_methods);
                    break;
                case MethdodsSource.NATRAJANI_LOPAM:
                    stringRes = getString(R.string.natrajani_lopam_prop_methods);
                    break;
                case MethdodsSource.BHASWARAM_LOPAM:
                    stringRes = getString(R.string.bhaswara_lopam_prop_methods);
                    break;
                case MethdodsSource.POTASSIUM_LOPAM:
                    stringRes = getString(R.string.potassium_lopam_prop_methods);
                    break;
                case MethdodsSource.GANDHAKAM_LOPAM:
                    stringRes = getString(R.string.gandhakam_lopam_prop_methods);
                    break;
                case MethdodsSource.ZYNC_LOPAM:
                    stringRes = getString(R.string.zync_lopam_prop_methods);
                    break;
                case MethdodsSource.INUMU_LOPAM:
                    stringRes = getString(R.string.inumu_lopam_prop_methods);
                    break;
                case MethdodsSource.CHOWDU_NELALU_LOPAM:
                    stringRes = getString(R.string.chowdu_nelalu_prop_methods);
                    break;

            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_proprietary_methods, container, false);
        mWebView = view.findViewById(R.id.webview);
        WebSettings settings = mWebView.getSettings();
//        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);

//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        loadContent(stringRes);

        return view;
    }

    private void loadContent(String content) {
        if (mWebView != null)
            mWebView.loadData(style + content + "</body>", "text/html; charset=utf-8", "utf-8");

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
}
