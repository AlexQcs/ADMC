package com.hc.admc.ui.contract;

/**
 * Created by alex on 2017/8/10.
 */

public class MainContract {
    public interface MainView{

        //暂停播放
        void pauseVideo();

        //恢复播放
        void replayVideo();
    }

    public interface MainPresenter {
       void parseProgramXml();
    }
}
