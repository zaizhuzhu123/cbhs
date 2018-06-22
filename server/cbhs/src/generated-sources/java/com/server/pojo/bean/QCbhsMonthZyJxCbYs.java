package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthZyJxCbYs is a Querydsl query type for CbhsMonthZyJxCbYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthZyJxCbYs extends EntityPathBase<CbhsMonthZyJxCbYs> {

    private static final long serialVersionUID = 225142186L;

    public static final QCbhsMonthZyJxCbYs cbhsMonthZyJxCbYs = new QCbhsMonthZyJxCbYs("cbhsMonthZyJxCbYs");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> p_clysf = createNumber("p_clysf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_jxdxf = createNumber("p_jxdxf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zjf = createNumber("p_zjf", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> p_zpf = createNumber("p_zpf", java.math.BigDecimal.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public QCbhsMonthZyJxCbYs(String variable) {
        super(CbhsMonthZyJxCbYs.class, forVariable(variable));
    }

    public QCbhsMonthZyJxCbYs(Path<? extends CbhsMonthZyJxCbYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthZyJxCbYs(PathMetadata metadata) {
        super(CbhsMonthZyJxCbYs.class, metadata);
    }

}

