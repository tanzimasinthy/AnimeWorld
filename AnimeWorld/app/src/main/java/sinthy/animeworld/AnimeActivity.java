package sinthy.animeworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class AnimeActivity extends AppCompatActivity {

    private TextView name;
    private ImageView image;
    private TextView genre;
    private TextView status;
    private TextView rating;
    private TextView link;
    private VideoView video;

    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        Intent intent = getIntent();

        name = (TextView) findViewById(R.id.animeName);
        image = (ImageView) findViewById(R.id.animeImage);
        genre = (TextView) findViewById(R.id.animeGenre);
        status = (TextView) findViewById(R.id.animeStatus);
        rating = (TextView) findViewById(R.id.animeRating);
        link = (TextView) findViewById(R.id.animeLink);
        video = (VideoView) findViewById(R.id.animeVideo);

        name.setText(intent.getStringExtra("Name"));
        image.setImageResource(intent.getIntExtra("Wallpaper", -1));
        genre.setText(intent.getStringExtra("Genre"));
        status.setText(intent.getStringExtra("Status"));

        String ratingValue = intent.getStringExtra("Rating");
        if (ratingValue == null) {
            LinearLayout ratingBackground = (LinearLayout) findViewById(R.id.ratingLayout);
            ratingBackground.setVisibility(View.GONE);
        } else {
            rating.setText(ratingValue);
        }

        link.setText(intent.getStringExtra("Link"));

        mediaController = new MediaController(this);

        String videoPath = "android.resource://sinthy.animeworld/" + intent.getIntExtra("Video", -1);
        Uri uri = Uri.parse(videoPath);

        video.setVideoURI(uri);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);

        video.start();
    }
}
