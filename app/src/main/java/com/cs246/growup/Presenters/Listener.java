package com.cs246.growup.Presenters;


import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;

import java.util.List;

public interface Listener {
    void notifyDataReady(Config config, List<Goal> goals, Entry entry);
    void NotifyConfigChanged();
}