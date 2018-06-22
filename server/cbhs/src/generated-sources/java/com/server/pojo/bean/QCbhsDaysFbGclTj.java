package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysFbGclTj is a Querydsl query type for CbhsDaysFbGclTj
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysFbGclTj extends EntityPathBase<CbhsDaysFbGclTj> {

    private static final long serialVersionUID = 196990871L;

    public static final QCbhsDaysFbGclTj cbhsDaysFbGclTj = new QCbhsDaysFbGclTj("cbhsDaysFbGclTj");

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbCompanyName = createString("fbCompanyName");

    public final NumberPath<Integer> fbCompanyOid = createNumber("fbCompanyOid", Integer.class);

    public final StringPath fbGclYsName = createString("fbGclYsName");

    public final NumberPath<Integer> fbGclYsOid = createNumber("fbGclYsOid", Integer.class);

    public final StringPath htName = createString("htName");

    public final NumberPath<Integer> htOid = createNumber("htOid", Integer.class);

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

    public QCbhsDaysFbGclTj(String variable) {
        super(CbhsDaysFbGclTj.class, forVariable(variable));
    }

    public QCbhsDaysFbGclTj(Path<? extends CbhsDaysFbGclTj> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysFbGclTj(PathMetadata metadata) {
        super(CbhsDaysFbGclTj.class, metadata);
    }

}

