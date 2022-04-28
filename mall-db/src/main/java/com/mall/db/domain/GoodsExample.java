package com.mall.db.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

    public GoodsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public GoodsExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        GoodsExample example = new GoodsExample();
        return example.createCriteria();
    }

    public GoodsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public GoodsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public GoodsExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> imagesCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            imagesCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getImagesCriteria() {
            return imagesCriteria;
        }

        protected void addImagesCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            imagesCriteria.add(new Criterion(condition, value, "com.mall.db.mybatis.JsonStringArrayTypeHandler"));
            allCriteria = null;
        }

        protected void addImagesCriterion(String condition, String[] value1, String[] value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            imagesCriteria.add(new Criterion(condition, value1, value2, "com.mall.db.mybatis.JsonStringArrayTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || imagesCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(imagesCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("`uid` is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("`uid` is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("`uid` =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("`uid` <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("`uid` >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("`uid` >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("`uid` <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("`uid` <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`uid` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("`uid` in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("`uid` not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("`uid` between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("`uid` not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`type` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("category_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("school_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`name` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("price <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andNormalPriceIsNull() {
            addCriterion("normal_price is null");
            return (Criteria) this;
        }

        public Criteria andNormalPriceIsNotNull() {
            addCriterion("normal_price is not null");
            return (Criteria) this;
        }

        public Criteria andNormalPriceEqualTo(BigDecimal value) {
            addCriterion("normal_price =", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceNotEqualTo(BigDecimal value) {
            addCriterion("normal_price <>", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceGreaterThan(BigDecimal value) {
            addCriterion("normal_price >", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("normal_price >=", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceLessThan(BigDecimal value) {
            addCriterion("normal_price <", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("normal_price <=", value, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("normal_price <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNormalPriceIn(List<BigDecimal> values) {
            addCriterion("normal_price in", values, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceNotIn(List<BigDecimal> values) {
            addCriterion("normal_price not in", values, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("normal_price between", value1, value2, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andNormalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("normal_price not between", value1, value2, "normalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Byte value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Byte value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Byte value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Byte value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Byte value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Byte value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("discount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Byte> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Byte> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Byte value1, Byte value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Byte value1, Byte value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDegreeIdIsNull() {
            addCriterion("degree_id is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIdIsNotNull() {
            addCriterion("degree_id is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeIdEqualTo(Byte value) {
            addCriterion("degree_id =", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotEqualTo(Byte value) {
            addCriterion("degree_id <>", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThan(Byte value) {
            addCriterion("degree_id >", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("degree_id >=", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThan(Byte value) {
            addCriterion("degree_id <", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThanOrEqualTo(Byte value) {
            addCriterion("degree_id <=", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("degree_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDegreeIdIn(List<Byte> values) {
            addCriterion("degree_id in", values, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotIn(List<Byte> values) {
            addCriterion("degree_id not in", values, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdBetween(Byte value1, Byte value2) {
            addCriterion("degree_id between", value1, value2, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("degree_id not between", value1, value2, "degreeId");
            return (Criteria) this;
        }

        public Criteria andBannerIsNull() {
            addCriterion("banner is null");
            return (Criteria) this;
        }

        public Criteria andBannerIsNotNull() {
            addCriterion("banner is not null");
            return (Criteria) this;
        }

        public Criteria andBannerEqualTo(String value) {
            addCriterion("banner =", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerNotEqualTo(String value) {
            addCriterion("banner <>", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThan(String value) {
            addCriterion("banner >", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanOrEqualTo(String value) {
            addCriterion("banner >=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerLessThan(String value) {
            addCriterion("banner <", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerLessThanOrEqualTo(String value) {
            addCriterion("banner <=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("banner <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBannerLike(String value) {
            addCriterion("banner like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotLike(String value) {
            addCriterion("banner not like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerIn(List<String> values) {
            addCriterion("banner in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotIn(List<String> values) {
            addCriterion("banner not in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerBetween(String value1, String value2) {
            addCriterion("banner between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotBetween(String value1, String value2) {
            addCriterion("banner not between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String[] value) {
            addImagesCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String[] value) {
            addImagesCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String[] value) {
            addImagesCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String[] value) {
            addImagesCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String[] value) {
            addImagesCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String[] value) {
            addImagesCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("images <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andImagesLike(String[] value) {
            addImagesCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String[] value) {
            addImagesCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String[]> values) {
            addImagesCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String[]> values) {
            addImagesCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String[] value1, String[] value2) {
            addImagesCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String[] value1, String[] value2) {
            addImagesCriterion("images not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andPropsIsNull() {
            addCriterion("props is null");
            return (Criteria) this;
        }

        public Criteria andPropsIsNotNull() {
            addCriterion("props is not null");
            return (Criteria) this;
        }

        public Criteria andPropsEqualTo(String value) {
            addCriterion("props =", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsNotEqualTo(String value) {
            addCriterion("props <>", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThan(String value) {
            addCriterion("props >", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThanOrEqualTo(String value) {
            addCriterion("props >=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsLessThan(String value) {
            addCriterion("props <", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsLessThanOrEqualTo(String value) {
            addCriterion("props <=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("props <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropsLike(String value) {
            addCriterion("props like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotLike(String value) {
            addCriterion("props not like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsIn(List<String> values) {
            addCriterion("props in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotIn(List<String> values) {
            addCriterion("props not in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsBetween(String value1, String value2) {
            addCriterion("props between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotBetween(String value1, String value2) {
            addCriterion("props not between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("quantity <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`status` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIsNull() {
            addCriterion("is_on_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIsNotNull() {
            addCriterion("is_on_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleEqualTo(Byte value) {
            addCriterion("is_on_sale =", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotEqualTo(Byte value) {
            addCriterion("is_on_sale <>", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThan(Byte value) {
            addCriterion("is_on_sale >", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_on_sale >=", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThan(Byte value) {
            addCriterion("is_on_sale <", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThanOrEqualTo(Byte value) {
            addCriterion("is_on_sale <=", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("is_on_sale <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIn(List<Byte> values) {
            addCriterion("is_on_sale in", values, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotIn(List<Byte> values) {
            addCriterion("is_on_sale not in", values, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleBetween(Byte value1, Byte value2) {
            addCriterion("is_on_sale between", value1, value2, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotBetween(Byte value1, Byte value2) {
            addCriterion("is_on_sale not between", value1, value2, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andViewIsNull() {
            addCriterion("`view` is null");
            return (Criteria) this;
        }

        public Criteria andViewIsNotNull() {
            addCriterion("`view` is not null");
            return (Criteria) this;
        }

        public Criteria andViewEqualTo(Integer value) {
            addCriterion("`view` =", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNotEqualTo(Integer value) {
            addCriterion("`view` <>", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewGreaterThan(Integer value) {
            addCriterion("`view` >", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("`view` >=", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewLessThan(Integer value) {
            addCriterion("`view` <", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewLessThanOrEqualTo(Integer value) {
            addCriterion("`view` <=", value, "view");
            return (Criteria) this;
        }

        public Criteria andViewLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("`view` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewIn(List<Integer> values) {
            addCriterion("`view` in", values, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotIn(List<Integer> values) {
            addCriterion("`view` not in", values, "view");
            return (Criteria) this;
        }

        public Criteria andViewBetween(Integer value1, Integer value2) {
            addCriterion("`view` between", value1, value2, "view");
            return (Criteria) this;
        }

        public Criteria andViewNotBetween(Integer value1, Integer value2) {
            addCriterion("`view` not between", value1, value2, "view");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(LocalDateTime value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(LocalDateTime value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(LocalDateTime value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(LocalDateTime value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualToColumn(Goods.Column column) {
            addCriterion(new StringBuilder("add_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<LocalDateTime> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<LocalDateTime> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private GoodsExample example;

        protected Criteria(GoodsExample example) {
            super();
            this.example = example;
        }

        public GoodsExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.mall.db.domain.GoodsExample example);
    }
}