package com.pyy.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.errands.test.R;

public class Fragment_Thirdstage extends Fragment {

    private static final String IPHONE_UA = "Mozilla/5.0 (Linux; Android 8.1.0; NX606J Build/OPM1.171019.026; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.98 Mobile Safari/537.36";
    private Context context;
    private String sign;

    public Fragment_Thirdstage(Context context, String sign) {
        this.context = context;
        this.sign = sign;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__thirdstage, container, false);
        WebView webView = view.findViewById(R.id.webview);
//        WebSettings settings = webView.getSettings();
//        // 是否保存表单数据
//        settings.setSaveFormData(true);
//        // 是否支持Javascript，默认值false
//        settings.setJavaScriptEnabled(true);
//        // 是否支持多窗口，默认值false
//        settings.setSupportMultipleWindows(false);
//
//        // 资源加载
//        settings.setLoadsImagesAutomatically(true); // 是否自动加载图片
//        // 缩放(zoom)
//        settings.setSupportZoom(true);          // 是否支持缩放
//        settings.setBuiltInZoomControls(false); // 是否使用内置缩放机制
//        // 默认文本编码，默认值 "UTF-8"
//        settings.setDefaultTextEncodingName("UTF-8");
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        settings.setUseWideViewPort(true);
//        settings.setDomStorageEnabled(true);
//        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);

        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAppCacheEnabled(true);


        switch (sign) {
            case "100":
                webView.loadUrl("file:///android_asset/a.html");
                break;
            case "101":
                webView.loadUrl("file:///android_asset/b.html");
                break;
            default:
                webView.loadUrl("https://www.baidu.com");
                break;
        }
        return view;
    }
}