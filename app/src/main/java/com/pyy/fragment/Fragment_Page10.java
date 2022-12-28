package com.pyy.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.errands.test.R;
import com.pyy.dao.JsInterface10;

import java.util.Objects;

public class Fragment_Page10 extends Fragment implements View.OnClickListener {
    private final Context context;
    private final String sign;
    private EditText input1, input2, input3;
    private WebView webview;
    private TableLayout tabLayout;

    private TextView tv_sign;
    private final StringBuilder[] param = new StringBuilder[3];
    private int current_focus = 0;

    public Fragment_Page10(Context context, String sign) {
        this.context = context;
        this.sign = sign;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page10, container, false);


        input1 = view.findViewById(R.id.input1);
        input2 = view.findViewById(R.id.input2);
        input3 = view.findViewById(R.id.input3);
        initView(view);
        if (Objects.equals(sign, "100")) {
            tv_sign.setText("弯头角度a");
        } else tv_sign.setText("弯头高度H");

        input1.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input2.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input3.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input1.setOnClickListener(view1 -> {
            initInput();
            input1.setBackground(getResources().getDrawable(R.drawable.bg_edittext_select));
            current_focus = 0;
            if (tabLayout.getVisibility() == View.GONE)
                tabLayout.setVisibility(View.VISIBLE);
            else if (webview.getVisibility() == View.VISIBLE)
                webview.setVisibility(View.GONE);
        });
        input2.setOnClickListener(view12 -> {
            initInput();
            input2.setBackground(getResources().getDrawable(R.drawable.bg_edittext_select));
            current_focus = 1;
            if (tabLayout.getVisibility() == View.GONE)
                tabLayout.setVisibility(View.VISIBLE);
            else if (webview.getVisibility() == View.VISIBLE)
                webview.setVisibility(View.GONE);
        });
        input3.setOnClickListener(view13 -> {
            initInput();
            input3.setBackground(getResources().getDrawable(R.drawable.bg_edittext_select));
            current_focus = 2;
            if (tabLayout.getVisibility() == View.GONE)
                tabLayout.setVisibility(View.VISIBLE);
            else if (webview.getVisibility() == View.VISIBLE)
                webview.setVisibility(View.GONE);
        });

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    void initView(View view) {
        param[0] = new StringBuilder();
        param[1] = new StringBuilder();
        param[2] = new StringBuilder();
        webview = view.findViewById(R.id.webview);
        webview.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webview.getSettings();
        //  允许WebView加载JavaScript
        webSettings.setJavaScriptEnabled(true);

        tabLayout = view.findViewById(R.id.tablayout);
        tv_sign = view.findViewById(R.id.tv_sign);

        Button btn0 = view.findViewById(R.id.bt0);
        Button btn1 = view.findViewById(R.id.bt1);
        Button btn2 = view.findViewById(R.id.bt2);
        Button btn3 = view.findViewById(R.id.bt3);
        Button btn4 = view.findViewById(R.id.bt4);
        Button btn5 = view.findViewById(R.id.bt5);
        Button btn6 = view.findViewById(R.id.bt6);
        Button btn7 = view.findViewById(R.id.bt7);
        Button btn8 = view.findViewById(R.id.bt8);
        Button btn9 = view.findViewById(R.id.bt9);
        Button delete = view.findViewById(R.id.delete);
        Button add = view.findViewById(R.id.add);
        Button minus = view.findViewById(R.id.minus);
        Button params = view.findViewById(R.id.param);
        Button point = view.findViewById(R.id.point);
        Button sure = view.findViewById(R.id.sure);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        delete.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        params.setOnClickListener(this);
        point.setOnClickListener(this);
        sure.setOnClickListener(this);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    void initInput(){
        input1.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input2.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input3.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
    }
    @SuppressLint({"DefaultLocale", "SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt0:
                if (param[current_focus].length() == 0)
                    break;
                else {
                    param[current_focus].append("0");
                    if (current_focus == 0)
                        input1.setText(param[current_focus]);
                    else if (current_focus == 1)
                        input2.setText(param[current_focus]);
                    else
                        input3.setText(param[current_focus]);
                }
                break;
            case R.id.bt1:
                param[current_focus].append("1");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt2:
                param[current_focus].append("2");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt3:
                param[current_focus].append("3");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt4:
                param[current_focus].append("4");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt5:
                param[current_focus].append("5");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt6:
                param[current_focus].append("6");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt7:
                param[current_focus].append("7");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt8:
                param[current_focus].append("8");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.bt9:
                param[current_focus].append("9");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.delete:
                if ((param[current_focus].length() == 1) || param[current_focus].length() == 0) {
                    param[current_focus].setLength(0);
                } else
                    param[current_focus].delete(param[current_focus].length() - 1, param[current_focus].length());
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.point:
                if (param[current_focus].indexOf(".") == -1)
                    param[current_focus].append(".");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else
                    input3.setText(param[current_focus]);
                break;
            case R.id.add:
                Toast.makeText(context, "点击了+", Toast.LENGTH_SHORT).show();
                break;
            case R.id.minus:
                Toast.makeText(context, "点击了-", Toast.LENGTH_SHORT).show();
                break;
            case R.id.param:
                Toast.makeText(context, "点击了参数", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sure:
                initInput();
                if ((input1.getText().toString().equals("")) || (input2.getText().toString().equals("")) || (input3.getText().toString().equals("")))
                    return;
                double input_D = Double.parseDouble(input1.getText().toString());
                double input_R = Double.parseDouble(input2.getText().toString());
                double input_a = Double.parseDouble(input3.getText().toString());
                webview.loadUrl("file:///android_asset/w.s");
                if (Objects.equals(sign, "101"))
                    input_a = 2 * Math.atan(input_a / input_R) * 180 / Math.PI;
                if ((input_D > 0 && input_R > (input_D / 2)) && (input_a > 0 && input_a < 90)) //取值范围
                    webview.addJavascriptInterface(new JsInterface10(input_D, input_a, input_R), "JsInterface");
                else
                    Toast.makeText(context, "输入参数有误，请检查", Toast.LENGTH_SHORT).show();
                webview.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.GONE);
                break;

        }
    }
}