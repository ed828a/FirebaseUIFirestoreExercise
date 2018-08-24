package com.dew.edward.firebaseui_firestore_exercise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


/**
 * Created by Edward on 8/23/2018.
 */
public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteViewHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
        holder.textViewDescription.setText(model.getDescription());
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new NoteViewHolder(view);
    }

    public void deleteItem(int position){

        getSnapshots().getSnapshot(position).getReference().delete();

    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;

        public NoteViewHolder(View itemView) {
            super(itemView);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
        }
    }
}
