package net.jptechnology.android.inclassassignment11_johnp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView personNameText;
    private TextView personAgeText;
    private TextView personAliveText;
    private Context context;

    private DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference("people");

    public PersonViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        personNameText = (TextView) itemView.findViewById(R.id.person_name);
        personAgeText = (TextView) itemView.findViewById(R.id.person_age);
        personAliveText = (TextView) itemView.findViewById(R.id.person_alive);
        this.context = itemView.getContext();
    }


    public void bind(final Person person) {
        personNameText.setText(person.name);
        personAgeText.setText("Age: " + person.age);
        personAliveText.setText("Alive: " + person.alive);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                peopleReference.child(person.id).removeValue();
                Toast.makeText(context, personNameText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

