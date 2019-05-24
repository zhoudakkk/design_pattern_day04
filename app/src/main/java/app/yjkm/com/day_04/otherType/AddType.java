package app.yjkm.com.day_04.otherType;

import android.widget.Button;

import java.util.List;

public class AddType implements AllType {

    private Button mButton;
    private ClockActivity.MyAdapter mAdapter;
    private List<ClockInfo> mInfos;

    public AddType(Button button, ClockActivity.MyAdapter adapter, List<ClockInfo> infos) {
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
            info.isChoose = "0";
        }
    }
}
