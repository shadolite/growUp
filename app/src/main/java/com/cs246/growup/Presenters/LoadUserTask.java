package com.cs246.growup.Presenters;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/**
 * Loads tasks using Async methods and notifies when done.
 */
public class LoadUserTask extends AsyncTask<Void, Void, Void> {

    private WeakReference<MainPresenter> presenter;

    /**
     * Non-default constructor.
     * @param presenter Presenter using the Async Task methods.
     */
    public LoadUserTask(MainPresenter presenter) {
        this.presenter = new WeakReference<MainPresenter>(presenter);
    }

    /**
     * Work to do in the background.
     * @param voids
     * @return Returns null.
     */
    @Override
    protected Void doInBackground(Void... voids) {
        presenter.get().loadUser();
        presenter.get().selectEntry();
        return null;
    }

    /**
     * Actions to take once the background thread is complete.
     * @param aVoid
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        presenter.get().notifyListenersDataReady();
    }
}