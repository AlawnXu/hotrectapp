package com.anyapps.hotapp.activity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anyapps.hotapp.R;
import com.anyapps.hotapp.utils.ImageUtil;
import com.anyapps.hotapp.utils.Util;
import com.anyapps.hotapp.widget.ClickareaView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private ClickareaView head;
    private ClickareaView neck;
    private ClickareaView chest;
    private ClickareaView abdomen;
    private ClickareaView upperLimb;
    private ClickareaView legs;

    private ClickareaView backHead;
    private ClickareaView backNeck;
    private ClickareaView backChest;
    private ClickareaView backAbdomen;
    private ClickareaView backUpperLimb;
    private ClickareaView backLegs;

    private Button overTurn;

    private StateListDrawable headDrawable;
    private StateListDrawable neckDrawable;
    private StateListDrawable chestDrawable;
    private StateListDrawable abdomenDrawable;
    private StateListDrawable upperLimbDrawable;
    private StateListDrawable legsDrawable;

    private StateListDrawable headBackDrawable;
    private StateListDrawable neckBackDrawable;
    private StateListDrawable chestBackDrawable;
    private StateListDrawable abdomenBackDrawable;
    private StateListDrawable upperLimbBackDrawable;
    private StateListDrawable legsBackDrawable;

    private View front;
    private View back;

    public static final int MAN = 100;
    public static final int FEMALE = 200;
    public static final int CHILDMAN = 300;
    public static final int CHILDFEMALE = 400;
    private int sex;
    private Resources res;
    private int width;
    private int height;
    private Handler mhandle = new Handler();

    @Override
    public void onStart() {
        super.onStart();
        if (!isLoad) {
            if (sex == MAN) {
                initBitmap();
            } else if (sex == FEMALE) {
                initFemaleBitmap();
            } else {
                initChildBitmap();
            }
        }
        setFrontBg();
    }

    @SuppressWarnings("deprecation")
    private void setFrontBg() {
        System.gc();
        head.setBackgroundDrawable(headDrawable);
        neck.setBackgroundDrawable(neckDrawable);
        chest.setBackgroundDrawable(chestDrawable);
        abdomen.setBackgroundDrawable(abdomenDrawable);
        upperLimb.setBackgroundDrawable(upperLimbDrawable);
        legs.setBackgroundDrawable(legsDrawable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("人体结构图");
        head = (ClickareaView) findViewById(R.id.clickareaView1);
        neck = (ClickareaView) findViewById(R.id.clickareaView2);
        chest = (ClickareaView) findViewById(R.id.clickareaView3);
        abdomen = (ClickareaView) findViewById(R.id.clickareaView4);
        upperLimb = (ClickareaView) findViewById(R.id.clickareaView5);
        legs = (ClickareaView) findViewById(R.id.clickareaView6);

        backHead = (ClickareaView) findViewById(R.id.clickareaView7);
        backNeck = (ClickareaView) findViewById(R.id.clickareaView8);
        backChest = (ClickareaView) findViewById(R.id.clickareaView9);
        backAbdomen = (ClickareaView) findViewById(R.id.clickareaView10);
        backUpperLimb = (ClickareaView) findViewById(R.id.clickareaView11);
        backLegs = (ClickareaView) findViewById(R.id.clickareaView12);

        front = findViewById(R.id.front);
        back = findViewById(R.id.back);

        head.setOnClickListener(this);
        neck.setOnClickListener(this);
        chest.setOnClickListener(this);
        abdomen.setOnClickListener(this);
        upperLimb.setOnClickListener(this);
        legs.setOnClickListener(this);

        backHead.setOnClickListener(this);
        backNeck.setOnClickListener(this);
        backChest.setOnClickListener(this);
        backAbdomen.setOnClickListener(this);
        backUpperLimb.setOnClickListener(this);
        backLegs.setOnClickListener(this);

        overTurn = (Button) findViewById(R.id.button1);
        overTurn.setOnClickListener(this);

        sex = MAN;
        res = getResources();
        width = Util.dip2px(this, 300);
        height = Util.dip2px(this, 500);
        showFront();
        mhandle.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (sex == MAN) {
                    initBackBitmap();
                } else if (sex == FEMALE) {
                    initFemaleBackBitmap();
                } else {
                    initChildBackBitmap();
                }
            }
        }, 1000);
    }

    private void initChildBitmap() {
        isLoad = true;
        headDrawable = new StateListDrawable();
        headDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_head_p, width, height)));
        headDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.child_head,
                                width, height)));

        neckDrawable = new StateListDrawable();
        neckDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_neck_p, width, height)));
        neckDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.child_neck,
                                width, height)));

        chestDrawable = new StateListDrawable();
        chestDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_chest_p, width, height)));
        chestDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.child_chest,
                                width, height)));

        abdomenDrawable = new StateListDrawable();
        abdomenDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_abdomen_p, width, height)));
        abdomenDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_abdomen, width, height)));

        upperLimbDrawable = new StateListDrawable();
        upperLimbDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_upper_limb_p, width, height)));
        upperLimbDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_upper_limb, width, height)));

        legsDrawable = new StateListDrawable();
        legsDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_legs_p, width, height)));
        legsDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.child_legs,
                                width, height)));
    }

    private void initFemaleBitmap() {
        isLoad = true;
        headDrawable = new StateListDrawable();
        headDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_head_p, width, height)));
        headDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.female_head,
                                width, height)));

        neckDrawable = new StateListDrawable();
        neckDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_neck_p, width, height)));
        neckDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.female_neck,
                                width, height)));

        chestDrawable = new StateListDrawable();
        chestDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_chest_p, width, height)));
        chestDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.female_chest,
                                width, height)));

        abdomenDrawable = new StateListDrawable();
        abdomenDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_abdomen_p, width, height)));
        abdomenDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_abdomen, width, height)));

        upperLimbDrawable = new StateListDrawable();
        upperLimbDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_upper_limb_p, width, height)));
        upperLimbDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_upper_limb, width, height)));

        legsDrawable = new StateListDrawable();
        legsDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_lower_limbs_p, width, height)));
        legsDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.female_lower_limbs,
                                width, height)));
    }

    private void initBitmap() {
        isLoad = true;
        headDrawable = new StateListDrawable();
        headDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.head_p, width, height)));
        headDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.head,
                                width, height)));

        neckDrawable = new StateListDrawable();
        neckDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.neck_p, width, height)));
        neckDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.neck,
                                width, height)));

        chestDrawable = new StateListDrawable();
        chestDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.chest_p, width, height)));
        chestDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.chest,
                                width, height)));

        abdomenDrawable = new StateListDrawable();
        abdomenDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.abdomen_p, width, height)));
        abdomenDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.abdomen, width, height)));

        upperLimbDrawable = new StateListDrawable();
        upperLimbDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.upper_limb_p, width, height)));
        upperLimbDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.upper_limb, width, height)));

        legsDrawable = new StateListDrawable();
        legsDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.legs_p, width, height)));
        legsDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res, R.mipmap.legs,
                                width, height)));
    }

    private void initChildBackBitmap() {
        isLoadBack = true;
        headBackDrawable = new StateListDrawable();
        headBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_head_p, width, height)));
        headBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_head, width, height)));

        neckBackDrawable = new StateListDrawable();
        neckBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_neck_p, width, height)));
        neckBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_neck, width, height)));

        chestBackDrawable = new StateListDrawable();
        chestBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_backside_p, width, height)));
        chestBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_backside, width, height)));

        abdomenBackDrawable = new StateListDrawable();
        abdomenBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_haunch_p, width, height)));
        abdomenBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_haunch, width, height)));

        upperLimbBackDrawable = new StateListDrawable();
        upperLimbBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_upper_limb_p, width, height)));
        upperLimbBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_upper_limb, width, height)));

        legsBackDrawable = new StateListDrawable();
        legsBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_legs_p, width, height)));
        legsBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.child_back_legs, width, height)));
    }

    private void initFemaleBackBitmap() {
        isLoadBack = true;
        headBackDrawable = new StateListDrawable();
        headBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_head_p, width, height)));
        headBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_head, width, height)));

        neckBackDrawable = new StateListDrawable();
        neckBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_neck_p, width, height)));
        neckBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_neck, width, height)));

        chestBackDrawable = new StateListDrawable();
        chestBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_loin_p, width, height)));
        chestBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_loin, width, height)));

        abdomenBackDrawable = new StateListDrawable();
        abdomenBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_haunch_p, width, height)));
        abdomenBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_haunch, width, height)));

        upperLimbBackDrawable = new StateListDrawable();
        upperLimbBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_upper_limb_p, width, height)));
        upperLimbBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_upper_limb, width, height)));

        legsBackDrawable = new StateListDrawable();
        legsBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_lower_limbs_p, width, height)));
        legsBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.female_back_lower_limbs, width, height)));
    }

    @Override
    public void onClick(View v) {
        String position = null;
        String strTemp = "点击了人体".concat(mOverTurnStr).concat("面的");
        String str = null;
        switch (v.getId()) {
            case R.id.clickareaView1://头部
            case R.id.clickareaView7://头部
                position = "1101,1102,1103,1104,1105,12";
                str = strTemp.concat("头部");
                break;
            case R.id.clickareaView2://颈部
            case R.id.clickareaView8://头部
                position = "3,12";
                str = strTemp.concat("颈部、头部");
                break;
            case R.id.clickareaView3://胸部
                position = "4,12";
                str = strTemp.concat("胸部");
                break;
            case R.id.clickareaView4://腹部
                if (sex == MAN || sex == CHILDMAN) {
                    position = "5,12,9101";//男 5,12,9101
                } else {
                    position = "5,12,9102";//女5,12,9102
                }
                str = strTemp.concat("腹部");
                break;
            case R.id.clickareaView5://上肢
            case R.id.clickareaView11://上肢
                position = "2101,12";
                str = strTemp.concat("上肢");
                break;
            case R.id.clickareaView6://下肢
            case R.id.clickareaView12://下肢
                position = "2012,12";
                str = strTemp.concat("下肢");
                break;
            case R.id.button1:
                setBackground();
                return;
            case R.id.clickareaView9://背部
                position = "6,7,12";
                str = strTemp.concat("背部");
                break;
            case R.id.clickareaView10://腹部，臀部
                position = "8,12";
                str = strTemp.concat("腹部，臀部");
                break;
            default:
                break;
        }
        //Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
        if (!TextUtils.isEmpty(position)) {
            Toast.makeText(this, "(".concat(position).concat(")").concat(str), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isLoadBack = false;
    private boolean isLoad = false;
    private String mOverTurnStr = "正";

    private void setBackground() {
        mOverTurnStr = overTurn.getText().toString();
        if ("背".equals(mOverTurnStr)) {
            overTurn.setText("正");
            if (!isLoadBack) {
                if (sex == MAN) {
                    initBackBitmap();
                } else if (sex == FEMALE) {
                    initFemaleBackBitmap();
                } else {
                    initChildBackBitmap();
                }
            }
            setBackBg();
            showBack();
        } else {
            overTurn.setText("背");
            showFront();
        }
    }

    private void showFront() {
        front.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
    }

    private void showBack() {
        front.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("deprecation")
    private void setBackBg() {
        System.gc();
        backHead.setBackgroundDrawable(headBackDrawable);
        backNeck.setBackgroundDrawable(neckBackDrawable);
        backChest.setBackgroundDrawable(chestBackDrawable);
        backAbdomen.setBackgroundDrawable(abdomenBackDrawable);
        backUpperLimb.setBackgroundDrawable(upperLimbBackDrawable);
        backLegs.setBackgroundDrawable(legsBackDrawable);
    }

    private void initBackBitmap() {
        isLoadBack = true;
        headBackDrawable = new StateListDrawable();
        headBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_head_p, width, height)));
        headBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_head, width, height)));

        neckBackDrawable = new StateListDrawable();
        neckBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_neck_p, width, height)));
        neckBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_neck, width, height)));

        chestBackDrawable = new StateListDrawable();
        chestBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_backside_p, width, height)));
        chestBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_backside, width, height)));

        abdomenBackDrawable = new StateListDrawable();
        abdomenBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_haunch_p, width, height)));
        abdomenBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_haunch, width, height)));

        upperLimbBackDrawable = new StateListDrawable();
        upperLimbBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_upper_limb_p, width, height)));
        upperLimbBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_upper_limb, width, height)));

        legsBackDrawable = new StateListDrawable();
        legsBackDrawable.addState(
                new int[]{android.R.attr.state_pressed},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_legs_p, width, height)));
        legsBackDrawable.addState(
                new int[]{},
                new BitmapDrawable(res, ImageUtil
                        .decodeSampledBitmapFromResource(res,
                                R.mipmap.back_legs, width, height)));
    }
}
