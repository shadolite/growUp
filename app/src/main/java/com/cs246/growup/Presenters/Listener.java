package com.cs246.growup.Presenters;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.User;

/**
 * Listener interface for listeners related to the MainActivity.
 */
public interface Listener {
    void notifyDataReady(User user, Config config);
    void notifyConfigChanged();
}