package com.codeaddi.row_your_boat.controller.sessions;

import com.codeaddi.row_your_boat.TestData;
import com.codeaddi.row_your_boat.model.RowerLevel;
import com.codeaddi.row_your_boat.model.SessionType;
import com.codeaddi.row_your_boat.model.sessions.http.RowingSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RowingSessionGrouperTests {
    @Test
    public void groupSessions_withMatchingSessions_groupsThem() {

        Map<RowingSessionGrouper.RowingSessionKey, List<RowingSession>> actualGroupedSessions = RowingSessionGrouper.groupSessions(TestData.sessions);

        RowingSessionGrouper.RowingSessionKey expectedRowingSessionKeyFor1And2 = new RowingSessionGrouper.RowingSessionKey(TestData.session1);

        RowingSessionGrouper.RowingSessionKey expectedRowingSessionKeyFor3 = new RowingSessionGrouper.RowingSessionKey(TestData.session3);

        assertEquals(2, actualGroupedSessions.size());
        actualGroupedSessions.containsKey(expectedRowingSessionKeyFor1And2);
        actualGroupedSessions.containsKey(expectedRowingSessionKeyFor3);

        List<RowingSession> actualGroupedSession1And2 = actualGroupedSessions.get(expectedRowingSessionKeyFor1And2);
        assertTrue(actualGroupedSession1And2.contains(TestData.session1) && actualGroupedSession1And2.contains(TestData.session2));

        List<RowingSession> actualGroupedSession3 = actualGroupedSessions.get(expectedRowingSessionKeyFor3);
        assertTrue(actualGroupedSession3.contains(TestData.session3));

    }
}
