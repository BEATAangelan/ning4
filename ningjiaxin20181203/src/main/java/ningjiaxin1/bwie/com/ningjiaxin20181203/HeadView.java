package ningjiaxin1.bwie.com.ningjiaxin20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HeadView extends LinearLayout {
    private EditText edit_shou;
    private ImageView image_shou;
    Context mContext;
    public HeadView(Context context) {
        super(context);
        mContext=context;
        initView();
    }

    public HeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }
    public void initView(){
        View view = View.inflate(mContext, R.layout.head, null);
        edit_shou = view.findViewById(R.id.edit_shou);
        image_shou = view.findViewById(R.id.image_serch);
        image_shou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallBack!=null){
                    mCallBack.getData(edit_shou.getText().toString());
                }
            }
        });
        addView(view);
    }
    //定义一个接口
    CallBack mCallBack;
    public void setOnCallBack(CallBack callBack){
        mCallBack=callBack;
    }
    public interface CallBack{
        void getData(String str);
   }
}
