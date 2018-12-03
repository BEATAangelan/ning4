package ningjiaxin1.bwie.com.ningjiaxin20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WaterFallLayout extends LinearLayout {
    //定义一个最大孩子的高度
    int mMaxChildenHeight;
    //定义上下边距和左右间距
    int mTopChilden=20;
    int mLeftChilden=20;
    public WaterFallLayout(Context context) {
        super(context);
    }

    public WaterFallLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取父布局的宽和高
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //找最大孩子
        findMaxChilden();
        int left=0,top=0;
        //得到孩子的数量
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if ((left+view.getMeasuredWidth())>sizeWidth){
                    top+=mMaxChildenHeight+mTopChilden;
                    left=0;
                }
            }
            left+=mLeftChilden+view.getMeasuredWidth();
        }
        setMeasuredDimension(sizeWidth,(top+mMaxChildenHeight)>sizeHeight?sizeHeight:top+mMaxChildenHeight);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //找最大孩子
        findMaxChilden();
        int left=0,top=0;
        //得到孩子的数量
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if ((left+view.getMeasuredWidth())>getWidth()){
                    top+=mMaxChildenHeight+mTopChilden;
                    left=0;
                }
            }
            view.layout(top,left,left+view.getMeasuredWidth(),top+view.getMeasuredHeight());
            left+=mLeftChilden+view.getMeasuredWidth();
        }
    }
    private void findMaxChilden() {
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(view.getMeasuredHeight()>mMaxChildenHeight){
                mMaxChildenHeight=view.getMeasuredHeight();
            }
        }
    }

}
