package wiki.win.util;

import java.util.List;

public class Page<T> {
    //每页显示条数
    private int iniSize = 3;
    //总共多少条数据
    private int countRow;
    //当前页码
    private int currentPage = 1;
    //共计多少页
    private int countPage;
    //上一页
    private int prePage;
    //下一页
    private int nextPage;
    //页面数据
    private List<T> pageList;

    public Page() {
    }

    public Page(int iniSize, int countRow, int currentPage, List<T> pageList) {
        this.iniSize = iniSize;
        this.countRow = countRow;
        this.currentPage = currentPage;
        //页面存放的对象列表
        this.pageList = pageList;
        //countPage
        int num = this.countRow / this.iniSize;
        this.countPage = this.countRow % this.iniSize == 0 ? num : num + 1;
        //prePage
        this.prePage = this.currentPage > 1 ? this.currentPage - 1 : this.currentPage;
        //nextPage
        this.nextPage = this.currentPage == this.countPage ? this.currentPage : this.currentPage + 1;


    }

    public int getIniSize() {
        return iniSize;
    }

    public void setIniSize(int iniSize) {
        this.iniSize = iniSize;
    }

    public int getCountRow() {
        return countRow;
    }

    public void setCountRow(int countRow) {
        this.countRow = countRow;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "iniSize=" + iniSize +
                ", countRow=" + countRow +
                ", currentPage=" + currentPage +
                ", countPage=" + countPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", pageList=" + pageList +
                '}';
    }
}
