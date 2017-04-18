package net.jptechnology.android.inclassassignment11_johnp;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class PeopleAdapter extends FirebaseRecyclerAdapter<Person, PersonViewHolder> {


    public PeopleAdapter(Query ref) {
        super(Person.class, R.layout.card_view_person, PersonViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(PersonViewHolder viewHolder, Person person, int position) {
        viewHolder.bind(person);
    }
}

