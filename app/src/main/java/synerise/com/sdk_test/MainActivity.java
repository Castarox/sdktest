package synerise.com.sdk_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.synerise.sdk.tracking.Tracker;
import com.synerise.sdk.tracking.TrackerParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        Tracker.initialize(this,1,60);

        final Button cart = (Button) findViewById(R.id.cart);
        final Button transaction = (Button) findViewById(R.id.transaction);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tracker.trackAddToCart("addToCart", new TrackerParams[]{
                        new TrackerParams("source","test sdk add to cart")
                });
            }
        });

        transaction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Tracker.trackTransactionCharge("transactionCharge", new TrackerParams[]{
                        new TrackerParams("source", "test sdk transaction charge")
                });
            }
        });
    }
}
