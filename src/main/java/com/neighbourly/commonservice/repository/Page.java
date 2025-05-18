package com.neighbourly.commonservice.repository;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final int totalPages;
    private final long totalElements;

    public Page(List<T> content, int totalPages, long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getContent() { return content; }
    public int getTotalPages() { return totalPages; }
    public long getTotalElements() { return totalElements; }
}