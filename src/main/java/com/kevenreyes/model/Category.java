package com.kevenreyes.model;

public enum Category {

    ACTION("Action"),
    ROMANCE("Romance"),
    CRIME("Crime"),
    COMEDY("Comedy"),
    DRAMA("Drama");

    private String categoryOmdb;

    Category(String categoryOmdb) {
        this.categoryOmdb = categoryOmdb;

    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.categoryOmdb.equalsIgnoreCase(text)) {
                return category;
            }

        }

        throw new IllegalArgumentException("Search, excluding category");
    }

}
