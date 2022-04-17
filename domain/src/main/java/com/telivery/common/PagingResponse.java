package com.telivery.common;

import org.springframework.lang.Nullable;

public class PagingResponse {
    private int currentPage;
    private int totalCount;
    @Nullable
    private Object payload;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Nullable
    public Object getPayload() {
        return payload;
    }

    public void setPayload(@Nullable Object payload) {
        this.payload = payload;
    }

    public PagingResponse() {
        this.currentPage = 0;
        this.totalCount = 0;
    }

    public PagingResponse(int currentPage, int totalCount, Object payload) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.payload = payload;
    }

}
