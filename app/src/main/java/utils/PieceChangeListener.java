package utils;

import android.text.TextWatcher;
import android.widget.ScrollView;

import services.RandomProgressBarManager;

public class PieceChangeListener implements TextWatcher {
    private ScrollView scrollView;
    private RandomProgressBarManager randomProgressBarManager;

    public PieceChangeListener(ScrollView scrollView, RandomProgressBarManager randomProgressBarManager) {
        this.scrollView = scrollView;
        this.randomProgressBarManager = randomProgressBarManager;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        randomProgressBarManager.clear();
        if (s.length() > 0) {
            randomProgressBarManager.createProgressBar(Integer.parseInt(s.toString()));
            scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
        }
    }

    @Override
    public void afterTextChanged(android.text.Editable s) {

    }
}
