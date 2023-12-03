package services;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.ahmetaltun.mobileprogrammingmidterm.R;

import java.util.Random;

public class RandomProgressBarManager {
    private Context context;
    private ScrollView scrollView;

    public RandomProgressBarManager(Context context, ScrollView scrollView) {
        this.context = context;
        this.scrollView = scrollView;
    }

    public void clear() {
        ((Activity) context).runOnUiThread(() -> scrollView.removeAllViews());
    }

    public void createProgressBar(int piece) {
        clear();
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout llMain = inflater.inflate(com.ahmetaltun.mobileprogrammingmidterm.R.layout.random_card_layout, null).findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.llMain);

        for (int i = 0; i < piece; i++) {
            int minValue = new Random().nextInt(100);
            int maxValue = new Random().nextInt(minValue) + minValue + 1;
            int randomValue = new Random().nextInt(maxValue - minValue + 1) + minValue;
            double precision = (double) (randomValue - minValue) / (maxValue - minValue) * 100;
            int progress = (int) Math.round(precision);

            View cardView = inflater.inflate(com.ahmetaltun.mobileprogrammingmidterm.R.layout.random_card_layout, null);

            TextView minValueTextView = cardView.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.tvMinValue);
            TextView maxValueTextView = cardView.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.tvMaxValue);
            LinearLayout progressBarLayout = cardView.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.llProgress);
            ProgressBar progressBar = cardView.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.prgMain);
            TextView progressTextView = cardView.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.tvProgressBar);

            minValueTextView.setText(String.valueOf(minValue));
            maxValueTextView.setText(String.valueOf(maxValue));
            progressBar.setProgress(progress);
            progressTextView.setText(randomValue + " = " + progress + "%");

            llMain.addView(cardView);
        }

        CardView initProgressbarCardView = llMain.findViewById(com.ahmetaltun.mobileprogrammingmidterm.R.id.progressCard);
        initProgressbarCardView.setVisibility(View.GONE);

        ((Activity)(context)).runOnUiThread(() -> scrollView.addView(llMain));
    }
}
