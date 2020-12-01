package com.example.temp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class WhoKnowsFrag extends Fragment implements View.OnClickListener {
    Button btnViewTeams;
    teamsAdapter adapter;
    RecyclerView recview;
    FirebaseRecyclerOptions<TeamData> options = new FirebaseRecyclerOptions.Builder<TeamData>().setQuery(FirebaseDatabase.getInstance().getReference().child("Teams"), TeamData.class).build();


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment_scrn1, container, false);
        btnViewTeams = v.findViewById(R.id.btnViewTeams);
        btnViewTeams.setOnClickListener(this::onClick);
        recview = v.findViewById(R.id.recview);
        recview.setHasFixedSize(true);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseAuth x;

        adapter = new teamsAdapter(options);
        recview.setAdapter(adapter);

        return v;
}

    @Override
    public void onClick(View v) {
        if (((Button) v).getText().toString().equals("View Teams")) {
            startActivity(new Intent(v.getContext(), ViewTeams.class));
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
