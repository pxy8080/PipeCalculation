package com.pyy.dao;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;

@SuppressLint("DefaultLocale")
public class JsInterface11 {
    double D;
    double R;
    double R2;
    double H;
    double L;
    double L1;
    double a;
    double wt_a;
    double wt_b;
    double wt_c;
    double wt_d;
    double wt_g;
    double wt_h;
    double wt_i;

    public JsInterface11(double d, double r, double r2, double h, double l, double l1, double a, double wt_a, double wt_b, double wt_c, double wt_d, double wt_g, double wt_h, double wt_i) {
        D = d;
        R = r;
        R2 = r2;
        H = h;
        L = l;
        L1 = l1;
        this.a = a;
        this.wt_a = wt_a;
        this.wt_b = wt_b;
        this.wt_c = wt_c;
        this.wt_d = wt_d;
        this.wt_g = wt_g;
        this.wt_h = wt_h;
        this.wt_i = wt_i;
    }

    @JavascriptInterface
    public String D() {
        return String.format("%.2f", D);
    }

    @JavascriptInterface
    public String R() {
        return String.format("%.2f", R);
    }

    @JavascriptInterface
    public String R2() {
        return String.format("%.2f", R2);
    }

    @JavascriptInterface
    public String H() {
        return String.format("%.2f", H);
    }

    @JavascriptInterface
    public String L() {
        return String.format("%.2f", L);
    }

    @JavascriptInterface
    public String L1() {
        return String.format("%.2f", L1);
    }

    @JavascriptInterface
    public String a() {
        return String.format("%.2f", a);
    }

    @JavascriptInterface
    public String wt_a() {
        return String.format("%.2f", wt_a);
    }

    @JavascriptInterface
    public String wt_b() {
        return String.format("%.2f", wt_b);
    }

    @JavascriptInterface
    public String wt_c() {
        return String.format("%.2f", wt_c);
    }

    @JavascriptInterface
    public String wt_d() {
        return String.format("%.2f", wt_d);
    }

    @JavascriptInterface
    public String wt_g() {
        return String.format("%.2f", wt_g);
    }

    @JavascriptInterface
    public String wt_h() {
        return String.format("%.2f", wt_h);
    }

    @JavascriptInterface
    public String wt_i() {
        return String.format("%.2f", wt_i);
    }
}
