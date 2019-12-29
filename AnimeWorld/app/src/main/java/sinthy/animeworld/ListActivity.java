package sinthy.animeworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Anime> animes;
    private ListView mListView;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView = (ListView) findViewById(R.id.list);

        animes = DataManager.getCurrentAnimes(this);

        ListAdapter adapter = new ListAdapter(this, animes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, AnimeActivity.class);

                intent.putExtra("Name", animes.get(position).getTitle());
                intent.putExtra("Wallpaper", animes.get(position).getWallpaperID());
                intent.putExtra("Genre", animes.get(position).getGenre());
                intent.putExtra("Status", animes.get(position).getStatus());
                intent.putExtra("Rating", animes.get(position).getRating());
                intent.putExtra("Link", animes.get(position).getLink());
                intent.putExtra("Video", animes.get(position).getVideoID());

                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.btnNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = ListActivity.this;
                animes = DataManager.getUpcomingAnimes(context);

                ListAdapter adapter = new ListAdapter(context, animes);
                mListView.setAdapter(adapter);
            }
        });
    }
}
