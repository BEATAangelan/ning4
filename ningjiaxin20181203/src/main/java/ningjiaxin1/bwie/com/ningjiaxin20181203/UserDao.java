package ningjiaxin1.bwie.com.ningjiaxin20181203;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Sql sql;
    private SQLiteDatabase database;
    public UserDao(Context context){
        sql = new Sql(context);
        database = sql.getReadableDatabase();
    }
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        database.insert("user",null,values);
    }
    public List<UserBean> select(){
        Cursor query = database.query("user", null, null, null, null, null, null);
        ArrayList<UserBean> list = new ArrayList<>();
        while(query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            UserBean bean = new UserBean(name);
            list.add(bean);
        }
        return list;
    }
    public void delect(){
        database.delete("user",null,null);
    }
}
