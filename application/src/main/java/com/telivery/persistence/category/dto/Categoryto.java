package com.telivery.persistence.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Categoryto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CategoryReq {

        private String name;

        @Builder
        public CategoryReq(String name) {
            this.name = name;
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CategoryRes {

        private Long id;
        private String name;

        @Builder
        public CategoryRes(Long id, String name) {
            this.id = id;
            this.name = name;
        }

    }
}
