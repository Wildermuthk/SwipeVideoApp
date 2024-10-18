package com.example.swipevideoapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemList = new ArrayList<>();
        VideoItem videoOne = new VideoItem();
        videoOne.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-dcef4.appspot.com/o/videotwo.mp4?alt=media&token=416c7259-c216-45d1-9cc0-15bf1785d50d";
        videoOne.videoTitle = "Video One";
        videoOne.videoDescription = "This is the first video.";
        videoOne.videoID = "ID: 234567";
        videoItemList.add(videoOne);

        videoViewPager.setAdapter(new VideoAdapter(videoItemList));

        VideoItem videoTwo = new VideoItem();
        videoTwo.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-dcef4.appspot.com/o/videothree.mp4?alt=media&token=70b3ecaf-686e-4de4-abb2-5db1e6cee575";
        videoTwo.videoTitle = "Video Two";
        videoTwo.videoDescription = "This is the second video.";
        videoTwo.videoID = "ID: 345678";
        videoItemList.add(videoTwo);

        videoViewPager.setAdapter(new VideoAdapter(videoItemList));

        VideoItem videoThree = new VideoItem();
        videoThree.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-dcef4.appspot.com/o/videoone.mp4?alt=media&token=67eab899-589a-4fb4-b313-26152bc56ff9";
        videoThree.videoTitle = "Video three";
        videoThree.videoDescription = "This is the third video";
        videoThree.videoID = "ID: 456789";
        videoItemList.add(videoThree);

        videoViewPager.setAdapter(new VideoAdapter(videoItemList));

    }
}

