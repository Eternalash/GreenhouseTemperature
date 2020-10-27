package per.bryan.temperature.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TemperatureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public TemperatureExample() {
        oredCriteria = new ArrayList<>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
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

        public Criteria andGreenhouseNoIsNull() {
            addCriterion("greenhouseNo is null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoIsNotNull() {
            addCriterion("greenhouseNo is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoEqualTo(String value) {
            addCriterion("greenhouseNo =", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoNotEqualTo(String value) {
            addCriterion("greenhouseNo <>", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoGreaterThan(String value) {
            addCriterion("greenhouseNo >", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouseNo >=", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoLessThan(String value) {
            addCriterion("greenhouseNo <", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoLessThanOrEqualTo(String value) {
            addCriterion("greenhouseNo <=", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoLike(String value) {
            addCriterion("greenhouseNo like", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoNotLike(String value) {
            addCriterion("greenhouseNo not like", value, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoIn(List<String> values) {
            addCriterion("greenhouseNo in", values, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoNotIn(List<String> values) {
            addCriterion("greenhouseNo not in", values, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoBetween(String value1, String value2) {
            addCriterion("greenhouseNo between", value1, value2, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNoNotBetween(String value1, String value2) {
            addCriterion("greenhouseNo not between", value1, value2, "greenhouseNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoIsNull() {
            addCriterion("sensorNo is null");
            return (Criteria) this;
        }

        public Criteria andSensorNoIsNotNull() {
            addCriterion("sensorNo is not null");
            return (Criteria) this;
        }

        public Criteria andSensorNoEqualTo(String value) {
            addCriterion("sensorNo =", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoNotEqualTo(String value) {
            addCriterion("sensorNo <>", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoGreaterThan(String value) {
            addCriterion("sensorNo >", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoGreaterThanOrEqualTo(String value) {
            addCriterion("sensorNo >=", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoLessThan(String value) {
            addCriterion("sensorNo <", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoLessThanOrEqualTo(String value) {
            addCriterion("sensorNo <=", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoLike(String value) {
            addCriterion("sensorNo like", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoNotLike(String value) {
            addCriterion("sensorNo not like", value, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoIn(List<String> values) {
            addCriterion("sensorNo in", values, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoNotIn(List<String> values) {
            addCriterion("sensorNo not in", values, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoBetween(String value1, String value2) {
            addCriterion("sensorNo between", value1, value2, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andSensorNoNotBetween(String value1, String value2) {
            addCriterion("sensorNo not between", value1, value2, "sensorNo");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNull() {
            addCriterion("humidity is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("humidity is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(String value) {
            addCriterion("humidity =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(String value) {
            addCriterion("humidity <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(String value) {
            addCriterion("humidity >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(String value) {
            addCriterion("humidity >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(String value) {
            addCriterion("humidity <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(String value) {
            addCriterion("humidity <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLike(String value) {
            addCriterion("humidity like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotLike(String value) {
            addCriterion("humidity not like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<String> values) {
            addCriterion("humidity in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<String> values) {
            addCriterion("humidity not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(String value1, String value2) {
            addCriterion("humidity between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(String value1, String value2) {
            addCriterion("humidity not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(LocalDateTime value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(LocalDateTime value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(LocalDateTime value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(LocalDateTime value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<LocalDateTime> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<LocalDateTime> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }
    }

    /**
     */
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