package net.jptechnology.android.inclassassignment11_johnp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.UUID;

//public class MainActivity extends AppCompatActivity {
//
//    private DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference("people");
//    private ArrayList<Person> people = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void addPerson(View view) {
//        String id = UUID.randomUUID().toString();
//        Person p = new Person(id, "Xi Wei", 120, true);
//        people.add(p);
//        peopleReference.child(id).setValue(p);
////    peopleReference.push().setValue(p);     // this generates a random id.
//    }
//
//
//    public void removePerson(View view) {
//        if (people.size() == 0) return;
//        Person p = people.remove(0);
//        peopleReference.child(p.id).removeValue();
//    }
//
//}

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private PeopleAdapter peopleAdapter;
    private VendorsAdapter vendorsAdapter;

    private DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference("people");
    private DatabaseReference vendorsReference = FirebaseDatabase.getInstance().getReference("vendors");

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference ordersReference = FirebaseDatabase.getInstance().getReference(auth.getCurrentUser().getUid() + "/orders");
    private DatabaseReference profileReference = FirebaseDatabase.getInstance().getReference(auth.getCurrentUser().getUid() + "/profile");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add_vendor:
                String id = UUID.randomUUID().toString();
                Random random = new Random();
                Vendor passvendor = new Vendor(id, "Enter Vendor Name", "Enter Vendor Info",
                        R.drawable.amazonia, false, false, 0.00, 0, 0, 0, 0);
                Intent intent = SecondActivity.makeIntent(this, passvendor);
                this.startActivity(intent);
                Toast.makeText(this, "Add New Vendor Here", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_add_person:
                addPerson();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        peopleAdapter = new PeopleAdapter(peopleReference);
        vendorsAdapter = new VendorsAdapter(vendorsReference);

        recyclerView.setAdapter(peopleAdapter);

        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        vendorsAdapter = new VendorsAdapter(vendorsReference);

        recyclerView2.setAdapter(vendorsAdapter);
        recyclerView2.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleAdapter.cleanup();
        vendorsAdapter.cleanup();
    }


    public void addPerson() {
        String id = UUID.randomUUID().toString();
        Random random = new Random();
        peopleReference.child(id).setValue(new Person(id, "Someone", random.nextInt(100), random.nextBoolean()));
    }

    public void showVendors(View view) {
        recyclerView.setVisibility(View.INVISIBLE);
        recyclerView2.setVisibility(View.VISIBLE);
    }

    public void showPeople(View view) {
        recyclerView2.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}

