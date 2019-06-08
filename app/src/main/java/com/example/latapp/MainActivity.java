package com.example.latapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.File;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                File fileMetadata = new File();
                fileMetadata.setName("photo.jpg");
                java.io.File filePath = new java.io.File("files/photo.jpg");
                FileContent mediaContent = new FileContent("image/jpeg", filePath);
                File file = driveService.files().create(fileMetadata, mediaContent)
                        .setFields("id")
                        .execute();

                /*
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mkyong.com"));
                startActivity(browserIntent);
                */
            }

        });

    }
}
