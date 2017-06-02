package com.ssm.bean;

import java.util.Date;

public class RecordBean {
    private Long recordid;

    private String recordname;

    private Long modeid;

    private Integer step;

    private Byte isdelete;

    private Date createdate;

    private Date modifytime;

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getRecordname() {
        return recordname;
    }

    public void setRecordname(String recordname) {
        this.recordname = recordname == null ? null : recordname.trim();
    }

    public Long getModeid() {
        return modeid;
    }

    public void setModeid(Long modeid) {
        this.modeid = modeid;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}