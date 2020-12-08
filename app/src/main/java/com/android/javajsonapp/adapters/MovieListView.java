package com.android.javajsonapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.javajsonapp.MainActivity;
import com.android.javajsonapp.R;
import com.android.javajsonapp.Result;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;

public class MovieListView extends ArrayAdapter<Result> {
    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Result> movies;


    public MovieListView(Context context, ArrayList<Result>movies) {

        super(context,0, movies);
        this.context = context;
        this.movies = movies;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Result getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, null);
            holder = new ViewHolder();
            holder.movieImage = (ImageView) convertView.findViewById(R.id.movie_image_id);
            holder.movieTitle = (TextView) convertView.findViewById(R.id.movie_title);
            holder.movieOriginalTitle = (TextView) convertView.findViewById(R.id.movie_originalTitle);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        Result movie = movies.get(position);

        if(movie != null){
            String url = "https://image.tmdb.org/t/p/w500"+movie.getPosterPath();
            String url2 ="https://via.placeholder.com/600/771796";
            Picasso.get().load(url).into(holder.movieImage);
            holder.movieTitle.setText(movie.getTitle());
            holder.movieOriginalTitle.setText(movie.getOverview());
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView movieTitle;
        TextView movieOriginalTitle;
        ImageView movieImage;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}