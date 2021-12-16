package guest.vo;

/**
 * @Class Name : GuestVO.java
 * @Description : Guest VO class
 * @Modification Information
 *
 * @author Brian
 * @since 2021-12-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class GuestVO extends GuestDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** idx */
    private int idx;
    
    /** content */
    private java.lang.String content;
    
    /** name */
    private java.lang.String name;
    
    public int getIdx() {
        return this.idx;
    }
    
    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
}
