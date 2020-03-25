package com.cs246.growup.Presenters;


import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.User;

import java.util.List;

public interface Listener {
    void notifyDataReady(User user, Config config);
    void notifyConfigChanged();
}