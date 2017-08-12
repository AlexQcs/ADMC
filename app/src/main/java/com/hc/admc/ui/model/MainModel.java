package com.hc.admc.ui.model;

import com.hc.admc.bean.program.ProgramItemBean;
import com.hc.admc.mvp.base.BaseModel;
import com.hc.admc.utils.FileUtils;
import com.hc.admc.utils.XmlUtils;

import java.util.List;

/**
 * Created by alex on 2017/8/10.
 */

public class MainModel extends BaseModel{
    public void parseProgramXml(){
        String xmlStr= FileUtils.getStringFromTxT("");
        List<ProgramItemBean> programList= XmlUtils.parsePrograms(xmlStr);

    }

    public interface PlayMisson{

    }
}
