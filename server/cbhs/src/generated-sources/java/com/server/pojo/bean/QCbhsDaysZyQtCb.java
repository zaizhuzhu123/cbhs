package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDaysZyQtCb is a Querydsl query type for CbhsDaysZyQtCb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDaysZyQtCb extends EntityPathBase<CbhsDaysZyQtCb> {

    private static final long serialVersionUID = -1339171116L;

    public static final QCbhsDaysZyQtCb cbhsDaysZyQtCb = new QCbhsDaysZyQtCb("cbhsDaysZyQtCb");

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath globalGclYsName = createString("globalGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

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

    public final StringPath shId = createString("shId");

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public QCbhsDaysZyQtCb(String variable) {
        super(CbhsDaysZyQtCb.class, forVariable(variable));
    }

    public QCbhsDaysZyQtCb(Path<? extends CbhsDaysZyQtCb> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDaysZyQtCb(PathMetadata metadata) {
        super(CbhsDaysZyQtCb.class, metadata);
    }

}

