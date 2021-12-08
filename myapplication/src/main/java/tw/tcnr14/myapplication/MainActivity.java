package tw.tcnr14.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private LinearLayout l1;
    private LinearLayout l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewcomponent();
    }

    private void setViewcomponent() {
     l1 =(LinearLayout)findViewById(R.id.l1);
     l2 =(LinearLayout)findViewById(R.id.l2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.item01:
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
                break;
            case R.id.item02:
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
                break;


        }



        return super.onOptionsItemSelected(item);
    }
}