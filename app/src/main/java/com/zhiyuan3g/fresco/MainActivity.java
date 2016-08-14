package com.zhiyuan3g.fresco;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

public class MainActivity extends AppCompatActivity {
    private final String urls[] = {
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224093&dir_path=/&name=10_01_48_5a61ed5173f5a08cb6923f31fd3c3148_1095.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224096&dir_path=/&name=10_01_48_f193be9144d2f063186b0f74c3322628_1096.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224002&dir_path=/&name=10_01_46_1db91cff6b96a9495bc24052cdf128ee_1062.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224005&dir_path=/&name=10_01_46_48aa27e5723c0e5f21a09ff26e37dab0_1063.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224008&dir_path=/&name=10_01_46_92601ae90e7c1dded6da8279ab3fc9e0_1064.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224011&dir_path=/&name=10_01_46_da04a99afb5a8e0b989d34dd8ef33a3e_1065.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224014&dir_path=/&name=10_01_46_95d05ca895c6d32b6e2e78627264ce6f_1066.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224039&dir_path=/&name=10_01_47_74520959560983ab7057702a05cfe79c_1075.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224042&dir_path=/&name=10_01_47_1f2ee819f7e7b7294498d53345694ebe_1076.jpg",
            "http://ac.tc.qq.com/store_file_download?buid=15017&uin=1460224074&dir_path=/&name=10_01_47_f68a4f58469204f5f58d0f7e719715fd_1088.jpg"
    };

    SimpleDraweeView simpleDraweeView;
    Button btnNext, btnList;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化Fresco控件
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        initView();

        //生成控件的控制工具
        DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(urls[0])
                .setTapToRetryEnabled(true)//当加载图片失败的时候，显示加载图片失败的图片
                .build();
        simpleDraweeView.setController(controller);//设置控制器，绑定控制工具
    }

    private void initView() {
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sv);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnList = (Button) findViewById(R.id.btnShowList);
        btnList.setBackgroundColor(Color.TRANSPARENT);
        btnNext.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                index++;
                simpleDraweeView.setImageURI(urls[index % 10]);
                break;
            case R.id.btnShowList:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnClear:
                ImagePipeline pipeline = Fresco.getImagePipeline();//对缓存进行管理
                pipeline.clearCaches();
            default:
                break;
        }
    }
}
