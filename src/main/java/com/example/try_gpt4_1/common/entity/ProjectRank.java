package com.example.try_gpt4_1.common.entity;

public enum ProjectRank {
    S(10000, Integer.MAX_VALUE),
    A(8000, 9999),
    B(5000, 7999),
    C(2000, 4999),
    D(0, 1999);

    private final int min;
    private final int max;

    ProjectRank(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static ProjectRank of(int salesAmount) {
        for (ProjectRank rank : values()) {
            if (salesAmount >= rank.min && salesAmount <= rank.max) {
                return rank;
            }
        }
        return D;
    }
}
