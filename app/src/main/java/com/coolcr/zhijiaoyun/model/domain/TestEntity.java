package com.coolcr.zhijiaoyun.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CoolCrush
 * On 2021/7/13
 * Email CoolCrush@126.com
 */
public class TestEntity {

    private Integer code;
    private List<ListBean> list;
    private PaginationBean pagination;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public static class PaginationBean {
        private Integer totalCount;
        private Integer pageSize;
        private Integer pageIndex;

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }
    }

    public static class ListBean {
        @SerializedName("Id")
        private String id;
        private String coverUrl;
        private String courseName;
        private String thumbnail;
        private String courseOpenId;
        private String courseOpenName;
        private String stuCount;
        private Integer process;
        @SerializedName("DateCreated")
        private String dateCreated;
        private String stuId;
        private Integer courseType;
        private Integer classify;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getCourseOpenId() {
            return courseOpenId;
        }

        public void setCourseOpenId(String courseOpenId) {
            this.courseOpenId = courseOpenId;
        }

        public String getCourseOpenName() {
            return courseOpenName;
        }

        public void setCourseOpenName(String courseOpenName) {
            this.courseOpenName = courseOpenName;
        }

        public String getStuCount() {
            return stuCount;
        }

        public void setStuCount(String stuCount) {
            this.stuCount = stuCount;
        }

        public Integer getProcess() {
            return process;
        }

        public void setProcess(Integer process) {
            this.process = process;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getStuId() {
            return stuId;
        }

        public void setStuId(String stuId) {
            this.stuId = stuId;
        }

        public Integer getCourseType() {
            return courseType;
        }

        public void setCourseType(Integer courseType) {
            this.courseType = courseType;
        }

        public Integer getClassify() {
            return classify;
        }

        public void setClassify(Integer classify) {
            this.classify = classify;
        }
    }
}
