package com.zhiyuan3g.fresco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
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
    String names[] = {"第一张", "第二张", "第三张", "第四张", "第五张", "第六张", "第七张", "第八张", "第九张", "第十张"};
    List<NaruTo> naruToList = new ArrayList<>();
    NaruTo naruTo;
    ListView mlistview;
    NuruToAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_show);

        initView();
        getItem();

        adapter = new NuruToAdapter(naruToList, this);

        try{

            mlistview.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void initView() {

        mlistview = (ListView) findViewById(R.id.list_view);

    }

    //获取图片
    public void getItem() {
        for (int index = 0; index < 30; index++) {
            naruTo = new NaruTo(names[index % 10], urls[index % 10]);
            naruToList.add(naruTo);
        }
    }
}
