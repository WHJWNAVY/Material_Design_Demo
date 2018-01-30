package com.wnavy.navigationview;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

public class GirlActivity extends AppCompatActivity {

    public static final String GIRL_NAME = "Girl_Name";
    public static final String GIRL_IMAGE_ID = "Girl_Image_Id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girl_activity);
        Intent intent = getIntent();
        String girlName = intent.getStringExtra(GIRL_NAME);
        int girlImageId = intent.getIntExtra(GIRL_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.girl_tool_bar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.girl_collapsing_toolbar);
        ImageView girlImageView = (ImageView) findViewById(R.id.girl_image_view);
        TextView girlTextView = (TextView) findViewById(R.id.girl_text_view);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbarLayout.setTitle(girlName);

        Glide.with(this).load(girlImageId).into(girlImageView);
        String girlContent = generateGirlContent(girlName);
        girlTextView.setText(girlContent);
    }

    private String generateGirlContent(String girlName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            stringBuilder.append(girlName);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return true;
    }
}
