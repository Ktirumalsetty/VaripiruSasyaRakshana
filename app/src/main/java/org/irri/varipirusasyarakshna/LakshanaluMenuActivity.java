package org.irri.varipirusasyarakshna;

import android.content.Context;
import android.content.Intent;

import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.irri.varipirusasyarakshna.adapter.LakshanaluMediaStickyHeaderAdapter;
import org.irri.varipirusasyarakshna.model.GeneralItem;
import org.irri.varipirusasyarakshna.model.ImageTypeItem;
import org.irri.varipirusasyarakshna.model.KanipincheLakshanaluItem;
import org.irri.varipirusasyarakshna.model.ListItem;
import org.irri.varipirusasyarakshna.model.MethdodsSource;
import org.irri.varipirusasyarakshna.utils.ClickListener;
import org.irri.varipirusasyarakshna.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LakshanaluMenuActivity extends AppCompatActivity {

    private static final String TAG = "LakshanaluMenuActivity";

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
    Map<String, Integer> mKandamTholuchuPuruguMap = new LinkedHashMap() {{
        put("గ్రుడ్ల సముదాయము", R.drawable.kandamu_tol_purugu_gudla_samu_1);
        put("తల్లి పురుగు", R.drawable.kandamu_tol_purugu_talli_pur_2);
        put("చనిపోయిన మొవ్వులు", R.drawable.kandamu_tol_purugu_chani_movvalu_3);
        put("తెల్ల కంకి", R.drawable.kandamu_tol_purugu_thella_kanki_4);

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
        put("పిలక దశలో రెల్లురాల్చు పురుగు ఆశించిన మొక్కలు", R.drawable.rellu_ralchu_purugu_1);
        put("కంకి దశలో రెల్లురాల్చు పురుగు ఆశించిన మొక్క", R.drawable.rellu_ralchu_purugu_2);
        put("రెల్లురాల్చు పురుగు వివిధ దశలు", R.drawable.rellu_ralchu_purugu_3);


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
        put("నాటిన పొలము_1", R.drawable.natina_polamu_1);
        put("నాటిన పొలము_2", R.drawable.natina_polamu_2);
        put("నాటిన పొలము_3", R.drawable.natina_polamu_3);
        put("నాటిన పొలము_4", R.drawable.natina_polamu_4);

    }};

    //    Map<String, Integer> mGaddiJathuluMap = new LinkedHashMap() {{
//        put("గడ్డి జాతులు_1", R.drawable.gaddi_jathulu_1);
//        put("గడ్డి జాతులు_2", R.drawable.gaddi_jathulu_2);
//
//
//    }};

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


    }};
    Map<String, Integer> mPotassiumMap = new LinkedHashMap() {{
        put("పొటాషియం లోపం", R.drawable.img_menu_potassium_lopam);


    }};
    Map<String, Integer> mGandhakamMap = new LinkedHashMap() {{
        put("గంధకం లోప లక్షణాలు", R.drawable.img_menu_gandhakam_lopam);


    }};
    Map<String, Integer> mZyncMap = new LinkedHashMap() {{
        put("జింకు లోప లక్షణాలు", R.drawable.img_menu_zink_lopam);


    }};
    Map<String, Integer> mInumuMap = new LinkedHashMap() {{
        put("ఇనుము లోప లక్షణాలు", R.drawable.img_menu_inumu_lopam);


    }};
    Map<String, Integer> mChowduMap = new LinkedHashMap() {{
        put("వరి పంటపై చౌడు ప్రభావం", R.drawable.img_menu_choudu_nelalu_lopam);


    }};

    List<KanipincheLakshanaluItem> mKanipincheLakshanaluItems = new ArrayList<>();
    private LinkedHashMap<Integer, List<KanipincheLakshanaluItem>> mItemsMap;

    RecyclerView mRecyclerView;
    private ArrayList<ListItem> mDriveItems;
    private LakshanaluMediaStickyHeaderAdapter mAdapter;

    //    ActivityLakshanaluMenu binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_lakshanalu_menu);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_lakshanalu_menu);
//        ActivityLakshanaluMenu =
//                DataBindingUtil.setContentView(this, R.layout.activity_lakshanalu_menu);
        mRecyclerView = findViewById(R.id.recycler_view);


        for (int i = 1; i <= 33; i++) {
            switch (i) {
                case 1:
                    prepareListFromMap(mSudimap, MethdodsSource.SUDI_THEGULU);
                    break;
                case 2:
                    prepareListFromMap(mKampuNalliMap, MethdodsSource.KAMPU_NALLI);
                    break;
                case 3:
                    prepareListFromMap(mKandamTholuchuPuruguMap, MethdodsSource.KANDAMU_THOLUCHU_PURUGU);
                    break;
                case 4:
                    prepareListFromMap(mThatakuTheguluMap, MethdodsSource.THATAKU_THEGULU);
                    break;
                case 5:
                    prepareListFromMap(mThellaRogamuMap, MethdodsSource.THELLA_ROGAM);
                    break;
                case 6:
                    prepareListFromMap(mAakuNalliMap, MethdodsSource.AAKU_NALLI);
                    break;
                case 7:
                    prepareListFromMap(mGottapuRogamuMap, MethdodsSource.GOTTAPU_ROGAM);
                    break;
                case 8:
                    prepareListFromMap(mKankiNalliMap, MethdodsSource.KANKI_NALLI);
                    break;
                case 9:
                    prepareListFromMap(mGottapuPuruguMap, MethdodsSource.GOTTAPU_PURUGU);
                    break;
                case 10:
                    prepareListFromMap(mHordMaggetMap, MethdodsSource.HORD_MAGGET);
                    break;
                case 11:
                    prepareListFromMap(mThamaraPuruguluMap, MethdodsSource.THAMARA_PURUGULU);
                    break;
                case 12:
                    prepareListFromMap(mRelluRalchPuruguMap, MethdodsSource.RELLU_RALCHU_PURUGU);
                    break;
                case 13:
                    prepareListFromMap(mAggiTheguluMap, MethdodsSource.AGGI_THEGULU);
                    break;
                case 14:
                    prepareListFromMap(mPaamuPodaMap, MethdodsSource.PAAMU_PODA_THEGULU);
                    break;
                case 15:
                    prepareListFromMap(mGodhumaRanguMap, MethdodsSource.GODHUMA_RANGU_AAKU_MACHA_THEGULU);
                    break;
                case 16:
                    prepareListFromMap(mPottaKulluMap, MethdodsSource.POTTA_KULLU_THEGULU);
                    break;
                case 17:
                    prepareListFromMap(mManiPanduMap, MethdodsSource.MAANI_PANDU_THEGULU);
                    break;
                case 18:
                    prepareListFromMap(mBacteriaAakuMap, MethdodsSource.BACTERIA_AAKU_ENDU_THEGULU);
                    break;
                case 19:
                    prepareListFromMap(mBakaneMap, MethdodsSource.BAKANE_THEGULU);
                    break;
                case 20:
                    prepareListFromMap(mKandamKulluTheguluMap, MethdodsSource.KANDAMU_KULLU_THEGULU);
                    break;
                case 21:
                    prepareListFromMap(mVariginjaRanguMarpuTheguluMap, MethdodsSource.VARIGINJA_MARPU_THEGULU);
                    break;
                case 22:
                    prepareListFromMap(mTungroMap, MethdodsSource.TUNGRO_VIRUS_THEGULU);
                    break;
                case 23:
                    prepareListFromMap(mVoodaMap, MethdodsSource.GADDI_JATHULU);
                    break;
                case 24:
                    prepareListFromMap(mThungaMap, MethdodsSource.THUNGA_JAATHI);
                    break;
                case 25:
                    prepareListFromMap(mVedalpaku_aaku, MethdodsSource.VEDALPAKU_KALUPU);
                    break;
                case 26:
                    prepareListFromMap(mNeeetiKalupuMap, MethdodsSource.NEETI_KALUPU);
                    break;
                case 27:
                    prepareListFromMap(mNatrajaniMap, MethdodsSource.NATRAJANI_LOPAM);
                    break;
                case 28:
                    prepareListFromMap(mBhaswaramMap, MethdodsSource.BHASWARAM_LOPAM);
                    break;
                case 29:
                    prepareListFromMap(mPotassiumMap, MethdodsSource.POTASSIUM_LOPAM);
                    break;
                case 30:
                    prepareListFromMap(mGandhakamMap, MethdodsSource.GANDHAKAM_LOPAM);
                    break;
                case 31:
                    prepareListFromMap(mZyncMap, MethdodsSource.ZYNC_LOPAM);
                    break;
                case 32:
                    prepareListFromMap(mInumuMap, MethdodsSource.INUMU_LOPAM);
                    break;
                case 33:
                    prepareListFromMap(mChowduMap, MethdodsSource.CHOWDU_NELALU_LOPAM);
                    break;
            }
        }

//        mDriveItems = groupImagesByCategory(mKanipincheLakshanaluItems);

        populateData();

    }

    /**
     * used to calculate the displayMetrics of the screen
     *
     * @param context
     * @return
     */

    private static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / 120);
    }

    private void populateData() {
        final int columnsCount = calculateNoOfColumns(this);
        Log.d(TAG, "columnsCount" + columnsCount);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, columnsCount);
//        mRecyclerView.setHasFixedSize(false);

//        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
//        mRecyclerView.addItemDecoration(itemDecoration);

//        RecyclerSectionItemDecoration sectionItemDecoration =
//                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.item_offset),
//                        true,
//                        getSectionCallback(mDriveItems));
//        mRecyclerView.addItemDecoration(sectionItemDecoration);
//        int spanCount = 3; // 3 columns
//        int spacing = 10; // 50px
//        boolean includeEdge = false;
//        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, columnsCount);
//        mLayoutManager.getSpanSizeLookup().setSpanIndexCacheEnabled(true);
//        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                switch(mAdapter.getItemViewType(position)){
//                    case ListItem.TYPE_GENERAL:
//                        return columnsCount;
//
//                    case ListItem.TYPE_IMAGE_CATEGORY:
//                        return columnsCount;
//
//                    default:
//                        return columnsCount;
//                }
//            }
//        });

        mRecyclerView.setLayoutManager(mLayoutManager);

//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                KanipincheLakshanaluItem driveItem = mKanipincheLakshanaluItems.get(position);
                try {
                    Log.d(TAG, "on  click");
                    LakshanaluMediaStickyHeaderAdapter.MyViewHolder holder = (LakshanaluMediaStickyHeaderAdapter.MyViewHolder) mRecyclerView.findViewHolderForAdapterPosition(position);
                    Intent intent = new Intent(LakshanaluMenuActivity.this, ImageViewerActivity.class);
                    intent.putExtra("DriveItemObj", driveItem);
                    intent.putExtra("EXTRA_MEDIA_IMAGE_TRANSITION_NAME", ViewCompat.getTransitionName(holder.mImageView));
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LakshanaluMenuActivity.this,
                            holder.mImageView,
                            ViewCompat.getTransitionName(holder.mImageView));

                    startActivity(intent, options.toBundle());

                } catch (Exception e) {
                    e.printStackTrace();
                }

//                KanipincheLakshanaluItem driveItem = null;
//                String dateItemDate;
//                ListItem listItem = mDriveItems.get(position);
//                if (listItem.getType() == ListItem.TYPE_IMAGE_CATEGORY){
//                    return;
//                }else{
//                    GeneralItem generalItem = (GeneralItem) mDriveItems.get(position);
//
//                    // Populate general item data here
//                    driveItem = generalItem.getLakshanaluItem();
//                    try {
//                        Log.d(TAG, "on  click");
//                        LakshanaluMediaStickyHeaderAdapter.MyViewHolder holder = (LakshanaluMediaStickyHeaderAdapter.MyViewHolder) mRecyclerView.findViewHolderForAdapterPosition(position);
//                        Intent intent = new Intent(LakshanaluMenuActivity.this, ImageViewerActivity.class);
//                        intent.putExtra("DriveItemObj", driveItem);
//                        intent.putExtra("EXTRA_MEDIA_IMAGE_TRANSITION_NAME", ViewCompat.getTransitionName(holder.mImageView));
//                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LakshanaluMenuActivity.this,
//                                holder.mImageView,
//                                ViewCompat.getTransitionName(holder.mImageView));
//
//                        startActivity(intent, options.toBundle());
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }


            }

            @Override
            public void onLongClick(View view, int position) {
             /*   if (mActionMode == null) {
                    mActionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(actionModeCallback);
                }
                toggleSelection(position);*/

            }
        }));

        if (mKanipincheLakshanaluItems != null && mKanipincheLakshanaluItems.size() > 0) {
//            mAdapter = new DriveMediaRecyclerAdapter(getActivity(), mDriveItems);
            mAdapter = new LakshanaluMediaStickyHeaderAdapter(this, mKanipincheLakshanaluItems);
            mRecyclerView.setAdapter(mAdapter);
//            runLayoutAnimation(mRecyclerView,R.anim.grid_layout_animation_from_bottom);
        }

    }


    private void prepareListFromMap(Map<String, Integer> map, int type) {
//        mFindImages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            mKanipincheLakshanaluItems.add(new KanipincheLakshanaluItem(entry.getKey().toString(), map.get(entry.getKey().toString()), type));
        }
    }

    private ArrayList<ListItem> groupImagesByCategory(List<KanipincheLakshanaluItem> mKanipincheLakshanaluItems) {

        mItemsMap = new LinkedHashMap<Integer, List<KanipincheLakshanaluItem>>();
        if (mItemsMap != null)
            for (KanipincheLakshanaluItem item : mKanipincheLakshanaluItems) {
                Integer hashMapKey = item.getItemType();
                if (mItemsMap.containsKey(hashMapKey)) {
                    // The key is already in the HashMap; add the pojo object
                    // against the existing key.
                    mItemsMap.get(hashMapKey).add(item);
                } else {
                    // The key is not there in the HashMap; create a new key-value pair
                    List<KanipincheLakshanaluItem> list = new ArrayList<>();
                    list.add(item);
                    mItemsMap.put(hashMapKey, list);
                }
            }
        //Converting the HashMap data into a sorted list
        ArrayList<ListItem> consolidatedList = new ArrayList<>();

        for (Integer key : mItemsMap.keySet()) {
            ImageTypeItem imageTypeItem = new ImageTypeItem();
            imageTypeItem.setItemType(key);

            consolidatedList.add(imageTypeItem);
            for (KanipincheLakshanaluItem driveItem : mItemsMap.get(key)) {
                GeneralItem generalItem = new GeneralItem();
                generalItem.setLakshanaluItem(driveItem);
                consolidatedList.add(generalItem);
            }

        }
        return consolidatedList;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
                return true;

            case R.id.action_home:

                Intent i = new Intent(this, HomeDrawerActivity.class);
                // Closing all the Activities
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

                finish();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
