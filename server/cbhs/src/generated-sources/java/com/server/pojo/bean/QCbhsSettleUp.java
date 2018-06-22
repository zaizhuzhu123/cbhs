package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsSettleUp is a Querydsl query type for CbhsSettleUp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsSettleUp extends EntityPathBase<CbhsSettleUp> {

    private static final long serialVersionUID = 641840674L;

    public static final QCbhsSettleUp cbhsSettleUp = new QCbhsSettleUp("cbhsSettleUp");

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

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsSettleUp(String variable) {
        super(CbhsSettleUp.class, forVariable(variable));
    }

    public QCbhsSettleUp(Path<? extends CbhsSettleUp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsSettleUp(PathMetadata metadata) {
        super(CbhsSettleUp.class, metadata);
    }

}

