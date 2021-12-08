package tw.tcnr14.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnr14.m0705.R;

public class M0705 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory, AdapterView.OnItemClickListener {

    // ----宣告變數----
    private ImageView txtComPlay;
    private TextView txtSelect, txtResult;
    private ImageButton btnScissors, btnStone, btnNet;
    private String user_select;
    private String answer;
    private MediaPlayer startmusic; //宣告媒體物件 片頭音樂
    private MediaPlayer mediaWin; // 宣告媒體物件 贏
    private MediaPlayer mediaLose; // 宣告媒體物件 輸
    private MediaPlayer mediaDraw; // 宣告媒體物件 平
    private RelativeLayout r_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {
        // ---取得R.java 配置碼---
        txtComPlay = (ImageView) findViewById(R.id.m0705_c001); // 電腦選擇
        txtSelect = (TextView) findViewById(R.id.m0705_s001); // 選擇結果
        txtResult = (TextView) findViewById(R.id.m0705_f000); // 輸贏判斷
        btnScissors = (ImageButton) findViewById(R.id.m0705_b001); // 剪刀
        btnStone = (ImageButton) findViewById(R.id.m0705_b002); // 石頭
        btnNet = (ImageButton) findViewById(R.id.m0705_b003); // 布

        //--設定imageButton初始值為全透明

        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back01);
        u_setalpha();
        // --開啟時片頭音樂-----
        startmusic = MediaPlayer.create(getApplicationContext(), R.raw.guess);
        startmusic.start();

        //--設定音樂連結--
        mediaWin = MediaPlayer.create(getApplicationContext(), R.raw.win);
        mediaLose = MediaPlayer.create(getApplicationContext(), R.raw.lose);
        mediaDraw = MediaPlayer.create(getApplicationContext(), R.raw.haha);

        // ---啟動監聽事件----
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }



        private void u_setalpha() {
        //imageButton 背景為銀色且為全透明
        btnScissors.setBackgroundColor(Color.GRAY);
        btnScissors.getBackground().setAlpha(0); //0-255
        btnStone.setBackgroundColor(Color.GRAY);
        btnStone.getBackground().setAlpha(0);
        btnNet.setBackgroundColor(Color.GRAY);
        btnNet.getBackground().setAlpha(0);
    }


    private Button.OnClickListener btn01On = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);

            // 1 - scissors, 2 - stone, 3 - net.
            switch (iComPlay) {
                case 1:
                    user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b001) + " ";
                    txtComPlay.setImageResource(R.drawable.scissors); // 轉換ImageView剪刀
                    break;
                case 2:
                    user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b002) + " ";
                    txtComPlay.setImageResource(R.drawable.stone); // 轉換ImageView石頭
                    break;
                case 3:
                    user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b003) + " ";
                    txtComPlay.setImageResource(R.drawable.net); // 轉換ImageView布
                    break;
            }
            switch (v.getId()) {
                case R.id.m0705_b001:
                    // 選擇 剪刀scissors
                    user_select += getString(R.string.m0705_s001)  + getString(R.string.m0705_b001);
                    //---------------------------------
                    u_setalpha();
                    btnScissors.getBackground().setAlpha(150);
                    //---------------------------------
                    switch (iComPlay) {
                        case 1:
                            music(2);
                            break;
                        case 2:
                            music(3);
                            break;
                        case 3:
                            music(1);
                            break;
                    }

                    break;
                //----------------------------------------------
                case R.id.m0705_b002:
                    // 選擇 石頭
                    user_select += getString(R.string.m0705_s001)  + getString(R.string.m0705_b002);
                    //---------------------------------
                    u_setalpha();
                    btnStone.getBackground().setAlpha(150);
                    //---------------------------------
                    switch (iComPlay) {
                        case 1:
                            music(1);
                            break;
                        case 2:
                            music(2);
                            break;
                        case 3:
                            music(3);
                            break;
                    }
                    break;
                //---------------------------------------------
                case R.id.m0705_b003:
                    // 選擇 布
                    user_select += getString(R.string.m0705_s001)  + getString(R.string.m0705_b003);
                    //---------------------------------
                    u_setalpha();
                    btnNet.getBackground().setAlpha(150);
                    //---------------------------------
                    switch (iComPlay) {
                        case 1:
                            music(3);
                            break;
                        case 2:
                            music(1);
                            break;
                        case 3:
                            music(2);
                            break;
                    }
                    break;
            }
            txtSelect.setText(user_select);
            txtResult.setText(answer);
        }
    };

    private void music(int i) {
        //--中斷播放中音樂--
        if (startmusic != null && startmusic.isPlaying()) {
            startmusic.stop();

        }
            if (mediaWin != null && mediaWin.isPlaying()) {
                mediaWin.pause();

            }
            if (mediaDraw != null && mediaDraw.isPlaying()) {
                mediaDraw.pause();

            }
            if (mediaLose != null && mediaLose.isPlaying()) {
                mediaLose.pause();

            }
        switch (i) {
            case 1: //贏
                mediaWin.start();
                answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); // 平
                txtResult.setTextColor(Color.GREEN); // 贏用綠顯示
                Toast.makeText(getApplicationContext(), R.string.m0705_f001, Toast.LENGTH_SHORT).show();
                break;
            case 2: //平
                mediaDraw.start();
                answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); // 平
                txtResult.setTextColor(Color.YELLOW); // 平用黃顯示
                Toast.makeText(getApplicationContext(), R.string.m0705_f003,
                        Toast.LENGTH_LONG).show(); // 平
                break;
            case 3: //輸
                mediaLose.start();
                answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002); // 輸
                txtResult.setTextColor(Color.RED); // 輸用紅顯示
                Toast.makeText(getApplicationContext(), R.string.m0705_f002,
                        Toast.LENGTH_LONG).show(); // 輸
                break;
            //----
        }

    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;

    }
}
