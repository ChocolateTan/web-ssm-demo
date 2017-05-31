package com.ssm.bean;

import java.util.Date;

public class ModeBean {
    private Long modeid;

    private String modename;

    private Integer xsize;

    private Integer ysize;

    private Date createtime;

    private Date modifytime;

    private Byte isdelete;

    private String modeinfo;

    public Long getModeid() {
        return modeid;
    }

    public void setModeid(Long modeid) {
        this.modeid = modeid;
    }

    public String getModename() {
        return modename;
    }

    public void setModename(String modename) {
        this.modename = modename == null ? null : modename.trim();
    }

    public Integer getXsize() {
        return xsize;
    }

    public void setXsize(Integer xsize) {
        this.xsize = xsize;
    }

    public Integer getYsize() {
        return ysize;
    }

    public void setYsize(Integer ysize) {
        this.ysize = ysize;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    public String getModeinfo() {
        return modeinfo;
    }

    public void setModeinfo(String modeinfo) {
        this.modeinfo = modeinfo == null ? null : modeinfo.trim();
    }
}