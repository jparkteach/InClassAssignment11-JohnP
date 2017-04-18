package net.jptechnology.android.inclassassignment11_johnp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
    private PeopleAdapter peopleAdapter;

    private DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference("people");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        peopleAdapter = new PeopleAdapter(peopleReference); // Stop listening if the activity is destroyed
        // peopleAdapter is from firebase

        recyclerView.setAdapter(peopleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleAdapter.cleanup();
    }


    public void addPerson(View view) {
        String id = UUID.randomUUID().toString();
        Random random = new Random();
        peopleReference.child(id).setValue(new Person(id, "Someone", random.nextInt(100), random.nextBoolean()));
    }
}

