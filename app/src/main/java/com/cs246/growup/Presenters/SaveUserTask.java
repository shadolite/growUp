package com.cs246.growup.Presenters;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public class SaveUserTask extends AsyncTask<Void, Void, Void> {
    private WeakReference<MainPresenter> presenter;

    public SaveUserTask(MainPresenter presenter) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        presenter.get().saveUser();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyListenersDataReady();
    }
}