package org.unasat.model;

/**
 * Created by dionc on 3/12/2017.
 */
public class RouteCount {

    private Long count;
    private Long countPerc;
    private String name;

    public Long getCount() {
        return count;
    }

    public Long getCountPerc() {
        return countPerc;
    }

    public void setCountPerc(Long countPerc) {
        this.countPerc = countPerc;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
