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

import java.util.Objects;


public class Fragment_Page11_012 extends Fragment implements View.OnClickListener {
    private final Context context;
    private EditText input1, input2, input3, input4;
    private TableLayout tabLayout;
    private WebView webview;
    private PercentRelativeLayout ll8;
    private final String sign;
    private TextView tip4;
    private TextView title;
    private final StringBuilder[] param = new StringBuilder[4];

    private int current_focus = 0;

    public Fragment_Page11_012(Context context, String sign) {
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
        View view = inflater.inflate(R.layout.fragment__page11_012, container, false);

        initView(view);
        input1 = view.findViewById(R.id.input1);
        input2 = view.findViewById(R.id.input2);
        input3 = view.findViewById(R.id.input3);
        input4 = view.findViewById(R.id.input4);

        if (Objects.equals(sign, "111")) {
            ll8.setVisibility(View.GONE);
            tip4.setText("弯头角度a：");
            title.setText("已知：角度，求：偏心距");
        } else if (Objects.equals(sign, "110")) {
            ll8.setVisibility(View.GONE);
            title.setText("已知：偏心距，求：角度与安装长度");
            tip4.setText("偏心距H：");
        } else {
            title.setText("已知：偏心距，求：角度");
            tip4.setText("偏心距H：");
            ll8.setVisibility(View.VISIBLE);
        }


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

        return view;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    void initInput() {
        input1.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input2.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input3.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
        input4.setBackground(getResources().getDrawable(R.drawable.edittext_bg));
    }

    @SuppressLint("SetJavaScriptEnabled")
    void initView(View view) {
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
        title = view.findViewById(R.id.title);
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
                if ((input1.getText().toString().equals("")) || (input2.getText().toString().equals("")) || (input4.getText().toString().equals("")))
                    return;
                double D = Double.parseDouble(input1.getText().toString());
                double R = Double.parseDouble(input2.getText().toString());

                if (Objects.equals(sign, "110")) {
//                    if (input3.getText().toString().equals(""))
//                        return;
//                    double R2 = Double.parseDouble(input3.getText().toString());
                    double H = Double.parseDouble(input4.getText().toString());
                    yaotw_1(D, R, H);
                } else if (Objects.equals(sign, "111")) {
                    double a = Double.parseDouble(input4.getText().toString());
                    yaotw_2(D, R, a);
                } else if (Objects.equals(sign, "112")) {
                    double R2 = Double.parseDouble(input3.getText().toString());
                    double H = Double.parseDouble(input4.getText().toString());
                    yaotw_3(D, R, R2, H);
                }
                break;
        }
    }

    //摇头弯计算公式1
    void yaotw_1(double D, double R, double H) {
        double a = 0;
        double L = 0;
        double wt_a;
        double wt_b;
        double wt_g;
        double wt_h;
        double wt_i;
        webview.loadUrl("file:///android_asset/y-123.s");
        if (D > 0 && R > D / 2 && (H > 0 && H <= 2 * R)) {//取值范围
            if (R == H) {
                a = 45;
                L = Math.sqrt(2) * H;
            } else if (R < H && H < 2 * R) {
                a = 45 + Math.asin((H - R) / (1.4142 * R)) * 180 / Math.PI;
                L = H / Math.tan(a * Math.PI / 180) + R * Math.tan(a / 2 * Math.PI / 180);
            } else if (R > H) {
                a = 45 - Math.asin((R - H) / (1.4142 * R)) * 180 / Math.PI;
                L = H / Math.tan(a * Math.PI / 180) + R * Math.tan(a / 2 * Math.PI / 180);
            }
            if (a >= 45) {
                wt_a = (R + D / 2) * Math.sin(((90 - a) * Math.PI / 180));
                wt_b = (R - D / 2) * Math.sin(((90 - a) * Math.PI / 180));
            } else {
                double a1 = 90 - a;
                wt_a = (R + D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
                wt_b = (R - D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
            }
            wt_g = (R + D / 2) * Math.PI * (a / 180);
            wt_h = (R - D / 2) * Math.PI * (a / 180);
            wt_i = R * Math.tan((a / 2 * Math.PI / 180));
            webview.addJavascriptInterface(new JsInterface11(D, R, 0, H, L, 0, a, wt_a, wt_b, 0, 0, wt_g, wt_h, wt_i), "JsInterface");
            webview.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
        } else Toast.makeText(context, "参数输入错误，请检查", Toast.LENGTH_SHORT).show();
    }

    //摇头弯计算公式2
    void yaotw_2(double D, double R, double a) {
        double h1 = R * Math.tan(a / 2 * Math.PI / 180);
        double H = (R + h1) * Math.sin(a * Math.PI / 180);
        double L = H / Math.tan(a * Math.PI / 180) + h1;
        double wt_a;
        double wt_b;
        double wt_c;
        double wt_d;
        double wt_g;
        double wt_h;
        double wt_i;
        webview.loadUrl("file:///android_asset/y-123.s");
        if (D > 0 && R > D / 2 && (a > 0 && a <= 90)) {
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
            webview.addJavascriptInterface(new JsInterface11(D, R, 0, H, L, 0, a, wt_a, wt_b, wt_c, wt_d, wt_g, wt_h, wt_i), "JsInterface");
            webview.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
        } else Toast.makeText(context, "参数输入错误，请检查", Toast.LENGTH_SHORT).show();

    }

    //摇头弯计算公式3
    private void yaotw_3(double D, double R, double R2, double H) {
        double a = 0;
        double L = 0;
        double b;
        double b1;
        double a2;
        double wt_a;
        double wt_b;
        double wt_g;
        double wt_h;
        double wt_i;
        webview.loadUrl("file:///android_asset/y-123.s");
        if (D > 0 && R > D / 2 && (H > 0 && H <= 2 * R)) {//取值范围
            if (R == H) {
                a = Math.atan(R / R2) * 180 / Math.PI;
                L = H / Math.tan(a * Math.PI / 180) + R * Math.tan(a / 2 * Math.PI / 180);
            } else if (R < H && H < 2 * R) {
                //a=45+Math.asin((H-R)/(1.4142*R))*180/Math.PI;
                b = Math.atan(R / R2) * 180 / Math.PI;
                b1 = Math.sin(b * Math.PI / 180);
                a2 = Math.asin((H - R) / (R / b1)) * 180 / Math.PI;
                a = a2 + b;
                L = H / Math.tan(a * Math.PI / 180) + R * Math.tan(a / 2 * Math.PI / 180);
            } else if (R > H) {
                b = Math.atan(R / R2) * 180 / Math.PI;
                b1 = Math.sin(b * Math.PI / 180);
                a2 = Math.asin((R - H) / (R / b1)) * 180 / Math.PI;
                a = b - a2;
                L = H / Math.tan(a * Math.PI / 180) + R * Math.tan(a / 2 * Math.PI / 180);

            }

            if (a > 45) {
                wt_a = (R + D / 2) * Math.sin(((90 - a) * Math.PI / 180));
                wt_b = (R - D / 2) * Math.sin(((90 - a) * Math.PI / 180));
            } else {
                double a1 = 90 - a;
                wt_a = (R + D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
                wt_b = (R - D / 2) * Math.sin(((90 - a1) * Math.PI / 180));
            }

            wt_g = (R + D / 2) * Math.PI * (a / 180);
            wt_h = (R - D / 2) * Math.PI * (a / 180);
            wt_i = R * Math.tan((a / 2 * Math.PI / 180));
            webview.addJavascriptInterface(new JsInterface11(D, R, R2, H, L, 0, a, wt_a, wt_b, 0, 0, wt_g, wt_h, wt_i), "JsInterface");
            webview.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
        } else Toast.makeText(context, "参数输入错误，请检查", Toast.LENGTH_SHORT).show();
    }
}
