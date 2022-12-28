package com.pyy.dao;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;

@SuppressLint("DefaultLocale")
public class JsInterface10 {
    private final Double D;
    private final Double a;
    private final Double R;

    public JsInterface10(Double D, Double a, Double R) {
        this.D = D;
        this.a = a;
        this.R = R;
    }

    @JavascriptInterface
    public String D() {
        return String.format("%.2f", D);//把角度值传给js
    }

    @JavascriptInterface
    public String a() {
        return String.format("%.2f", a);//把角度值传给js
    }

    @JavascriptInterface
    public String wt_a() {
        Double wt_a = (R + D / 2) * Math.sin(((90 - a) * Math.PI / 180)) * 1000000 / 1000000;
        return String.format("%.2f", wt_a);
    }

    @JavascriptInterface
    public String wt_b() {
        Double wt_b = (R - D / 2) * Math.sin(((90 - a) * Math.PI / 180)) * 1000000 / 1000000;
        return String.format("%.2f", wt_b);
    }

    @JavascriptInterface
    public String wt_c() {
        Double wt_c = 2 * (R + D / 2) * Math.sin((a / 2 * Math.PI / 180)) * 1000000 / 1000000;
        return String.format("%.2f", wt_c);
    }

    @JavascriptInterface
    public String wt_d() {
        Double wt_d = 2 * (R - D / 2) * Math.sin((a / 2 * Math.PI / 180)) * 1000000 / 1000000;
        return String.format("%.2f", wt_d);
    }

    @JavascriptInterface
    public String wt_g() {
        Double wt_g  = (R + D / 2) * Math.PI * (a / 180);
        return String.format("%.2f", wt_g);
    }

    @JavascriptInterface
    public String wt_h() {
        Double wt_h = (R - D / 2) * Math.PI * (a / 180);
        return String.format("%.2f", wt_h);
    }

    @JavascriptInterface
    public String wt_i() {
        Double wt_i = R * Math.tan((a / 2 * Math.PI / 180)) * 1000000 / 1000000;
        return String.format("%.2f", wt_i);
    }

}
