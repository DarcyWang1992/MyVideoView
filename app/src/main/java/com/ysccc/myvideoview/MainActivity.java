package com.ysccc.myvideoview;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import cn.jzvd.JZVideoPlayerStandard;

/***
 *@描述 <用第三方饺子播放器来加载视频播放>
 *@作者 Administrator
 *@日期 2019-09 11-10:41
 *@版本
 */
public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private JZVideoPlayerStandard jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jzvdStd=findViewById(R.id.jzvideo);
        initVideo();
    }

    /**
     * 初始化网络视频数据
     */
    private void initVideo() {
        jzvdStd.setUp("http://img.app.ysccc.com//2019/09/p90XfnA0_1567653248769.mp4",JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL,"饺子视频");
        Glide.with(getApplicationContext()).load("http://p0.so.qhmsg.com/bdr/_240_/t01c10808f98a39bd4f.jpg")
                .into(jzvdStd.thumbImageView);
        jzvdStd.startVideo();
    }

    //播放网络视频
    private void initNetVideo() {
        //设置有进度条可以拖动快进
        MediaController localMediaController = new MediaController(this);
        videoView.setMediaController(localMediaController);
        String url = "http://img.app.ysccc.com//2019/09/p90XfnA0_1567653248769.mp4";
        videoView.setVideoPath(url);
        videoView.start();
    }

}
