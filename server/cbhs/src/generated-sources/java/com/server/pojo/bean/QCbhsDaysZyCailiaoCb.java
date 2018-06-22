package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysZyCailiaoCb is a Querydsl query type for CbhsDaysZyCailiaoCb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysZyCailiaoCb extends EntityPathBase<CbhsDaysZyCailiaoCb> {

    private static final long serialVersionUID = -1051818493L;

    public static final QCbhsDaysZyCailiaoCb cbhsDaysZyCailiaoCb = new QCbhsDaysZyCailiaoCb("cbhsDaysZyCailiaoCb");

    public final StringPath cailiaoKemuName = createString("cailiaoKemuName");

    public final NumberPath<Integer> cailiaoKemuOid = createNumber("cailiaoKemuOid", Integer.class);

    public final StringPath cailiaoName = createString("cailiaoName");

    public final NumberPath<Integer> cailiaoOid = createNumber("cailiaoOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

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

    public final StringPath shId = createString("shId");

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final StringPath style = createString("style");

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsDaysZyCailiaoCb(String variable) {
        super(CbhsDaysZyCailiaoCb.class, forVariable(variable));
    }

    public QCbhsDaysZyCailiaoCb(Path<? extends CbhsDaysZyCailiaoCb> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysZyCailiaoCb(PathMetadata metadata) {
        super(CbhsDaysZyCailiaoCb.class, metadata);
    }

}

