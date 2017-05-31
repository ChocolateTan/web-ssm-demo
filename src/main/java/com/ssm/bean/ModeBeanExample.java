package com.ssm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModeBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andModeidIsNull() {
            addCriterion("modeId is null");
            return (Criteria) this;
        }

        public Criteria andModeidIsNotNull() {
            addCriterion("modeId is not null");
            return (Criteria) this;
        }

        public Criteria andModeidEqualTo(Long value) {
            addCriterion("modeId =", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidNotEqualTo(Long value) {
            addCriterion("modeId <>", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidGreaterThan(Long value) {
            addCriterion("modeId >", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidGreaterThanOrEqualTo(Long value) {
            addCriterion("modeId >=", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidLessThan(Long value) {
            addCriterion("modeId <", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidLessThanOrEqualTo(Long value) {
            addCriterion("modeId <=", value, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidIn(List<Long> values) {
            addCriterion("modeId in", values, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidNotIn(List<Long> values) {
            addCriterion("modeId not in", values, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidBetween(Long value1, Long value2) {
            addCriterion("modeId between", value1, value2, "modeid");
            return (Criteria) this;
        }

        public Criteria andModeidNotBetween(Long value1, Long value2) {
            addCriterion("modeId not between", value1, value2, "modeid");
            return (Criteria) this;
        }

        public Criteria andModenameIsNull() {
            addCriterion("modeName is null");
            return (Criteria) this;
        }

        public Criteria andModenameIsNotNull() {
            addCriterion("modeName is not null");
            return (Criteria) this;
        }

        public Criteria andModenameEqualTo(String value) {
            addCriterion("modeName =", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameNotEqualTo(String value) {
            addCriterion("modeName <>", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameGreaterThan(String value) {
            addCriterion("modeName >", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameGreaterThanOrEqualTo(String value) {
            addCriterion("modeName >=", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameLessThan(String value) {
            addCriterion("modeName <", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameLessThanOrEqualTo(String value) {
            addCriterion("modeName <=", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameLike(String value) {
            addCriterion("modeName like", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameNotLike(String value) {
            addCriterion("modeName not like", value, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameIn(List<String> values) {
            addCriterion("modeName in", values, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameNotIn(List<String> values) {
            addCriterion("modeName not in", values, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameBetween(String value1, String value2) {
            addCriterion("modeName between", value1, value2, "modename");
            return (Criteria) this;
        }

        public Criteria andModenameNotBetween(String value1, String value2) {
            addCriterion("modeName not between", value1, value2, "modename");
            return (Criteria) this;
        }

        public Criteria andXsizeIsNull() {
            addCriterion("xSize is null");
            return (Criteria) this;
        }

        public Criteria andXsizeIsNotNull() {
            addCriterion("xSize is not null");
            return (Criteria) this;
        }

        public Criteria andXsizeEqualTo(Integer value) {
            addCriterion("xSize =", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeNotEqualTo(Integer value) {
            addCriterion("xSize <>", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeGreaterThan(Integer value) {
            addCriterion("xSize >", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("xSize >=", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeLessThan(Integer value) {
            addCriterion("xSize <", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeLessThanOrEqualTo(Integer value) {
            addCriterion("xSize <=", value, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeIn(List<Integer> values) {
            addCriterion("xSize in", values, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeNotIn(List<Integer> values) {
            addCriterion("xSize not in", values, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeBetween(Integer value1, Integer value2) {
            addCriterion("xSize between", value1, value2, "xsize");
            return (Criteria) this;
        }

        public Criteria andXsizeNotBetween(Integer value1, Integer value2) {
            addCriterion("xSize not between", value1, value2, "xsize");
            return (Criteria) this;
        }

        public Criteria andYsizeIsNull() {
            addCriterion("ySize is null");
            return (Criteria) this;
        }

        public Criteria andYsizeIsNotNull() {
            addCriterion("ySize is not null");
            return (Criteria) this;
        }

        public Criteria andYsizeEqualTo(Integer value) {
            addCriterion("ySize =", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeNotEqualTo(Integer value) {
            addCriterion("ySize <>", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeGreaterThan(Integer value) {
            addCriterion("ySize >", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ySize >=", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeLessThan(Integer value) {
            addCriterion("ySize <", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeLessThanOrEqualTo(Integer value) {
            addCriterion("ySize <=", value, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeIn(List<Integer> values) {
            addCriterion("ySize in", values, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeNotIn(List<Integer> values) {
            addCriterion("ySize not in", values, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeBetween(Integer value1, Integer value2) {
            addCriterion("ySize between", value1, value2, "ysize");
            return (Criteria) this;
        }

        public Criteria andYsizeNotBetween(Integer value1, Integer value2) {
            addCriterion("ySize not between", value1, value2, "ysize");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifyTime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifyTime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifyTime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyTime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifyTime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifyTime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifyTime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifyTime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifyTime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifyTime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Byte value) {
            addCriterion("isDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Byte value) {
            addCriterion("isDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Byte value) {
            addCriterion("isDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("isDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Byte value) {
            addCriterion("isDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Byte value) {
            addCriterion("isDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Byte> values) {
            addCriterion("isDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Byte> values) {
            addCriterion("isDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Byte value1, Byte value2) {
            addCriterion("isDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("isDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}