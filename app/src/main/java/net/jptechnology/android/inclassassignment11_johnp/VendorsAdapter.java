package net.jptechnology.android.inclassassignment11_johnp;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class VendorsAdapter extends FirebaseRecyclerAdapter<Vendor, VendorViewHolder> {


    public VendorsAdapter(Query ref) {
        super(Vendor.class, R.layout.card_view_vendor, VendorViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(VendorViewHolder viewHolder, Vendor vendor, int position) {
        viewHolder.bind(vendor);
    }
}

