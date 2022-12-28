package com.pyy.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.percentlayout.widget.PercentRelativeLayout;

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
import com.pyy.dao.JsInterface11;

public class Fragment_Page11_3 extends Fragment implements View.OnClickListener {
    private Context context;
    private EditText input1, input2, input3, input4;
    private TableLayout tabLayout;
    private WebView webview;
    private PercentRelativeLayout ll8;
    private TextView tip4;
    private final StringBuilder[] param = new StringBuilder[4];
    private TextView title;
    private int current_focus = 0;

    public Fragment_Page11_3(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__page113, container, false);
        initView(view);
        return view;
    }
@SuppressLint("UseCompatLoadingForDrawables")
void initInput(){
        input1.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input2.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input3.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input4.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
}
    @SuppressLint("UseCompatLoadingForDrawables")
    private void initView(View view) {
        input1 = view.findViewById(R.id.input1);
        input2 = view.findViewById(R.id.input2);
        input3 = view.findViewById(R.id.input3);
        input4 = view.findViewById(R.id.input4);
        title = view.findViewById(R.id.title);
        title.setText("已知：角度，求：偏心距");
        input1.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input2.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input3.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
        input4.setShowSoftInputOnFocus(false);//设置获取焦点后，不弹出键盘
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
        input4.setOnClickListener(view13 -> {
            initInput();
            input4.setBackground(getResources().getDrawable(R.drawable.bg_edittext_select));
            current_focus = 3;
            if (tabLayout.getVisibility() == View.GONE)
                tabLayout.setVisibility(View.VISIBLE);
            else if (webview.getVisibility() == View.VISIBLE)
                webview.setVisibility(View.GONE);
        });

        param[0] = new StringBuilder();
        param[1] = new StringBuilder();
        param[2] = new StringBuilder();
        param[3] = new StringBuilder();
        tabLayout = view.findViewById(R.id.tablayout);
        ll8 = view.findViewById(R.id.ll8);
        tip4 = view.findViewById(R.id.tip4);
        webview = view.findViewById(R.id.webview);
        webview.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webview.getSettings();
        //  允许WebView加载JavaScript
        webSettings.setJavaScriptEnabled(true);

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

    @SuppressLint({"DefaultLocale", "SetTextI18n", "NonConstantResourceId", "JavascriptInterface"})
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
                    else if (current_focus == 2)
                        input3.setText(param[current_focus]);
                    else
                        input4.setText(param[current_focus]);
                }
                break;
            case R.id.bt1:
                param[current_focus].append("1");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt2:
                param[current_focus].append("2");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt3:
                param[current_focus].append("3");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt4:
                param[current_focus].append("4");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt5:
                param[current_focus].append("5");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt6:
                param[current_focus].append("6");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt7:
                param[current_focus].append("7");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt8:
                param[current_focus].append("8");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.bt9:
                param[current_focus].append("9");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
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
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
                break;
            case R.id.point:
                if (param[current_focus].indexOf(".") == -1)
                    param[current_focus].append(".");
                if (current_focus == 0)
                    input1.setText(param[current_focus]);
                else if (current_focus == 1)
                    input2.setText(param[current_focus]);
                else if (current_focus == 2)
                    input3.setText(param[current_focus]);
                else
                    input4.setText(param[current_focus]);
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
                double D = Double.parseDouble(input1.getText().toString());
                double R = Double.parseDouble(input2.getText().toString());
                double R2 = Double.parseDouble(input3.getText().toString());
                double a = Double.parseDouble(input4.getText().toString());
                double wt_a = 0;
                double wt_b = 0;
                double wt_c = 0;
                double wt_d = 0;
                double wt_g = 0;
                double wt_h = 0;
                double wt_i = 0;
                double H = 0;
                double L = 0;
                webview.loadUrl("file:///android_asset/y-3b.s");
                if (D > 0 && R > (D / 2) && (a > 0 && a <= 90)) {//取值范围
                    double h1 = R * Math.tan(a / 2 * Math.PI / 180);
                    H = (R2 + h1) * Math.sin(a * Math.PI / 180);
                    L = H / Math.tan(a * Math.PI / 180) + h1;
                    if (a >= 45) {
                        wt_a = (R + D / 2) * Math.sin(((90 - a) * Math.PI / 180));
                        wt_b = (R - D / 2) * Math.sin(((90 - a) * Math.PI / 180));
                    } else {
                        double a1 = 90 - a;
                        wt_a = (R + D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
                        wt_b = (R - D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
                    }
                    wt_c = 2 * (R + D / 2) * Math.sin((a / 2 * Math.PI / 180));
                    wt_d = 2 * (R - D / 2) * Math.sin((a / 2 * Math.PI / 180));
                    wt_g = (R + D / 2) * Math.PI * (a / 180);
                    wt_h = (R - D / 2) * Math.PI * (a / 180);
                    wt_i = R * Math.tan((a / 2 * Math.PI / 180));
                } else Toast.makeText(context, "参数输入错误，请检查", Toast.LENGTH_SHORT).show();
                webview.addJavascriptInterface(new JsInterface11(D, R, R2, H, L, 0, a, wt_a, wt_b, wt_c, wt_d, wt_g, wt_h, wt_i), "JsInterface");
                webview.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.GONE);
                break;
        }
    }
}