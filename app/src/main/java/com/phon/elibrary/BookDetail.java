package com.phon.elibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_detail);

        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtAuthor = findViewById(R.id.txt_author);
        TextView txtSize = findViewById(R.id.txt_size);
        TextView txtDesc = findViewById(R.id.txt_description);

        //Get data From HomeActivity
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String size = intent.getStringExtra("size");
        String desc = intent.getStringExtra("description");

        txtTitle.setText(title);
        txtAuthor.setText(author);
        txtSize.setText(size);
        txtDesc.setText(desc);

    }
}
