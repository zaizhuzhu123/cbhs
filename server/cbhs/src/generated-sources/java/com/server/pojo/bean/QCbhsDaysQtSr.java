package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysQtSr is a Querydsl query type for CbhsDaysQtSr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysQtSr extends EntityPathBase<CbhsDaysQtSr> {

    private static final long serialVersionUID = 1155874229L;

    public static final QCbhsDaysQtSr cbhsDaysQtSr = new QCbhsDaysQtSr("cbhsDaysQtSr");

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

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

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsDaysQtSr(String variable) {
        super(CbhsDaysQtSr.class, forVariable(variable));
    }

    public QCbhsDaysQtSr(Path<? extends CbhsDaysQtSr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysQtSr(PathMetadata metadata) {
        super(CbhsDaysQtSr.class, metadata);
    }

}

