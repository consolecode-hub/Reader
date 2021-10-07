package com.console.reader.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.console.reader.Model.Article_Data_Model;
import com.console.reader.R;

import java.util.ArrayList;
import java.util.List;

import info.bliki.wiki.model.WikiModel;

public class Category_ArticleAdapter extends
        RecyclerView.Adapter<Category_ArticleAdapter.Article_Data_ModelViewHolder> {

    private Context mContext;
    ArrayList<Article_Data_Model> article_Data_Model;

    public Category_ArticleAdapter(Context context, ArrayList<Article_Data_Model>  article_Data_Model){

        this.article_Data_Model = article_Data_Model;
        this.mContext = context;

    }


    @Override
    public Article_Data_ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_article, parent, false);
        return new Article_Data_ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Article_Data_ModelViewHolder holder, int position) {
        holder.textRepoName.setText(article_Data_Model.get(position).name);

        WikiModel wikiModel =
                new WikiModel("https://www.mywiki.com/wiki/${image}",
                        "https://www.mywiki.com/wiki/${title}");
        String htmlStr = wikiModel.render(article_Data_Model.get(position).description);

        String a = htmlStr;
        a = a.replace("{{","");
        a = a.replace("}}","");
        a = a.replace("File:","");
        a = a.replace(".jpg","");
        a = a.replace(".svg","");
        a = a.replace(".PNG","");
        a = a.replace(".JPG","");
        a = a.replace(".gif","");
        a = a.replace(".png","");
        holder.textRepoDescription.setText(Html.fromHtml(a));
      //  holder.textLanguage.setText("Language: " + article_Data_Model.get(position).thumb_Url);
        holder.textStars.setText("Stars: " + article_Data_Model.get(position).stargazersCount);


        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.cate)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontAnimate()
                .dontTransform();

        Glide.with(mContext).load(article_Data_Model.get(position).thumb_Url)
                 .apply(options).into(holder.thumb);
//
//        Glide.with(mContext)
//                .load(article_Data_Model.get(position).thumb_Url)
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .into(holder.thumb);

    }

    public void setarticle_Data_Model(@Nullable List<Article_Data_Model> repos) {
        if (repos == null) {
            return;
        }
        article_Data_Model.clear();
        article_Data_Model.addAll(repos);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return article_Data_Model.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class Article_Data_ModelViewHolder extends RecyclerView.ViewHolder {

        TextView textRepoName;
        TextView textRepoDescription;
        TextView textLanguage;
        TextView textStars;
        ImageView thumb;

        public Article_Data_ModelViewHolder(View itemView) {
            super(itemView);


            textRepoName = (TextView) itemView.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) itemView.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) itemView.findViewById(R.id.text_language);
            textStars = (TextView) itemView.findViewById(R.id.text_stars);
            thumb = (ImageView) itemView.findViewById(R.id.thumb);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });



        }
    }

}
