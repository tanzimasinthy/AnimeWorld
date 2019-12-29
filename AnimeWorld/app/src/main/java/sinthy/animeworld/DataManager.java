package sinthy.animeworld;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

public class DataManager
{
    private static ArrayList<Anime> data;

    private static TypedArray animePictures;
    private static String[] animeTitles;
    private static String[] animeDescriptions;
    private static String[] animeDates;
    private static String[] animeGenres;
    private static String[] animeStatus;
    private static String[] animeRatings;
    private static String[] animeLinks;
    private static TypedArray animeWallpapers;
    private static TypedArray animeVideos;

    public static ArrayList<Anime> getCurrentAnimes(Context context) {
        data = new ArrayList<>();

        animePictures = context.getResources().obtainTypedArray(R.array.anime_pictures);
        animeTitles = context.getResources().getStringArray(R.array.anime_titles);
        animeDescriptions = context.getResources().getStringArray(R.array.anime_descriptions);
        animeDates = context.getResources().getStringArray(R.array.anime_dates);
        animeGenres = context.getResources().getStringArray(R.array.anime_genres);
        animeStatus = context.getResources().getStringArray(R.array.anime_status);
        animeRatings = context.getResources().getStringArray(R.array.anime_ratings);
        animeLinks = context.getResources().getStringArray(R.array.anime_links);
        animeWallpapers = context.getResources().obtainTypedArray(R.array.anime_wallpapers);
        animeVideos = context.getResources().obtainTypedArray(R.array.anime_videos);

        addAnimes();

        return data;
    }

    public static ArrayList<Anime> getUpcomingAnimes(Context context) {
        data = new ArrayList<>();

        animePictures = context.getResources().obtainTypedArray(R.array.upcoming_anime_pictures);
        animeTitles = context.getResources().getStringArray(R.array.upcoming_anime_titles);
        animeDescriptions = context.getResources().getStringArray(R.array.upcoming_anime_descriptions);
        animeDates = context.getResources().getStringArray(R.array.upcoming_anime_dates);
        animeGenres = context.getResources().getStringArray(R.array.upcoming_anime_genres);
        animeStatus = context.getResources().getStringArray(R.array.upcoming_anime_status);
        animeRatings = null;
        animeLinks = context.getResources().getStringArray(R.array.upcoming_anime_links);
        animeWallpapers = context.getResources().obtainTypedArray(R.array.upcoming_anime_wallpapers);
        animeVideos = context.getResources().obtainTypedArray(R.array.upcoming_anime_videos);

        addAnimes();

        return data;
    }

    private static void addAnimes() {
        for (int i = 0; i < animeTitles.length; i++) {
            Anime item = new Anime(animePictures.getResourceId(i, -1),
                    animeTitles[i],
                    animeDescriptions[i],
                    animeDates[i],
                    animeGenres[i],
                    animeStatus[i],
                    null,
                    animeLinks[i],
                    animeWallpapers.getResourceId(i, -1),
                    animeVideos.getResourceId(i, -1));

            data.add(item);
        }
    }
}
