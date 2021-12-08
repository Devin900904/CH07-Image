package tw.tcnr14.m0702;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnr14.m0702.R;


public class M0702 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory, AdapterView.OnItemClickListener {

    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
    };    private Integer[] thumbImgArr = {
            R.drawable.img01th, R.drawable.img02th,
            R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th,
            R.drawable.img09th, R.drawable.img10th,
            R.drawable.img11th, R.drawable.img12th,
            R.drawable.img13th,R.drawable.img14th,
            R.drawable.img15th,R.drawable.img16th,
    };

    private final String TAG = "tcnr14=>";
    private GridView gridview;
    private ImageSwitcher imgSwi;
    private Object item;
    private int ss;

    private void setupViewcomponent() {
        // 從資源類別R中取得介面元件
        gridview = (GridView) findViewById(R.id.m0702_g001);
        imgSwi = (ImageSwitcher) findViewById(R.id.m0702_im01);
        imgSwi.setFactory((ViewSwitcher.ViewFactory)this);
        //將縮圖填入 GridView
//        gridview.setAdapter(new GridAdapter(this, thumbImgArr));
     gridview.setAdapter(new GridAdapter(this, thumbImgArr));
     gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0702);
        Log.d(TAG, "onCreat()");
        setupViewcomponent();
    }

    // 圖庫的圖片資源索引


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.m0702, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.item01:

                ss = 1;
                break;
            case R.id.item02:
                ss = 2;
                break;

            case R.id.item03:
                ss = 3;
                break;

            case R.id.item04:
                ss = 4;
                break;
            case R.id.item05:
                ss = 5;
                break;
        }

        return super.onOptionsItemSelected(item);
    }
//




    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "進用返回建", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

     //==========================================================//
//   //透明
//    imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_out));
//        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_in));
//        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,));
//        Toast.makeText(getApplicationContext(),"漸漸透明",Toast.LENGTH_LONG).show();
        //放大縮小
//        imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_out));
//        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_in));
//
//        Toast.makeText(getApplicationContext(),"放大縮小",Toast.LENGTH_LONG).show();
        //滑動由上二下
//        imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_out));
//        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_in));
//
//        Toast.makeText(getApplicationContext(),"轉換由上到下",Toast.LENGTH_LONG).show();
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_trans_bounce);
//        anim.setInterpolator(new BounceInterpolator());      //設定彈跳特效
//        imgSwi.setAnimation(anim);
//        Toast.makeText(getApplicationContext(), "彈跳效果", Toast.LENGTH_SHORT).show();
//     imgSwi.setImageResource(imgArr[position]);
     switch (ss){
         case 1:
                 imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_out));
        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_alpha_in));

        Toast.makeText(getApplicationContext(),"漸漸透明",Toast.LENGTH_LONG).show();
        break;
         case 2:
                     imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_out));
        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_in));
        Toast.makeText(getApplicationContext(),"放大縮小",Toast.LENGTH_LONG).show();
        break;
         case 3:
                     imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_out));
        imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_in));

        Toast.makeText(getApplicationContext(),"轉換由上到下",Toast.LENGTH_LONG).show();
        break;
         case 4:
             Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_trans_bounce);
             anim.setInterpolator(new BounceInterpolator());      //設定彈跳特效
             imgSwi.setAnimation(anim);
             Toast.makeText(getApplicationContext(), "彈跳效果", Toast.LENGTH_SHORT).show();

             break;
         case 5:
             imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_out));
             imgSwi.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_in));

             

             break;
     }

        imgSwi.setImageResource(imgArr[position]);


    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;

    }
}