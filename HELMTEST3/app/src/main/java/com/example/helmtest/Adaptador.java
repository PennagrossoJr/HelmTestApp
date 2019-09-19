package com.example.helmtest;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import com.squareup.picasso.Picasso;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<Objeto> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public Adaptador(Context context, ArrayList<Objeto> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Objeto currentItem = mExampleList.get(position);


        //System.out.println(currentItem.getImageUrl() + " ID a la hora de seleccionar del JSON");


        String imageUrl = currentItem.getImageUrl();



        //System.out.println(currentItem.getmCreator() + " ID a la hora de seleccionar del JSON");


        String creatorName = currentItem.getmCreator();

        //System.out.println(new Integer(currentItem.getId()).toString() + " ID a la hora de seleccionar del JSON");

        /*String id = new Integer(currentItem.getId()).toString(); //currentItem.getId();

        String status = currentItem.getStatus();
        String species = currentItem.getSpecie();
        String gender = currentItem.getGenero();
        String origen = currentItem.getOrigen();
        String location = currentItem.getLast_Location();*/


        //int likeCount = currentItem.getLikeCount();

        holder.mTextViewCreator.setText(creatorName);

        //holder.Id.setText(id);
        //holder.Status.setText(status);
        //holder.Species.setText(species);
        //holder.Gender.setText(gender);
        //holder.Origin.setText(origen);
        //holder.Location.setText(location);

        //holder.mTextViewLikes.setText("Likes: " + likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView Id;
        public TextView Status;
        public TextView Species;
        public TextView Gender;
        public TextView Origin;
        public TextView Location;

        //public TextView mTextViewLikes;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_name);
            Id = itemView.findViewById(R.id.id);
            Status = itemView.findViewById(R.id.status);
            Species = itemView.findViewById(R.id.specie);
            Gender = itemView.findViewById(R.id.gender);
            Origin = itemView.findViewById(R.id.origin);
            Location = itemView.findViewById(R.id.last_location);

            //mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
