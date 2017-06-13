package com.lyg.bookstore.common;

import java.util.List;

/**
 * Created by weida on 2017/6/13.
 */
public class PaginationHelper {
    /**
     * 当前页
     */
    private Integer currentPage=1;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 总条数
     */
    private Integer count;

    /**
     * 每页显示条数
     */
    private Integer pageSize=10;

    /**
     * 查询起始位置
     */
    private Integer beginIndex;

    /**
     * 分页数据
     */
    private List<?> datas;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage==null||currentPage<=0){
            currentPage=1;
        }
        System.out.println(currentPage);
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        this.pageCount=(count/pageSize)+(count%pageSize==0?0:1);
        if(this.currentPage>pageCount){
            this.currentPage=pageCount;
        }
        this.beginIndex=((currentPage-1)*pageSize);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize==null||pageSize<=0){
            pageSize=10;
        }
        this.pageSize = pageSize;
    }

    public List<?> getDatas() {
        return datas;
    }

    public void setDatas(List<?> datas) {
        this.datas = datas;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public PaginationHelper(){}

    public PaginationHelper(Integer currentPage, Integer pageSize) {
        this.setCurrentPage(currentPage);
        this.setPageSize(pageSize);
    }

    @Override
    public String toString() {
        return "PaginationHelper{" +
                "currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", count=" + count +
                ", pageSize=" + pageSize +
                ", beginIndex=" + beginIndex +
                ", datas=" + datas +
                '}';
    }
}
