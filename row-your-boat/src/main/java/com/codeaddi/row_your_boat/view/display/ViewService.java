package com.codeaddi.row_your_boat.view.display;

import com.codeaddi.row_your_boat.controller.sessions.SessionsService;
import com.codeaddi.row_your_boat.controller.sessions.http.SchedulerClient;
import com.codeaddi.row_your_boat.model.Squad;
import com.codeaddi.row_your_boat.model.sessions.RowingSessions;
import com.codeaddi.row_your_boat.model.sessions.http.RowingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ViewService {

    @Autowired
    private SchedulerClient schedulerClient;

    public Map<Squad, List<RowingSessions>> getAllStandardSessionsToDisplay(){
        List<RowingSession> rowingSessions = schedulerClient.getAllSessions();
        List<RowingSessions> groupedSessions = SessionsService.mapRowingSessionToSessions(rowingSessions);
        return SessionsService.getRowingSessionsPerSquad(groupedSessions);
    }
}
