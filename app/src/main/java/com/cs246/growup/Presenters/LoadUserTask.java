package com.cs246.growup.Presenters;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public class LoadUserTask extends AsyncTask<Void, Void, Void> {
    private WeakReference<MainPresenter> presenter;

    public LoadUserTask(MainPresenter presenter) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        presenter.get().loadUser();
        presenter.get().selectEntry();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyListenersDataReady();
    }
}
