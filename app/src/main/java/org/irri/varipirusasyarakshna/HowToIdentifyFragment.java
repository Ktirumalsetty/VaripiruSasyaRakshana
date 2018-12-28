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

import org.irri.varipirusasyarakshna.adapter.GridSpacingItemDecoration;
import org.irri.varipirusasyarakshna.adapter.MyAdapter;
import org.irri.varipirusasyarakshna.model.FindImage;
import org.irri.varipirusasyarakshna.model.MethdodsSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
    private int mParam1;
    private String mParam2;

    String style = " <body style=\"text-align:justify;color:black;font-size:110%;\">";

    private OnFragmentInteractionListener mListener;

//    TextView mTextViewContent;
    TextView mTextViewLabelMethods;
    WebView mWebView;
    ImageView mImageViewOne;
    RecyclerView mRecyclerView;
    TextView mTvNavTab2;
    String mHowToIdentStrRes;

    //    int[] mSudiTheguluImageUrls ={R.drawable.img_aragya_panta,R.drawable.aragya_panta_r};
//    String[] mSudiImageTitles = {"test","test2"};
    List<FindImage> mFindImages;

    Map<String, Integer> mSudimap = new LinkedHashMap() {{
        put("దోమ పోటు - తొలిదశ", R.drawable.sudi_1);
        put("దోమ పోటు తుదిదశ", R.drawable.sudi_2);
        put("గోధుమ వర్ణపు దోమ పురుగులు", R.drawable.sudi_3);
        put("తెల్ల వీపు దోమ పురుగులు", R.drawable.sudi_4);
        put("కుబుసము లాంటి దోమల చర్మము", R.drawable.sudi_5);
    }};

    Map<String, Integer> mThatakuTheguluMap = new LinkedHashMap() {{
        put("పెద్ద పురుగు", R.drawable.thataku_thegulu_pedda_purugu_1);
        put("ఆకు మధ్యలో పిల్ల పురుగు", R.drawable.thataku_thegulu_aaku_pilla_purugu_2);
        put("గోకి తిన్నచారలు", R.drawable.thataku_thegulu_goki_3);
        put("పురుగు సోకిన ఆకులు", R.drawable.thataku_thegulu_purugu_4);

    }};

    Map<String, Integer> mKampuNalliMap = new LinkedHashMap() {{
        put("పిల్ల పురుగులు", R.drawable.kampu_pilla_purugu_1);
        put("పెద్ద పురుగు", R.drawable.kampu_pedda_2);
        put("పురుగు హాని చేసిన గింజలు", R.drawable.kampu_purugu_hani_3);

    }};

    Map<String, Integer> mThellaRogamuMap = new LinkedHashMap() {{
        put("రెక్కల పురుగు", R.drawable.thella_rogam_rekkala_purugu_1);
        put("పిల్ల పురుగు", R.drawable.thella_rogam_pilla_purugu_2);
        put("ఆకు ముడత ఆశించిన పొలము", R.drawable.thella_rogam_aaku_mudatha_asainchina_polam_3);

    }};
    Map<String, Integer> mGottapuRogamuMap = new LinkedHashMap() {{
        put("గొట్టపు పురుగు", R.drawable.gottapu_rogam_gottapu_purugu_1);
        put("ఉల్లి కోడు", R.drawable.gottapu_rogam_vulli_kodu_2);

    }};

    Map<String, Integer> mKandamTholuchuPuruguMap = new LinkedHashMap() {{
        put("గ్రుడ్ల సముదాయము", R.drawable.kandamu_tol_purugu_gudla_samu_1);
        put("తల్లి పురుగు", R.drawable.kandamu_tol_purugu_talli_pur_2);
        put("చనిపోయిన మొవ్వులు", R.drawable.kandamu_tol_purugu_chani_movvalu_3);
        put("తెల్ల కంకి", R.drawable.kandamu_tol_purugu_thella_kanki_4);

    }};

    Map<String, Integer> mAakuNalliMap = new LinkedHashMap() {{
        put("ఆకు నల్లి సోకిన వరి దుబ్బు - ఎర్రగా కనిపిస్తుంది", R.drawable.aaku_nalli_vari_dubba_1);

    }};

    Map<String, Integer> mAggiTheguluMap = new LinkedHashMap() {{
        put("ఆకుల మీద అగ్గి తెగులు", R.drawable.aggi_tegulu_1);
        put("అగ్గి తెగులు ఆశించిన పొలము", R.drawable.aggi_tegulu_2);
        put("కణుపుల మీద అగ్గి తెగులు", R.drawable.aggi_tegulu_3);
        put("మెడవిరుపు తెగులు", R.drawable.aggi_tegulu_4);

    }};

    Map<String, Integer> mPaamuPodaMap = new LinkedHashMap() {{
        put("మట్టలపై పాముపొడ తెగులు", R.drawable.paamu_poda_thegulu_1);
        put("ఆకు మీద పాముపొడ తెగులు మరియు స్ల్కిరోషియా", R.drawable.paamu_poda_thegulu_2);
        put("పాముపొడ తెగులు ఆశించిన పొలము", R.drawable.paamu_poda_thegulu_3);
        put("ఆకు మీద పాముపొడ తెగులు", R.drawable.paamu_poda_thegulu_4);
        put("కంకి మీద పాముపొడ తెగులు", R.drawable.paamu_poda_thegulu_5);

    }};

    Map<String, Integer> mGodhumaRanguMap = new LinkedHashMap() {{
        put("గోధుమ రంగు ఆకుమచ్చ తెగులు", R.drawable.godhuma_rangu_1);

    }};

    Map<String, Integer> mPottaKulluMap = new LinkedHashMap() {{
        put("పొట్టకుళ్ళు తెగులు వలన పాక్షికంగా బయటకు వచ్చిన కంకి", R.drawable.potta_kullu_1);
        put("పోటాకు పై పొట్టకుళ్ళు తెగులు", R.drawable.potta_kullu_2);
//        put("పొట్ట కుళ్ళు తెగులు_3", R.drawable.potta_kullu_3);


    }};

    Map<String, Integer> mManiPanduMap = new LinkedHashMap() {{
        put("మానిపండు తెగులు ఆశించిన కంకి", R.drawable.mani_pandu_1);
        put("కంకిపై పసుపు రంగు శిలీంద్రపు ముద్ద ", R.drawable.mani_pandu_2);
        put("కంకిపై నలుపు రంగు శిలీంద్రపు ముద్ద", R.drawable.mani_pandu_3);

    }};
    Map<String, Integer> mBacteriaAakuMap = new LinkedHashMap() {{
        put("ఆకుమీద ఎండు తెగులు", R.drawable.bacteria_aaku_endu_1);
        put("ఆకు ఎండు తెగులు ద్వారా స్రవించిన బాక్టీరియా కణ సముదాయం", R.drawable.bacteria_aaku_endu_2);
        put("ఆకు ఎండు తెగులు సోకిన పొలం", R.drawable.bacteria_aaku_endu_3);
        put("క్రెసెక్\u200Cదశ", R.drawable.bacteria_aaku_endu_4);

    }};
    Map<String, Integer> mTungroMap = new LinkedHashMap() {{
        put("టుంగ్రోవైరస్ సోకిన ఆకులు", R.drawable.tungro_1);
        put("పచ్చదీపపు పురుగులు", R.drawable.tungro_2);
        put("టటుంగ్రోవైరస్ సోకిన పొలం", R.drawable.tungro_3);

    }};
    Map<String, Integer> mNaruMudiMap = new LinkedHashMap() {{
        put("నారు మడి", R.drawable.naru_mudi_1);

    }};

    Map<String, Integer> mPilakaDasaMap = new LinkedHashMap() {{
        put("పిలక దశ", R.drawable.pilaka_dasa_1);
        put("పత్ర హరిత పటం", R.drawable.pilaka_dasa_2);
        put("క్రిమిసంహారక మందులు", R.drawable.pilaka_dasa_3);

    }};
    Map<String, Integer> mAnkuramuNundiMap = new LinkedHashMap() {{
        put("అంకురము నుండి పూత దశ", R.drawable.ankuramu_nundi_1);

    }};
    Map<String, Integer> mNatinaPolamuMap = new LinkedHashMap() {{
        put("నాటిన పొలము", R.drawable.natina_polamu_1);
//        put("నాటిన పొలము_2", R.drawable.natina_polamu_2);
//        put("నాటిన పొలము_3", R.drawable.natina_polamu_3);
//        put("నాటిన పొలము_4", R.drawable.natina_polamu_4);

    }};

    Map<String, Integer> mVoodaMap = new LinkedHashMap() {{
        put("బొంత ఊద", R.drawable.vooda_1);
        put("ఊద", R.drawable.vooda_2);
        put("ఉర్రంకి గడ్డి", R.drawable.vooda_3);
        put("గడ్డి మొక్క", R.drawable.vooda_4);

    }};


    Map<String, Integer> mThungaMap = new LinkedHashMap() {{
        put("బ్రహ్మ తుంగ", R.drawable.thunga_jathi_1);
        put("తుంగ", R.drawable.thunga_jathi_2);
        put("రాకాసి తుంగ", R.drawable.thunga_jathi_3);
        put("అల్లి తుంగ", R.drawable.thunga_jathi_4);


    }};
    Map<String, Integer> mVedalpaku_aaku = new LinkedHashMap() {{
        put("గుంటకలగర", R.drawable.vedalpaku_1);
        put("పిల్లి అడుగు", R.drawable.vedalpaku_2);
        put("అమృత కాడ", R.drawable.vedalpaku_3);
        put("అగ్నివేండ్రపాకు", R.drawable.vedalpaku_4);


    }};

    Map<String, Integer> mNeeetiKalupuMap = new LinkedHashMap() {{
//        put("Image1", R.drawable.vedal);
        put("కలువ", R.drawable.neeti_kalupu_1);
        put("అంతర తామర", R.drawable.neeti_kalupu_2);
        put("హైడ్రిల్లా", R.drawable.neeti_kalupu_3);
        put("అజొల్లా", R.drawable.neeti_kalupu_4);
        put("పసరాకు", R.drawable.neeti_kalupu_5);
        put("నీటి తామర", R.drawable.neeti_kalupu_6);

    }};

    Map<String, Integer> mKankiNalliMap = new LinkedHashMap() {{
        put("ఆకు తొడిమలో నల్లి", R.drawable.kanki_aaku_thodimalo_nalli_1);
        put("నల్లి", R.drawable.kanki_nalli_2);
        put("ఈనెల మీద ఎరుపు చార", R.drawable.kanki_enela_mida_erupu_chara_3);
        put("మచ్చలు పడిన గింజలు", R.drawable.kandamu_tol_purugu_thella_kanki_4);

    }};

    Map<String, Integer> mGottapuPuruguMap = new LinkedHashMap() {{
        put("గొట్టాలలోవున్నపిల్ల పురుగు", R.drawable.gottapu_purugu_pilla_1);
        put("తల్లి పురుగు", R.drawable.gottapu_purugu_thalli_2);
        put("కత్తిరించినట్లున్న ఆకులు", R.drawable.gottapu_purugu_kathirinchi_nattu_aakulu_3);

    }};


    Map<String, Integer> mHordMaggetMap = new LinkedHashMap() {{
        put("పురుగు సోకిన వరి మొక్కలు", R.drawable.hord_magget_purugu_sokina_1);
        put("పిల్ల పురుగు", R.drawable.hord_magget_pilla_purugu_2);


    }};
    Map<String, Integer> mThamaraPuruguluMap = new LinkedHashMap() {{
        put("తామర పురుగు సోకిన వరి", R.drawable.thamara_purugulu_thamara_purugu_sokina_vari_1);
        put("తామర పురుగులు", R.drawable.thamara_purugulu_2);


    }};

    Map<String, Integer> mRelluRalchPuruguMap = new LinkedHashMap() {{
        put("రెల్లురాల్చు పురుగు_1", R.drawable.rellu_ralchu_purugu_1);
        put("రెల్లురాల్చు పురుగు_2", R.drawable.rellu_ralchu_purugu_2);
        put("రెల్లురాల్చు పురుగు_3", R.drawable.rellu_ralchu_purugu_3);


    }};

    Map<String, Integer> mGaddiJathuluMap = new LinkedHashMap() {{
        put("గడ్డి జాతులు_1", R.drawable.gaddi_jathulu_1);
        put("గడ్డి జాతులు_2", R.drawable.gaddi_jathulu_2);


    }};

    Map<String, Integer> mBakaneMap = new LinkedHashMap() {{
        put("బకానే తెగులు సోకిన పొలం", R.drawable.img_menu_bakane_tegulu);


    }};
    Map<String, Integer> mKandamKulluTheguluMap = new LinkedHashMap() {{
        put("కాండం కుళ్ళు తెగులు", R.drawable.img_menu_kandam_kullu_tegulu);


    }};
    Map<String, Integer> mVariginjaRanguMarpuTheguluMap = new LinkedHashMap() {{
        put("గింజ రంగు మార్పు తెగులు", R.drawable.img_menu_variginja_marpu_tegulu);


    }};

    Map<String, Integer> mNatrajaniMap = new LinkedHashMap() {{
        put("నత్రజని లోపం", R.drawable.img_menu_natrajani_lopam);


    }};
    Map<String, Integer> mBhaswaramMap = new LinkedHashMap() {{
        put("భాస్వరం లోప లక్షణాలు", R.drawable.img_menu_bhaswaram_lopam);


    }};Map<String, Integer> mPotassiumMap = new LinkedHashMap() {{
        put("పొటాషియం లోపం", R.drawable.img_menu_potassium_lopam);


    }};Map<String, Integer> mGandhakamMap = new LinkedHashMap() {{
        put("గంధకం లోప లక్షణాలు", R.drawable.img_menu_gandhakam_lopam);


    }};Map<String, Integer> mZyncMap = new LinkedHashMap() {{
        put("జింకు లోప లక్షణాలు", R.drawable.img_menu_zink_lopam);


    }};
    Map<String, Integer> mInumuMap = new LinkedHashMap() {{
        put("ఇనుము లోప లక్షణాలు", R.drawable.img_menu_inumu_lopam);


    }};Map<String, Integer> mChowduMap = new LinkedHashMap() {{
        put("వరి పంటపై చౌడు ప్రభావం", R.drawable.img_menu_choudu_nelalu_lopam);


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
    public static HowToIdentifyFragment newInstance(int param1, String param2) {
        HowToIdentifyFragment fragment = new HowToIdentifyFragment();
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
//            if (mParam1.equals("sudi")){
//                List<FindImage> values = mSudimap.values().stream().collect(Collectors.toList());
//
//            }


            switch (mParam1) {

                case MethdodsSource.SUDI_THEGULU:
                    mHowToIdentStrRes = getString(R.string.sudi_thegulu_identify);
                    prepareListFromMap(mSudimap);

                    break;
                case MethdodsSource.THATAKU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.thataku_thegulu_identify);
                    prepareListFromMap(mThatakuTheguluMap);
                    break;
                case MethdodsSource.KAMPU_NALLI:
                    mHowToIdentStrRes = getString(R.string.kampu_nalli_identify);
                    prepareListFromMap(mKampuNalliMap);
                    break;
                case MethdodsSource.THELLA_ROGAM:
                    mHowToIdentStrRes = getString(R.string.thella_rogam_identify);
                    prepareListFromMap(mThellaRogamuMap);
                    break;
                case MethdodsSource.GOTTAPU_ROGAM:
                    mHowToIdentStrRes = getString(R.string.gottapu_rogam_identify);
                    prepareListFromMap(mGottapuRogamuMap);
                    break;
                case MethdodsSource.KANDAMU_THOLUCHU_PURUGU:
                    mHowToIdentStrRes = getString(R.string.kandamu_tholuchu_purugu_identify);
                    prepareListFromMap(mKandamTholuchuPuruguMap);
                    break;
                case MethdodsSource.AAKU_NALLI:
                    mHowToIdentStrRes = getString(R.string.aaku_nalli_identify);
                    prepareListFromMap(mAakuNalliMap);
                    break;

                case MethdodsSource.AGGI_THEGULU:
                    mHowToIdentStrRes = getString(R.string.aggi_thegulu_identify);
                    prepareListFromMap(mAggiTheguluMap);
                    break;
                case MethdodsSource.PAAMU_PODA_THEGULU:
                    mHowToIdentStrRes = getString(R.string.paamu_poda_identify);
                    prepareListFromMap(mPaamuPodaMap);
                    break;
                case MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU:
                    mHowToIdentStrRes = getString(R.string.godhuma_rangu_identify);
                    prepareListFromMap(mGodhumaRanguMap);
                    break;
                case MethdodsSource.POTTA_KULLU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.potta_kullu_identify);
                    prepareListFromMap(mPottaKulluMap);
                    break;
                case MethdodsSource.MAANI_PANDU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.mani_pandu_identify);
                    prepareListFromMap(mManiPanduMap);
                    break;
                case MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.bacteria_aaku_endu_identify);
                    prepareListFromMap(mBacteriaAakuMap);
                    break;
                case MethdodsSource.TUNGRO_VIRUS_THEGULU:
                    mHowToIdentStrRes = getString(R.string.tungro_identify);
                    prepareListFromMap(mTungroMap);
                    break;
                case MethdodsSource.NAARU_MADI:
                    mHowToIdentStrRes = getString(R.string.naru_mudi_prop_methods);
                    prepareListFromMap(mNaruMudiMap);
                    break;
                case MethdodsSource.PILAKA_DASA:
                    mHowToIdentStrRes = getString(R.string.pilaka_dasa_prop_methods);
                    prepareListFromMap(mPilakaDasaMap);
                    break;
                case MethdodsSource.ANKURAMU_NUNDI:
                    mHowToIdentStrRes = getString(R.string.ankuramu_putha_dasa_prop_methods);
                    prepareListFromMap(mAnkuramuNundiMap);
                    break;
                case MethdodsSource.NAATINA_POLAMU:
                    mHowToIdentStrRes = getString(R.string.natina_polamu_prop_methods);
                    prepareListFromMap(mNatinaPolamuMap);
                    break;
                case MethdodsSource.VOODA_KALUPU_MOKKA:
                    mHowToIdentStrRes = getString(R.string.vooda_identify);
                    prepareListFromMap(mVoodaMap);
                    break;
                case MethdodsSource.THUNGA_JAATHI:
                    mHowToIdentStrRes = getString(R.string.thunga_identify);
                    prepareListFromMap(mThungaMap);
                    break;
                case MethdodsSource.VEDALPAKU_KALUPU:
                    mHowToIdentStrRes = getString(R.string.vedalpaku_aaku_identify);
                    prepareListFromMap(mVedalpaku_aaku);
                    break;
                case MethdodsSource.NEETI_KALUPU:
                    mHowToIdentStrRes = getString(R.string.neeti_kalupu_identify);
                    prepareListFromMap(mNeeetiKalupuMap);
                    break;
                case MethdodsSource.KANKI_NALLI:
                    mHowToIdentStrRes = getString(R.string.kanki_nalli_identify);
                    prepareListFromMap(mKankiNalliMap);
                    break;
                case MethdodsSource.GOTTAPU_PURUGU:
                    mHowToIdentStrRes = getString(R.string.gottapu_purugu_identify);
                    prepareListFromMap(mGottapuPuruguMap);
                    break;
                case MethdodsSource.HORD_MAGGET:
                    mHowToIdentStrRes = getString(R.string.hord_magget_identify);
                    prepareListFromMap(mHordMaggetMap);
                    break;
                case MethdodsSource.THAMARA_PURUGULU:
                    mHowToIdentStrRes = getString(R.string.thamara_purugu_identify);
                    prepareListFromMap(mThamaraPuruguluMap);
                    break;
                case MethdodsSource.RELLU_RALCHU_PURUGU:
                    mHowToIdentStrRes = getString(R.string.rellu_ralchu_purugu_identify);
                    prepareListFromMap(mRelluRalchPuruguMap);
                    break;
                case MethdodsSource.GADDI_JATHULU:
                    mHowToIdentStrRes = getString(R.string.gaddi_jathulu_identify);
                    prepareListFromMap(mGaddiJathuluMap);
                    break;
                case MethdodsSource.AROGYA_PANTA_DOS_DONTS:
                    mHowToIdentStrRes = getString(R.string.aarogyamina_panta_dos);
//                    mTvNavTab2.setText(R.string.label_donts);
//                    prepareListFromMap(mRelluRalchPuruguMap);
                    break;
                case MethdodsSource.BAKANE_THEGULU:
                    mHowToIdentStrRes = getString(R.string.bakane_thegulu_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mBakaneMap);
                    break;
                case MethdodsSource.KANDAMU_KULLU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.kandam_kullu_thegulu_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mKandamKulluTheguluMap);
                    break;
                case MethdodsSource.VARIGINJA_MARPU_THEGULU:
                    mHowToIdentStrRes = getString(R.string.variginja_marpu_thegulu_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mVariginjaRanguMarpuTheguluMap);
                    break;
                case MethdodsSource.NATRAJANI_LOPAM:
                    mHowToIdentStrRes = getString(R.string.natrajani_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mNatrajaniMap);
                    break;
                case MethdodsSource.BHASWARAM_LOPAM:
                    mHowToIdentStrRes = getString(R.string.bhaswara_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mBhaswaramMap);
                    break;
                case MethdodsSource.POTASSIUM_LOPAM:
                    mHowToIdentStrRes = getString(R.string.potassium_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mPotassiumMap);
                    break;
                case MethdodsSource.GANDHAKAM_LOPAM:
                    mHowToIdentStrRes = getString(R.string.gandhakam_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mGandhakamMap);
                    break;
                case MethdodsSource.ZYNC_LOPAM:
                    mHowToIdentStrRes = getString(R.string.zync_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mZyncMap);
                    break;
                case MethdodsSource.INUMU_LOPAM:
                    mHowToIdentStrRes = getString(R.string.inumu_lopam_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mInumuMap);
                    break;
                case MethdodsSource.CHOWDU_NELALU_LOPAM:
                    mHowToIdentStrRes = getString(R.string.chowdu_nelalu_identify);
//                    mTvNavTab2.setText(R.string.label_donts);
                    prepareListFromMap(mChowduMap);
                    break;


            }
//            if (mParam1.equals("sudi")){
//                mFindImages = new ArrayList<>();
//                for (Map.Entry<String, Integer> entry : mSudimap.entrySet()) {
//                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//                    mFindImages.add(new FindImage(entry.getKey().toString(),mSudimap.get(entry.getKey().toString())));
//                }
//            }

        }
    }

    private void prepareListFromMap(Map<String, Integer> map) {
        mFindImages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            mFindImages.add(new FindImage(entry.getKey().toString(), map.get(entry.getKey().toString())));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;


        if (mParam2 != null && mParam2.equals("PiruDasalu") | mParam2 != null && mParam2.equals("AROGYA_PANTA_SARINA_MANDULU")) {
            view = inflater.inflate(R.layout.fragment_piru_vividha_dasalu_view, container, false);
            mTextViewLabelMethods = view.findViewById(R.id.tv_label_methods);

        }else{
            view = inflater.inflate(R.layout.fragment_how_to_identify, container, false);
            TextView mTvNavigateTab2 = view.findViewById(R.id.tv_navigate_tab2);
            mTvNavigateTab2.setPaintFlags(mTvNavigateTab2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            if (mParam1 == MethdodsSource.AROGYA_PANTA_DOS_DONTS) {
                mTvNavigateTab2.setText(R.string.label_donts);
            }
            mTvNavigateTab2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewPager viewPager = (ViewPager) getActivity().findViewById(
                            R.id.container);
                    viewPager.setCurrentItem(1);
                }
            });
        }

//        if (mParam2 != null && mParam2.equals("PiruDasalu") | mParam2 != null && mParam2.equals("AROGYA_PANTA_SARINA_MANDULU")){
//            mTvNavigateTab2.setVisibility(View.GONE);
//        }

//        mTextViewContent = view.findViewById(R.id.tv_content);

        mWebView = view.findViewById(R.id.webview);
//        mImageViewOne = view.findViewById(R.id.image1);
        mRecyclerView = view.findViewById(R.id.rv_images);
        mTvNavTab2 = view.findViewById(R.id.tv_navigate_tab2);
//        TextView mTvNavigateTab2 = view.findViewById(R.id.tv_navigate_tab2);

        loadContent(mHowToIdentStrRes);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                mImageViewOne.setImageDrawable(getResources().getDrawable(R.drawable.rice_protection));
                GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
//                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                int spanCount = 2; // 3 columns
                int spacing = 50; // 50px
                boolean includeEdge = false;
                mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
                if (mFindImages != null) {
                    MyAdapter adapter = new MyAdapter(getActivity(), mFindImages);
                    mRecyclerView.setAdapter(adapter);
                }

            }
        }, 500);


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

    private void loadContent(String content) {
        if (mWebView != null)
            mWebView.loadData(style + content + "</body>", "text/html; charset=utf-8", "utf-8");

    }
}
