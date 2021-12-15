package tw.tcnr14.m0708;



import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tw.tcnr14.m0708.R;

public class M0708 extends ListActivity {

    private TextView mTxResualt;

    private ArrayList<Map<String, Object>> mList;
    private String[] listFormResualt;

    private TextView mTxResualt1;
    private String[] listFormResualt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupcomponent();
    }

    private void setupcomponent() {

        mTxResualt =(TextView)findViewById(R.id.m0708_t001);
        mTxResualt1 =(TextView)findViewById(R.id.m0708_t004);
        listFormResualt =getResources().getStringArray(R.array.teacname);
        listFormResualt3 =getResources().getStringArray(R.array.descr);

        mList =new ArrayList<Map<String,Object>>();

        for(int i=0;i<listFormResualt.length;i++)
        {
            String idName="t"+String.format("%02d",i+1);
            int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
            Map<String,Object> item =new HashMap<String,Object>();  //


            item.put("imgView",resID);   //這是屬於一個key我要丟的物件
            item.put("TextView",listFormResualt[i]);
            item.put("TextView2",listFormResualt3[i]);
           mList.add(item);    //將物品丟進陣列
            SimpleAdapter adapter =new SimpleAdapter(this,mList,R.layout.list_item
            ,new String[]{"imgView","TextView","TextView2"},new int[]{R.id.m0708_im01,R.id.m0708_t002,R.id.m0708_t004});



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
                mTxResualt.setText(getString(R.string.m0708_t002)+listFormResualt[position]);
                mTxResualt1.setText(getString(R.string.m0708_descr)+listFormResualt3[position]);
            }
    };
}