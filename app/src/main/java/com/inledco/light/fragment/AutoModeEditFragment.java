package com.inledco.light.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.inledco.light.R;
import com.inledco.light.bean.LightModel;

/**
 * 自动模式编辑界面
 * 1.增加和删除时间点
 * 2.时间点列表
 * 3.更改选择的时间点及时间点对应的设置
 * 4.保存和取消设置
 */
public class AutoModeEditFragment extends BaseFragment {
    // 初始化参数
    private static final String LIGHT_MODEL = "LIGHT_MODEL";

    private LightModel mLightModel;

    private OnFragmentInteractionListener mListener;

    // 控件
    private Button mAddTimePointBtn;
    private Button mDeleteTimePointBtn;
    private TimePicker mTimePointPicker;
    private RecyclerView mTimePointListRv;
    private RecyclerView mColorSliderRv;
    private Button mSaveBtn;
    private Button mCancelBtn;

    public AutoModeEditFragment() {
        // Required empty public constructor
    }

    /**
     * 创建一个实例
     * @param lightModel 设备模型
     * @return 实例
     */
    public static AutoModeEditFragment newInstance(LightModel lightModel) {
        AutoModeEditFragment fragment = new AutoModeEditFragment();
        Bundle args = new Bundle();

        args.putSerializable(LIGHT_MODEL, lightModel);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLightModel = (LightModel) getArguments().getSerializable(LIGHT_MODEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_mode_edit, container, false);

        initData();
        initView(view);
        initEvent();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mAddTimePointBtn = view.findViewById(R.id.auto_mode_edit_addTimePoint);
        mDeleteTimePointBtn = view.findViewById(R.id.auto_mode_edit_deleteTimePoint);
        mTimePointPicker = view.findViewById(R.id.auto_mode_edit_timePicker);
        mTimePointListRv = view.findViewById(R.id.auto_mode_edit_timePointList);
        mColorSliderRv = view.findViewById(R.id.auto_mode_edit_colorSlider);
        mSaveBtn = view.findViewById(R.id.auto_mode_edit_saveBtn);
        mCancelBtn = view.findViewById(R.id.auto_mode_edit_cancelBtn);
    }

    @Override
    protected void initEvent() {
        mAddTimePointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                TimePicker timePicker = new TimePicker(getContext());

                timePicker.setIs24HourView(true);

                builder.setView(timePicker);
                builder.setNeutralButton(R.string.cancel, null);
                builder.setNeutralButton(R.string.confirm, null);

                builder.show();
            }
        });

        mDeleteTimePointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("确认删除时间点");
                builder.setView(new TimePicker(getContext()));
                builder.setNeutralButton(R.string.cancel, null);
                builder.setNeutralButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 同步到模型中
                    }
                });

                builder.show();
            }
        });

        mTimePointPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}













































