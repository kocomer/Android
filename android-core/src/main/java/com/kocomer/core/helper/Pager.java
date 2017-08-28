package com.kocomer.core.helper;

import java.util.List;

/**
 * Created by kocomer on 2017/8/17.
 */

public class Pager<T> {

    private List<T> items; // 当页记录
    private Integer prevPageNo; // 前一页
    private Integer pageNo; // 页号
    private Integer nextPageNo; // 下一页
    private Integer totalPage; // 总页数
    private Long totalCount; // 总记录数

    public List<T> getItems() {
        return items;
    }

    public Pager<T> setItems(List<T> items) {
        this.items = items;
        return this;
    }

    public Integer getPrevPageNo() {
        return prevPageNo;
    }

    public void setPrevPageNo(Integer prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(Integer nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Pager<T> setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public Pager<T> setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

}
