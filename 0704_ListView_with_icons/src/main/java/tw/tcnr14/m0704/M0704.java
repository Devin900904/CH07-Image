package tw.tcnr14.m0704;



import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {

    private TextView mTxResualt;

    private ArrayList<Map<String, Object>> mList;
    private String[] listFormResualt;
    private String[] listFormResualt2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);
        setupcomponent();
    }

    private void setupcomponent() {

        mTxResualt =(TextView)findViewById(R.id.m0704_t001);
        listFormResualt =getResources().getStringArray(R.array.weekday);
        listFormResualt2 =getResources().getStringArray(R.array.weekday02);

        mList =new ArrayList<Map<String,Object>>();

        for(int i=0;i<listFormResualt.length;i++)
        {
            String idName="img"+String.format("%02dth",i+1);
            int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
            Map<String,Object> item =new HashMap<String,Object>();  //


            item.put("imgView",resID);   //這是屬於一個key我要丟的物件
            item.put("TextView",listFormResualt[i]);
            item.put("TextView2",listFormResualt2[i]);
           mList.add(item);    //將物品丟進陣列
            SimpleAdapter adapter =new SimpleAdapter(this,mList,R.layout.list_item
            ,new String[]{"imgView","TextView","TextView2"},new int[]{R.id.m0704_im01,R.id.m0704_t002,R.id.m0704_t003});


            //----------------------------------------------------------------
            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);

        }

        }
        //----------------------------------------------------------------
        AdapterView.OnItemClickListener  listviewOnItemClkLis =new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTxResualt.setText(getString(R.string.m0704_t002)+listFormResualt[position]);
            }
    };
}