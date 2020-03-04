package com.cs246.growup.Presenters;


import com.cs246.growup.Config;
import com.cs246.growup.Entry;
import com.cs246.growup.Goal;

import java.util.List;

public interface Listener {
    void notifyDataReady(Config config, List<Goal> goals, Entry entry);
    void NotifyConfigChanged();
}