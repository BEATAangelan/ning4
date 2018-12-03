package ningjiaxin1.bwie.com.ningjiaxin20181203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TextVi extends TextView {
    public TextVi(Context context) {
        super(context);
    }

    public TextVi(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TextVi);
        int color = typedArray.getColor(R.styleable.TextVi_textVie,Color.BLUE);
        setTextColor(color);
        //回收机制
        typedArray.recycle();
    }
}
