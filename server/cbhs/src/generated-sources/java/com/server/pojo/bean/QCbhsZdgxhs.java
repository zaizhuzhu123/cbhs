package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCbhsZdgxhs is a Querydsl query type for CbhsZdgxhs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZdgxhs extends EntityPathBase<CbhsZdgxhs> {

    private static final long serialVersionUID = -779004990L;

    public static final QCbhsZdgxhs cbhsZdgxhs = new QCbhsZdgxhs("cbhsZdgxhs");

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath fbcompanyName = createString("fbcompanyName");

    public final NumberPath<Integer> fbcompanyOid = createNumber("fbcompanyOid", Integer.class);

    public final StringPath fbGclYsName = createString("fbGclYsName");

    public final NumberPath<Integer> fbGclYsOid = createNumber("fbGclYsOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> fcTotal = createNumber("fcTotal", java.math.BigDecimal.class);

    public final StringPath globaGclYsName = createString("globaGclYsName");

    public final NumberPath<Integer> globalGclYsOid = createNumber("globalGclYsOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzTotal = createNumber("gzTotal", java.math.BigDecimal.class);

    public final ListPath<CbhsZdgxhsMachine, QCbhsZdgxhsMachine> machinerys = this.<CbhsZdgxhsMachine, QCbhsZdgxhsMachine>createList("machinerys", CbhsZdgxhsMachine.class, QCbhsZdgxhsMachine.class, PathInits.DIRECT2);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> zcTotal = createNumber("zcTotal", java.math.BigDecimal.class);

    public QCbhsZdgxhs(String variable) {
        super(CbhsZdgxhs.class, forVariable(variable));
    }

    public QCbhsZdgxhs(Path<? extends CbhsZdgxhs> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZdgxhs(PathMetadata metadata) {
        super(CbhsZdgxhs.class, metadata);
    }

}

