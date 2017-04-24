package net.jptechnology.android.inclassassignment11_johnp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_ID = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorID";
    private static final String EXTRA_NAME = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorName";
    private static final String EXTRA_INFO = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorInfo";
    private static final String EXTRA_LOGOID = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorLogoId";
    private static final String EXTRA_FREESHIP = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorFreeShip";
    private static final String EXTRA_PICKUPAVAILABLE = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorPickupAvailable";
    private static final String EXTRA_EXCHANGERATEEURO = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorExchangeRateEuro";
    private static final String EXTRA_EXCHANGERATEREAL = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorExchangeRateReal";
    private static final String EXTRA_EXCHANGERATEYEN = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorExchangeRateYen";
    private static final String EXTRA_EXCHANGERATEYUON = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorExchangeRateYuon";
    private static final String EXTRA_EXCHANGERATEWON = "net.jptechnology.android.inclassassignment11_johnp.SecondActivity - vendorExchangeRateWon";


    private Vendor vendor2;
    private DatabaseReference vendorsReference = FirebaseDatabase.getInstance().getReference("vendors");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        extractDataFromIntent();

        setupEndActivityButton();
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        String vendorId = intent.getStringExtra(EXTRA_ID);
        String vendorName = intent.getStringExtra(EXTRA_NAME);
        String vendorInfo = intent.getStringExtra(EXTRA_INFO);
        int vendorLogoId = intent.getIntExtra(EXTRA_LOGOID, 0);
        boolean vendorFreeShip = intent.getBooleanExtra(EXTRA_FREESHIP, false);
        boolean vendorPickupAvailable = intent.getBooleanExtra(EXTRA_PICKUPAVAILABLE, false);
        double vendorExchangeRateEuro = intent.getDoubleExtra(EXTRA_EXCHANGERATEEURO, 0);
        double vendorExchangeRateReal = intent.getDoubleExtra(EXTRA_EXCHANGERATEREAL, 0);
        double vendorExchangeRateYen = intent.getDoubleExtra(EXTRA_EXCHANGERATEYEN, 0);
        double vendorExchangeRateYuon = intent.getDoubleExtra(EXTRA_EXCHANGERATEYUON, 0);
        double vendorExchangeRateWon = intent.getDoubleExtra(EXTRA_EXCHANGERATEWON, 0);

        vendor2 = new Vendor(vendorId, vendorName, vendorInfo, vendorLogoId,
                vendorFreeShip, vendorPickupAvailable, vendorExchangeRateEuro, vendorExchangeRateReal,
                vendorExchangeRateYen, vendorExchangeRateYuon, vendorExchangeRateWon);
    }

    private void setupEndActivityButton() {
        Button button = (Button) findViewById(R.id.close);
        ImageView vendorLogoView = (ImageView) findViewById(R.id.vendor_logo2);
        TextView vendorNameView = (TextView) findViewById(R.id.vendor_name2);
        TextView vendorInfoView = (TextView) findViewById(R.id.vendor_info2);
        vendorLogoView.setImageResource(vendor2.getLogoId());
        vendorNameView.setText(vendor2.getName());
        vendorInfoView.setText(vendor2.getInfo());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context, Vendor vendor) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_NAME, vendor.getName());
        intent.putExtra(EXTRA_INFO, vendor.getInfo());
        intent.putExtra(EXTRA_LOGOID, vendor.getLogoId());
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                vendorsReference.child(vendor2.id).setValue(new Vendor(vendor2.id, vendor2.name,
                        vendor2.info, vendor2.logoId, vendor2.freeShip, vendor2.pickupAvailable,
                        vendor2.exchangeRateEuro, vendor2.exchangeRateReal, vendor2.exchangeRateYen,
                        vendor2.exchangeRateYuon, vendor2.exchangeRateWon));
                return true;
            case R.id.menu_item_trash:
                vendorsReference.child(vendor2.id).removeValue();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
