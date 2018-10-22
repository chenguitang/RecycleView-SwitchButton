package com.greetty.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.greetty.recycleviewdemo.bean.Student;
import com.greetty.recycleviewdemo.view.MyToggleButton;
import com.greetty.recycleviewdemo.view.SwitchButton;
import com.greetty.recycleviewdemo.view.SwitchButton2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FileName: MyRecycleViewAdapter
 * Author: Greetty
 * Time: 2018/10/18 20:00
 * Desc: TODO
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.StudentItemHolder> {
    private static final String TAG = "MyRecycleViewAdapter";
    private List<Student> studentList;
    private Context context;


    public MyRecycleViewAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public MyRecycleViewAdapter.StudentItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select, parent, false);
        return new StudentItemHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecycleViewAdapter.StudentItemHolder holder, final int position) {
        final Student student = studentList.get(position);
        holder.tvName.setText(student.getName());

//        ==========================================================================================
//        SwitchButton
//        ==========================================================================================
        holder.sbSelect.setOnCheckedChangeListener(null);//清掉监听器
        holder.sbSelect.setChecked(student.isSelect());
        holder.sbSelect.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                Log.e(TAG, "Name: " + student.getName() + "   position: " +
                        position + "   isChecked: " + isChecked);
                studentList.get(position).setSelect(isChecked);
            }
        });

//==================================================================================================
//       SwitchButton2
//==================================================================================================
//        holder.sb2Select.setOnCheckedChangeListener(null);//清掉监听器
//        holder.sb2Select.setChecked(student.isSelect());
//        holder.sb2Select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.e(TAG, "Name: " + student.getName() + "   position: " +
//                        position + "   isChecked: " + isChecked);
//                studentList.get(position).setSelect(isChecked);
//            }
//        });


//        ==========================================================================================
//        ToggleButton
//        ==========================================================================================
//        holder.btnToggle.setOnCheckedChangeListener(null);//清掉监听器
//        holder.btnToggle.setChecked(student.isSelect());
//        holder.btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.e(TAG, "Name: " + student.getName() + "   position: " +
//                        position + "   isChecked: " + isChecked);
//                studentList.get(position).setSelect(isChecked);
//            }
//        });


//        ==========================================================================================
//        MyToggleButton
//        ==========================================================================================
//        holder.myToggleButton.setOnCheckedChangeListener(null);//清掉监听器
//        holder.myToggleButton.setChecked(student.isSelect());
//        holder.myToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.e(TAG, "Name: " + student.getName() + "   position: " +
//                        position + "   isChecked: " + isChecked);
//                studentList.get(position).setSelect(isChecked);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.cb_select)
        CheckBox cbSelect;
        @BindView(R.id.sb_select)
        SwitchButton sbSelect;
//        @BindView(R.id.sb2_select)
//        SwitchButton2 sb2Select;
//        @BindView(R.id.toggle_btn)
//        ToggleButton btnToggle;
//        @BindView(R.id.mtb_toggle)
//        MyToggleButton myToggleButton;

        public StudentItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
