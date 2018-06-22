package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthZyLxygCbYs is a Querydsl query type for CbhsMonthZyLxygCbYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthZyLxygCbYs extends EntityPathBase<CbhsMonthZyLxygCbYs> {

    private static final long serialVersionUID = -1941115082L;

    public static final QCbhsMonthZyLxygCbYs cbhsMonthZyLxygCbYs = new QCbhsMonthZyLxygCbYs("cbhsMonthZyLxygCbYs");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> personCount = createNumber("personCount", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsMonthZyLxygCbYs(String variable) {
        super(CbhsMonthZyLxygCbYs.class, forVariable(variable));
    }

    public QCbhsMonthZyLxygCbYs(Path<? extends CbhsMonthZyLxygCbYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthZyLxygCbYs(PathMetadata metadata) {
        super(CbhsMonthZyLxygCbYs.class, metadata);
    }

}

