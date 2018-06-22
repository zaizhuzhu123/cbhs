package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthFbCailiaoCbYs is a Querydsl query type for CbhsMonthFbCailiaoCbYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthFbCailiaoCbYs extends EntityPathBase<CbhsMonthFbCailiaoCbYs> {

    private static final long serialVersionUID = 131333775L;

    public static final QCbhsMonthFbCailiaoCbYs cbhsMonthFbCailiaoCbYs = new QCbhsMonthFbCailiaoCbYs("cbhsMonthFbCailiaoCbYs");

    public final StringPath cailiaoKemuName = createString("cailiaoKemuName");

    public final StringPath cailiaoName = createString("cailiaoName");

    public final NumberPath<Integer> cailiaoOid = createNumber("cailiaoOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbCompanyName = createString("fbCompanyName");

    public final NumberPath<Integer> fbCompanyOid = createNumber("fbCompanyOid", Integer.class);

    public final StringPath globalGclYsName = createString("globalGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath style = createString("style");

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsMonthFbCailiaoCbYs(String variable) {
        super(CbhsMonthFbCailiaoCbYs.class, forVariable(variable));
    }

    public QCbhsMonthFbCailiaoCbYs(Path<? extends CbhsMonthFbCailiaoCbYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthFbCailiaoCbYs(PathMetadata metadata) {
        super(CbhsMonthFbCailiaoCbYs.class, metadata);
    }

}

