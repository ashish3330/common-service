package com.neighbourly.commonservice.repository;

import java.util.Map;

public class Criteria {
    private final Map<String, Object> conditions;

    public Criteria(Map<String, Object> conditions) {
        this.conditions = conditions;
    }

    public Map<String, Object> getConditions() {
        return conditions;
    }
}