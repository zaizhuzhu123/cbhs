package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCb is a Querydsl query type for CbhsCb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCb extends EntityPathBase<CbhsCb> {

    private static final long serialVersionUID = -1629052357L;

    public static final QCbhsCb cbhsCb = new QCbhsCb("cbhsCb");

    public final NumberPath<Integer> cbOid = createNumber("cbOid", Integer.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QCbhsCb(String variable) {
        super(CbhsCb.class, forVariable(variable));
    }

    public QCbhsCb(Path<? extends CbhsCb> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCb(PathMetadata metadata) {
        super(CbhsCb.class, metadata);
    }

}

