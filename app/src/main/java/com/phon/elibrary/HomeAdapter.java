package com.phon.elibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.EventViewHolder> {

    private Book[] data;
    public void setData(Book[] data){
        this.data = data;
        notifyDataSetChanged();

    }

    EventViewHolder eventViewHolder;

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewHolder  = layoutInflater.inflate(R.layout.view_holder_home, viewGroup, false);
        eventViewHolder = new EventViewHolder(viewHolder);
        return eventViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int i) {
        Book book = data[i];
        eventViewHolder.txtTitle.setText(book.getTitle());
        eventViewHolder.txtAuthor.setText(book.getAuthor());
        eventViewHolder.txtSize.setText(book.getSize());
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.length;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgHome;
        private TextView txtTitle;
        private TextView txtAuthor;
        private TextView txtSize;
        public EventViewHolder(View itemView) {
            super(itemView);

            imgHome = itemView.findViewById(R.id.ImagesUrl);
            txtTitle = itemView.findViewById(R.id.titles);
            txtAuthor = itemView.findViewById(R.id.authors);
            txtSize = itemView.findViewById(R.id.size);

        }
    }

}
