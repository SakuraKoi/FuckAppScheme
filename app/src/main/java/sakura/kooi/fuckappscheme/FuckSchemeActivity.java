package sakura.kooi.fuckappscheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

public class FuckSchemeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        View view = new View(this);
        view.setBackgroundColor(Color.BLACK);
        setContentView(view);
        Intent intent = this.getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri != null) {
                String type = null;
                if ("market".equals(uri.getScheme()) && "details".equals(uri.getHost()))
                    type = "应用商店";
                else if ("baiduboxapp".equals(uri.getScheme()) && "v1".equals(uri.getHost()))
                    type = "百度";
                else if ("tbopen".equals(uri.getScheme()) && "m.taobao.com".equals(uri.getHost()))
                    type = "淘宝";
                else if ("intent".equals(uri.getScheme()) && "m.taobao.com".equals(uri.getHost()))
                    type = "淘宝";
                else if ("zhihu".equals(uri.getScheme()) && "questions".equals(uri.getHost()))
                    type = "知乎";
                else if ("com.baidu.tieba".equals(uri.getScheme()) && "unidispatch".equals(uri.getHost()))
                    type = "百度贴吧";

                if (type != null)
                    Toast.makeText(this, "拦截了一次打开 " + type +" 的请求", Toast.LENGTH_SHORT).show();
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            finishAndRemoveTask();
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }, 300);
    }
}