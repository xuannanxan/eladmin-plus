package com.eladmin.jsonconfig;


import com.eladmin.annotation.FieldDescribe;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.BooleanUtils;

@Getter
@Setter
public class DataSources {

    public static final String DEFAULT_DRIVERCLASSNAME = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
    public static final String DEFAULT_URL = "jdbc:log4jdbc:mysql://localhost:3306/eladmin?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false";
    public static final String DEFAULT_USERNAME = "root";
    public static final String DEFAULT_PASSWORD = "123456";
    public static final Integer DEFAULT_INITSIZE = 5;
    public static final Integer DEFAULT_MINIDLE = 15;
    public static final Integer DEFAULT_MAXACT = 30;
    public static final Integer DEFAULT_MAXWAIT = 3000;
    public static final String DEFAULT_URLPATTERN = "/druid/*";
    public static final String DEFAULT_ALLOW = "127.0.0.1";
    public static final String DEFAULT_DENY = "";
    public static final String DEFAULT_DRUIDUSERNAME = "admin";
    public static final String DEFAULT_DRUIDPASSWORD = "123456";
    public static final Boolean DEFAULT_RESETENABLE = false;
    public static final Integer DEFAULT_SLOWSQLMILLIS = 1000;
    public static final Boolean DEFAULT_SHOWSQL = false;
    public static final Boolean DEFAULT_DDL = true;
    public static final String DEFAULT_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";


    public static DataSources defaultInstance() {
        return new DataSources();
    }

    public DataSources() {
        this.driverClassName = DEFAULT_DRIVERCLASSNAME;
        this.url = DEFAULT_URL;
        this.username = DEFAULT_USERNAME;
        this.password = DEFAULT_PASSWORD;
        this.initSize = DEFAULT_INITSIZE;
        this.minIdle = DEFAULT_MINIDLE;
        this.maxAct = DEFAULT_MAXACT;
        this.maxWait = DEFAULT_MAXWAIT;
        this.urlPattern = DEFAULT_URLPATTERN;
        this.allow = DEFAULT_ALLOW;
        this.deny = DEFAULT_DENY;
        this.druidUsername = DEFAULT_DRUIDUSERNAME;
        this.druidPassword = DEFAULT_DRUIDPASSWORD;
        this.resetEnable = DEFAULT_RESETENABLE;
        this.slowSqlMillis = DEFAULT_SLOWSQLMILLIS;
        this.showSql = DEFAULT_SHOWSQL;
        this.ddl = DEFAULT_DDL;
        this.dialect = DEFAULT_DIALECT;

    }

    @FieldDescribe("????????????")
    private String driverClassName;


    @FieldDescribe("????????????????????????")
    private String url;

    @FieldDescribe("?????????")
    private String username;

    @FieldDescribe("??????")
    private String password;

    @FieldDescribe("???????????????")
    private Integer initSize;


    @FieldDescribe("???????????????")
    private Integer minIdle;

    @FieldDescribe("???????????????")
    private Integer maxAct;


    @FieldDescribe("????????????????????????")
    private Integer maxWait;


    @FieldDescribe("druid ??????")
    private String urlPattern;

    @FieldDescribe("druid ??????")
    private String allow;

    @FieldDescribe("druid ??????")
    private String deny;

    @FieldDescribe("druid ??????")
    private String druidUsername;

    @FieldDescribe("druid ??????")
    private String druidPassword;

    @FieldDescribe("??????????????????")
    private Boolean resetEnable;

    @FieldDescribe("????????????(??????????????????)")
    private Integer slowSqlMillis;

    @FieldDescribe("???????????????SQL??????")
    private Boolean showSql;

    @FieldDescribe("????????????DDL??????????????????")
    private Boolean ddl;

    @FieldDescribe("??????hibernate??????")
    private String dialect;
}
