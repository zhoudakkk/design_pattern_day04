package app.yjkm.com.day_04.otherType;

import android.widget.Button;

import java.util.List;

/**
 * 管理状态
 */
public class ManagerType implements AllType{
    private Button mButton;
    private ClockActivity.MyAdapter mAdapter;
    private List<ClockInfo> mInfos;
    public ManagerType(Button button, ClockActivity.MyAdapter adapter, List<ClockInfo> infos) {
        mButton = button;
        mAdapter = adapter;
        mInfos = infos;
    }

    @Override
    public void upData() {
        mAdapter.isManager = "1";
        mButton.setText("删除");
    }

    @Override
    public void setData() {

    }
}
