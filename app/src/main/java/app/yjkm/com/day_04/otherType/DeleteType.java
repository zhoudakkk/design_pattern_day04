package app.yjkm.com.day_04.otherType;

import android.widget.Button;

import java.util.List;

/**
 * 点击删除后
 * 管理状态
 */
public class DeleteType implements AllType {

    private Button mButton;
    private ClockActivity.MyAdapter mAdapter;
    private List<ClockInfo> mInfos;

    public DeleteType(Button button, ClockActivity.MyAdapter adapter, List<ClockInfo> infos) {
        mButton = button;
        mAdapter = adapter;
        mInfos = infos;
    }

    @Override
    public void upData() {
        mAdapter.isManager = "0";
        mButton.setText("管理");
    }

    @Override
    public void setData() {
        if (mInfos == null) {
            return;
        }
        for (int i = 0; i < mInfos.size(); i++) {
            ClockInfo info = mInfos.get(i);
            if ("1".equals(info.isChoose)) {
                mInfos.remove(i);
            }
        }
    }


}
