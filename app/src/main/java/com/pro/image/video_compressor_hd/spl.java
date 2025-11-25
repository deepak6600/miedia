package com.pro.image.video_compressor_hd;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class spl extends AppCompatActivity {
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spl);

        loadBanner();
    }


    public void loadBanner(){
// Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_banner), AdSize.BANNER_HEIGHT_90);

        // Find the Ad container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to container
        adContainer.addView(adView);

        adView.setAdListener(new com.facebook.ads.AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Toast.makeText(getActivity(), "Error: " + adError.getErrorMessage(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onAdLoaded(Ad ad) {
                //  Toast.makeText(getActivity(), "Ad loaded!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                //   Toast.makeText(getActivity(), "Ad clicked!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                //Toast.makeText(getActivity(), "Impression logged!", Toast.LENGTH_LONG).show();
            }
        });

        // Request an ad
        adView.loadAd();


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"My new app");
                String appLink ="https://play.google.com/store/apps/details?id=com.pro.image.video_compressor_hd";
                share.putExtra(Intent.EXTRA_TEXT,"Image compress and Video Compress very advanced Features  "+appLink);
                startActivity(Intent.createChooser(share, "Share Via"));


            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://sites.google.com/view/image-and-video-compress/home")));
                }   catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://sites.google.com/view/image-and-video-compress/home")));
                }

            }
        });

    }
}


