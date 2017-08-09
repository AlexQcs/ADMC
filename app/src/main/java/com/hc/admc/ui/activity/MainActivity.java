package com.hc.admc.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hc.admc.R;
import com.hc.admc.bean.program.Programtask;
import com.hc.admc.utils.XmlUtils;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<programtask>\n" +
                "    <!-- 节目单 -->\n" +
                "    <programs>\n" +
                "        <!-- 节目1 -->\n" +
                "        <programItem>\n" +
                "            <!-- 素材 -->\n" +
                "            <matItems>\n" +
                "            \t<!-- sortNum 是素材的播发优先级，同一块显示区域，允许多个素材循环播放显示 数值越小优先级越高 -->\n" +
                "            \t<!-- itemId  显示区块的唯一标识  -->\n" +
                "                <matItem itemId=\"text_3_1496805271496\" sortNum=\"1\">\n" +
                "                \t<!-- type 是素材的类型也是其在显示图层中的等级，大的优先级高 -->\n" +
                "                \t<!-- 1:图片，2:视频，3:音频，4:文字,5:网址 -->\n" +
                "                    <material type=\"4\">\n" +
                "                        <content>测试文字测试文字测试文字测试文字测试文字测试文字</content>\n" +
                "                        <matName>测试文字</matName>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "                <matItem itemId=\"url_4_1496805277605\" sortNum=\"1\">\n" +
                "                    <material type=\"5\">\n" +
                "                        <content>http://map.baidu.com</content>\n" +
                "                        <matName>百度地图</matName>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "                <matItem itemId=\"video_2_1496805266232\" sortNum=\"1\">\n" +
                "                    <material suffix=\"mp4\" type=\"2\">\n" +
                "                        <matName>7266015BB22649A291DD97BC11653DA2.mp4</matName>\n" +
                "                        <path>20170513/068b5bae-8ccc-4f25-80a9-5a987608fb41.mp4</path>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "                <matItem itemId=\"video_2_1496805266232\" sortNum=\"2\">\n" +
                "                    <material suffix=\"mp4\" type=\"2\">\n" +
                "                        <matName>test2.mp4</matName>\n" +
                "                        <path>20170513/84da084c-2714-4e15-ab63-52da81ff4040.mp4</path>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "            </matItems>\n" +
                "            <!-- 节目基础设置 -->\n" +
                "            <program height=\"1920\" width=\"1080\">\n" +
                "                <!-- 各个显示区块的位置，和大小 -->\n" +
                "                <items>[\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"image_1_1496805256519\",\n" +
                "\t\t\t\t\t\t\"x\": 0,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 4,\n" +
                "\t\t\t\t\t\t\"height\": 4\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"video_2_1496805266232\",\n" +
                "\t\t\t\t\t\t\"x\": 6,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 5,\n" +
                "\t\t\t\t\t\t\"height\": 4\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"url_4_1496805277605\",\n" +
                "\t\t\t\t\t\t\"x\": 0,\n" +
                "\t\t\t\t\t\t\"y\": 5,\n" +
                "\t\t\t\t\t\t\"width\": 18,\n" +
                "\t\t\t\t\t\t\"height\": 9\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"text_3_1496805271496\",\n" +
                "\t\t\t\t\t\t\"x\": 12,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 6,\n" +
                "\t\t\t\t\t\t\"height\": 4\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]</items>\n" +
                "            </program>\n" +
                "            <!-- 定时任务 -->\n" +
                "            <!-- playNum \t节目优先级 数值越小越优先级越高 -->\n" +
                "            <!-- week \t\t指定星期几播发 -->\n" +
                "            <programTaskRelation beginDate=\"2017-07-25\" beginTime=\"11:07:00\" endDate=\"2017-07-31\" endTime=\"15:05:38\" playNum=\"1\" week=\"2,7\"/>\n" +
                "        </programItem>\n" +
                "        <!-- 节目2 -->\n" +
                "        <programItem>\n" +
                "            <matItems>\n" +
                "                <matItem itemId=\"video_1_1501133859273\" sortNum=\"1\">\n" +
                "                    <material fileSize=\"27.07\" suffix=\"mp4\" type=\"2\">\n" +
                "                        <matName>test3.mp4</matName>\n" +
                "                        <path>20170513/5e45fe8e-de45-4881-adda-ae0c9aa20ba6.mp4</path>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "            </matItems>\n" +
                "            <program height=\"1080\" width=\"1920\">\n" +
                "                <items>[\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"video_1_1501133859273\",\n" +
                "\t\t\t\t\t\t\"x\": 0,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 32,\n" +
                "\t\t\t\t\t\t\"height\": 15\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]</items>\n" +
                "            </program>\n" +
                "            <programTaskRelation beginDate=\"\" beginTime=\"15:52:30\" endDate=\"\" endTime=\"15:53:00\" playNum=\"2\" week=\"2,4\"/>\n" +
                "        </programItem>\n" +
                "        <!-- 节目2 -->\n" +
                "        <programItem>\n" +
                "            <matItems>\n" +
                "                <matItem itemId=\"video_1_1501124075270\" sortNum=\"1\">\n" +
                "                    <material fileSize=\"27.07\" suffix=\"mp4\" type=\"2\">\n" +
                "                        <matName>test3.mp4</matName>\n" +
                "                        <path>20170513/5e45fe8e-de45-4881-adda-ae0c9aa20ba6.mp4</path>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "                <matItem itemId=\"video_2_1501124080477\" sortNum=\"1\">\n" +
                "                    <material suffix=\"mp4\" type=\"2\">\n" +
                "                        <matName>test2.mp4</matName>\n" +
                "                        <path>20170513/84da084c-2714-4e15-ab63-52da81ff4040.mp4</path>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "                <matItem itemId=\"url_4_1501124100117\" sortNum=\"1\">\n" +
                "                    <material type=\"5\">\n" +
                "                        <content>http://map.baidu.com</content>\n" +
                "                        <matName>百度地图</matName>\n" +
                "                    </material>\n" +
                "                </matItem>\n" +
                "            </matItems>\n" +
                "            <program height=\"1080\" width=\"1920\">\n" +
                "                <items>[\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"video_1_1501124075270\",\n" +
                "\t\t\t\t\t\t\"x\": 0,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 11,\n" +
                "\t\t\t\t\t\t\"height\": 4\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"video_2_1501124080477\",\n" +
                "\t\t\t\t\t\t\"x\": 20,\n" +
                "\t\t\t\t\t\t\"y\": 0,\n" +
                "\t\t\t\t\t\t\"width\": 12,\n" +
                "\t\t\t\t\t\t\"height\": 4\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"audio_3_1501124091750\",\n" +
                "\t\t\t\t\t\t\"x\": 12,\n" +
                "\t\t\t\t\t\t\"y\": 5,\n" +
                "\t\t\t\t\t\t\"width\": 7,\n" +
                "\t\t\t\t\t\t\"height\": 1\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"id\": \"url_4_1501124100117\",\n" +
                "\t\t\t\t\t\t\"x\": 11,\n" +
                "\t\t\t\t\t\t\"y\": 9,\n" +
                "\t\t\t\t\t\t\"width\": 9,\n" +
                "\t\t\t\t\t\t\"height\": 3\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t]</items>\n" +
                "            </program>\n" +
                "            <programTaskRelation beginDate=\"2017-07-27\" beginTime=\"11:06:00\" endDate=\"2017-07-28\" endTime=\"15:05:38\" playNum=\"3\" week=\"4\"/>\n" +
                "        </programItem>\n" +
                "    </programs>\n" +
                "</programtask>";
//        InputStream in = new ByteArrayInputStream(xmlStr.getBytes());
//        XmlPullParser parser = Xml.newPullParser();
//        try {
//            parser.setInput(in, "UTF-8");
//        } catch (XmlPullParserException e) {
//            e.printStackTrace();
//        }
//        PostResult postResult = null;
//        try {
//            postResult = XmlUtils.getBeanByParseXml(parser, "programItem", ProgramItemBean.class, "programtask", TempClass.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LogUtils.e("MainActivity", "开始");
//        LogUtils.e("MainActivity", postResult.toString());
//        List<ProgramItemBean> list = postResult.getList();
//        String tvStr = "";
//        for (ProgramItemBean bean : list) {
//            tvStr += bean.toString();
//        }
        Programtask programtask= (Programtask) XmlUtils.getXMLObject(xmlStr,Programtask.class);
        mTextView.setText(programtask.toString());
//        mTextView.setX(200);
//        mTextView.setY(200);
    }
}
