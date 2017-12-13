package br.com.tramalho.githubmvvm.data.model;

/**
 * Created by trama on 12/12/17.
 */

public class RepoFilter {

    private final String language;
    private final String sort;
    private long pageNumber;

    public RepoFilter(String language, String sort, long pageNumber) {

        this.language = language;
        this.sort = sort;
        this.pageNumber = pageNumber;
    }

    public String getLanguage() {
        return language;
    }

    public String getSort() {
        return sort;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long page) {
        this.pageNumber = page;
    }
}
