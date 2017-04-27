package com.cmpe277.investor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

import com.squareup.picasso.Picasso;
import android.graphics.Typeface;

public class InvestorAdapter extends BaseAdapter {

  public static final String TAG = InvestorAdapter.class.getSimpleName();
  public static final HashMap<String, Integer> LABEL_COLORS = new HashMap<String, Integer>()
  {{
    put("High Risk", R.color.colorLowCarb);
    put("Safe", R.color.colorLowFat);
    put("Moderate Risk", R.color.colorLowSodium);
    put("Great Returns", R.color.colorMediumCarb);
    put("Vegetarian", R.color.colorVegetarian);
    put("Balanced", R.color.colorBalanced);
  }};

  private Context mContext;
  private LayoutInflater mInflater;
  private ArrayList<Investor> mDataSource;


  public InvestorAdapter(Context context, ArrayList<Investor> items) {
    mContext = context;
    mDataSource = items;
    mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  /**
   * How many items are in the data set represented by this Adapter.
   *
   * @return Count of items.
   */
  @Override
  public int getCount() {
    return mDataSource.size();
  }

  /**
   * Get the data item associated with the specified position in the data set.
   *
   * @param position Position of the item whose data we want within the adapter's
   *                 data set.
   * @return The data at the specified position.
   */
  @Override
  public Object getItem(int position) {
    return mDataSource.get(position);
  }

  /**
   * Get the row id associated with the specified position in the list.
   *
   * @param position The position of the item within the adapter's data set whose row id we want.
   * @return The id of the item at the specified position.
   */
  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    // check if the view already exists if so, no need to inflate and findViewById again!
    if (convertView == null) {

      // Inflate the custom row layout from your XML.
      convertView = mInflater.inflate(R.layout.list_item_investor, parent, false);

      // create a new "Holder" with subviews
      holder = new ViewHolder();
      holder.thumbnailImageView = (ImageView) convertView.findViewById(R.id.investor_list_thumbnail);
      holder.titleTextView = (TextView) convertView.findViewById(R.id.investor_list_title);
      holder.subtitleTextView = (TextView) convertView.findViewById(R.id.investor_list_subtitle);
      holder.detailTextView = (TextView) convertView.findViewById(R.id.investor_list_detail);

      // hang onto this holder for future recyclage
      convertView.setTag(holder);
    }
    else {

      // skip all the expensive inflation/findViewById and just get the holder you already made
      holder = (ViewHolder) convertView.getTag();
    }

    // Get relevant subviews of row view
    TextView titleTextView = holder.titleTextView;
    TextView subtitleTextView = holder.subtitleTextView;
    TextView detailTextView = holder.detailTextView;
    ImageView thumbnailImageView = holder.thumbnailImageView;


    Investor investor = (Investor) getItem(position);


    titleTextView.setText(investor.companyId);
    subtitleTextView.setText(investor.shortdesc);
    detailTextView.setText(investor.dependent);

    // Use Picasso to load the image. Temporarily have a placeholder in case it's slow to load
    Picasso.with(mContext).load(investor.image).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

    // Style text views
    Typeface titleTypeFace = Typeface.createFromAsset(mContext.getAssets(),
        "fonts/JosefinSans-Bold.ttf");
    titleTextView.setTypeface(titleTypeFace);
    Typeface subtitleTypeFace = Typeface.createFromAsset(mContext.getAssets(),
        "fonts/JosefinSans-SemiBoldItalic.ttf");
    subtitleTextView.setTypeface(subtitleTypeFace);
    Typeface detailTypeFace = Typeface.createFromAsset(mContext.getAssets(),
        "fonts/Quicksand-Bold.otf");
    detailTextView.setTypeface(detailTypeFace);
  // detailTextView.setTextColor(android.support.v4.content.ContextCompat.getColor(mContext, LABEL_COLORS.get(investor.dependent)));

    return convertView;
  }

  private static class ViewHolder {
    public TextView titleTextView;
    public TextView subtitleTextView;
    public TextView detailTextView;
    public ImageView thumbnailImageView;
  }
}
