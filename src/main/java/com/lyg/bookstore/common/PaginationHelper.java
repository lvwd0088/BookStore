package com.lyg.bookstore.common;

import java.util.List;

/**
 * Created by weida on 2017/6/13.
 */
public class PaginationHelper {
    /**
     * 当前页
     */
    private Integer current =1;

    /**
     * 总页数
     */
//    private Integer pageCount;

    /**
     * 总条数
     */
    private Integer total;

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
    private List<?> list;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if(current ==null|| current <=0){
            current =1;
        }
        System.out.println(current);
        this.current = current;
    }

//    public Integer getPageCount() {
//        return pageCount;
//    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
//        this.pageCount=(total /pageSize)+(total %pageSize==0?0:1);
//        if(this.current >pageCount){
//            this.current =pageCount;
//        }
        this.beginIndex=((current -1)*pageSize);
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

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public PaginationHelper(){}

    public PaginationHelper(Integer current, Integer pageSize) {
        this.setCurrent(current);
        this.setPageSize(pageSize);
    }

    @Override
    public String toString() {
        return "PaginationHelper{" +
                "current=" + current +
//                ", pageCount=" + pageCount +
                ", total=" + total +
                ", pageSize=" + pageSize +
                ", beginIndex=" + beginIndex +
                ", list=" + list +
                '}';
    }
}
