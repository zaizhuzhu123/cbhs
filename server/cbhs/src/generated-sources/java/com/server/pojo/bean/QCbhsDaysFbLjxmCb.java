package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysFbLjxmCb is a Querydsl query type for CbhsDaysFbLjxmCb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysFbLjxmCb extends EntityPathBase<CbhsDaysFbLjxmCb> {

    private static final long serialVersionUID = 1961740513L;

    public static final QCbhsDaysFbLjxmCb cbhsDaysFbLjxmCb = new QCbhsDaysFbLjxmCb("cbhsDaysFbLjxmCb");

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbCompanyName = createString("fbCompanyName");

    public final NumberPath<Integer> fbCompanyOid = createNumber("fbCompanyOid", Integer.class);

    public final StringPath ljxmYsName = createString("ljxmYsName");

    public final NumberPath<Integer> ljxmYsOid = createNumber("ljxmYsOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath shId = createString("shId");

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsDaysFbLjxmCb(String variable) {
        super(CbhsDaysFbLjxmCb.class, forVariable(variable));
    }

    public QCbhsDaysFbLjxmCb(Path<? extends CbhsDaysFbLjxmCb> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysFbLjxmCb(PathMetadata metadata) {
        super(CbhsDaysFbLjxmCb.class, metadata);
    }

}

