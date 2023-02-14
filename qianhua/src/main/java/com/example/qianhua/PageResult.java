package com.example.qianhua;

public class PageResult<T> {
    private Integer pageIndex;//页码
    private Integer pageSize;//每页显示数量
    private Integer total;//数据总条数
    private Integer pageTotal;//总页数
    private T data;//每页显示数据

    public void setPageIndex(Integer pageIndex){
        this.pageIndex = (pageIndex<1?1:pageIndex);
    }

    public Integer getPageIndex(){
        return this.pageIndex;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = (pageSize == 1 ? 10 : pageSize);
    }

    public Integer getPageSize(){
        return this.pageSize;
    }

    public void setPageTotal(Integer pageSize,Integer total){
        this.pageTotal = (total % pageSize == 0 ? total % pageSize:(total % pageSize) + 1);
    }

    public Integer getPageTotal(){
        return this.pageTotal;
    }

    public PageResult(Integer pageIndex, Integer pageSize, T data) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.data = data;
    }
}
