package app.yjkm.com.day_04.otherType;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import app.yjkm.com.day_04.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 闹钟界面
 * item 要有3种状态显示 然后保证其扩展性
 * <p>
 * 现在我就这水平了 感觉有优化的空间 但是 无从下手 201903024
 * <p>
 * 用了状态模式来封装了一下
 * 代码量增加了但是逻辑更清楚了 感觉这里用这个模式有一点大材小用
 * 主要是逻辑不复杂但是要实现的代码多
 * 用这个模式我就多写了4个类 盈亏一半一半
 */
public class ClockActivity extends AppCompatActivity {

    private RecyclerView mClockRv;
    private List<ClockInfo> mInfoList = new ArrayList<>();
    private MyAdapter mAdapter;
    private Button mClockBtn;
    private DeleteType deleteType;
    private ManagerType managerType;
    private AddType addType;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_activity);
        mClockRv = findViewById(R.id.clock_rv);
        for (int i = 0; i < 5; i++) {
            ClockInfo info = new ClockInfo();
            info.id = "" + i;
            mInfoList.add(info);
        }
        mAdapter = new MyAdapter(mInfoList);
        mClockRv.setLayoutManager(new GridLayoutManager(ClockActivity.this, 1));
        mClockRv.setAdapter(mAdapter);

        mClockBtn = findViewById(R.id.clock_btn);
        mClockBtn.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String trim = mClockBtn.getText().toString().trim();
            AllType type = null;
            switch (trim) {
                case "管理":
                    if (managerType == null) {
                        managerType = new ManagerType(mClockBtn, mAdapter, mInfoList);
                    }
                    type = managerType;
                    break;
                case "删除":
                    if (deleteType == null) {
                        deleteType = new DeleteType(mClockBtn, mAdapter, mInfoList);
                    }
                    type = deleteType;
                    break;
                case "添加":
                    if (addType == null) {
                        addType = new AddType(mClockBtn, mAdapter, mInfoList);
                    }
                    type = addType;
                    break;
            }
            type.setData();
            type.upData();
            mAdapter.notifyDataSetChanged();
        }
    };


    class MyAdapter extends RecyclerView.Adapter<VH> {

        private List<ClockInfo> mInfoList;
        //是否是管理状态 0 是 1 不是
        public String isManager = "0";

        public MyAdapter(List<ClockInfo> infos) {
            mInfoList = infos;
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.item_clock, null);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final VH vh, int i) {
            final ClockInfo item = mInfoList.get(i);
            vh.item_id_tv.setText(item.id);
            vh.item_is_choose_tv.setText(item.isChoose);
            vh.item_is_choose_tv.setVisibility(View.GONE);
            if (!"0".equals(isManager)) {
                vh.item_is_choose_tv.setVisibility(View.VISIBLE);
            }
            vh.item_is_choose_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("0".equals(item.isChoose)) {
                        vh.item_is_choose_tv.setText("1");
                        item.isChoose = "1";
                    } else {
                        vh.item_is_choose_tv.setText("0");
                        item.isChoose = "0";
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mInfoList == null ? 0 : mInfoList.size();
        }
    }

    class VH extends RecyclerView.ViewHolder {

        public TextView item_id_tv;
        public TextView item_is_choose_tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            item_id_tv = itemView.findViewById(R.id.item_id_tv);
            item_is_choose_tv = itemView.findViewById(R.id.item_is_choose_tv);
        }
    }
}
