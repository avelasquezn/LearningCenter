package com.acme.learning.platform.analytics.service;

import com.acme.learning.platform.analytics.domain.service.LearningAnalyticsService;
import com.acme.learning.platform.learning.api.internal.LearningContextFacade;

public class LearningAnalyticsServiceImpl implements LearningAnalyticsService {
    private final LearningContextFacade learningContextFacade;

    public LearningAnalyticsServiceImpl(LearningContextFacade learningContextFacade) {
        this.learningContextFacade = learningContextFacade;
    }

    @Override
    public int getTotalStudents() {
        return learningContextFacade.getAllStudents().size();
    }
}
