package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGclQdYs is a Querydsl query type for CbhsGclQdYs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGclQdYs extends EntityPathBase<CbhsGclQdYs> {

    private static final long serialVersionUID = 1912770401L;

    public static final QCbhsGclQdYs cbhsGclQdYs = new QCbhsGclQdYs("cbhsGclQdYs");

    public final NumberPath<java.math.BigDecimal> completeCount = createNumber("completeCount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> count = createNumber("count", java.math.BigDecimal.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final NumberPath<Integer> fbcompanyOid = createNumber("fbcompanyOid", Integer.class);

    public final BooleanPath isGlobal = createBoolean("isGlobal");

    public final StringPath month = createString("month");

    public final StringPath name = createString("name");

    public final StringPath nodeId = createString("nodeId");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath pNodeId = createString("pNodeId");

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> totaPrice = createNumber("totaPrice", java.math.BigDecimal.class);

    public final StringPath unit = createString("unit");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public QCbhsGclQdYs(String variable) {
        super(CbhsGclQdYs.class, forVariable(variable));
    }

    public QCbhsGclQdYs(Path<? extends CbhsGclQdYs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGclQdYs(PathMetadata metadata) {
        super(CbhsGclQdYs.class, metadata);
    }

}

