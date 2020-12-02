package com.example.temp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class teamsAdapter extends FirebaseRecyclerAdapter<TeamData, teamsAdapter.myview> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public teamsAdapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myview view, int i, @NonNull TeamData teamData) {
        view.teamName.setText(teamData.getTeamID());
        view.teamHead.setText(teamData.getTeamHead());
        view.members.setText(teamData.getMemberNo());

    }

    class myview extends RecyclerView.ViewHolder
    {
        TextView teamName, members, teamHead;

        public myview(@NonNull View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.playerFour);
            teamHead = (TextView) itemView.findViewById(R.id.playerThree);
            members = (TextView) itemView.findViewById(R.id.memberNo);
        }
    }


    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new teamsAdapter.myview(view);
    }
}
