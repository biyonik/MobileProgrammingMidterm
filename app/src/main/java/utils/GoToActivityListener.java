package utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class GoToActivityListener implements View.OnClickListener {
    private final Context context;
    private final Class<?> activityClass;

    public GoToActivityListener(Context context, Class<?> activityClass) {
        this.context = context;
        this.activityClass = activityClass;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }
}
