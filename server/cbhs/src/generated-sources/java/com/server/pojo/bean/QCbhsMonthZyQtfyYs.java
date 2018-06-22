package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMonthZyQtfyYs is a Querydsl query type for CbhsMonthZyQtfyYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMonthZyQtfyYs extends EntityPathBase<CbhsMonthZyQtfyYs> {

    private static final long serialVersionUID = 422916947L;

    public static final QCbhsMonthZyQtfyYs cbhsMonthZyQtfyYs = new QCbhsMonthZyQtfyYs("cbhsMonthZyQtfyYs");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public QCbhsMonthZyQtfyYs(String variable) {
        super(CbhsMonthZyQtfyYs.class, forVariable(variable));
    }

    public QCbhsMonthZyQtfyYs(Path<? extends CbhsMonthZyQtfyYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMonthZyQtfyYs(PathMetadata metadata) {
        super(CbhsMonthZyQtfyYs.class, metadata);
    }

}

