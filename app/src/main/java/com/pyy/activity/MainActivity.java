package com.pyy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.errands.test.R;
import com.pyy.adapter.AdapterFunction;
import com.pyy.adapter.AdapterSecondStage;
import com.pyy.event.backEvent;
import com.pyy.fragment.Fragment_Page11_012;
import com.pyy.fragment.Fragment_Page11_3;
import com.pyy.fragment.Fragment_Page11_456;
import com.pyy.fragment.Fragment_calculator;
import com.pyy.fragment.Fragment_Page10;
import com.pyy.fragment.Fragment_me;
import com.pyy.fragment.Fragment_Secondstage;
import com.pyy.fragment.Fragment_tools;
import com.pyy.util.BaseHandleMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "TAG";

    private Fragment_calculator fragment_cal;
    private Fragment_tools fragment_tool;
    private Fragment_me fragment_me;
    private ImageView back;
    public static int current_page = 1;
    public static int last_page = 1;
    public static String title = "";
    public static String sign = "";
    private LinearLayout bottom_nav;
    private LinearLayout nav;
    private LinearLayout nav1;
    private TextView nav_tv1;
    private LinearLayout nav2;
    private TextView nav_tv2;
    private LinearLayout nav3;
    private TextView nav_tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @SuppressLint({"NonConstantResourceId", "CutPasteId"})
    private void initView() {
        fragment_cal = new Fragment_calculator(this);
        fragment_tool = new Fragment_tools(this);
        fragment_me = new Fragment_me();
        fragmentReplace(fragment_cal);
        nav = findViewById(R.id.bottom_nav);
        bottom_nav = findViewById(R.id.bottom_nav);

        back = findViewById(R.id.back);
        nav1 = findViewById(R.id.nav1);
        nav1.setOnClickListener(this);
        nav_tv1 = findViewById(R.id.nav_tv1);
        nav2 = findViewById(R.id.nav2);
        nav2.setOnClickListener(this);
        nav_tv2 = findViewById(R.id.nav_tv2);
        nav3 = findViewById(R.id.nav3);
        nav3.setOnClickListener(this);
        nav_tv3 = findViewById(R.id.nav_tv3);

        //                    Fragment_Thirdstage fragment_thirdstage = new Fragment_Thirdstage(this, "101");
        //                    fragmentReplace(fragment_thirdstage);
        Handler handler = new Handler(message -> {
            if (message.what == AdapterFunction.SECOND_STAGE_SIGN) {
                Fragment_Secondstage fragment_secondstage = new Fragment_Secondstage(this, message.obj.toString(), title);
                sign = message.obj.toString();
                fragmentReplace(fragment_secondstage);
            } else if (message.what == AdapterSecondStage.THIRD_STAGE_SIGN) {
                if ((Integer.parseInt(message.obj.toString()) == 100) || (Integer.parseInt(message.obj.toString()) == 101)) {
                    Fragment_Page10 fragment_page10 = new Fragment_Page10(this, message.obj.toString());
                    fragmentReplace(fragment_page10);
                } else if ((Integer.parseInt(message.obj.toString()) == 110) || (Integer.parseInt(message.obj.toString()) == 111) || (Integer.parseInt(message.obj.toString()) == 112)) {
                    Fragment_Page11_012 fragment_page11012 = new Fragment_Page11_012(this, message.obj.toString());
                    fragmentReplace(fragment_page11012);
                } else if (Integer.parseInt(message.obj.toString()) == 113) {
                    Fragment_Page11_3 fragment_page113 = new Fragment_Page11_3(this);
                    fragmentReplace(fragment_page113);
                }else if ((Integer.parseInt(message.obj.toString()) == 114)||(Integer.parseInt(message.obj.toString()) == 115)||(Integer.parseInt(message.obj.toString()) == 116)) {
                    Fragment_Page11_456 fragment_page456 = new Fragment_Page11_456(this, message.obj.toString());
                    fragmentReplace(fragment_page456);
                }
                else {
                    Toast.makeText(this, "点击了其他页面", Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        });
        BaseHandleMessage.getInstance().addBaseHandleMessage(handler);


        back.setOnClickListener(view -> {
            if (current_page == 1) {
                MainActivity.super.onBackPressed();
            } else if (current_page == 2) {
                initNavigation();
                back.setVisibility(View.VISIBLE);
                nav.setVisibility(View.GONE);
                if (last_page == 1) {
                    fragmentReplace(fragment_cal);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                        nav_tv1.setTextColor(getColor(R.color.colorPrimary));
                    nav1.setBackgroundResource(R.drawable.bg_navigation);
                } else if (last_page == 2) {
                    fragmentReplace(fragment_tool);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                        nav_tv2.setTextColor(getColor(R.color.colorPrimary));
                    nav2.setBackgroundResource(R.drawable.bg_navigation);
                }
                current_page = 1;
                EventBus.getDefault().post(new backEvent());
            } else if (current_page == 3) {
                Fragment_Secondstage fragment_secondstage = new Fragment_Secondstage(MainActivity.this, sign, title);
                fragmentReplace(fragment_secondstage);
                current_page = 2;
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav1:
                initNavigation();
                fragmentReplace(fragment_cal);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    nav_tv1.setTextColor(getColor(R.color.colorPrimary));
                nav1.setBackgroundResource(R.drawable.bg_navigation);
                break;
            case R.id.nav2:
                initNavigation();
                fragmentReplace(fragment_tool);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    nav_tv2.setTextColor(getColor(R.color.colorPrimary));
                nav2.setBackgroundResource(R.drawable.bg_navigation);
                break;
            case R.id.nav3:
                initNavigation();
                fragmentReplace(fragment_me);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    nav_tv3.setTextColor(getColor(R.color.colorPrimary));
                nav3.setBackgroundResource(R.drawable.bg_navigation);
                break;
            default:
                break;
        }
    }

    @SuppressLint("ResourceType")
    void initNavigation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            nav1.setBackground(null);
            nav2.setBackground(null);
            nav3.setBackground(null);
            nav_tv1.setTextColor(getColor(R.color.white));
            nav_tv2.setTextColor(getColor(R.color.white));
            nav_tv3.setTextColor(getColor(R.color.white));
        }
    }

    //返回事件
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void backEvent(backEvent backEvent) {
        this.runOnUiThread(() -> {
            if (current_page == 1) {
                back.setVisibility(View.GONE);
                bottom_nav.setVisibility(View.VISIBLE);
            } else {
                back.setVisibility(View.VISIBLE);
                bottom_nav.setVisibility(View.GONE);
            }
        });
    }

    private void fragmentReplace(Fragment fragment) {
        //拿到事务管理器并开启事务
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment, null).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (current_page == 1)
            super.onBackPressed();
        else if (current_page == 2) {
            initNavigation();
            back.setVisibility(View.VISIBLE);
            nav.setVisibility(View.GONE);
            if (last_page == 1) {
                fragmentReplace(fragment_cal);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    nav_tv1.setTextColor(getColor(R.color.colorPrimary));
                nav1.setBackgroundResource(R.drawable.bg_navigation);
            } else if (last_page == 2) {
                fragmentReplace(fragment_tool);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    nav_tv2.setTextColor(getColor(R.color.colorPrimary));
                nav2.setBackgroundResource(R.drawable.bg_navigation);
            }
            current_page = 1;
            EventBus.getDefault().post(new backEvent());
        } else if (current_page == 3) {
            Fragment_Secondstage fragment_secondstage = new Fragment_Secondstage(MainActivity.this, sign, title);
            fragmentReplace(fragment_secondstage);
            current_page = 2;
        }
    }

}