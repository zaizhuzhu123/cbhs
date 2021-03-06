package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZytj is a Querydsl query type for CbhsZytj
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZytj extends EntityPathBase<CbhsZytj> {

    private static final long serialVersionUID = 2144458961L;

    public static final QCbhsZytj cbhsZytj = new QCbhsZytj("cbhsZytj");

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbcompanyName = createString("fbcompanyName");

    public final NumberPath<Integer> fbcompanyOid = createNumber("fbcompanyOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> fcTotal = createNumber("fcTotal", java.math.BigDecimal.class);

    public final StringPath globalGclYsName = createString("globalGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzTotal = createNumber("gzTotal", java.math.BigDecimal.class);

    public final NumberPath<Integer> jxCount = createNumber("jxCount", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_jxdxf = createNumber("p_jxdxf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_jxysf = createNumber("p_jxysf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zjf = createNumber("p_zjf", java.math.BigDecimal.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<Integer> ryID = createNumber("ryID", Integer.class);

    public final StringPath ryKemuName = createString("ryKemuName");

    public final StringPath ryName = createString("ryName");

    public final NumberPath<java.math.BigDecimal> ryPrice = createNumber("ryPrice", java.math.BigDecimal.class);

    public final StringPath ryStyle = createString("ryStyle");

    public final StringPath ryUnit = createString("ryUnit");

    public final NumberPath<java.math.BigDecimal> ryUnitPrice = createNumber("ryUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> ryUseCount = createNumber("ryUseCount", java.math.BigDecimal.class);

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> zcTotal = createNumber("zcTotal", java.math.BigDecimal.class);

    public QCbhsZytj(String variable) {
        super(CbhsZytj.class, forVariable(variable));
    }

    public QCbhsZytj(Path<? extends CbhsZytj> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZytj(PathMetadata metadata) {
        super(CbhsZytj.class, metadata);
    }

}

