package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGlobalFyzYs is a Querydsl query type for CbhsGlobalFyzYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGlobalFyzYs extends EntityPathBase<CbhsGlobalFyzYs> {

    private static final long serialVersionUID = 1044926274L;

    public static final QCbhsGlobalFyzYs cbhsGlobalFyzYs = new QCbhsGlobalFyzYs("cbhsGlobalFyzYs");

    public final StringPath name = createString("name");

    public final StringPath nodeId = createString("nodeId");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> totaPrice = createNumber("totaPrice", java.math.BigDecimal.class);

    public QCbhsGlobalFyzYs(String variable) {
        super(CbhsGlobalFyzYs.class, forVariable(variable));
    }

    public QCbhsGlobalFyzYs(Path<? extends CbhsGlobalFyzYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGlobalFyzYs(PathMetadata metadata) {
        super(CbhsGlobalFyzYs.class, metadata);
    }

}

