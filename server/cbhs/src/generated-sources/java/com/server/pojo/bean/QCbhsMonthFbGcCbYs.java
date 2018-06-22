package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthFbGcCbYs is a Querydsl query type for CbhsMonthFbGcCbYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthFbGcCbYs extends EntityPathBase<CbhsMonthFbGcCbYs> {

    private static final long serialVersionUID = 685644277L;

    public static final QCbhsMonthFbGcCbYs cbhsMonthFbGcCbYs = new QCbhsMonthFbGcCbYs("cbhsMonthFbGcCbYs");

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbCompanyName = createString("fbCompanyName");

    public final NumberPath<Integer> fbCompanyOid = createNumber("fbCompanyOid", Integer.class);

    public final StringPath globalGclYsName = createString("globalGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

    public final StringPath htName = createString("htName");

    public final NumberPath<Integer> htOid = createNumber("htOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nodeId = createString("nodeId");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath pNodeId = createString("pNodeId");

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsMonthFbGcCbYs(String variable) {
        super(CbhsMonthFbGcCbYs.class, forVariable(variable));
    }

    public QCbhsMonthFbGcCbYs(Path<? extends CbhsMonthFbGcCbYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthFbGcCbYs(PathMetadata metadata) {
        super(CbhsMonthFbGcCbYs.class, metadata);
    }

}

