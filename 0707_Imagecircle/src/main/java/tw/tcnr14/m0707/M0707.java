package tw.tcnr14.m0707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class M0707 extends AppCompatActivity  implements View.OnClickListener {

    private ImageView img1;
    private ImageButton img2;
    private TextView t001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0707);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
//        img1=(ImageView)findViewById(R.id.m0707_imgview);
//        img2=(ImageButton)findViewById(R.id.m0707_imgbutton);
        t001 =(TextView)findViewById(R.id.m0707_t001);

        img1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.m0707_imgview:
//               t001.setText(getText(R.string.m0707_t001)+getString(R.string.m0707_imageview));
//
//                break;
//            case R.id.m0707_imgbutton:
//                t001.setText(getText(R.string.m0707_t001)+getString(R.string.m0707_ingbutton));
//
//                break;
//        }

    }
}