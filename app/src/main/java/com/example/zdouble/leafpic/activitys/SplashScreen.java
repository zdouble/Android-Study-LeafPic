package com.example.zdouble.leafpic.activitys;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.zdouble.leafpic.R;
import com.example.zdouble.leafpic.utils.PermissionUtils;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "SplashScreen";
    private final int REQUESTPERMISSIONS_CODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
            动态设置statusbar和navigationbar沉浸模式
            https://www.jianshu.com/p/11a2b780fd9b
            https://www.jianshu.com/p/08ff70c15667
        */
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
                .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setNavBarColor();
        setStatusBarColor();

        if (PermissionUtils.checkPermissions(getApplicationContext(), Manifest.permission
                .WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            start();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(SplashScreen.this, "我要换取权限", Toast.LENGTH_SHORT).show();
            } else {
                PermissionUtils.requestPermissions(SplashScreen.this, REQUESTPERMISSIONS_CODE, Manifest.permission
                        .WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }

    }

    public void start() {
    }

    public void setNavBarColor() {
        // 如果当前设备的sdk版本大于等于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /*
                先获取到相应颜色到资源id
                再将其透明度改变
                最后将导航栏到颜色设置成该值
             */
            getWindow().setNavigationBarColor(ColorUtils.setAlphaComponent(ContextCompat.getColor
                    (getApplicationContext(), R.color.md_black_1000), 70));
        }
    }

    public void setStatusBarColor() {
        // 如果当前设备的sdk版本大于等于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /*
                先获取到相应颜色到资源id
                再将其透明度改变
                最后将状态栏到颜色设置成该值
             */
            getWindow().setStatusBarColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(getApplicationContext()
                    , R.color.md_black_1000), 70));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        if (requestCode == REQUESTPERMISSIONS_CODE) {
            for (int grantResult : grantResults) {
                if (grantResult == -1) {
                    PermissionUtils.requestPermissions(SplashScreen.this, REQUESTPERMISSIONS_CODE, Manifest
                            .permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
                    return;
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
