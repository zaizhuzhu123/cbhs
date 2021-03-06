package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthFbLjxmCbYs is a Querydsl query type for CbhsMonthFbLjxmCbYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthFbLjxmCbYs extends EntityPathBase<CbhsMonthFbLjxmCbYs> {

    private static final long serialVersionUID = 1047697036L;

    public static final QCbhsMonthFbLjxmCbYs cbhsMonthFbLjxmCbYs = new QCbhsMonthFbLjxmCbYs("cbhsMonthFbLjxmCbYs");

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final StringPath name = createString("name");

    public final StringPath no = createString("no");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsMonthFbLjxmCbYs(String variable) {
        super(CbhsMonthFbLjxmCbYs.class, forVariable(variable));
    }

    public QCbhsMonthFbLjxmCbYs(Path<? extends CbhsMonthFbLjxmCbYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthFbLjxmCbYs(PathMetadata metadata) {
        super(CbhsMonthFbLjxmCbYs.class, metadata);
    }

}

