package ningjiaxin1.bwie.com.ningjiaxin20181203;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HeadView head;
    private WaterFallLayout water,water1,water2;
    private EditText edit;
    private ImageView image_del,image_s;
    private UserDao dao;
    private TextView textView;
    Context context;
    private String str[]=new String[]{"基础护肤","面部清洁","面膜","兰蔻","雅诗兰黛","资生堂","眼部护理","越是声音","美容服服"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        info();
    }
    public void initView(){
        edit= findViewById(R.id.edit);
        water = findViewById(R.id.water);
        dao=new UserDao(this);
        List<UserBean> select = dao.select();
        for(int i=0;i<select.size();i++){
            textView = new TextView(MainActivity.this);
            textView.setText(select.get(i).getName() );
            water.addView(textView);
        }
        findViewById(R.id.image_s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(edit.getText());
                textView.setTextColor(Color.BLACK);
              //  Toast.makeText(context,textView.getText().toString(),Toast.LENGTH_SHORT).show();
                water.addView(textView);
                dao.add(textView.getText().toString());
            }
        });
        image_del = findViewById(R.id.image_del);
        image_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delect();
            }
        });
    }
    //常用分类
    public void info(){
        for(int i=0;i<str.length;i++){
            water2 = findViewById(R.id.water2);
            TextView textView = new TextView(MainActivity.this);
            textView.setText(str[i]);
            textView.setTextColor(Color.BLACK);
            water2.addView(textView);
            dao.add(textView.getText().toString());
        }
    }
}
